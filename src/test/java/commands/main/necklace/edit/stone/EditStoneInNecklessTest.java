package commands.main.necklace.edit.stone;

import commands.Command;
import commands.main.necklace.edit.stone.delete.DeleteStoneFromNeckless;
import commands.main.necklace.edit.stone.replace.ReplaceStoneInNeckless;
import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EditStoneInNecklessTest {


    public static Stream<Arguments> source() {

        PreciousStone s1 = mock(PreciousStone.class);
        PreciousStone s2 = mock(PreciousStone.class);
        PreciousStone s3 = mock(PreciousStone.class);
        PreciousStone s4 = mock(PreciousStone.class);
        PreciousStone s5 = mock(PreciousStone.class);

        JsonConverterData jsonConverterData1 = JsonConverterData.builder()
                .stones(new ArrayList<>())
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s3,s2,s1))))
                .build();

        JsonConverterData jsonConverterData2 = JsonConverterData.builder()
                .stones(new ArrayList<>())
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s1,s2,s5))))
                .build();

        return Stream.of(
                Arguments.arguments(jsonConverterData1, 0, "1", ReplaceStoneInNeckless.class),
                Arguments.arguments(jsonConverterData2, 2, "2", DeleteStoneFromNeckless.class)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void editStoneInNecklessTest(JsonConverterData data, int index, String input, Class<Command> expected){
        InputStream my = new ByteArrayInputStream(input.getBytes());
        System.setIn(my);
        EditStoneInNeckless editStoneInNeckless = new EditStoneInNeckless(data,index);
        assertEquals(expected, editStoneInNeckless.execute().getClass());


    }

}