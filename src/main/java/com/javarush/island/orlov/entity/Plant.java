package com.javarush.island.orlov.entity;


import lombok.Getter;

public class Plant {

    private boolean alive = true;
    @Getter
    private int weight = 1;

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
    }
}
