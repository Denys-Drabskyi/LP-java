package commands.main.necklace.edit.stone.add;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;
import precious_stones.PreciousStone;

import java.util.List;

public class AddStoneToNeckless extends Command {

    @Override
    public Command execute() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        System.out.println("Виберіть камінь, який хочете добавити");
        List<PreciousStone> unusedStones = data().getStones().stream()
                .filter(x -> ! data().getNecklace().getStones().contains(x))
                .toList();

        while (i<unusedStones.size()){
            sb.append(String.format("%d: %s\n", i, unusedStones.get(i).toString()));
            i++;
        }

        if (unusedStones.size() == 0)
            sb.append("\nУсі доступні камінці вже доданодо намиста\n");
        sb.append(String.format("%d -> Назад",unusedStones.size()));

        do {
            System.out.println(sb);
            i = scanner().nextInt();
        } while (i < 0 || i > unusedStones.size());

        if (i == unusedStones.size())
            new EditNeckless(data()).execute();

        data().getNecklace().addStone(unusedStones.get(i));
        updateData();
        return new EditNeckless(data());
    }

    public AddStoneToNeckless(JsonConverterData data) {
        super(data);
    }

}
