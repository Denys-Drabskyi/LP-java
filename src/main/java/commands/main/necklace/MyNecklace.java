package commands.main.necklace;

import commands.Command;
import commands.main.necklace.delete.DeleteNeckless;
import commands.main.necklace.edit.EditNeckless;
import commands.main.MainMenu;
import commands.main.necklace.sort.SortStonesInNeckless;
import json.JsonConverterData;

public class MyNecklace extends Command {

    public MyNecklace(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        System.out.flush();
        if (data().getNecklace() == null)
            necklaceIsNull();
        else if (data().getNecklace().getStones().size() == 0)
            necklaceStoneBlank();
        else {
            logger().info(String.format("necklace %s", data().getNecklace()));
            System.out.println(data().getNecklace());
            int i = 0;
            while (i < 1 || i > 4) {
                System.out.println(
                        """
                                1 -> редагувати
                                2 -> сортувати
                                3 -> видалити
                                4 -> назад""");
                i = scanner().nextInt();
            }
            switch (i) {
                case 1 -> new EditNeckless(data()).execute();
                case 2 -> new SortStonesInNeckless(data()).execute();
                case 3 -> new DeleteNeckless(data()).execute();
                case 4 -> new MainMenu(data()).execute();
            }
        }
        return true;
    }

    private void necklaceIsNull(){
        logger().info("necklace null");
        data().newNecklace();
        necklaceStoneBlank();
    }

    private void necklaceStoneBlank(){
        logger().info("necklace.getStones().size() == 0");
        System.out.println("У намисті немає каменів");
        int i = 0;
        while (i<1 || i>2){
            System.out.println(
                    """
                            1 -> редагувати
                            2 -> назад""");
            i = scanner().nextInt();
        }
        switch (i){
            case 1 -> new EditNeckless(data()).execute();
            case 2 -> new MainMenu(data()).execute();
        }
    }
}
