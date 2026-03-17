package com.javarush.island.orlov.entity;


import lombok.Getter;

public class Plant {

    private boolean alive = true;
    public final int weight = 1;
    public static final int maxPlant = 200;

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
    }
}
