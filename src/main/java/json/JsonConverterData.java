package json;

import necklace.Necklace;
import precious_stones.PreciousStone;
import java.util.List;

public class JsonConverterData {
    private final List<PreciousStone> stones;
    private final Necklace necklace;

    public JsonConverterData(List<PreciousStone> test, Necklace necklace) {
        this.necklace = necklace;
        this.stones = test;
    }

    public List<PreciousStone> getStones() {
        return stones;
    }

    public Necklace getNecklace() {
        return necklace;
    }
}
