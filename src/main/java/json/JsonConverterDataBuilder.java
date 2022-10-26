package json;

import necklace.Necklace;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.util.ArrayList;
import java.util.List;

public class JsonConverterDataBuilder {
    private List<PreciousStone> stones;
    private Necklace necklace;
    private List<StoneType> types;

    public JsonConverterDataBuilder() {
        this.stones = new ArrayList<>();
        this.necklace = null;
        this.types = new ArrayList<>();
    }

    public JsonConverterDataBuilder(JsonConverterData jsonConverterData) {
        this.stones = jsonConverterData.getStones();
        this.necklace = jsonConverterData.getNecklace();
        this.types = jsonConverterData.getTypes();
    }

    public JsonConverterData build (){
        return new JsonConverterData(stones, necklace, types);
    }

    public JsonConverterDataBuilder setStones(List<PreciousStone> stones) {
        this.stones = stones;
        return this;
    }

    public JsonConverterDataBuilder addStone(PreciousStone stone) {
        this.stones.add(stone);
        return this;
    }

    public JsonConverterDataBuilder addType(StoneType type) {
        this.types.add(type);
        return this;
    }

    public JsonConverterDataBuilder setNecklace(Necklace necklace) {
        this.necklace = necklace;
        return this;
    }

    public JsonConverterDataBuilder setTypes(List<StoneType> types) {
        this.types = types;
        return this;
    }
}
