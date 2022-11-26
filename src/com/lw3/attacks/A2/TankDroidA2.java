package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;

public class TankDroidA2 extends Attack {

    public TankDroidA2() {
        this.baseCoolDown = 3;
        this.name = "TankDroidA2";
    }

    @Override
    public boolean attack(Droid self, Droid enemy) {
        if (coolDown == 0){
            enemy.setHp((int) (enemy.getHp() - self.getAtc()*4));
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
