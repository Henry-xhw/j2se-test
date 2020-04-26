package com.henry.test.java.design.pattern.adapter.usage;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ASensitiveWordsFilter { // A敏感词过滤系统提供的接口
    //text是原始文本，函数输出用***替换敏感词之后的文本
    public String filterSexyWords(String text) {
        // ...
        return null;
    }

    public String filterPoliticalWords(String text) {
        // ...
        return null;
    }
}

class BSensitiveWordsFilter  { // B敏感词过滤系统提供的接口
    public String filter(String text) {
        //...
        return null;
    }
}

class CSensitiveWordsFilter { // C敏感词过滤系统提供的接口
    public String filter(String text, String mask) {
        //...
        return null;
    }
}

// 未使用适配器模式之前的代码：代码的可测试性、扩展性不好
class RiskManagement {
    private ASensitiveWordsFilter aFilter = new ASensitiveWordsFilter();
    private BSensitiveWordsFilter bFilter = new BSensitiveWordsFilter();
    private CSensitiveWordsFilter cFilter = new CSensitiveWordsFilter();

    public String filterSensitiveWords(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        maskedText = bFilter.filter(maskedText);
        maskedText = cFilter.filter(maskedText, "***");
        return maskedText;
    }
}

// 使用适配器模式进行改造
interface ISensitiveWordsFilter { // 统一接口定义
    String filter(String text);
}

class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private ASensitiveWordsFilter aFilter;
    public ASensitiveWordsFilterAdaptor(ASensitiveWordsFilter aFilter) {
        this.aFilter = aFilter;
    }
    public String filter(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        return maskedText;
    }
}

class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private BSensitiveWordsFilter bSensitiveWordsFilter;

    public BSensitiveWordsFilterAdaptor(BSensitiveWordsFilter bSensitiveWordsFilter) {
        this.bSensitiveWordsFilter = bSensitiveWordsFilter;
    }

    @Override public String filter(String text) {
        String maskedText = bSensitiveWordsFilter.filter(text);
        return maskedText;
    }
}

class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private CSensitiveWordsFilter cSensitiveWordsFilter;
    @Setter
    private String mask;

    public CSensitiveWordsFilterAdaptor(CSensitiveWordsFilter cSensitiveWordsFilter, String mask) {
        this.cSensitiveWordsFilter = cSensitiveWordsFilter;
        this.mask = mask;
    }

    @Override public String filter(String text) {
        String maskedText = cSensitiveWordsFilter.filter(text, mask);
        return maskedText;
    }
}

// 扩展性更好，更加符合开闭原则，如果添加一个新的敏感词过滤系统，
// 这个类完全不需要改动；而且基于接口而非实现编程，代码的可测试性更好。
class RiskManagement2 {
    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String text) {
        String maskedText = text;
//        for (ISensitiveWordsFilter filter : filters) {
//            maskedText = filter.filter(maskedText);
//        }
        filters.forEach(filter -> filter.filter(maskedText));
        return maskedText;
    }
}