package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter {
    private static final Gson gson = configureGson();

    public static String convertToJson(JsonConverterData jsonConverterData){
        return gson.toJson(jsonConverterData);
    }

    public static JsonConverterData convertToJsonConverterData(String jsonString){
        return gson.fromJson(jsonString, JsonConverterData.class);
    }

    private static Gson configureGson (){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls().setPrettyPrinting();
        return gsonBuilder.create();
    }
}
