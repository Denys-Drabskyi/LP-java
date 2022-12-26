package commands.main.necklace.edit;

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
        when(jsonConverterData1.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>(Collections.singletonList(preciousStone))));

        JsonConverterData jsonConverterData2 = mock(JsonConverterData.class);
        when(jsonConverterData2.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>(Arrays.asList(preciousStone, preciousStone1))));

        JsonConverterData jsonConverterData3 = mock(JsonConverterData.class);
        when(jsonConverterData2.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>()));


        return Stream.of(
                Arguments.arguments(jsonConverterData1, "3 -> додати камінь","3"),
                Arguments.arguments(jsonConverterData2, "2 -> додати камінь","2"),
                Arguments.arguments(jsonConverterData3, "1 -> додати камінь","1")
                );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void editNecklessMenuTest(JsonConverterData data, String contains, String input){
        InputStream base = System.in;
        InputStream my = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(my);
//        log.info(my.toString());
//        Scanner s = new Scanner(System.in);
//        log.info(String.valueOf(s.nextInt()));
        EditNeckless editNeckless = new EditNeckless(data);
        assertEquals(AddStoneToNeckless.class, editNeckless.execute().getClass());
        assertTrue(console.toString().contains(contains));
        System.setIn(base);

    }


}