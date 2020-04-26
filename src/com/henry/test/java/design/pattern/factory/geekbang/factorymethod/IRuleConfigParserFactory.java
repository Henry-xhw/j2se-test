package com.henry.test.java.design.pattern.factory.geekbang.factorymethod;

import com.henry.test.java.design.pattern.factory.geekbang.simplefactory.IRuleConfigParser;

public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
