import json.JsonConverter;
import json.JsonConverterData;
import org.slf4j.LoggerFactory;
import precious_stones.PreciousStone;
import java.util.List;
import java.util.Scanner;

// TODO: 26.10.2022 кодування тексту повністю померло
public class Program {
    private Scanner s = new Scanner(System.in);
    private JsonConverterData jsonConverterData = JsonConverter.convertToJsonConverterData();

    public static void main(String[] args) {
        Program program = new Program();
        program.mainMenu();
    }

    private void mainMenu (){
        int i = 0;
        while (i<1 || i >3){
            System.out.println("1 -> моє намисто\n2 -> мої камінці\n3 -> налаштування");
            i = s.nextInt();
        }
        switch (i){
            case 1 -> myNecklace();
            case 2 -> myStones();
            case 3 -> settings();
        }

    }

    private void myNecklace (){
        System.out.println(jsonConverterData.getNecklace());
        int i = 0;
        while (i<1 || i > 4){
            System.out.println("1 -> редагувати\n2 -> сортувати\n3 -> видалити\n4 -> до головного меню");
            i = s.nextInt();
        }
        switch (i){
            case 1 -> editNeckless();
            case 2 -> sortStonesInNeckless();
            case 3 -> deleteNeckless();
            case 4 -> mainMenu();
        }
    }
    private void myStones (){
        List<PreciousStone> stones = jsonConverterData.getStones();
        int i = 0;
        while (i<stones.size()){
            System.out.printf("%d: %s, тип = %s", i, stones.get(i).getName(), stones.get(i).getType().getName());
        }
        
    }
    private void settings (){

    }



    private void  editNeckless() {

    }

    private void sortStonesInNeckless() {

    }

    private void deleteNeckless() {}
}
