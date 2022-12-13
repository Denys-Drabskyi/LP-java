package commands.main.stones.manage.delete;

import commands.Command;
import commands.main.stones.MyStones;
import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import precious_stones.PreciousStone;
import precious_stones.PreciousStoneBuilder;
import precious_stones.StoneType;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeleteStoneTest {

    @Test
    void deleteStoneTest() {
        JsonConverterData jsonConverterData = Mockito.mock(JsonConverterData.class);
        PreciousStone preciousStone1 = new PreciousStoneBuilder()
                .setName("name1")
                .setPricePerCarat(10)
                .setTransparency(0.2)
                .setWeight(12)
                .setType(new StoneType("type1",1))
                .build();
        PreciousStone preciousStone2 = new PreciousStoneBuilder()
                .setName("name2")
                .setPricePerCarat(10)
                .setTransparency(0.2)
                .setWeight(12)
                .setType(new StoneType("type2",2))
                .build();
        ArrayList<PreciousStone> stones = new ArrayList<>();
        stones.add(preciousStone1);
        stones.add(preciousStone2);
        Necklace necklace = new Necklace(new LinkedHashSet<>(stones));

        when(jsonConverterData.getNecklace()).thenReturn(necklace);
        when(jsonConverterData.getStones()).thenReturn(stones);

        DeleteStone deleteStone = Mockito.mock(DeleteStone.class);
        when(deleteStone.getStone()).thenReturn(preciousStone1);
        when(deleteStone.data()).thenReturn(jsonConverterData);

        assertEquals(2,deleteStone.data().getStones().size());
        Command command = deleteStone.execute();
        assertEquals(command.getClass(), MyStones.class);
        assertEquals(1,deleteStone.data().getStones().size());
    }

    private void doNothing(){}
}