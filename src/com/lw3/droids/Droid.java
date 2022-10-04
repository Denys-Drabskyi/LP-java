package com.lw3.droids;

import com.lw3.attacks.Attack;

import java.util.Scanner;

public abstract class Droid {
    private int hp = 100;
    private int atc = 10;
    private int defence = 10;
    private String name;
    private int statsPoints;

    private final Attack a1;
    private final Attack a2;
    private final Attack a3;

    public Droid(Attack a1, Attack a2, Attack a3) {
        statsDistribution();
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
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
                ", a1=" + a1.getClass().getSimpleName() +
                ", a2=" + a2.getClass().getSimpleName() +
                ", a3=" + a3.getClass().getSimpleName() +
                '}';
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void attack(Attack attack) {

    }
}
