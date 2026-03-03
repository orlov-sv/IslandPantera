package com.javarush.island.orlov.entity.animals;

import com.javarush.island.orlov.Island;
import com.javarush.island.orlov.Location;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    private int x;
    private int y;

    protected int weight;
    protected  int maxAn;
    protected int speed;
    protected int foodNeed;
    protected int foodEaten;
    protected boolean alive;

    public void move(Island island){
        if (alive == false) return;

        int dx = ThreadLocalRandom.current().nextInt(-1,2);
        int dy = ThreadLocalRandom.current().nextInt(-1,2);
        if (dx==0 && dy==0)return;

        int distance = ThreadLocalRandom.current().nextInt(0, speed + 1);
        int newX = x + dx * distance;
        int newY = y + dy * distance;

        if(newX < 0 || newX >= island.getWidth()) return;
        if(newY < 0 || newY >= island.getHeight()) return;

        Location currentLocation = island.getLocations()[x][y];
        Location newLocation = island.getLocations()[newX][newY];

        currentLocation.removeAnimals(this);
        newLocation.addAnimals(this);
        x = newX;
        y = newY;
    }


    protected abstract void eat(Location location);
    public void reproduce(){}
    public void die(){}

}
