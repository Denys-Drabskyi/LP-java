package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;

public class TankDroidA1 implements Attack {
    @Override
    public void attack(Droid self, Droid enemy) {
        enemy.setHp((int) (enemy.getHp() - self.getAtc()));
    }
}
