import json.JsonConverter;
import json.JsonConverterData;
import necklace.Necklace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import precious_stones.PreciousStone;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Program {
    private final Scanner s = new Scanner(System.in);
    private final Logger logger = LoggerFactory.getLogger(Program.class);
    private final JsonConverterData jsonConverterData = JsonConverter.convertToJsonConverterData();

    public static void main(String[] args) {
        Program program = new Program();
        program.mainMenu();
    }

    private void mainMenu (){
        System.out.flush();
        System.out.println("Для вибору команди впишіть номер пункту меню, під якии ввона знаходиться");
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
        System.out.flush();
        Necklace necklace = jsonConverterData.getNecklace();
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
            case 1 -> editNeckless();
            case 2 -> sortStonesInNeckless();
            case 3 -> deleteNeckless();
            case 4 -> mainMenu();
        }
    }

    private void myStones (){
        System.out.flush();
        List<PreciousStone> stones = jsonConverterData.getStones();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        logger.info(String.format("Список каменів %s",stones.toString()));
        while (i<stones.size()){
            sb.append(String.format("%d: назва каменю = %s, тип = %s\n",
                    i,
                    stones.get(i).getName(),
                    stones.get(i).getType().getName()));
            i++;
        }
        sb.append(String.format("%d -> Новий камінець\n", i+1));
        sb.append(String.format("%d -> Назад", i+2));
        int count = i;
        i=-1;

        while (i<0||i>count+2){
            System.out.println(sb);
            i = s.nextInt();
        }

        if (i < stones.size())
            manageStone(stones.get(i));
        if (i == stones.size()+1)
            createStone();
        else
            mainMenu();
    }

    private void createStone() {
    }

    private void manageStone(PreciousStone preciousStone) {
    }

    private void settings (){

    }

    private void  editNeckless() {

    }

    private void sortStonesInNeckless() {

    }

    private void deleteNeckless() {}
}
