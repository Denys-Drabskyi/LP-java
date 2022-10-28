package necklace;

import precious_stones.PreciousStone;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class NecklaceBuilder {
    LinkedHashSet<PreciousStone> stones;

    public NecklaceBuilder() {
        stones = new LinkedHashSet<>();
    }

    public NecklaceBuilder setStones(LinkedHashSet<PreciousStone> stones) {
        this.stones = stones;
        return this;
    }

    public NecklaceBuilder addStone (PreciousStone preciousStone) {
        this.stones.add(preciousStone);
        return this;
    }

    public Necklace build (){
        return new Necklace(stones);
    }
}
