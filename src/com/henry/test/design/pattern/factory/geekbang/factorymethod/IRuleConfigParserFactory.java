package com.henry.test.design.pattern.factory.geekbang.factorymethod;

import com.henry.test.design.pattern.factory.geekbang.simplefactory.IRuleConfigParser;

public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
