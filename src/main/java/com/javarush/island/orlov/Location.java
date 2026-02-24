package com.javarush.island.orlov;

import com.javarush.island.orlov.entity.Animal;
import com.javarush.island.orlov.entity.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Location {

    @Getter
    public List<Animal> animals = new ArrayList<>();

    @Getter
    public List<Plant> plants = new ArrayList<>();

    public void addAnimals(Animal animal){
        animals.add(animal);
    }

    public void addPlants(Plant plant){
        plants.add(plant);
    }

    public void removeAnimals(Animal animal){
        animals.remove(animal);
    }

    void removePlants(Plant plant){
        plants.remove(plant);
    }



}
