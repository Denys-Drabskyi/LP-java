package commands.main.necklace.edit.stone.add;

import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import test.ConsoleCheck;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AddStoneToNecklessTest extends ConsoleCheck {


    public static Stream<Arguments> source() {
        PreciousStone s1 = mock(PreciousStone.class);
        PreciousStone s2 = mock(PreciousStone.class);
        PreciousStone s3 = mock(PreciousStone.class);
        PreciousStone s4 = mock(PreciousStone.class);
        PreciousStone s5 = mock(PreciousStone.class);

        JsonConverterData jsonConverterData1 = JsonConverterData.builder()
                .stones(new ArrayList<>())
                .necklace(new Necklace(new LinkedHashSet<>()))
                .build();

        JsonConverterData jsonConverterData2 = JsonConverterData.builder()
                .stones(new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5)))
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s1,s2,s5))))
                .build();

        return Stream.of(
                Arguments.arguments(jsonConverterData1, "0", "Усі доступні камінці вже доданодо намиста", 0),
                Arguments.arguments(jsonConverterData2, "1", "2 -> Назад", jsonConverterData2.getNecklace().getStones().size()+1)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void AddStoneTest(JsonConverterData data, String input,String expected,int expectedSize){
        InputStream def = System.in;
        InputStream my = new ByteArrayInputStream(input.getBytes());
        System.setIn(my);

        AddStoneToNeckless command = new AddStoneToNeckless(data);
        command.execute();

        assertTrue(console.toString().contains(expected));
        assertEquals(expectedSize, data.getNecklace().getStones().size());

        System.setIn(def);

    }


}