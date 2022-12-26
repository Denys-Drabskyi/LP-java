package commands.main.stones;

import commands.Command;
import commands.main.MainMenu;
import commands.main.stones.create.CreateStone;
import commands.main.stones.manage.ManageStone;
import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import precious_stones.StoneType;
import test.ConsoleCheck;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyStonesTest extends ConsoleCheck {

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
        JsonConverterData jsonConverterData = new JsonConverterData(
                new ArrayList<>(Arrays.asList(s1,s2,s3)),
                new Necklace(new LinkedHashSet<>()),
                new ArrayList<>()
        );

        return Stream.of(
                Arguments.arguments(jsonConverterData, "4 -> Новий камінець", "1", ManageStone.class),
                Arguments.arguments(jsonConverterData, "4 -> Новий камінець", "4", CreateStone.class),
                Arguments.arguments(jsonConverterData, "4 -> Новий камінець", "5", MainMenu.class)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void myStonesTest(JsonConverterData data, String expected, String input, Class<Command> expectedClass){
        InputStream my = new ByteArrayInputStream(input.getBytes());
        System.setIn(my);

        MyStones myStones = new MyStones(data);
        assertEquals(expectedClass, myStones.execute().getClass());
        assertTrue(console.toString().contains(expected));

    }
    

}