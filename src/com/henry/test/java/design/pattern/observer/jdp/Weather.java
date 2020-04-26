package com.henry.test.java.design.pattern.observer.jdp;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Weather {
    private WeatherType currentWeather;
    private List<WeatherObserver> observers;


    public Weather() {
        observers = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        log.info("The weather changed to {}.", currentWeather);
        notifyObservers();

    }

    private void notifyObservers() {
        observers.forEach(observer -> {
            observer.update(currentWeather);
        });
    }
}
