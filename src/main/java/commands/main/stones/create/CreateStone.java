package commands.main.stones.create;

import commands.Command;
import json.JsonConverterData;

public class CreateStone extends Command {
    public CreateStone(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
