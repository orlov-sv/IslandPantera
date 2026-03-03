package com.javarush.island.orlov;

import com.javarush.island.orlov.entity.animals.Animal;
import com.javarush.island.orlov.entity.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Location {

    @Getter
    public List<Animal> animals = new ArrayList<>();

    @Getter
    public List<Plant> plants = new ArrayList<>();

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



}
