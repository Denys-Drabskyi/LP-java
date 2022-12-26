package commands.main.necklace;

import commands.Command;
import commands.main.MainMenu;
import commands.main.necklace.delete.DeleteNeckless;
import commands.main.necklace.edit.EditNeckless;
import commands.main.necklace.sort.SortStonesInNeckless;
import commands.main.necklace.weightAndPrice.PrintWeightAndPrice;
import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MyNecklaceTest {

    public static Stream<Arguments> source() {

        PreciousStone s1 = PreciousStone.builder()
                .type(new StoneType("das",2))
                .pricePerCarat(12)
                .name("s1")
                .build();
        PreciousStone s2 = PreciousStone.builder()
                .type(new StoneType("vrc",1))
                .pricePerCarat(15)
                .name("s2")
                .build();
        PreciousStone s3 = PreciousStone.builder()
                .type(new StoneType("hba",1))
                .pricePerCarat(7)
                .name("s3")
                .build();

        JsonConverterData jsonConverterData = mock(JsonConverterData.class);
        when(jsonConverterData.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>(Arrays.asList(s1,s2,s3))));

        JsonConverterData jsonConverterData1 = mock(JsonConverterData.class);
        when(jsonConverterData1.getNecklace()).thenReturn(null);

        JsonConverterData jsonConverterData2 = mock(JsonConverterData.class);
        when(jsonConverterData2.getNecklace()).thenReturn(new Necklace(new LinkedHashSet<>()));

        return Stream.of(
                Arguments.arguments(jsonConverterData,"1", EditNeckless.class),
                Arguments.arguments(jsonConverterData,"-1\n2", SortStonesInNeckless.class),
                Arguments.arguments(jsonConverterData,"0\n3", PrintWeightAndPrice.class),
                Arguments.arguments(jsonConverterData,"7\n4", DeleteNeckless.class),
                Arguments.arguments(jsonConverterData,"5", MainMenu.class),
                Arguments.arguments(jsonConverterData1,"1", EditNeckless.class),
                Arguments.arguments(jsonConverterData2,"2", MainMenu.class)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void myNecklaceTest(JsonConverterData jsonConverterData, String input, Class<Command> expected){
        InputStream my = new ByteArrayInputStream(input.getBytes());
        System.setIn(my);

        MyNecklace myNecklace = new MyNecklace(jsonConverterData);
        assertEquals(expected,myNecklace.execute().getClass());

    }

}