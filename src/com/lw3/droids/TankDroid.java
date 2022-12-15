package com.lw3.droids;

import com.lw3.attacks.A1.SneakyA1;
import com.lw3.attacks.A1.TankDroidA1;
import com.lw3.attacks.A2.SneakyA2;
import com.lw3.attacks.A2.TankDroidA2;
import com.lw3.attacks.A3.SneakyA3;
import com.lw3.attacks.A3.TankDroidA3;
import com.lw3.attacks.Attack;

import java.util.ArrayList;
import java.util.Arrays;

public class TankDroid extends Droid {

    public TankDroid(boolean newDroid) {
        super(newDroid);
    }

    public TankDroid(String name, int hp, int atc, int def) {
        super(name, hp, atc, def);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(new TankDroidA1(), new TankDroidA2(), new TankDroidA3()));
    }
}

