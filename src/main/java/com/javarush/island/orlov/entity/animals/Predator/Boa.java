package com.javarush.island.orlov.entity.animals.Predator;
import com.javarush.island.orlov.entity.animals.Herbivore.*;

import com.javarush.island.orlov.entity.animals.Animal;

public class Boa extends Predator{

    public Boa() {
        this.weight = 15;
        this.maxAn = 30;
        this.speed = 1;
        this.foodNeed = 3;
        this.alive = true;
    }

    @Override
    protected int getEatChance(Animal animal) {

        if (animal instanceof Fox) return 15;
        if (animal instanceof Rabbit) return 60;
        if (animal instanceof Mouse) return 40;
        if (animal instanceof Duck) return 10;

        return 0;
    }

    @Override
    protected Animal createChild() {
        return new Boa();
    }
}
