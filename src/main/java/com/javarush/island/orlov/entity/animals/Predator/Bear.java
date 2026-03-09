package com.javarush.island.orlov.entity.animals.Predator;
import com.javarush.island.orlov.entity.animals.Herbivore.*;

import com.javarush.island.orlov.entity.animals.Animal;

public class Bear extends Predator {
    @Override
    protected int getEatChance(Animal animal) {
        if (animal instanceof Boa) return 80;
        if (animal instanceof Horse) return 40;
        if (animal instanceof Deer) return 80;
        if (animal instanceof Rabbit) return 80;
        if (animal instanceof Mouse) return 90;
        if (animal instanceof Goat) return 70;
        if (animal instanceof Sheep) return 70;
        if (animal instanceof Hog) return 50;
        if (animal instanceof Buffalo) return 20;
        if (animal instanceof Duck) return 10;

        return 0;
    }

    @Override
    protected Animal createChild() {
        return new Bear();
    }
}
