package commands.main.necklace.edit;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.necklace.edit.stone.add.AddStoneToNeckless;
import commands.main.necklace.edit.stone.EditStoneInNeckless;
import json.JsonConverterData;
import precious_stones.PreciousStone;

import java.util.List;

public class EditNeckless extends Command {
    public EditNeckless(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        StringBuilder sb = new StringBuilder();
        System.out.println("виберіть камінь, який потрібно модифікувати/замінити/видалити");
        int i = 0;
        List<PreciousStone> stones = data().getNecklace().getStones().stream().toList();
        while (i < data().getNecklace().getStones().size()){
            sb.append(String.format("%d: %s \n",i,stones.get(i).toString()));
            i++;
        }
        sb.append(String.format("%d -> додати камінь\n",i));
        sb.append(String.format("%d -> назад",i+1));
        int count = i;
        i = -1;
        while (i<0 || i > count+1){
            System.out.println(sb);
            i = scanner().nextInt();
        }
        if (i < data().getNecklace().getStones().size())
            new EditStoneInNeckless(data(), i).execute();
        if (i == count)
            new AddStoneToNeckless(data()).execute();
        else
            new MyNecklace(data()).execute();
        return true;
    }
}
