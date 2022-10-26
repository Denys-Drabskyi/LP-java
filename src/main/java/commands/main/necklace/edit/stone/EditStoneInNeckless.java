package commands.main.necklace.edit.stone;

import commands.Command;
import commands.main.necklace.edit.stone.delete.DeleteStoneFromNeckless;
import commands.main.necklace.edit.stone.replace.ReplaceStoneInNeckless;
import json.JsonConverterData;

public class EditStoneInNeckless extends Command {
    private final int stoneIndexInNeckless ;
    public EditStoneInNeckless(JsonConverterData jsonConverterData, int index) {
        super(jsonConverterData);
        this.stoneIndexInNeckless = index;
    }

    @Override
    public boolean execute() {
        int i = 0;
        while (i < 1 || i > 2){
            System.out.printf("%s\n1 -> замінити\n2 -> видалити", data.getStones().get(stoneIndexInNeckless));
            i = s.nextInt();
        }
        switch (i){
            case 1 -> new ReplaceStoneInNeckless(data,stoneIndexInNeckless).execute();
            case 2 -> new DeleteStoneFromNeckless(data,stoneIndexInNeckless).execute();
        }
        return true;
    }
}
