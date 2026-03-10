package com.javarush.island.orlov.entity.animals.Predator;
import com.javarush.island.orlov.entity.animals.Herbivore.*;

import com.javarush.island.orlov.entity.animals.Animal;

public class Eagle extends Predator {
    public Eagle() {
        this.weight = 6;
        this.maxAn = 20;
        this.speed = 3;
        this.foodNeed = 1;
        this.alive = true;
    }

    @Override
    protected int getEatChance(Animal animal) {


        if (animal instanceof Fox) return 10;
        if (animal instanceof Rabbit) return 90;
        if (animal instanceof Mouse) return 90;
        if (animal instanceof Duck) return 80;

        return 0;
    }

    @Override
    protected Animal createChild() {
        return new Eagle();
    }
}
