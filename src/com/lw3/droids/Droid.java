package com.lw3.droids;

import com.lw3.attacks.A1.SneakyA1;
import com.lw3.attacks.A2.SneakyA2;
import com.lw3.attacks.A3.SneakyA3;
import com.lw3.attacks.Attack;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

@EqualsAndHashCode
@AllArgsConstructor
public abstract class Droid {
    private int hp = 100;
    private int atc = 10;
    private int defence = 10;
    private String name;
    private int statsPoints;
    public static String description;

    public Droid(boolean newDroid) {
        statsDistribution();
    }

    public Droid(String name, int hp, int atc, int def) {
        this.name = name;
        this.hp = hp;
        this.atc = atc;
        this.defence = def;
    }

    private void statsDistribution (){

        statsPoints = 10;
        Scanner s = new Scanner(System.in);
        String stats = "";

        System.out.println("Введіть назву робота");
        name = s.nextLine();

        while (statsPoints>0){
            System.out.printf("У вас залишилося %d очків, щоб розподілити їх між здоров'ям(h), атакою(a), та захистом робота(d)," +
                    "\nвпишіть дані показники відповідними символами зразу або по черзі. " +
                    "\nщоб скинути очки введіть r\n", statsPoints);
            stats = s.nextLine();
            stats.chars().forEach(x-> {
                if (statsPoints>0)
                    switch (x) {
                        case 'h' -> {
                            hp += 100;
                            statsPoints--;
                        }
                        case 'a' -> {
                            atc += 10;
                            statsPoints--;
                        }
                        case 'd' -> {
                            defence += 10;
                            statsPoints--;
                        }
                        case 'r' -> {
                            hp = 100;
                            atc = 10;
                            defence = 10;
                            statsPoints = 10;
                        }
                    }
            });
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAtc() {
        return atc;
    }

    public abstract ArrayList<Attack> getAttacks();

    public int getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "hp=" + hp +
                ", atc=" + atc +
                ", defence=" + defence +
                ", name='" + name + '\'' +
                ", statsPoints=" + statsPoints +
                '}';
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

//    public void attack(Droid other) {
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder("\n" +
//                "Виберіть атаку" +
//                "\nДля інформації про атаку дублюйте її номер\n");
//        int input = -1;
//        String string = "";
//
//        for (int i = 0; i < 3; i++) {
//            sb.append(String.format("\n| %d-> %s", i+1, attacks.get(i).getName()));
//        }
//        do {
//            System.out.println(sb);
//            input = sc.nextInt();
//            if (input == 11)
//                System.out.println(attacks.get(0).getShortDesc());
//            if (input == 22)
//                System.out.println(attacks.get(1).getShortDesc());
//            if (input == 33)
//                System.out.println(attacks.get(2).getShortDesc());
//        }
//        while (input<1 || input>3);
//        if (! attacks.get(input-1).attack(this,other)){
//            System.out.println("ця атака ще не відновилася, зачекайте "+ attacks.get(input-1).getCoolDown()+" ходів");
//            this.attack(other);
//        }
//
//    }
}
