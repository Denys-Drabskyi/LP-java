package commands.main;

import json.JsonConverterData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainMenuTest {
//    @Mock
    MainMenu mainMenu;

    @Mock
    JsonConverterData jsonConverterData;

    @BeforeEach
    void init (){
        MockitoAnnotations.openMocks(this);
        mainMenu = new MainMenu(jsonConverterData);
    }

    @Test
    public void shouldTakeUserInput() {
        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("add 5", mainMenu.scanner().nextLine());
    }

    @Test
    void execute() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3\n4\n".getBytes()));
        assertEquals("3", mainMenu.scanner().nextLine());

    }

    void setInputStream(String s){
        InputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
    }
}