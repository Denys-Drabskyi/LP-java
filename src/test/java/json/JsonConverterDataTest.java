package json;

import necklace.Necklace;
import org.junit.jupiter.api.Test;
import precious_stones.PreciousStone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class JsonConverterDataTest {

    // не готовий
    @Test
    public void jsonConverterDataEqualsTest(){
        PreciousStone preciousStone = mock(PreciousStone.class);
        PreciousStone preciousStone1 = mock(PreciousStone.class);
        JsonConverterData jsonConverterData = new JsonConverterData(new ArrayList<>(Arrays.asList(preciousStone1, preciousStone)), new Necklace(new LinkedHashSet<>()), new ArrayList<>());
        JsonConverterData jsonConverterData1 = new JsonConverterData(new ArrayList<>(Arrays.asList(preciousStone1, preciousStone)), new Necklace(new LinkedHashSet<>()), new ArrayList<>());
        jsonConverterData1.equals(jsonConverterData);
        jsonConverterData.newNecklace();
    }

}