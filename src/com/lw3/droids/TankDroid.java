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
    private TankDroidA1 tankDroidA1 = new TankDroidA1();
    private TankDroidA2 tankDroidA2 = new TankDroidA2();
    private TankDroidA3 tankDroidA3 = new TankDroidA3();

    public TankDroid() {
        this.tankDroidA1 = new TankDroidA1();
        this.tankDroidA2 = new TankDroidA2();
        this.tankDroidA3 = new TankDroidA3();
    }

    public TankDroid(boolean newDroid) {
        super(newDroid);
    }

    public TankDroid(String name, int hp, int atc, int def) {
        super(name, hp, atc, def);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(this.tankDroidA1, this.tankDroidA2, this.tankDroidA3));
    }
}

