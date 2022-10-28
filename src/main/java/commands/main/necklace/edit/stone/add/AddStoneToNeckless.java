package commands.main.necklace.edit.stone.add;

import commands.Command;
import commands.main.necklace.edit.EditNeckless;
import json.JsonConverterData;

public class AddStoneToNeckless extends Command {

    // TODO: 27.10.2022 якщо камінь додано виключити можливість його додавання
    @Override
    public boolean execute() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Виберіть камінь, який хочете добавити");
        int i = 0;
        while (i<data.getStones().size()){
            sb.append(String.format("%d: %s\n",
                    i,
                    data.getStones().get(i)));
            i++;
        }
        int count = i;
        do {
            System.out.println(sb);
            i = s.nextInt();
        } while (i < 0 || i > count);
        data.getNecklace().addStone(data.getStones().get(i));

        updateData();

        new  EditNeckless(data).execute();
        return true;
    }

    public AddStoneToNeckless(JsonConverterData data) {
        super(data);
    }

}
