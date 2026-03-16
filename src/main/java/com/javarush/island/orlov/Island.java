package com.javarush.island.orlov;


import com.javarush.island.orlov.entity.Plant;
import com.javarush.island.orlov.entity.animals.Animal;
import com.javarush.island.orlov.entity.animals.Herbivore.*;
import com.javarush.island.orlov.entity.animals.Predator.*;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;



public class Island {
    @Getter
    public final int width;
    @Getter
    public final int height;

   @Getter
   private final Location[][] locations;

    private static final List<Class<? extends Animal>> ANIMAL_TYPES = List.of(
            Wolf.class,
            Fox.class,
            Bear.class,
            Eagle.class,
            Horse.class,
            Deer.class,
            Rabbit.class,
            Mouse.class,
            Goat.class,
            Sheep.class,
            Hog.class,
            Buffalo.class,
            Duck.class,
            Caterpillar.class
    );

    public Island(int width, int height){
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];

        initialize();
    }

   private void initialize(){
       for (int i = 0; i < width; i++) {
           for (int j = 0; j < height; j++) {
               locations[i][j] = new Location(i, j);
           }
       }
       populate();
   }

   private void populate() {
       for (int x = 0; x < width; x++) {
           for (int y = 0; y < height; y++) {
               Location location = locations[x][y];

               int planCount = ThreadLocalRandom.current().nextInt(0, 200);
               for(int p = 0; p < planCount; p++){
                   location.addPlants(new Plant());
               }

               for (Class<? extends Animal> animals: ANIMAL_TYPES){
                   try{
                       Animal temp = animals.getDeclaredConstructor().newInstance();
                       int animalCount = ThreadLocalRandom.current().nextInt(0, temp.getMaxAn());

                       for(int i = 0; i < animalCount; i++){
                           Animal animal = animals.getDeclaredConstructor().newInstance();
                           animal.setLocation(location);
                           location.addAnimals(animal);
                       }
                   }
                   catch (Exception e){e.printStackTrace();}

               }

           }
       }
   }

    public void goAnimals(ExecutorService animalPool) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location location = locations[i][j];
                animalPool.submit(()->
                        location.goAnimals(this));
            }
        }

    }

    public void goPlants() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                locations[i][j].goPlants();
            }
        }
    }

    public void printStat() {
        Map<Class<? extends Animal>, Integer> animalMap = new HashMap<>();

        int countPlants = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                countPlants += locations[i][j].getPlants().size();

                List<Animal> animals = locations[i][j].getAnimals();
                for (Animal animal : animals) {
                    Class<? extends Animal> type = animal.getClass();
                    animalMap.put(type, animalMap.getOrDefault(type, 0)+1);
                }

            }
        }
        System.out.println("=== Статистика по острову ===");
            for (Map.Entry<Class<? extends Animal>, Integer> map : animalMap.entrySet()){
                System.out.println(map.getKey().getSimpleName() + ": " + map.getValue());
            }
        System.out.println("Plants " + countPlants);
    }
}
