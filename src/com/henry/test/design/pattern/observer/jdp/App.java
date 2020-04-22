package com.henry.test.design.pattern.observer.jdp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());


        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();


        log.info("--Running generic version--");




    }



}
