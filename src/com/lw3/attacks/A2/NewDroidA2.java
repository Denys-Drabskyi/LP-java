package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;

public class NewDroidA2 implements Attack {
    int baseCoolDown = 3;
    @Override
    public void attack(Droid self, Droid enemy) {
        enemy.setHp((int) (enemy.getHp() - self.getAtc()*4));
    }
}
