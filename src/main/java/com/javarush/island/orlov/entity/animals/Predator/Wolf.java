package com.javarush.island.orlov.entity.animals.Predator;

import com.javarush.island.orlov.entity.animals.Animal;
import com.javarush.island.orlov.entity.animals.Herbivore.*;


public class Wolf extends Predator{
    public Wolf() {
        this.weight = 50;
        this.maxAn = 30;
        this.speed = 3;
        this.foodNeed = 8;
        this.alive = true;
    }

    @Override
    protected int getEatChance(Animal animal) {

        if (animal instanceof Horse) return 10;
        if (animal instanceof Deer) return 15;
        if (animal instanceof Rabbit) return 60;
        if (animal instanceof Mouse) return 80;
        if (animal instanceof Goat) return 60;
        if (animal instanceof Sheep) return 70;
        if (animal instanceof Hog) return 15;
        if (animal instanceof Buffalo) return 10;
        if (animal instanceof Duck) return 40;
        return 0;
    }

    @Override
    protected Animal createChild() {
        return new Wolf();
    }
}
