package com.javarush.island.orlov.entity.animals.Herbivore;

import com.javarush.island.orlov.Location;
import com.javarush.island.orlov.entity.animals.Animal;

public abstract class Herbivore extends Animal {


    @Override
    protected void eat(Location location){

    }

    @Override
    protected abstract Animal createChild();
}
