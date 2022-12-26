package commands.main.necklace.weightAndPrice;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.settings.Settings;
import commands.main.stones.MyStones;
import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import test.ConsoleCheck;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PrintWeightAndPriceTest extends ConsoleCheck {

    @ParameterizedTest
    @MethodSource("source")
    void printWeightAndPriceTest (JsonConverterData data, String contains){
        PrintWeightAndPrice printWeightAndPrice = new PrintWeightAndPrice(data);
        Command command = printWeightAndPrice.execute();
        assertTrue(console.toString().contains(contains));
        assertEquals(MyNecklace.class, command.getClass());
    }

    static Stream<Arguments> source() {
        PreciousStone stone = mock(PreciousStone.class);
        when(stone.getWeight()).thenReturn(10);
        when(stone.getPrice()).thenReturn(200);

        PreciousStone stone1= mock(PreciousStone.class);
        when(stone1.getWeight()).thenReturn(7);
        when(stone1.getPrice()).thenReturn(140);

        JsonConverterData jsonConverterData1 = JsonConverterData.builder()
                .necklace(
                        new Necklace(new LinkedHashSet<>(Arrays.asList(stone,stone1)))
                ).build();

        JsonConverterData jsonConverterData2 = JsonConverterData.builder().necklace(new Necklace(
                new LinkedHashSet<>()
        )).build();



        return Stream.of(
                arguments(jsonConverterData1, "Загальна вага каменів в намисті: 17, вартість: 340"),
                arguments(jsonConverterData2, "Не можна визначити вагу та вартість пустого намиста")
        );
    }
}