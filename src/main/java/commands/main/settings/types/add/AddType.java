package commands.main.settings.types.add;

import commands.Command;
import json.JsonConverterData;

public class AddType extends Command {

    public AddType(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
