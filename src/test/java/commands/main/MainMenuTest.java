package commands.main;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.settings.Settings;
import commands.main.stones.MyStones;
import json.JsonConverterData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MainMenuTest {
    MainMenu mainMenu;
    @Mock
    JsonConverterData jsonConverterData;

    @Test
    void shouldReturnMyNecklace(){
        String testInput = "0\n1";
        InputStream in = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        mainMenu = new MainMenu(jsonConverterData);
        Command command = mainMenu.execute();
        assertEquals(MyNecklace.class,command.getClass());

    }
    @Test
    void shouldReturnMyStones(){
        String testInput = "2";
        InputStream in = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        mainMenu = new MainMenu(jsonConverterData);
        Command command = mainMenu.execute();
        assertEquals(MyStones.class, command.getClass());

    }
    @Test
    void shouldReturnSettings(){
        String testInput = "3";
        InputStream in = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        mainMenu = new MainMenu(jsonConverterData);
        Command command = mainMenu.execute();
        assertEquals(Settings.class, command.getClass());

    }
}