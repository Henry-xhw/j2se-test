package com.henry.test.design.pattern.factory.geekbang.factorymethod;

import com.henry.test.design.pattern.factory.geekbang.simplefactory.IRuleConfigParser;
import com.henry.test.design.pattern.factory.geekbang.simplefactory.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
