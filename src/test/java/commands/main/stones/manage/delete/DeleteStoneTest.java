package commands.main.stones.manage.delete;

import commands.Command;
import commands.main.stones.MyStones;
import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import precious_stones.PreciousStone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeleteStoneTest {

    @ParameterizedTest
    @MethodSource("source")
    void deleteStoneTest(DeleteStone deleteStone, PreciousStone remained) {

        assertEquals(2,deleteStone.data().getStones().size());
        Command command = deleteStone.execute();
        assertEquals(1,deleteStone.data().getStones().size());
        assertEquals(remained, deleteStone.data().getStones().get(0));
        assertEquals(MyStones.class, command.getClass());
    }

    private static Stream<Arguments> source(){
        JsonConverterData jsonConverterData1 = newData();
        JsonConverterData jsonConverterData2 = newData();
        return Stream.of(
                Arguments.arguments(new DeleteStone(jsonConverterData1, jsonConverterData1.getStones().get(0)), jsonConverterData1.getStones().get(1)),
                Arguments.arguments(new DeleteStone(jsonConverterData2, jsonConverterData2.getStones().get(1)), jsonConverterData2.getStones().get(0))
        );
    }

    private static JsonConverterData newData(){
        JsonConverterData jsonConverterData = Mockito.mock(JsonConverterData.class);

        PreciousStone preciousStone1 = mock(PreciousStone.class);
        PreciousStone preciousStone2 = mock(PreciousStone.class);
        ArrayList<PreciousStone> stones = new ArrayList<>(Arrays.asList(preciousStone1,preciousStone2));

        Necklace necklace = new Necklace(new LinkedHashSet<>(stones));
        when(jsonConverterData.getNecklace()).thenReturn(necklace);
        when(jsonConverterData.getStones()).thenReturn(stones);
        return jsonConverterData;
    }
}