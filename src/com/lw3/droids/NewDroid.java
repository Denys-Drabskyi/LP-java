package com.lw3.droids;

import com.lw3.attacks.A1.NewDroidA1;
import com.lw3.attacks.A2.NewDroidA2;
import com.lw3.attacks.A3.NewDroidA3;

public class NewDroid extends Droid {
    public NewDroid() {
        super(new NewDroidA1(), new NewDroidA2(),new NewDroidA3());
    }
}

