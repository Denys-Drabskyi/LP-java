package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;

public class SneakyA1 implements Attack {
    @Override
    public void attack(Droid self, Droid enemy) {
        SneakyDroid sneakyDroid = (SneakyDroid) self;
        enemy.setHp((int) (enemy.getHp() - (self.getAtc()+sneakyDroid.getAdditionalDamage()) ));
        sneakyDroid.setAdditionalDamage(0);
    }
}
