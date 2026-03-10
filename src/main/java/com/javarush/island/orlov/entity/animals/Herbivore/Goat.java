package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Goat extends Herbivore{
    public Goat() {
        this.weight = 60;
        this.maxAn = 140;
        this.speed = 3;
        this.foodNeed = 10;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Goat();
    }
}
