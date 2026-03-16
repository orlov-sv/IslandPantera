package com.javarush.island.orlov;

import com.javarush.island.orlov.service.Simulation;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(100,20);
        Simulation simulation = new Simulation(island);
        simulation.start();
    }
}
