package necklace;

import precious_stones.PreciousStone;

import java.util.List;

public class Necklace {
    List<PreciousStone> stones;

    public Necklace(List<PreciousStone> stones) {
        this.stones = stones;
    }

    public List<PreciousStone> getStones() {
        return stones;
    }
}
