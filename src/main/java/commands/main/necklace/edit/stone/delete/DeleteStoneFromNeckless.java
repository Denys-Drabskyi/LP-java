package commands.main.necklace.edit.stone.delete;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;

public class DeleteStoneFromNeckless extends Command {
    private final int stoneIndexInNeckless;
    public DeleteStoneFromNeckless(JsonConverterData data, int stoneIndexInNeckless) {
        super(data);
        this.stoneIndexInNeckless = stoneIndexInNeckless;
    }

    @Override
    public boolean execute() {
        data.getNecklace().getStones().remove(stoneIndexInNeckless);
        System.out.println("видалено");

        updateData();

        new EditNeckless(data).execute();
        return true;
    }
}
