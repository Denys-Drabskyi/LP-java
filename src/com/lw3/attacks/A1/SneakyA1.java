package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class SneakyA1 extends Attack {
    public SneakyA1() {
        this.name = "SneakyA1";
    }

//    public boolean attack(Droid self, Droid enemy) {
//        SneakyDroid sneakyDroid = (SneakyDroid) self;
//        enemy.setHp((int) (enemy.getHp() - (self.getAtc()+sneakyDroid.getAdditionalDamage()) ));
//        sneakyDroid.setAdditionalDamage(0);
//        return true;
//    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        SneakyDroid sneakyDroid = (SneakyDroid) self;
        Droid enemy = chooseDroid(defenderTeam, false, moves, recorded, sc);

        enemy.setHp((int) (enemy.getHp() - (self.getAtc()+sneakyDroid.getAdditionalDamage()) ));
        sneakyDroid.setAdditionalDamage(0);

        return true;
    }


}
