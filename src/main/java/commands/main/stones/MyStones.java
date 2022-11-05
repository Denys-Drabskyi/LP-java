package commands.main.stones;

import commands.Command;
import commands.main.stones.create.CreateStone;
import commands.main.MainMenu;
import commands.main.stones.manage.ManageStone;
import json.JsonConverterData;
import precious_stones.PreciousStone;

import java.util.List;

public class MyStones extends Command {

    public MyStones(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        System.out.flush();
        List<PreciousStone> stones = data().getStones();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        logger().info(String.format("Список каменів %s",stones.toString()));
        while (i<stones.size()){
            sb.append(String.format("%d: назва каменю = %s, тип = %s\n",
                    i,
                    stones.get(i).getName(),
                    stones.get(i).getType().getName()));
            i++;
        }
        sb.append(String.format("%d -> Новий камінець\n", i+1));
        sb.append(String.format("%d -> Назад", i+2));
        int count = i;
        i=-1;
        while (i<0||i>count+2){
            System.out.println(sb);
            i = scanner().nextInt();
        }

        if (i < stones.size())
            new ManageStone(data(),stones.get(i));
        if (i == stones.size()+1)
            new CreateStone(data()).execute();
        else
            new MainMenu(data()).execute();
        return true;
    }
}
