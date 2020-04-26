package com.henry.test.java.design.pattern.factory.geekbang.factorymethod;

import com.henry.test.java.design.pattern.factory.geekbang.simplefactory.IRuleConfigParser;
import com.henry.test.java.design.pattern.factory.geekbang.simplefactory.PropertiesRuleConfigParser;

public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
