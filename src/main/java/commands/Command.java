package commands;

import json.JsonConverter;
import json.JsonConverterData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import precious_stones.PreciousStone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class Command {

    private JsonConverterData data;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Scanner s = new Scanner(System.in);

    public JsonConverterData data() {
        return data;
    }

    public Logger logger() {
        return logger;
    }

    public Scanner scanner() {
        return s;
    }

    public abstract boolean execute();

    public Command(JsonConverterData jsonConverterData) {
        this.data = jsonConverterData;
    }

    public void updateData (){
        JsonConverter.convertToJson(data);
    }

    protected HashMap<String,Integer> printStones (String msg, List<PreciousStone> stones){
        StringBuilder sb = new StringBuilder();
        System.out.println(msg);
        int i = 0;
        while (i<stones.size()){
            sb.append(String.format("%d: %s\n",
                    i,
                    stones.get(i)));
            i++;
        }
        int count = i;
        do {
            System.out.println(sb);
            i = s.nextInt();
        } while (i < 0 || i > count);
        HashMap<String,Integer> rez = new HashMap<>();
        rez.put("i",i);
        rez.put("count",count);
        return rez;
    }
}
