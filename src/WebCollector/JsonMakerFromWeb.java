package WebCollector;

import WebCollector.Domain.LineFromWebToJson;
import WebCollector.Domain.MetroMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static WebCollector.CollectorWeb.createMetroMap;

public class JsonMakerFromWeb {
    public static void createMetroJson(MetroMap metroMap, String SavePath) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LineFromWebToJson.class, new LineSerializer())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(metroMap);

        try {
            FileWriter writer = new FileWriter(SavePath);
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
