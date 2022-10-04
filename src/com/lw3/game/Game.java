package com.lw3.game;

import com.lw3.droids.TankDroid;

import java.util.Random;

class Game {
    public static final boolean ONE_VS_ONE = false;
    public static final boolean THREE_VS_THREE = false;

    public static void main(String[] args) {
//        TankDroid tankDroid = new TankDroid();
//        System.out.println(tankDroid.toString());
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
