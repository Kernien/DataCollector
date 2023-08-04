package TotalsCollector;

import TotalsCollector.Domain.StationsToJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonMaker {
    public static void createStationsJson(List<?> list, String SavePath) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(StationsToJson.class, new StationsSerializer())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(list);

        try (FileWriter writer = new FileWriter(SavePath)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
