package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.Location;
import com.javarush.island.orlov.entity.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {
    public Duck() {
        this.weight = 1;
        this.maxAn = 200;
        this.speed = 4;
        this.foodNeed = 0.15;
        this.alive = true;
    }

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
                if (foodEaten >= foodNeed) {
                    return;
                }
            }
        }

        super.eat(location);
    }

    private int getEatChance(Animal animal) {
        if(animal instanceof Caterpillar) return 90;
        return 0;
    }

    @Override
    protected Animal createChild() {
        return new Duck();
    }
}
