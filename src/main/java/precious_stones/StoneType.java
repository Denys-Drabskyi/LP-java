package precious_stones;

import java.util.Scanner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoneType stoneType)) return false;

        if (getValue() != stoneType.getValue()) return false;
        return getName() != null ? getName().equals(stoneType.getName()) : stoneType.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getValue();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
