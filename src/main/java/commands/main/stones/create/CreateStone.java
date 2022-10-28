package commands.main.stones.create;

import commands.Command;
import commands.main.stones.MyStones;
import json.JsonConverterData;
import precious_stones.PreciousStone;
import precious_stones.PreciousStoneBuilder;

public class CreateStone extends Command {
    public CreateStone(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {

        PreciousStone preciousStone = new PreciousStoneBuilder().build();
        data.getStones().add(preciousStone);
        if (data.getStones().contains(preciousStone)){
            System.out.println("Камінь додано успішно");
            logger.info("Created stone "+preciousStone);
        }

        updateData();

        new MyStones(data).execute();
        return false;
    }
}
