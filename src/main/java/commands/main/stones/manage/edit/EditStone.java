package commands.main.stones.manage.edit;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import commands.main.stones.MyStones;
import commands.main.stones.manage.ManageStone;
import json.JsonConverterData;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.util.ArrayList;
import java.util.List;

public class EditStone extends Command {
    private final PreciousStone preciousStone;
    public EditStone(JsonConverterData jsonConverterData, PreciousStone stone) {
        super(jsonConverterData);
        preciousStone = stone;
    }

    @Override
    public Command execute() {
        PreciousStone temp = new PreciousStone(preciousStone);
        int i;
        do {
            System.out.println(temp);
            System.out.println("""
                    1 -> Змінити ім'я
                    2 -> Змінити ціну за карат
                    3 -> Змінити вагу
                    4 -> Змінити прозорість
                    5 -> Змінити тип
                    6 -> Закінчити
                    7 -> Не зберігати зміни""");
            i = scanner().nextInt();

            if (i == 1)
                nameInput(temp);
            if (i == 2)
                pricePerCaratInput(temp);
            if (i == 3)
                weightInput(temp);
            if (i == 4)
                transparencyInput(temp);
            if (i == 5)
                typeInput(temp);

        } while (i<6 || i>7);

        if (i == 6){
            List<PreciousStone> preciousStones =  data().getStones();
            int index = preciousStones.indexOf(preciousStone);
            preciousStones.remove(index);
            preciousStones.add(index, temp);

            if (data().getNecklace().getStones().contains(preciousStone)){
                List<PreciousStone> stonesInNecklace = data().getNecklace().getStones().stream().toList();
                index = stonesInNecklace.indexOf(preciousStone);
                data().getNecklace().replaceStone(index, temp);
            }
        }
        return new MyStones(data());
    }

    private void nameInput(PreciousStone preciousStone){
            System.out.println("Введіть ім'я каменю");
            preciousStone.setName(scanner().next());

    }

    private void pricePerCaratInput(PreciousStone temp){
        int pricePerCarat = 0;
        while (pricePerCarat <= 0){
            System.out.println("Введіть ціну за карат каменю");
            pricePerCarat = scanner().nextInt();
        }
        temp.setPricePerCarat(pricePerCarat);
    }

    private void weightInput(PreciousStone temp){
        int weight = 0;
        while (weight <= 0){
            System.out.println("Введіть вагу в каратах каменю");
            weight = scanner().nextInt();
        }
        temp.setWeight(weight);

    }

    private void transparencyInput(PreciousStone temp){
        double transparency = -1;
        while (transparency < 0 || transparency > 1){
            System.out.println("Введіть відсоток прозорості де 10% = 0,1 каменю");
            transparency = scanner().nextDouble();
        }
        temp.setTransparency(transparency);

    }

    private void typeInput(PreciousStone temp){
            List<StoneType> types = data().getTypes();
            StoneType type = null;
            while (type == null) {
                System.out.println("Виберіть тип каменю\n");
                int i = 0;
                while (i < types.size()) {
                    System.out.printf("%d: %s, рідкість = %d\n", i, types.get(i).getName(), types.get(i).getValue());
                    i++;
                }
                System.out.printf("%d -> Додати тип", i);
                int index = scanner().nextInt();
                if (index == i) {
                    StoneType stoneType = StoneType.builder().build();
                    data().getTypes().add(stoneType);
//                    JsonConverter.convertToJson(data());
                    type = stoneType;
                } else
                    type = types.get(index);
            }
            temp.setType(type);
    }


}
