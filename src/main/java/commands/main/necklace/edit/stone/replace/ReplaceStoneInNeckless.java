package commands.main.necklace.edit.stone.replace;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;

import java.util.ArrayList;
import java.util.HashMap;

public class ReplaceStoneInNeckless extends Command {
    private final int stoneIndexInNeckless;
    public ReplaceStoneInNeckless(JsonConverterData jsonConverterData, int stoneIndexInNeckless) {
        super(jsonConverterData);
        this.stoneIndexInNeckless = stoneIndexInNeckless;
    }

    // TODO: 27.10.2022  
    @Override
    public boolean execute() {

        HashMap<String, Integer> rez = printStones(
                "Виберіть камінь на який хочете замінити",
                data.getStones());

        data.getNecklace().replaceStone(stoneIndexInNeckless, data.getStones().get(rez.get("i")));

        updateData();

        new  EditNeckless(data).execute();
        return true;
    }
}
