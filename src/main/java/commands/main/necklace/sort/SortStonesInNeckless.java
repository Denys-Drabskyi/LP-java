package commands.main.necklace.sort;

import commands.Command;
import commands.main.necklace.MyNecklace;
import json.JsonConverterData;

public class SortStonesInNeckless extends Command {
    public SortStonesInNeckless(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public Command execute() {
        data().getNecklace().sortByRarityAndValue();
        System.out.println(
                """
                 Каміння в намисті відсортовано за типом,
                 при однаковому типі за вартістю,
                 а при однаковій вартості та типу за назвою""");
        return new MyNecklace(data());
    }
}
