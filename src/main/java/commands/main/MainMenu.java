package commands.main;

import commands.Command;
import commands.main.necklace.MyNecklace;
import commands.main.stones.MyStones;
import commands.main.settings.Settings;
import json.JsonConverterData;

public class MainMenu extends Command {
    public MainMenu(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        System.out.flush();
        System.out.println("Для вибору команди впишіть номер пункту меню, під якии ввона знаходиться");
        int i = 0;
        while (i<1 || i >3){
            System.out.println("1 -> моє намисто\n2 -> мої камінці\n3 -> налаштування");
            i = scanner().nextInt();
        }
        switch (i){
            case 1 -> new MyNecklace(data()).execute();
            case 2 -> new MyStones(data()).execute();
            case 3 -> new Settings(data()).execute();
        }
        return true;
    }
}
