package WebCollector;

import WebCollector.Domain.LineFromWebToJson;
import com.google.gson.*;

import javax.sound.sampled.Line;
import java.lang.reflect.Type;

class LineSerializer implements JsonSerializer<LineFromWebToJson> {
    @Override
    public JsonElement serialize(LineFromWebToJson line, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("name", line.getName());

        JsonArray stationsArray = new JsonArray();
        for (String station : line.getStations()) {
            stationsArray.add(station);
        }
        result.add("stations", stationsArray);

        return result;
    }
}
