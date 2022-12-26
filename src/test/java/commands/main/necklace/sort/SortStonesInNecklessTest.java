package commands.main.necklace.sort;

import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SortStonesInNecklessTest {
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

        JsonConverterData jsonConverterData1 = JsonConverterData.builder()
                .stones(new ArrayList<>())
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s3,s2,s1))))
                .build();

        JsonConverterData jsonConverterData2 = JsonConverterData.builder()
                .stones(new ArrayList<>())
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s1,s2,s3))))
                .build();

        ArrayList<PreciousStone> expected = new ArrayList<>(Arrays.asList(s3,s2,s1));

        return Stream.of(
                Arguments.arguments(jsonConverterData1, expected),
                Arguments.arguments(jsonConverterData2, expected)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void sortStonesInNecklessTest(JsonConverterData jsonConverterData, List<PreciousStone> expected){
        SortStonesInNeckless sortStonesInNeckless = new SortStonesInNeckless(jsonConverterData);
        sortStonesInNeckless.execute();
        assertEquals(expected,jsonConverterData.getNecklace().getStones().stream().toList());
    }


}