package com.henry.test.java.design.pattern.factory.geekbang.simplefactory;

public class RuleConfigParserFactory {
    public static IRuleConfigParser createParser(String fileExtension) throws InvalidRuleConfigException {
        IRuleConfigParser parser = null;

        if ("json".equalsIgnoreCase(fileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(fileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(fileExtension)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(fileExtension)) {
            parser = new PropertiesRuleConfigParser();
        } else {
            throw new InvalidRuleConfigException(
                "Rule config file format is not supported: " + fileExtension);
        }
        return parser;

    }
}
