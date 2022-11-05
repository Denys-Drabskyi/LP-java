package commands.main.necklace.delete;

import commands.Command;
import commands.main.necklace.MyNecklace;
import json.JsonConverterData;
import java.util.LinkedHashSet;

public class DeleteNeckless extends Command {
    public DeleteNeckless(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        data().getNecklace().setStones(new LinkedHashSet<>());
        logger().info("necklace was cleared");
        System.out.println("Намисто видалено");

        this.updateData();

        new MyNecklace(data()).execute();
        return false;
    }
}
