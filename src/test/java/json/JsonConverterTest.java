package json;

import necklace.Necklace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JsonConverterTest {

    public static Stream<Arguments> pathSource() {
        return Stream.of(Arguments.arguments("con.txt", false), Arguments.arguments("test.txt", true));
    }

    public static Stream<Arguments> toJson() {
        PreciousStone s1 = PreciousStone.builder()
                .type(new StoneType("das",2))
                .pricePerCarat(12)
                .name("s1")
                .build();
        PreciousStone s2 = PreciousStone.builder()
                .type(new StoneType("vrc",1))
                .pricePerCarat(15)
                .name("s2")
                .build();
        PreciousStone s3 = PreciousStone.builder()
                .type(new StoneType("hba",1))
                .pricePerCarat(7)
                .name("s3")
                .build();
        JsonConverterData jsonConverterData = new JsonConverterData(
                new ArrayList<>(Arrays.asList(s1,s2,s3)),
                new Necklace(new LinkedHashSet<>(Arrays.asList(s2,s1))),
                new ArrayList<>(Arrays.asList(new StoneType("Diamond",1),new StoneType("Ruby",3)))
        );
        return Stream.of(Arguments.arguments(json1, jsonConverterData));
    }

    @ParameterizedTest
    @MethodSource("pathSource")
    public void setPath (String path, boolean expected){
        assertEquals(expected, JsonConverter.setPath(path));
    }

    @ParameterizedTest
    @MethodSource("toJson")
    public void convertToJsonTest (String json, JsonConverterData data) throws FileNotFoundException {
        JsonConverter.convertToJson(data);
        File file = new File("testTest");
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine())
            sb.append(scanner.nextLine()).append("\n");
        assertEquals(json, sb.toString());
    }

    @ParameterizedTest
    @MethodSource("toJson")
    public void convertToJsonConverterDataTest (String json, JsonConverterData data) throws FileNotFoundException {
        JsonConverter.setPath("testTest");
        JsonConverter.convertToJson(data);
        JsonConverterData data1 = JsonConverter.convertToJsonConverterData();
        assertEquals(data1.toString(), data.toString());
    }

    @Test
    public void getPathTest(){
        assertEquals("test.json", JsonConverter.getPath());
        JsonConverter.setPath("testTest");
        assertEquals("testTest", JsonConverter.getPath());
    }



    private static final String json1 = "{\n" +
            "  \"stones\": [\n" +
            "    {\n" +
            "      \"name\": \"s1\",\n" +
            "      \"pricePerCarat\": 12,\n" +
            "      \"weight\": 0,\n" +
            "      \"transparency\": 0.0,\n" +
            "      \"type\": {\n" +
            "        \"name\": \"das\",\n" +
            "        \"value\": 2\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"s2\",\n" +
            "      \"pricePerCarat\": 15,\n" +
            "      \"weight\": 0,\n" +
            "      \"transparency\": 0.0,\n" +
            "      \"type\": {\n" +
            "        \"name\": \"vrc\",\n" +
            "        \"value\": 1\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"s3\",\n" +
            "      \"pricePerCarat\": 7,\n" +
            "      \"weight\": 0,\n" +
            "      \"transparency\": 0.0,\n" +
            "      \"type\": {\n" +
            "        \"name\": \"hba\",\n" +
            "        \"value\": 1\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"necklace\": {\n" +
            "    \"stones\": [\n" +
            "      {\n" +
            "        \"name\": \"s2\",\n" +
            "        \"pricePerCarat\": 15,\n" +
            "        \"weight\": 0,\n" +
            "        \"transparency\": 0.0,\n" +
            "        \"type\": {\n" +
            "          \"name\": \"vrc\",\n" +
            "          \"value\": 1\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"s1\",\n" +
            "        \"pricePerCarat\": 12,\n" +
            "        \"weight\": 0,\n" +
            "        \"transparency\": 0.0,\n" +
            "        \"type\": {\n" +
            "          \"name\": \"das\",\n" +
            "          \"value\": 2\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"types\": [\n" +
            "    {\n" +
            "      \"name\": \"Diamond\",\n" +
            "      \"value\": 1\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Ruby\",\n" +
            "      \"value\": 3\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";

}