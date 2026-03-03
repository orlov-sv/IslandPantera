package com.javarush.island.orlov;

import lombok.Getter;

public class Island {
    @Getter
    public final int width;
    @Getter
    public final int height;

   @Getter
   private final Location[][] locations;

    public Island(int width, int height){
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];

        initialize();
    }

   private void initialize(){
       for (int i = 0; i < height; i++) {
           for (int j = 0; j < width; j++) {
               locations[i][j] = new Location(i, j);
           }
       }
   }

}
