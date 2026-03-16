package com.javarush.island.orlov.service;


import com.javarush.island.orlov.Island;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private final Island island;
    private final ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

    private final ExecutorService animalPool =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Simulation(Island island) {
        this.island = island;
    }

    public void start(){
        ses.scheduleAtFixedRate(()-> {

            island.goAnimals(animalPool);
            island.goPlants();
            island.printStat();


                },0, 1, TimeUnit.SECONDS);
    }
}
