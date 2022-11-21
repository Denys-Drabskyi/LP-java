package commands.main;

import commands.main.necklace.MyNecklace;
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

//    Integer counter = 0;
//    @BeforeEach
//    void init (){
//        MockitoAnnotations.openMocks(this);
////        String input = "add 5";
//        InputStream in = new ByteArrayInputStream(String.valueOf(counter).getBytes(StandardCharsets.UTF_8));
//        System.setIn(in);
//        mainMenu = new MainMenu(jsonConverterData);
//
//    }

//    @AfterEach
//    void counterAddition (){
//        counter++;
//    }

//    @Test
//    public void shouldTakeUserInput() {
//        assertEquals("add 5", mainMenu.scanner().nextLine());
//        assertEquals(3, mainMenu.scanner().nextInt());
//    }

    @Test
    void inputsTest(){
        String testInput = "0\n1";
        InputStream in = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        mainMenu = new MainMenu(jsonConverterData);
        mainMenu.execute();
        verify(mainMenu, times(2)).scanner();
        verify(mainMenu, times(1)).data();
    }
}