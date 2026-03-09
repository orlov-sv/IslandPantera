package com.javarush.island.orlov.entity.animals.Predator;

import com.javarush.island.orlov.entity.animals.Animal;
import com.javarush.island.orlov.entity.animals.Herbivore.*;
public class Fox extends Predator {
    @Override
    protected int getEatChance(Animal animal) {

        if (animal instanceof Rabbit) return 70;
        if (animal instanceof Mouse) return 90;
        if (animal instanceof Goat) return 60;
        if (animal instanceof Duck) return 60;
        if (animal instanceof Caterpillar) return 40;
        return 0;
    }

    @Override
    protected Animal createChild() {
        return new Fox();
    }
}
