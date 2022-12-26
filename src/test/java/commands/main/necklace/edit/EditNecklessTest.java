package commands.main.necklace.edit;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.necklace.edit.stone.EditStoneInNeckless;
import commands.main.necklace.edit.stone.add.AddStoneToNeckless;
import json.JsonConverter;
import json.JsonConverterData;
import lombok.extern.slf4j.Slf4j;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import test.ConsoleCheck;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@Slf4j
class EditNecklessTest extends ConsoleCheck {

    public static Stream<Arguments> source() {
        PreciousStone preciousStone = mock(PreciousStone.class);
        PreciousStone preciousStone1 = mock(PreciousStone.class);

        JsonConverterData jsonConverterData1 = mock(JsonConverterData.class);
        when(jsonConverterData1.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>(Arrays.asList(preciousStone, preciousStone1))));

        JsonConverterData jsonConverterData2 = mock(JsonConverterData.class);
        when(jsonConverterData2.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>(Collections.singleton(preciousStone))));

        JsonConverterData jsonConverterData3 = mock(JsonConverterData.class);
        when(jsonConverterData3.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>()));


        return Stream.of(
                Arguments.arguments(jsonConverterData1, "2 -> додати камінь","2", AddStoneToNeckless.class),
                Arguments.arguments(jsonConverterData2, "1 -> додати камінь","1", AddStoneToNeckless.class),
                Arguments.arguments(jsonConverterData3, "0 -> додати камінь","0", AddStoneToNeckless.class),
                Arguments.arguments(jsonConverterData1, "2 -> додати камінь","1", EditStoneInNeckless.class),
                Arguments.arguments(jsonConverterData1, "2 -> додати камінь","3", MyNecklace.class)
                );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void editNecklessMenuTest(JsonConverterData data, String contains, String input, Class<Command> expected){
        InputStream base = System.in;
        InputStream my = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(my);

        EditNeckless editNeckless = new EditNeckless(data);
        assertEquals(expected, editNeckless.execute().getClass());
        assertTrue(console.toString().contains(contains));
        System.setIn(base);

    }


}