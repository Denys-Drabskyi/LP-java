import commands.CommandProcessor;
import commands.main.MainMenu;
import json.JsonConverter;
import json.JsonConverterData;

public class Program {
    public static void main(String[] args) {
        JsonConverterData jsonConverterData = JsonConverter.convertToJsonConverterData();
        CommandProcessor commandProcessor = new CommandProcessor(new MainMenu(jsonConverterData));
        commandProcessor.execute();
    }
}
