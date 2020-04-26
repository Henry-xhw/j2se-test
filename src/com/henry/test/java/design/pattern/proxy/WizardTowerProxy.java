package com.henry.test.java.design.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WizardTowerProxy implements WizardTower {
    private WizardTower wizardTower;
    private static final int NUM_WIZARDS_ALLOWED = 3;
    private int numWizards;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override public void enter(Wizard wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            wizardTower.enter(wizard);
            numWizards ++;
        } else {
            log.info("{} is not allowed to enter!", wizard);
        }
    }
}
