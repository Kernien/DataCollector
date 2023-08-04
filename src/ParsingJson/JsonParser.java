package ParsingJson;

import ParsingJson.Domain.StationFromJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonParser {
    public static ArrayList<StationFromJson> ParsToJson(String jsonFile) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<StationFromJson> stations = null;
        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFile)));
            stations = mapper.readValue(json, new TypeReference<ArrayList<StationFromJson>>(){});
            //stations.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stations;
    }
}
