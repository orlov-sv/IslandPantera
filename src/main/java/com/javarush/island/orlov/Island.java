package com.javarush.island.orlov;

import lombok.Getter;

public class Island {
    private final int width;
    private final int height;

   @Getter
   private final Location[][] locations;

    public Island(int width, int height){
        this.width = width;
        this.height = height;
        this.locations = new Location[height][width];

        initialize();
    }

   private void initialize(){
       for (int i = 0; i < height; i++) {
           for (int j = 0; j < width; j++) {
               locations[i][j] = new Location();
           }
       }
   }

}
