package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Deer extends Herbivore{
    public Deer() {
        this.weight = 300;
        this.maxAn = 20;
        this.speed = 4;
        this.foodNeed = 50;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Deer();
    }
}
