package commands;

import json.JsonConverterData;

public class DeleteNeckless extends Command {
    public DeleteNeckless(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
