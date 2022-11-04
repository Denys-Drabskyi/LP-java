package commands.main.necklace.edit.stone.add;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import commands.main.necklace.edit.stone.EditStoneInNeckless;
import json.JsonConverterData;
import precious_stones.PreciousStone;

import java.util.List;

public class AddStoneToNeckless extends Command {

    @Override
    public boolean execute() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        System.out.println("Виберіть камінь, який хочете добавити");
        List<PreciousStone> unusedStones = data.getStones().stream()
                .filter(x -> ! data.getNecklace().getStones().contains(x))
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
            i = s.nextInt();
        } while (i < 0 || i > unusedStones.size());

        if (i == unusedStones.size())
            new EditNeckless(data).execute();

        data.getNecklace().addStone(unusedStones.get(i));
        updateData();
        new  EditNeckless(data).execute();
        return true;
    }

    public AddStoneToNeckless(JsonConverterData data) {
        super(data);
    }

}
