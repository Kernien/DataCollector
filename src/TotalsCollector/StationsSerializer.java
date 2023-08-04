package TotalsCollector;

import TotalsCollector.Domain.StationsToJson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

class StationsSerializer implements JsonSerializer<StationsToJson> {
    @Override
    public JsonElement serialize(StationsToJson src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        if (src.getName() != null && !src.getName().isEmpty()) {
            jsonObject.addProperty("name", src.getName());
        }

        if (src.getLine() != null && !src.getLine().isEmpty()) {
            jsonObject.addProperty("line", src.getLine());
        }

        if (src.getDate() != null && !src.getDate().isEmpty()) {
            jsonObject.addProperty("date", src.getDate());
        }

        if (src.getDepth() != null && !src.getDepth().isEmpty()) {
            jsonObject.addProperty("depth", src.getDepth());
        }

        jsonObject.addProperty("hasConnection", src.isHasConnection());

        return jsonObject;
    }
}