package commands.main.necklace.edit.stone.replace;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;
import precious_stones.PreciousStone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReplaceStoneInNeckless extends Command {
    private final int stoneIndexInNeckless;
    public ReplaceStoneInNeckless(JsonConverterData jsonConverterData, int stoneIndexInNeckless) {
        super(jsonConverterData);
        this.stoneIndexInNeckless = stoneIndexInNeckless;
    }

    @Override
    public boolean execute() {
        StringBuilder sb = new StringBuilder("Виберіть камінь на який хочете замінити\n");

        List<PreciousStone> unusedStones = data.getStones().stream()
                .filter(x -> ! data.getNecklace().getStones().contains(x))
                .toList();

        int i = 0;
        while (i<unusedStones.size()){
            sb.append(String.format("%d: %s\n", i, unusedStones.get(i).toString()));
            i++;
        }

        if (unusedStones.size() == 0)
            sb.append("\nУсі доступні камінці вже доданодо намиста\n");
        sb.append(String.format("%d -> Назад",i));

        do {
            System.out.println(sb);
            i = s.nextInt();
        } while (i<0 || i>unusedStones.size());

        if (i == unusedStones.size())
            new EditNeckless(data).execute();

        data.getNecklace().replaceStone(stoneIndexInNeckless, unusedStones.get(i));

        updateData();

        new  EditNeckless(data).execute();
        return true;
    }
}
