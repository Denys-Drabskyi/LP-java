package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;

public class SneakyA1 extends Attack {
    public SneakyA1() {
        this.name = "SneakyA1";
    }

    public boolean attack(Droid self, Droid enemy) {
        SneakyDroid sneakyDroid = (SneakyDroid) self;
        enemy.setHp((int) (enemy.getHp() - (self.getAtc()+sneakyDroid.getAdditionalDamage()) ));
        sneakyDroid.setAdditionalDamage(0);
        return true;
    }
}
