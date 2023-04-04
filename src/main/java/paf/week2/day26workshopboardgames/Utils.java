package paf.week2.day26workshopboardgames;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {
    public static JsonArray toJsonArray(Object object){        
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
            return jsonReader.readArray();
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            JsonArray jsonArr = Json.createArrayBuilder().add("Object notmapped correctly").build();
            return jsonArr;
        }
    }
    
    public static JsonObject toJsonObject(Object object){
        ObjectMapper objectMapper = new ObjectMapper();        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
            return jsonReader.readObject();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            JsonObject jsonObject = Json.createObjectBuilder().add("message", "Object not mapped correctly").build();
            return jsonObject;
        }
    }

    public static JsonObject docToJsonObject(Document doc){
        String jsonString = doc.toJson();
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        return jsonReader.readObject();
    
    }
    public static JsonArray docToJsonArray(Document doc){
        String jsonString = doc.toJson();
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        return jsonReader.readArray();
    }
    public static JsonArray docToJsonArray(List<Document> docList){        
        
        String jsonString = docList.toString();
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        return jsonReader.readArray();
    }

}
