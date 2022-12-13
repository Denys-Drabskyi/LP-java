package precious_stones;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreciousStone {
    private String name;
    private int pricePerCarat;
    private int weight;
    double transparency;
    private StoneType type;

//    public PreciousStone(String name, int pricePerCarat, int weight, double transparency, StoneType type) {
//        this.name = name;
//        this.pricePerCarat = pricePerCarat;
//        this.weight = weight;
//        this.transparency = transparency;
//        this.type = type;
//    }

//    private void validate(){
//        Scanner s = new Scanner(System.in);
//        while (this.name == null){
//            System.out.println("Введіть ім'я каменю");
//            this.name = s.nextLine();
//        }
//        while (pricePerCarat <= 0){
//            System.out.println("Введіть ціну за карат каменю");
//            this.pricePerCarat = s.nextInt();
//        }
//        while (weight <= 0){
//            System.out.println("Введіть вагу в каратах каменю");
//            this.weight = s.nextInt();
//        }
//        transparencyValidator(s);
//        typeValidator(s);
//    }
//
//    private void transparencyValidator(Scanner s){
//        while (this.transparency < 0 || this.transparency > 1){
//            System.out.println("Введіть відсоток прозорості де 10% = 0,1 каменю");
//            try {
//                this.transparency = s.nextDouble();
//            } catch (Exception e){
//                System.out.println("Для введення типу дробових чисел слід використовувати знак ',' замісь '.'");
//                this.transparency = -1;
//                transparencyValidator(s);
//            }
//        }
//    }
//
//    private void typeValidator (Scanner s){
//        if (type == null) {
//            JsonConverterData jcd = JsonConverter.convertToJsonConverterData();
//            List<StoneType> types = jcd.getTypes();
//            while (type == null) {
//                System.out.println("Виберіть тип каменю\n");
//                int i = 0;
//                while (i < types.size()) {
//                    System.out.printf("%d: %s, рідкість = %d\n", i, types.get(i).getName(), types.get(i).getValue());
//                    i++;
//                }
//                System.out.printf("%d -> Додати тип", i);
//                int index = s.nextInt();
//                if (index == i) {
//                    StoneType stoneType = new StoneTypeBuilder().build();
//                    jcd.getTypes().add(stoneType);
//                    JsonConverter.convertToJson(jcd);
//                    this.type = stoneType;
//                } else
//                    this.type = types.get(index);
//            }
//        }
//    }

    @Override
    public String toString() {
        return String.format("тип = %s,\t ім'я = %s,\t ціна за карат = %d,\t вага = %d,\t прозорість = %s",
                type.toString(), name, pricePerCarat, weight, transparency);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PreciousStone that)) return false;
//
//        if (getPricePerCarat() != that.getPricePerCarat()) return false;
//        if (getWeight() != that.getWeight()) return false;
//        if (Double.compare(that.getTransparency(), getTransparency()) != 0) return false;
//        if (!getName().equals(that.getName())) return false;
//        return getType().equals(that.getType());
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = getName().hashCode();
//        result = 31 * result + getPricePerCarat();
//        result = (int) (31 * result + getWeight());
//        temp = Double.doubleToLongBits(getTransparency());
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + getType().hashCode();
//        return result;
//    }
}
