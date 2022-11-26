package com.lw3.droids;

import com.lw3.attacks.A1.TankDroidA1;
import com.lw3.attacks.A2.TankDroidA2;
import com.lw3.attacks.A3.TankDroidA3;

public class TankDroid extends Droid {


    public TankDroid() {
        super(new TankDroidA1(), new TankDroidA2(),new TankDroidA3());
    }

    public TankDroid(String name, int hp, int atc, int def) {
        super(new TankDroidA1(), new TankDroidA2(),new TankDroidA3(), name, hp, atc, def);
    }
}

