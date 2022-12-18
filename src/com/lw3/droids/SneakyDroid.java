package com.lw3.droids;

import com.lw3.attacks.A1.SneakyA1;
import com.lw3.attacks.A2.SneakyA2;
import com.lw3.attacks.A3.SneakyA3;
import com.lw3.attacks.Attack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SneakyDroid extends Droid{
    int additionalDamage = 0;

    private SneakyA1 sneakyA1;
    private SneakyA2 sneakyA2;
    private SneakyA3 sneakyA3;

    public SneakyDroid() {
        this.sneakyA1 = new SneakyA1();
        this.sneakyA2 = new SneakyA2();
        this.sneakyA3 = new SneakyA3();
    }

    public SneakyDroid(boolean newDroid) {
        super(newDroid);
    }

    public SneakyDroid(String name, int hp, int atc, int def) {
        super(name, hp, atc, def);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(sneakyA1,sneakyA2,sneakyA3));
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
