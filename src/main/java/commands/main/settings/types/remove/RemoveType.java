package commands.main.settings.types.remove;

import commands.Command;
import json.JsonConverterData;

public class RemoveType extends Command {

    public RemoveType(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
