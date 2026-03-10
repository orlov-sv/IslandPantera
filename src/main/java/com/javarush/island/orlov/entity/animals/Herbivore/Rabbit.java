package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.entity.animals.Animal;

public class Rabbit extends Herbivore{

    public Rabbit() {
        this.weight = 2;
        this.maxAn = 150;
        this.speed = 2;
        this.foodNeed = 0.45;
        this.alive = true;
    }

    @Override
    protected Animal createChild() {
        return new Rabbit();
    }
}
