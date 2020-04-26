package com.henry.test.java.design.pattern.decorator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ClubbedTroll implements Troll {

    private Troll troll;


    @Override public void attack() {
        troll.attack();
        log.info("The troll swings at you with a club!");
    }

    @Override public int getAttackPower() {
        return troll.getAttackPower() + 10;
    }

    @Override public void fleeBattle() {
        troll.fleeBattle();
    }
}
