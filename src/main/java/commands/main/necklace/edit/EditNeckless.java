package commands.main.necklace.edit;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.necklace.edit.stone.EditStoneInNeckless;
import json.JsonConverterData;

public class EditNeckless extends Command {
    public EditNeckless(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        StringBuilder sb = new StringBuilder();
        System.out.println("виберіть камінь, який потрібно модифікувати/замінити/видалити");
        int i = 0;
        while (i < data.getStones().size()){
            sb.append(String.format("%d: %s \n",i,data.getStones().get(i).toString()));
        }
        sb.append(String.format("%d -> назад",i+1));
        int count = i;
        i = -1;
        while (i<0 || i> count){
            System.out.println(sb);
            i = s.nextInt();
        }
        if (i < data.getStones().size()){
            new EditStoneInNeckless(data, i).execute();
        } else {
            new MyNecklace(data).execute();
        }

        return true;
    }
}
