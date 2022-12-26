package commands.main.stones.manage;

import commands.Command;
import commands.main.stones.MyStones;
import commands.main.stones.manage.delete.DeleteStone;
import commands.main.stones.manage.edit.EditStone;
import json.JsonConverterData;
import precious_stones.PreciousStone;

public class ManageStone extends Command {
    PreciousStone stone;
    public ManageStone(JsonConverterData data, PreciousStone preciousStone) {
        super(data);
        stone = preciousStone;
    }

    @Override
    public Command execute() {
        System.out.println(stone);
        int i = -1;
        while (i<1 || i>3) {
            System.out.println(stone);
            System.out.println("1 -> замінити\n2 -> видалити\n3 -> назад");
            i = scanner().nextInt();
        }
        switch (i) {
            case 1 -> {
                return new EditStone(data(), stone);
            }
            case 2 -> {
                return new DeleteStone(data(), stone);
            }
            case 3 -> {
                return new MyStones(data());
            }
        }
        return null;
    }
}
