package com.henry.test.design.pattern.observer.jdp;

public enum WeatherType {
    SUNNY, RAINY, WINDY, COLD;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
