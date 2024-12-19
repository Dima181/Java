package stonks.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class DoubleDeserializer extends JsonDeserializer<Double> {
    public DoubleDeserializer() {
    }

    public Double deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        String doubleString = parser.getText().replace(',', '.');
        return Double.parseDouble(doubleString);
    }
}
