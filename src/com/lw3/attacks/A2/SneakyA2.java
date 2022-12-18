package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class SneakyA2 extends Attack {
    public SneakyA2() {
        this.baseCoolDown = 2;
        this.name = "Сильна атака";
        this.shortDesc = "Атакує 1 противника на 200% від своєї атаки, якщо є додаткова шкода, застосовіє її";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            Droid enemy = chooseDroid(defenderTeam, false, moves, recorded, sc);

            SneakyDroid sneakyDroid = (SneakyDroid) self;
            enemy.setHp((int) (enemy.getHp() - (self.getAtc()*2+sneakyDroid.getAdditionalDamage())));
            sneakyDroid.setAdditionalDamage(0);
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
