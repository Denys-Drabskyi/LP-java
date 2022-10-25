package necklace;

import precious_stones.PreciousStone;

import java.util.ArrayList;
import java.util.List;

public class NecklaceBuilder {
    List<PreciousStone> stones;

    public NecklaceBuilder() {
        stones = new ArrayList<>();
    }

    public NecklaceBuilder setStones(List<PreciousStone> stones) {
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
