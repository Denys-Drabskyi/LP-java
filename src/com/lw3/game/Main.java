package com.lw3.game;

import com.lw3.droids.SneakyDroid;
import com.lw3.droids.TankDroid;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class Main {
    public static final boolean ONE_VS_ONE = false;
    public static final boolean THREE_VS_THREE = false;

    public static void main(String[] args) {
        SneakyDroid sneakyDroid = new SneakyDroid("namebvghjghj",100,10,12);
        TankDroid tankDroid = new TankDroid("name2",150,5,20);
//        System.out.println(sneakyDroid.toString());
////        sneakyDroid.setHp(40);
//        for (int i = 0; i < 20; i++) {
//            sneakyDroid.setHp(sneakyDroid.getHp()-100);
        Game game = new GameImpl();
        game.run();


//        System.out.println();
//        String s = "12 13";
//        System.setIn(new ByteArrayInputStream(s.getBytes()));
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext())
//            System.out.println(sc.nextInt());
    }
}

