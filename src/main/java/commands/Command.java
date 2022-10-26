package commands;

import json.JsonConverter;
import json.JsonConverterData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public abstract class Command {

    public JsonConverterData data;
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    public Scanner s = new Scanner(System.in);
    public abstract boolean execute();

    public Command(JsonConverterData jsonConverterData) {
        this.data = jsonConverterData;
    }

    public void updateData (){
        JsonConverter.convertToJson(data);
    }
}
