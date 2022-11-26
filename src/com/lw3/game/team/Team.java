package com.lw3.game.team;

import com.lw3.droids.Droid;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@Setter
public class Team {
    private String name;
    private ArrayList<Droid> droids = new ArrayList<>();

    public Team () {

    }
    /*for testing only*/
    public Team(String name, ArrayList<Droid> droids) {
        this.name = name;
        this.droids = droids;
    }

    public ArrayList<Droid> droids() {
        return droids;
    }

    public void addDroid (Droid droid){
        droids.add(droid);
    }

    public String name() {
        return name;
    }
}
