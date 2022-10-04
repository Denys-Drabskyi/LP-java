package com.lw3.game;

import com.lw3.attacks.A1.SneakyA1;
import com.lw3.attacks.A2.SneakyA2;
import com.lw3.attacks.A3.SneakyA3;
import com.lw3.droids.SneakyDroid;
import com.lw3.droids.TankDroid;

import java.util.Random;

class Game {
    public static final boolean ONE_VS_ONE = false;
    public static final boolean THREE_VS_THREE = false;

    public static void main(String[] args) {
        SneakyDroid sneakyDroid = new SneakyDroid(new  SneakyA1(),new  SneakyA2(),new  SneakyA3());
        System.out.println(sneakyDroid.toString());
//        sneakyDroid.setHp(40);
        for (int i = 0; i < 20; i++) {
            sneakyDroid.setHp(sneakyDroid.getHp()-100);
        }
    }
}
