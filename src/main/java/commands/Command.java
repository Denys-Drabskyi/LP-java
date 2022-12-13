package commands;

import json.JsonConverter;
import json.JsonConverterData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import precious_stones.PreciousStone;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class Command {

    private JsonConverterData data;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Scanner s = new Scanner(System.in);

    public JsonConverterData data() {
        return data;
    }

    public Logger logger() {
        return logger;
    }

    public Scanner scanner() {
        return s;
    }

    public abstract Command execute();

    public Command(JsonConverterData jsonConverterData) {
        this.data = jsonConverterData;
    }

    public void updateData (){
        JsonConverter.convertToJson(data);
    }


}