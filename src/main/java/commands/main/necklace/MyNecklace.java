package commands.main.necklace;

import commands.Command;
import commands.main.necklace.delete.DeleteNeckless;
import commands.main.necklace.edit.EditNeckless;
import commands.main.MainMenu;
import commands.main.necklace.sort.SortStonesInNeckless;
import json.JsonConverterData;
import necklace.Necklace;

public class MyNecklace extends Command {

    public MyNecklace(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public boolean execute() {
        System.out.flush();
        Necklace necklace = data.getNecklace();
        if (necklace == null){
            logger.info("necklace null");
            System.out.println("У намисті немає каменів");

        } else {
            logger.info(String.format("necklace %s",necklace));
            System.out.println(necklace);
        }
        int i = 0;
        while (i<1 || i > 4){
            System.out.println(
                    """
                            1 -> редагувати
                            2 -> сортувати
                            3 -> видалити
                            4 -> назад""");
            i = s.nextInt();
        }
        switch (i){
            case 1 -> new EditNeckless(data).execute();
            case 2 -> new SortStonesInNeckless(data).execute();
            case 3 -> new DeleteNeckless(data).execute();
            case 4 -> new MainMenu(data).execute();
        }
        return true;
    }
}
