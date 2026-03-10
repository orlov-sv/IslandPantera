package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        this.weight = 0.01;
        this.maxAn = 1000;
        this.speed = 0;
        this.foodNeed = 0;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Caterpillar();
    }
}
