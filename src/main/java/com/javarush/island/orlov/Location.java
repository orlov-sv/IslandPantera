package com.javarush.island.orlov;

import com.javarush.island.orlov.entity.animals.Animal;
import com.javarush.island.orlov.entity.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
    @Getter
    private int x;
    @Getter
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Getter
    private List<Animal> animals = new ArrayList<>();

    @Getter
    private List<Plant> plants = new ArrayList<>();

    public synchronized void addAnimals(Animal animal){
        animals.add(animal);
    }

    public synchronized void addPlants(Plant plant){
        plants.add(plant);
    }

    public synchronized void removeAnimals(Animal animal){
        animals.remove(animal);
    }

    public synchronized void removePlants(Plant plant){
        plants.remove(plant);
    }


    public void goAnimals(Island island) {
        List<Animal> animalsCopy;
        synchronized (animals){animalsCopy = new ArrayList<>(animals);}

        for (Animal animal : animalsCopy) {
            if(!animal.alive) continue;

            animal.move(island);
            animal.eat(this);
            animal.reproduce();
            animal.checkHunger();
        }


    }

    public void goPlants() {
        List<Plant> plantCopy;
        synchronized (plants){
            plantCopy = new ArrayList<>(plants);
        }

        for (Plant plant : plantCopy) {
            if(!plant.isAlive())continue;

            if(ThreadLocalRandom.current().nextInt(100) < 50){
                synchronized (plants){
                    if (plants.size() < Plant.maxPlant){
                        Plant newPlant = new Plant();
                        plants.add(newPlant);
                    }
                }
            }
        }

    }
}
