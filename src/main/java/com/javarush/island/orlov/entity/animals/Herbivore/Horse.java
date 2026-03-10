package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Horse extends  Herbivore{
    public Horse() {
        this.weight = 400;
        this.maxAn = 20;
        this.speed = 4;
        this.foodNeed = 60;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Horse();
    }
}
