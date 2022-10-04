package com.lw3.droids;

import com.lw3.attacks.Attack;

import java.util.Random;

public class SneakyDroid extends Droid{
    int additionalDamage = 0;

    public SneakyDroid(Attack a1, Attack a2, Attack a3) {
        super(a1, a2, a3);
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
        if (random.nextInt(100)<=15)
            additionalDamage += hp - this.getHp();
        else
            super.setHp(hp);
    }
}
