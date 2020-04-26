package com.henry.test.java.design.pattern.factory.geekbang.factorymethod;

import com.henry.test.java.design.pattern.factory.geekbang.simplefactory.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public XmlRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
