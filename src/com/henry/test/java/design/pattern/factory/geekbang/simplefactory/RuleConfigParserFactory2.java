package com.henry.test.java.design.pattern.factory.geekbang.simplefactory;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactory2 {
    private static final Map<String, IRuleConfigParser> cacheParsers = new HashMap<>();

    static {
        cacheParsers.put("json", new JsonRuleConfigParser());
        cacheParsers.put("xml", new XmlRuleConfigParser());
        cacheParsers.put("yaml", new YamlRuleConfigParser());
        cacheParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (StringUtils.isEmpty(configFormat)) {
            return null; //返回null还是IllegalArgumentException全凭你自己说了算
        }
        return cacheParsers.get(configFormat.toLowerCase());
    }
}
