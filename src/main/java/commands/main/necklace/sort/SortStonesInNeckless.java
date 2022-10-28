package commands.main.necklace.sort;

import commands.Command;
import commands.main.necklace.MyNecklace;
import json.JsonConverterData;

public class SortStonesInNeckless extends Command {
    public SortStonesInNeckless(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        data.getNecklace().sortByRarityAndValue();
        System.out.println("\nКаміння в намисті відсортовано за типом,\n при однаковому типі за вартістю,\n а при однаковій вартості та типу за назвою");

        this.updateData();

        new  MyNecklace(data).execute();
        return true;
    }
}
