package commands.main.necklace;

import commands.Command;
import commands.main.necklace.delete.DeleteNeckless;
import commands.main.necklace.edit.EditNeckless;
import commands.main.MainMenu;
import commands.main.necklace.sort.SortStonesInNeckless;
import commands.main.necklace.weightAndPrice.PrintWeightAndPrice;
import json.JsonConverterData;

public class MyNecklace extends Command {

    public MyNecklace(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public Command execute() {
        System.out.flush();
        if (data().getNecklace() == null)
            return necklaceIsNull();
        else if (data().getNecklace().getStones().size() == 0)
            return necklaceStoneBlank();
        else {
            logger().info("necklace {}", data().getNecklace());
            System.out.println(data().getNecklace());
            int i = 0;
            while (i < 1 || i > 5) {
                System.out.println(
                        """
                                1 -> редагувати
                                2 -> сортувати
                                3 -> ціна та вага
                                4 -> видалити
                                5 -> назад""");
                i = scanner().nextInt();
            }
            switch (i) {
                case 1 -> {
                    return new EditNeckless(data());
                }
                case 2 -> {
                    return new SortStonesInNeckless(data());
                }
                case 3 -> {
                    return new PrintWeightAndPrice(data());
                }
                case 4 -> {
                    return new DeleteNeckless(data());
                }
                case 5 -> {
                    return new MainMenu(data());
                }
            }
        }
        return null;
    }

    private Command necklaceIsNull(){
        logger().info("necklace null");
        data().newNecklace();
        return necklaceStoneBlank();
    }

    private Command necklaceStoneBlank(){
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
            case 1 -> {
                return new EditNeckless(data());
            }
            case 2 -> {
                return new MainMenu(data());
            }
        }
        return null;
    }
}
