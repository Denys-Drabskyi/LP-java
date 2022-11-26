package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;

public class TankDroidA3 extends Attack {
    public TankDroidA3() {
        this.baseCoolDown = 4;
    }

    @Override
    public boolean attack(Droid self, Droid enemy) {
        if (coolDown == 0){
            enemy.setHp((int) (enemy.getHp() - self.getAtc()*3.5));
            return true;
        }
        return false;
    }
}
