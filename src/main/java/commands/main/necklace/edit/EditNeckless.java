package commands.main.necklace.edit;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.necklace.edit.stone.add.AddStoneToNeckless;
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
        while (i < data.getNecklace().getStones().size()){
            sb.append(String.format("%d: %s \n",i,data.getNecklace().getStones(). get(i).toString()));
            i++;
        }
        sb.append(String.format("%d -> додати камінь\n",i+1));
        sb.append(String.format("%d -> назад",i+2));
        int count = i;
        i = -1;
        while (i<0 || i > count+2){
            System.out.println(sb);
            i = s.nextInt();
        }
        if (i < data.getNecklace().getStones().size())
            new EditStoneInNeckless(data, i).execute();
        if (i == count+1)
            new AddStoneToNeckless(data).execute();
        else
            new MyNecklace(data).execute();
        return true;
    }
}
