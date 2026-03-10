package com.javarush.island.orlov.entity.animals;

import com.javarush.island.orlov.Island;
import com.javarush.island.orlov.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    @Setter
    protected Location location;

    @Getter
    protected double weight;
    protected  int maxAn;
    protected int speed;
    protected double foodNeed;
    protected double foodEaten;
    volatile public boolean alive;



    public void move(Island island){
        if (!alive) return;

        int dx = ThreadLocalRandom.current().nextInt(-1,2);
        int dy = ThreadLocalRandom.current().nextInt(-1,2);
        if (dx==0 && dy==0)return;

        int distance = ThreadLocalRandom.current().nextInt(0, speed + 1);
        int newX = location.getX() + dx * distance;
        int newY = location.getY() + dy * distance;

        if(newX < 0 || newX >= island.getWidth()) return;
        if(newY < 0 || newY >= island.getHeight()) return;


        Location newLocation = island.getLocations()[newX][newY];

        //Надо здесь избежать deadlock, но как правильнее?
        synchronized (location){
            synchronized (newLocation){
                location.removeAnimals(this);
                newLocation.addAnimals(this);
                }
            }


    }


    protected abstract void eat(Location location);

    public void reproduce(){
        if (!alive) return;


        synchronized (location){
            int count = 0;
                for (Animal animal: location.getAnimals()){
                    if(animal.getClass() == this.getClass())count++;
                }

                if (count >= 2 && count < maxAn){
                    Animal baby = createChild();
                    baby.setLocation(location);
                    location.addAnimals(baby);
                }
        }

    }

    protected abstract Animal createChild();

    public void die(){
        alive = false;
        synchronized (location){
        location.removeAnimals(this);
        }
    }

}
