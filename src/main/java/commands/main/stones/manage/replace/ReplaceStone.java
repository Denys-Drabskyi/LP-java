package commands.main.stones.manage.replace;

import commands.Command;
import json.JsonConverterData;
import precious_stones.PreciousStone;

// TODO: 27.10.2022
public class ReplaceStone extends Command {
    public ReplaceStone(JsonConverterData jsonConverterData, PreciousStone stone) {
        super(jsonConverterData);
    }

    @Override
    public Command execute() {
        return null;
    }
}
