package com.lw3.views.droids.create;

import com.lw3.droids.HealerDroid;
import com.lw3.droids.SneakyDroid;
import com.lw3.droids.TankDroid;
import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.droids.DroidsMenu;

public class CreateDroidMenu extends Command {
    private final JsonConverterData data;
    public CreateDroidMenu() {
        this.data = JsonConverter.convertToJsonConverterData();
    }

    @Override
    public Command execute() {
        int input;
        do {
            System.out.println("""
                    Виберіть дроїда, якого типу ви хочере створити,
                    двічі напишіть номер для опису кожного типу
                    1-> Sneaky
                    2-> Tank
                    3-> Healer
                    """);
            input = getSc().nextInt();
            if (input == 11)
                System.out.println(SneakyDroid.description);
            if (input == 22)
                System.out.println(TankDroid.description);
            if (input == 33)
                System.out.println(HealerDroid.description);
        } while (input<0 || input>3);
        if (input == 1)
            data.getSneakyDroids().add(new SneakyDroid(true));
        if (input == 2)
            data.getTankDroids().add(new TankDroid(true));
        if (input == 3)
            data.getHealerDroids().add(new HealerDroid(true));
        JsonConverter.convertToJson(data);
        return new DroidsMenu();
    }
}
