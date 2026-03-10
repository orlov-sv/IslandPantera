package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Mouse extends Herbivore{

    public Mouse() {
        this.weight = 0.05;
        this.maxAn = 500;
        this.speed = 1;
        this.foodNeed = 0.01;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Mouse();
    }
}
