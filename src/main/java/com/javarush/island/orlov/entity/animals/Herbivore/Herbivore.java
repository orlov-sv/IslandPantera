package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.Location;
import com.javarush.island.orlov.entity.Plant;
import com.javarush.island.orlov.entity.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal{

    @Override
    public void eat(Location location) {
        List<Plant> plants = new ArrayList<>(location.getPlants());

        for(Plant plant: plants){
            if(!plant.isAlive()) continue;

            synchronized (plant){
                if (!plant.isAlive()) continue;
                plant.die();
                foodEaten += 1;
            }

            if(foodEaten >= foodNeed) return;

        }

    }
    public void checkHunger() {
        if (!alive) return;

        if (foodEaten < foodNeed) {
            die();
        }


        foodEaten = 0;
    }

    @Override
    protected abstract Animal createChild();
}
