package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class HealerA3 extends Attack {
    public HealerA3() {
        this.baseCoolDown = 4;
        this.name = "Прийняти своїх і чужих";
        this.shortDesc = "Лікує всіх союзників на 10% від свого здоров'я, а противникам наносить удар на 10% свого здоров'я";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            int value = (int) (self.getHp()*0.1);
            attackTeam.droids().forEach(droid -> droid.setHp(droid.getHp()+value));
            defenderTeam.droids().forEach(droid -> droid.setHp(droid.getHp()-value));
            return true;
        }
        return false;
    }
}
