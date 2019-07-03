package com.zolo.healthcheck;


@Singleton
public class Geyser {

    String name;
    String model;

    private Geyser(){}

    private Geyser geyser;

    public synchronized  Geyser getInstance(){
        if(geyser == null){
            geyser = new Geyser();
        }
        return  geyser;
    }
}
