package commands.main.necklace.weightAndPrice;

import commands.Command;
import commands.main.necklace.MyNecklace;
import json.JsonConverterData;
import precious_stones.PreciousStone;

public class PrintWeightAndPrice extends Command {

    public PrintWeightAndPrice(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public Command execute() {
        if (!data().getNecklace().getStones().isEmpty()) {
            int weight = data().getNecklace().getStones().stream().mapToInt(PreciousStone::getWeight).sum();
            int sum = data().getNecklace().getStones().stream().mapToInt(PreciousStone::getPrice).sum();
            System.out.printf("\nЗагальна вага каменів в намисті: %d, вартість: %d\n", weight, sum);
        } else
            System.out.println("не можна визначити вагу та вартість пустого намиста");
        return new MyNecklace(data());
    }
}
