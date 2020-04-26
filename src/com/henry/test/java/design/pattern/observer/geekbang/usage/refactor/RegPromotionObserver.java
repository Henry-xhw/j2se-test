package com.henry.test.java.design.pattern.observer.geekbang.usage.refactor;

import com.henry.test.java.design.pattern.observer.geekbang.usage.origin.PromotionService;

public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService; //依赖注入

    @Override public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
