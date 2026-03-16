package com.javarush.island.orlov.entity.animals.Predator;

import com.javarush.island.orlov.Location;
import com.javarush.island.orlov.entity.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    @Override
    public void eat(Location location){
        List<Animal> animals = new ArrayList<>(location.getAnimals());
        for (Animal animal: animals){
            if (animal == this) continue;
            if (!animal.alive) continue;
            int chance =  getEatChance(animal);
            if (chance == 0) continue;
            int random = ThreadLocalRandom.current().nextInt(100);
            if (random < chance){
                animal.die();
                foodEaten += animal.getWeight();
                return;
            }
        }
    }

    public void checkHunger() {
        if (!alive) return;

        if (foodEaten < foodNeed) {
            die(); // животное умирает от голода
        }

        // Сброс еды на следующий такт
        foodEaten = 0;
    }

    protected abstract int getEatChance(Animal animal);

    @Override
    protected abstract Animal createChild();
}
