package precious_stones;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PreciousStone {
    private String name;
    private int pricePerCarat;
    private int weight;
    double transparency;
    private StoneType type;

    public int getPrice(){
        return pricePerCarat*weight;
    }

    @Override
    public String toString() {
        return String.format("тип = %s,\t ім'я = %s,\t ціна за карат = %d,\t вага = %d,\t прозорість = %s",
                type.toString(), name, pricePerCarat, weight, transparency);
    }

}
