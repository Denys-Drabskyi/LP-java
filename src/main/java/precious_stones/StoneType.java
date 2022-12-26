package precious_stones;

import lombok.Builder;
import lombok.Data;

import java.util.Scanner;

@Builder
@Data
public class StoneType {
    private String name;
    private int value;

    public StoneType(String name, int value) {
        this.name = name;
        this.value = value;
        init();
    }

    void init (){
        Scanner s = new Scanner(System.in);
        while (name == null){
        System.out.println("Введіть ім'я типу");
        this.name = s.nextLine();
        }
        while (value < 0){
            System.out.println("Введіть рейтинг типу, де 1 - найрідкісніший тип");
            this.value = s.nextInt();
        }

    }
}
