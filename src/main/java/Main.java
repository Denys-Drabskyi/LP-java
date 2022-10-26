import json.JsonConverter;
import json.JsonConverterData;
import json.JsonConverterDataBuilder;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Comparator<PreciousStone> comparator = new Comparator<PreciousStone>() {
            @Override
            public int compare(PreciousStone o1, PreciousStone o2) {
                if (o1.getType().getValue()>o2.getType().getValue())
                    return 1;
                else if (o1.getType().getValue() == o2.getType().getValue() && o1.getPricePerCarat() > o2.getPricePerCarat())
                    return 1;
                else
                    return o1.getName().compareTo(o2.getName());
            }
        };
        TreeSet<PreciousStone> test1 = new TreeSet<>(comparator);

        test1.add(new PreciousStone("рол",10,10,0,new StoneType("name",0)));
        test1.add(new PreciousStone("atest2",10,10,0.2,new StoneType("name",0)));
        List<PreciousStone> test = test1.stream().toList();


        JsonConverterData jsonConverterData = new JsonConverterDataBuilder().setStones(test).build();

        JsonConverter.convertToJson(jsonConverterData);
        JsonConverterData jsonConverterData1 = JsonConverter.convertToJsonConverterData();

        System.out.println(jsonConverterData);
        System.out.println(jsonConverterData1.getStones());
        System.out.println(jsonConverterData.getStones());
    }


}
