package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class SneakyA3 extends Attack {
    public SneakyA3() {
        this.baseCoolDown = 4;
        this.name = "Атака з засади";
        this.shortDesc = "Атакує 1 противника на 300% від своєї атаки, якщо є додаткова шкода зверху наносить 120% від неї";
    }



    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            Droid enemy = chooseDroid(defenderTeam, false, moves, recorded, sc);

            SneakyDroid sneakyDroid = (SneakyDroid) self;
            enemy.setHp((int) (enemy.getHp() - (self.getAtc()*3+sneakyDroid.getAdditionalDamage()*1.2) ));
            sneakyDroid.setAdditionalDamage(0);
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}