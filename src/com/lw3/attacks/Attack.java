package com.lw3.attacks;

import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

public abstract class Attack {
    protected String name = "no name";
    protected String shortDesc = "no description";
    protected int coolDown = 0;
    protected int baseCoolDown;

    public abstract boolean attack(Droid self, Droid enemy);

//    public abstract boolean prepareAndAttack(Team selfTeam, Team enemyTeam);


    public int getCoolDown(){
        return coolDown;
    }

    public String getName() {
        return name;
    }

    public void reduceCoolDown(){
        if (coolDown>0)
            this.coolDown--;
    }

    public String getShortDesc() {
        return shortDesc;
    }
}

