package commands.main.stones.create;

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
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CreateStoneTest {


    public static Stream<Arguments> source() {
        JsonConverterData jsonConverterData = new JsonConverterData(new ArrayList<>(), new Necklace(new LinkedHashSet<>()),new ArrayList<>());
        jsonConverterData.getTypes().add(new StoneType("Diamond",2));
        jsonConverterData.getTypes().add(new StoneType("Ruby",3));


        return Stream.of(
                Arguments.arguments(jsonConverterData, "name1\n12\n10\n0,2\n0", new PreciousStone("name1",12,10,0.2, new StoneType("Diamond",2))),
                Arguments.arguments(jsonConverterData, "name2\n-1\n10\n-3\n10\n2,2\n0,3\n1", new PreciousStone("name2",10,10,0.3, new StoneType("Ruby",3)))
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void createStoneTest(JsonConverterData jsonConverterData, String input, PreciousStone expected){
        InputStream my = new ByteArrayInputStream(input.getBytes());
        System.setIn(my);

        CreateStone createStone = new CreateStone(jsonConverterData);
        createStone.execute();
        assertTrue(jsonConverterData.getStones().contains(expected));

    }

}