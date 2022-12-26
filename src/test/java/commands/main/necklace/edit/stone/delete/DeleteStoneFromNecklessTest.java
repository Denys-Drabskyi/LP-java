package commands.main.necklace.edit.stone.delete;

import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DeleteStoneFromNecklessTest {

    public static Stream<Arguments> source() {
        PreciousStone preciousStone = mock(PreciousStone.class);
        PreciousStone preciousStone1 = mock(PreciousStone.class);

        JsonConverterData jsonConverterData = JsonConverterData.builder().necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(preciousStone,preciousStone1)))).build();

        JsonConverterData jsonConverterData1 = JsonConverterData.builder().necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(preciousStone,preciousStone1)))).build();

        return Stream.of(
                Arguments.arguments(jsonConverterData, preciousStone, preciousStone1),
                Arguments.arguments(jsonConverterData1, preciousStone1, preciousStone)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void deleteStoneFromNecklessTest(JsonConverterData jsonConverterData, PreciousStone delete, PreciousStone remaining){
        DeleteStoneFromNeckless command = new DeleteStoneFromNeckless(jsonConverterData, delete);
        command.execute();
        assertTrue(jsonConverterData.getNecklace().getStones().contains(remaining));
        assertFalse(jsonConverterData.getNecklace().getStones().contains(delete));
    }

}