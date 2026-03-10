package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Buffalo extends Herbivore {
    public Buffalo() {
        this.weight = 700;
        this.maxAn = 10;
        this.speed = 3;
        this.foodNeed = 100;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Buffalo();
    }
}
