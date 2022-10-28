package commands.main.settings.types.edit;

import commands.Command;
import json.JsonConverterData;

public class EditType extends Command {
    public EditType(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
