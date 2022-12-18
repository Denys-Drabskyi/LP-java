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
    private static final TankDroidA1 tankDroidA1 = new TankDroidA1();
    private static final TankDroidA2 tankDroidA2 = new TankDroidA2();
    private static final TankDroidA3 tankDroidA3 = new TankDroidA3();

    public TankDroid(boolean newDroid) {
        super(newDroid);
    }

    public TankDroid(Droid droid) {
        super(droid);
        TankDroid droid1 = (TankDroid) droid;
//        this.tankDroidA1 = droid1.tankDroidA1;
//        this.tankDroidA2 = tankDroidA2;
//        this.tankDroidA3 = tankDroidA3;
    }

    public TankDroid(String name, int hp, int atc, int def) {
        super(name, hp, atc, def);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(this.tankDroidA1, this.tankDroidA2, this.tankDroidA3));
    }
}

