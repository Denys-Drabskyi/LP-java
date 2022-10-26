package commands.main.necklace.edit.stone.replace;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;

public class ReplaceStoneInNeckless extends Command {
    private final int stoneIndexInNeckless;
    public ReplaceStoneInNeckless(JsonConverterData jsonConverterData, int stoneIndexInNeckless) {
        super(jsonConverterData);
        this.stoneIndexInNeckless = stoneIndexInNeckless;
    }

    @Override
    public boolean execute() {
        data.getStones().remove(stoneIndexInNeckless);
        System.out.println("видалено");

        updateData();

        new EditNeckless(data).execute();
        return false;
    }
}
