package com.lw3.droids;

import com.lw3.attacks.A1.SneakyA1;
import com.lw3.attacks.A2.SneakyA2;
import com.lw3.attacks.A3.SneakyA3;
import com.lw3.attacks.Attack;

import java.util.Random;

public class SneakyDroid extends Droid{
    int additionalDamage = 0;

    public SneakyDroid() {
        super(new SneakyA1(), new SneakyA2(), new SneakyA3());
    }

    public SneakyDroid(String name, int hp, int atc, int def) {
        super(new SneakyA1(), new SneakyA2(), new SneakyA3(), name, hp, atc, def);
    }

    public int getAdditionalDamage() {
        return additionalDamage;
    }

    public void setAdditionalDamage(int additionalDamage) {
        this.additionalDamage = additionalDamage;
    }

    @Override
    public void setHp(int hp) {
        Random random = new Random();
        if (random.nextInt(100) <= 15)
        {
            additionalDamage += this.getHp()-hp;
            System.out.println(this.getClass().getSimpleName() + this.getName() + " ухилився, та посилить свою наступну атаку на " + additionalDamage);
        } else
            super.setHp(hp);
    }
}
