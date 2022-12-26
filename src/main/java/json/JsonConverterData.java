package json;

import lombok.Builder;
import necklace.Necklace;
import org.slf4j.LoggerFactory;
import precious_stones.PreciousStone;
import precious_stones.StoneType;
import java.util.*;

@Builder
public class JsonConverterData {
    private final List<PreciousStone> stones;
    private Necklace necklace;
    private final List<StoneType> types;

    public JsonConverterData(List<PreciousStone> stones, Necklace necklace, List<StoneType> types) {
        this.necklace = Objects.requireNonNullElseGet(necklace, () -> new Necklace(new LinkedHashSet<>()));
        this.stones = Objects.requireNonNullElseGet(stones, ArrayList::new);
        this.types = Objects.requireNonNullElseGet(types, ArrayList::new);
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

    public void newNecklace (){
        this.necklace = new Necklace(new LinkedHashSet<>());
    }
}
