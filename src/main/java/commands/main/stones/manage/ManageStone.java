package commands.main.stones.manage;

import commands.Command;
import json.JsonConverterData;
import precious_stones.PreciousStone;

public class ManageStone extends Command {
    public ManageStone(JsonConverterData data, PreciousStone preciousStone) {
        super(data);
    }

    @Override
    public Command execute() {
        return null;
    }
}
