package commands.main.stones.manage;

import commands.Command;
import commands.main.stones.MyStones;
import commands.main.stones.manage.delete.DeleteStone;
import commands.main.stones.manage.edit.EditStone;
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
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ManageStoneTest {

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
                Arguments.arguments(jsonConverterData, s1,"1", EditStone.class),
                Arguments.arguments(jsonConverterData, s2,"2", DeleteStone.class),
                Arguments.arguments(jsonConverterData, s3,"3", MyStones.class)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void manageStoneTest(JsonConverterData jsonConverterData, PreciousStone stone, String input, Class<Command> expected){
        InputStream my = new ByteArrayInputStream(input.getBytes());
        System.setIn(my);

        ManageStone manageStone = new ManageStone(jsonConverterData,stone);
        assertEquals(expected, manageStone.execute().getClass());
    }

}