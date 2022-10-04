package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;

public class NewDroidA3 implements Attack {
    int baseCoolDown = 5;
    int lastUsed;
    @Override
    public void attack(Droid self, Droid enemy) {
        enemy.setHp((int) (enemy.getHp() - self.getAtc()*3.5));
    }
}
