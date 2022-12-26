package commands.main.necklace.edit.stone.replace;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
@Slf4j
class EditStoneInNecklessTest extends ConsoleCheck {

    public static Stream<Arguments> source() {
        PreciousStone s1 = mock(PreciousStone.class);
        PreciousStone s2 = mock(PreciousStone.class);
        PreciousStone s3 = mock(PreciousStone.class);
        PreciousStone s4 = mock(PreciousStone.class);
        PreciousStone s5 = mock(PreciousStone.class);

        JsonConverterData jsonConverterData1 = JsonConverterData.builder()
                .stones(new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5)))
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s3,s2))))
                .build();

        JsonConverterData jsonConverterData2 = JsonConverterData.builder()
                .stones(new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5)))
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s1,s2,s5))))
                .build();
        JsonConverterData jsonConverterData3 = JsonConverterData.builder()
                .stones(new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5)))
                .necklace(new Necklace(new LinkedHashSet<>(Arrays.asList(s1,s2,s3,s4,s5))))
                .build();
        return Stream.of(
                Arguments.arguments(jsonConverterData1, 0, "0", s1, "3 -> Назад"),
                Arguments.arguments(jsonConverterData2, 2, "0", s3, "2 -> Назад"),
                Arguments.arguments(jsonConverterData3, 0, "0", null, "Усі доступні камінці вже доданодо намиста")
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void replaceStoneInNecklessTest(JsonConverterData data, int indexWhichReplace, String replaceIndex, PreciousStone expectedReplaced, String expectedString){
        InputStream def = System.in;
        InputStream my = new ByteArrayInputStream(replaceIndex.getBytes());
        System.setIn(my);

        ReplaceStoneInNeckless command = new ReplaceStoneInNeckless(data, indexWhichReplace);
        PreciousStone toReplace = data.getNecklace().getStones().stream().toList().get(indexWhichReplace);
        command.execute();
        assertTrue(console.toString().contains(expectedString));
        if (data.getNecklace().getStones().size() != data.getStones().size()){
            assertTrue(data.getNecklace().getStones().contains(expectedReplaced));
            assertFalse(data.getNecklace().getStones().contains(toReplace));
        }

        System.setIn(def);

    }
}