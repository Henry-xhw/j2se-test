package com.henry.test.proxy;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IvoryTower implements WizardTower {
    @Override public void enter(Wizard wizard) {
        log.info("{} enters the tower.", wizard);
    }
}
