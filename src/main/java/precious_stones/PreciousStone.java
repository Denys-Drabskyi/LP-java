package precious_stones;

import json.JsonConverter;
import json.JsonConverterData;
import json.JsonConverterDataBuilder;

import java.util.List;
import java.util.Scanner;

public class PreciousStone {
    private String name;
    private int pricePerCarat;
    private int weight;
    double transparency;
    private StoneType type;

    public PreciousStone(String name, int pricePerCarat, int weight, double transparency, StoneType type) {
        this.name = name;
        this.pricePerCarat = pricePerCarat;
        this.weight = weight;
        this.transparency = transparency;
        this.type = type;
        validate();
    }

    private void validate(){
        Scanner s = new Scanner(System.in);
        while (this.name == null){
            System.out.println("Введіть ім'я каменю");
            this.name = s.nextLine();
        }
        while (pricePerCarat <= 0){
            System.out.println("Введіть ціну за карат каменю");
            this.pricePerCarat = s.nextInt();
        }
        while (weight <= 0){
            System.out.println("Введіть вагу в каратах каменю");
            this.weight = s.nextInt();
        }
        while (transparency < 0 || transparency > 1){
            System.out.println("Введіть відсоток прозорості де 10% = 0,1 каменю");
            this.transparency = s.nextDouble();
        }
        typeValidator(s);
    }

    private void typeValidator (Scanner s){
        if (type == null) {
            JsonConverterData jcd = JsonConverter.convertToJsonConverterData();
            List<StoneType> types = jcd.getTypes();
            while (type == null) {
                System.out.println("Виберіть тип каменю\n");
                int i = 0;
                while (i < types.size())
                    System.out.printf("%d: %s, рідкість = %d", i, types.get(i).getName(), types.get(i).getValue());
                System.out.printf("%d -> Додати тип", i + 1);
                int index = s.nextInt();
                if (index == i + 1) {
                    JsonConverter.convertToJson(
                            new JsonConverterDataBuilder(jcd)
                                    .addType(new StoneTypeBuilder().build())
                                    .build());
                } else
                    this.type = types.get(index);
            }
        }
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public StoneType getType() {
        return type;
    }

    public void setType(StoneType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getPricePerCarat() {
        return pricePerCarat;
    }

    protected void setPricePerCarat(int pricePerCarat) {
        this.pricePerCarat = pricePerCarat;
    }

    public double getWeight() {
        return weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PreciousStone{" +
                "name='" + name + '\'' +
                ", pricePerCarat=" + pricePerCarat +
                ", weight=" + weight +
                ", transparency=" + transparency +
                ", type='" + type + '\'' +
                '}';
    }
}
