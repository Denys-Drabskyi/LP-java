package commands.main.stones.manage.delete;

import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import precious_stones.PreciousStone;
import precious_stones.PreciousStoneBuilder;
import precious_stones.StoneType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeleteStoneTest {

//    @Mock
//    JsonConverterData jsonConverterData;

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

        deleteStone.execute();

//        assertEquals(1,necklace.getStones().size());
        assertEquals(1,stones.size());
        assertEquals(preciousStone2, stones.get(0));

    }

//    @BeforeAll
//    public void prepareData(){
//
//    }
}