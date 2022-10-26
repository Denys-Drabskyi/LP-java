package commands.main.necklace.edit.stone.delete;

import commands.Command;
import json.JsonConverterData;

public class DeleteStoneFromNeckless extends Command {
    private final int stoneIndexInNeckless;
    public DeleteStoneFromNeckless(JsonConverterData data, int stoneIndexInNeckless) {
        super(data);
        this.stoneIndexInNeckless = stoneIndexInNeckless;
    }

    // TODO: 27.10.2022  
    @Override
    public boolean execute() {
        
        return true;
    }
}
