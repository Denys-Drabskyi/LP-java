package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;

public class SneakyA3 extends Attack {
    public SneakyA3() {
        this.baseCoolDown = 4;
    }

    @Override
    public boolean attack(Droid self, Droid enemy) {
        if (coolDown == 0){
            SneakyDroid sneakyDroid = (SneakyDroid) self;
            enemy.setHp((int) (enemy.getHp() - (self.getAtc()*3+sneakyDroid.getAdditionalDamage()*1.2) ));
            sneakyDroid.setAdditionalDamage(0);
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
