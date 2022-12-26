package commands.main.necklace.edit.stone.delete;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;
import precious_stones.PreciousStone;

public class DeleteStoneFromNeckless extends Command {
    private final PreciousStone stone;
    public DeleteStoneFromNeckless(JsonConverterData data, PreciousStone stone) {
        super(data);
        this.stone = stone;
    }

    @Override
    public Command execute() {
        data().getNecklace().getStones().remove(stone);
        System.out.println("видалено");
        logger().info("deleted stone {} from necklace", stone.getName());
//        updateData();
        return new EditNeckless(data());
    }
}
