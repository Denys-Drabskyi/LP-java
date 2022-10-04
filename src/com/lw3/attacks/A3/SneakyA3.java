package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;

public class SneakyA3 implements Attack {
    int baseCoolDown = 4;
    @Override
    public void attack(Droid self, Droid enemy) {
        SneakyDroid sneakyDroid = (SneakyDroid) self;
        enemy.setHp((int) (enemy.getHp() - (self.getAtc()*3+sneakyDroid.getAdditionalDamage()*1.2) ));
        sneakyDroid.setAdditionalDamage(0);
    }
}
