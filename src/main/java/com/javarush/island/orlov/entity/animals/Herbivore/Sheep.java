package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Sheep extends Herbivore {

    public Sheep() {
        this.weight = 70;
        this.maxAn = 140;
        this.speed = 3;
        this.foodNeed = 15;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Sheep();
    }
}
