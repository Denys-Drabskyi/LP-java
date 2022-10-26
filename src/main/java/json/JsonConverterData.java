package json;

import necklace.Necklace;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.util.List;

public class JsonConverterData {
    private final List<PreciousStone> stones;
    private final Necklace necklace;
    private final List<StoneType> types;

    public JsonConverterData(List<PreciousStone> test, Necklace necklace, List<StoneType> types) {
        this.necklace = necklace;
        this.stones = test;
        this.types = types;
    }

    public List<PreciousStone> getStones() {
        return stones;
    }

    public Necklace getNecklace() {
        return necklace;
    }

    public List<StoneType> getTypes() {
        return types;
    }
}
