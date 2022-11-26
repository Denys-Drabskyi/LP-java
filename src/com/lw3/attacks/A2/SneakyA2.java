package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;

public class SneakyA2 extends Attack {
    public SneakyA2() {
        this.baseCoolDown = 2;
        this.name = "SneakyA2";
    }

    @Override
    public boolean attack(Droid self, Droid enemy) {
        if (coolDown == 0){
            SneakyDroid sneakyDroid = (SneakyDroid) self;
            enemy.setHp((int) (enemy.getHp() - (self.getAtc()*2+sneakyDroid.getAdditionalDamage()) ));
            sneakyDroid.setAdditionalDamage(0);
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
