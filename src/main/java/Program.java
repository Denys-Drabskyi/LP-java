import commands.main.MainMenu;
import json.JsonConverter;
import json.JsonConverterData;

public class Program {
    public static void main(String[] args) {
        JsonConverterData jsonConverterData = JsonConverter.convertToJsonConverterData();
        new MainMenu(jsonConverterData).execute();
    }
}
