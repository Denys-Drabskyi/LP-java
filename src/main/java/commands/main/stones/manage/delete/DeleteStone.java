package commands.main.stones.manage.delete;

import commands.Command;
import commands.main.stones.MyStones;
import json.JsonConverterData;
import lombok.extern.slf4j.Slf4j;
import precious_stones.PreciousStone;
public class DeleteStone extends Command {
    private final PreciousStone stone;
    public DeleteStone(JsonConverterData jsonConverterData, PreciousStone stone) {
        super(jsonConverterData);
        this.stone = stone;

    }
    @Override
    public Command execute() {
        logger().error("i was here");
        data().getNecklace().getStones().remove(getStone());
        data().getStones().remove(getStone());
        updateData();
        logger().info("removed stone {}",getStone().getName());
        System.out.println("Камінь видалено");
        return new MyStones(data());
    }

    public PreciousStone getStone() {
        return stone;
    }
}
