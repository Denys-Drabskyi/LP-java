package com.lw3.game.team;

import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;
import com.lw3.droids.TankDroid;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@Setter
public class Team {
    private String name;
//    private ArrayList<Droid> droids = new ArrayList<>();
    private ArrayList<SneakyDroid> sneakyDroids = new ArrayList<>();
    private ArrayList<TankDroid> tankDroids = new ArrayList<>();


    public Team () {

    }
    /*for testing only*/
    public Team(String name, ArrayList<Droid> droids) {
        this.name = name;
        droids.forEach(this::addDroid);
    }

    public ArrayList<Droid> droids() {
        ArrayList<Droid> droids = new ArrayList<>(sneakyDroids);
        droids.addAll(tankDroids);
        return droids;
    }

    public void addDroid (Droid droid){
        if (droid instanceof SneakyDroid)
            sneakyDroids.add((SneakyDroid) droid);
        else if (droid instanceof TankDroid) {
            tankDroids.add((TankDroid) droid);
        }
    }

    public String name() {
        return name;
    }
}
