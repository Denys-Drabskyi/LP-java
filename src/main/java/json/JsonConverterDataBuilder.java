package json;

import necklace.Necklace;
import precious_stones.PreciousStone;

import java.util.ArrayList;
import java.util.List;

public class JsonConverterDataBuilder {

    private List<PreciousStone> stones;
    private Necklace necklace;


    public JsonConverterDataBuilder() {
        this.stones = new ArrayList<>();
        this.necklace = null;
    }


    public JsonConverterData build (){
        return new JsonConverterData(stones,necklace);
    }

    public JsonConverterDataBuilder setStones(List<PreciousStone> stones) {
        this.stones = stones;
        return this;
    }

    public JsonConverterDataBuilder setNecklace(Necklace necklace) {
        this.necklace = necklace;
        return this;
    }
}
