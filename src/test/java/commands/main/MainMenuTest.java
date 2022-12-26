package commands.main;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.settings.Settings;
import commands.main.stones.MyStones;
import json.JsonConverterData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.verify;

class MainMenuTest {
    MainMenu mainMenu;
    @Mock
    JsonConverterData jsonConverterData;

    @ParameterizedTest
    @MethodSource("source")
    void test(String input, Class<Command> expectedClass){
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        mainMenu = new MainMenu(jsonConverterData);
        Command command = mainMenu.execute();
        assertEquals(expectedClass, command.getClass());
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments("0\n1", MyNecklace.class),
                arguments("2", MyStones.class),
                arguments("-3\n7\n3", Settings.class)
        );
    }

}