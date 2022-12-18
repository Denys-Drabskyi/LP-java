package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

public class TankDroidA3 extends Attack {
    public TankDroidA3() {
        this.baseCoolDown = 4;
    }

//    @Override
//    public boolean attack(Droid self, Droid enemy) {
//        if (coolDown == 0){
//            enemy.setHp((int) (enemy.getHp() - self.getAtc()*3.5));
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded) {
        if (coolDown == 0){
            Droid enemy = chooseDroid(defenderTeam, false, moves, recorded);

            enemy.setHp((int) (enemy.getHp() - self.getAtc()*3.5));
            return true;
        }
        return false;
    }
}
