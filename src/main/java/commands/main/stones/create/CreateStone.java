package commands.main.stones.create;

import commands.Command;
import commands.main.stones.MyStones;
import json.JsonConverter;
import json.JsonConverterData;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.util.List;

public class CreateStone extends Command {
    private String name;
    private int pricePerCarat;
    private int weight;
    private double transparency;
    private StoneType type;

    public CreateStone(JsonConverterData jsonConverterData) {
        super(jsonConverterData);
    }

    @Override
    public Command execute() {
        input();
        PreciousStone preciousStone = PreciousStone.builder()
                .name(name)
                .type(type)
                .weight(weight)
                .pricePerCarat(pricePerCarat)
                .transparency(transparency)
                .build();
        data().getStones().add(preciousStone);
        if (data().getStones().contains(preciousStone)){
            System.out.println("Камінь додано успішно");
            logger().info("Created stone "+preciousStone);
        }




        return new MyStones(data());
    }


    private void input(){
        nameInput();
        pricePerCaratInput();
        weightInput();
        transparencyInput();
        typeInput();
    }

    private void nameInput(){
        while (name == null){
            System.out.println("Введіть ім'я каменю");
            name = scanner().nextLine();
        }
    }

    private void pricePerCaratInput(){
        while (pricePerCarat <= 0){
            System.out.println("Введіть ціну за карат каменю");
            pricePerCarat = scanner().nextInt();
        }
    }

    private void weightInput(){
        while (weight <= 0){
            System.out.println("Введіть вагу в каратах каменю");
            weight = scanner().nextInt();
        }
    }

    private void transparencyInput(){
        while (this.transparency < 0 || this.transparency > 1){
            System.out.println("Введіть відсоток прозорості де 10% = 0,1 каменю");
            try {
                this.transparency = scanner().nextDouble();
            } catch (Exception e){
                System.out.println("Для введення типу дробових чисел слід використовувати знак ',' замісь '.'");
                this.transparency = -1;
                transparencyInput();
            }
        }
    }

    private void typeInput(){
        if (type == null) {

            List<StoneType> types = data().getTypes();
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
                    JsonConverter.convertToJson(data());
                    this.type = stoneType;
                } else
                    this.type = types.get(index);
            }
        }
    }
}
