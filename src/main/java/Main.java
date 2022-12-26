//import json.JsonConverter;
//import json.JsonConverterData;
//import necklace.Necklace;
//import org.slf4j.LoggerFactory;
//import precious_stones.PreciousStone;
//import precious_stones.StoneType;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedHashSet;
//
//public class Main {
////    int test[] = {1,2};
//    public static void main(String[] args) {
////        LoggerFactory.getLogger(Main.class).error("fjsak");
//        PreciousStone s1 = PreciousStone.builder()
//                .type(new StoneType("das",2))
//                .pricePerCarat(12)
//                .name("s1")
//                .build();
//        PreciousStone s2 = PreciousStone.builder()
//                .type(new StoneType("vrc",1))
//                .pricePerCarat(15)
//                .name("s2")
//                .build();
//        PreciousStone s3 = PreciousStone.builder()
//                .type(new StoneType("hba",1))
//                .pricePerCarat(7)
//                .name("s3")
//                .build();
//        JsonConverterData jsonConverterData = new JsonConverterData(
//                new ArrayList<>(Arrays.asList(s1,s2,s3)),
//                new Necklace(new LinkedHashSet<>(Arrays.asList(s2,s1))),
//                new ArrayList<>(Arrays.asList(new StoneType("Diamond",1),new StoneType("Ruby",3)))
//        );
//        JsonConverter.setPath("testTest");
//        JsonConverter.convertToJson(jsonConverterData);
//    }
//}