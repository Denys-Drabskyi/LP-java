package commands.main.necklace.edit.stone;

import commands.Command;
import commands.main.necklace.edit.stone.delete.DeleteStoneFromNeckless;
import commands.main.necklace.edit.stone.replace.ReplaceStoneInNeckless;
import json.JsonConverterData;
import precious_stones.PreciousStone;

import java.util.List;

public class EditStoneInNeckless extends Command {
    private final int stoneIndexInNeckless ;
    public EditStoneInNeckless(JsonConverterData jsonConverterData, int index) {
        super(jsonConverterData);
        this.stoneIndexInNeckless = index;
    }

    @Override
    public boolean execute() {
        int i;
        List<PreciousStone> stones = data().getNecklace().getStones().stream().toList();
        do {
            System.out.printf("%s\n1 -> замінити\n2 -> видалити", stones.get(stoneIndexInNeckless));
            i = scanner().nextInt();
        } while (i < 1 || i > 2);
        switch (i){
            case 1 -> new ReplaceStoneInNeckless(data(),stoneIndexInNeckless).execute();
            case 2 -> new DeleteStoneFromNeckless(data(),stones.get(stoneIndexInNeckless)).execute();
        }
        return true;
    }
}
