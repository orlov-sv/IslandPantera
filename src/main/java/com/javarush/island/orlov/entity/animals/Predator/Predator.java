package com.javarush.island.orlov.entity.animals.Predator;

import com.javarush.island.orlov.Location;
import com.javarush.island.orlov.entity.animals.Animal;

public class Predator extends Animal {

    @Override
    protected void eat(Location location){

    }

    @Override
    protected Animal createChild() {
        return null;
    }
}
