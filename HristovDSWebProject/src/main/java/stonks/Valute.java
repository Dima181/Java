package stonks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import stonks.util.DoubleDeserializer;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Valute {
    @JacksonXmlProperty(
            localName = "ID",
            isAttribute = true
    )
    private String id;
    @JacksonXmlProperty(
            localName = "Name"
    )
    private String name;
    @JacksonXmlProperty(
            localName = "Value"
    )
    @JsonDeserialize(
            using = DoubleDeserializer.class
    )
    private Double value;

    public Valute() {
    }

    public Valute(String id, String name, Double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Valute(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getValue() {
        return this.value;
    }

    public String toString() {
        return "Valute{id='" + this.id + "', name='" + this.name + "', value=" + this.value + "}";
    }
}
