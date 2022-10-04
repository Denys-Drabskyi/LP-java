package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;

public class SneakyA2 implements Attack {
    int baseCoolDown = 2;

    @Override
    public void attack(Droid self, Droid enemy) {
        SneakyDroid sneakyDroid = (SneakyDroid) self;
        enemy.setHp((int) (enemy.getHp() - (self.getAtc()*2+sneakyDroid.getAdditionalDamage()) ));
        sneakyDroid.setAdditionalDamage(0);
    }
}
