package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

public class TankDroidA1 extends Attack {
    public TankDroidA1() {
        this.name = "TankDroidA1";
    }

//    @Override
//    public boolean attack(Droid self, Droid enemy) {
//       enemy.setHp((int) (enemy.getHp() - self.getAtc()));
//    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded) {
        Droid enemy = chooseDroid(defenderTeam, false, moves, recorded);

        enemy.setHp((int) (enemy.getHp() - self.getAtc()));
        return true;
    }
}
