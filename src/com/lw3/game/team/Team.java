package com.lw3.game.team;

import com.lw3.droids.Droid;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    private String name;
    private ArrayList<Droid> droids = new ArrayList<>();

    public Team (boolean oneVsOne) {
        Scanner s = new Scanner(System.in);
        int count = 3;
        this.name = s.nextLine();
        if (oneVsOne)
            count = 1;
        // TODO: 25.11.2022
//        while (droids.size()<count)
//            this.droids.add(chooseFromAllOrCreate());
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
