package	models.event;

import com.google.gson.*;
import java.lang.reflect.Type;

public class EventSerializer implements JsonSerializer<Event> {
	public JsonElement serialize(Event event, Type typeOfT, JsonSerializationContext ctx) {
		return new JsonPrimitive(event.toString());
	}
}