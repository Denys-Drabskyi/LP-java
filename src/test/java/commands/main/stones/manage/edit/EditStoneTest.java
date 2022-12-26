package commands.main.stones.manage.edit;

import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EditStoneTest {
    public static Stream<Arguments> source() {
        PreciousStone preciousStone = PreciousStone.builder()
                .name("name1")
                .weight(10)
                .transparency(0.2)
                .pricePerCarat(10)
                .type(new StoneType("Diamond",2))
                .build();

        JsonConverterData jsonConverterData = new JsonConverterData(
                new ArrayList<>(Collections.singleton(preciousStone)),
                new Necklace(new LinkedHashSet<>(Collections.singletonList(preciousStone))),
                new ArrayList<>(Collections.singleton(new StoneType("Ruby", 3)))
        );

        return Stream.of(
                Arguments.arguments(jsonConverterData, "1\nnameChanged\n2\n12\n3\n20\n4\n0,5\n5\n0\n6", preciousStone,
                        new PreciousStone("nameChanged", 12, 20, 0.5, new StoneType("Ruby",3)))
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void editStoneTest(JsonConverterData jsonConverterData, String input, PreciousStone old, PreciousStone after){
        InputStream my = new ByteArrayInputStream(input.getBytes());
        System.setIn(my);
        EditStone editStone = new EditStone(jsonConverterData,old);
        assertEquals(old, jsonConverterData.getStones().get(0));
        editStone.execute();
        assertEquals(after, jsonConverterData.getStones().get(0));
        assertTrue(jsonConverterData.getNecklace().getStones().contains(after));

    }

}