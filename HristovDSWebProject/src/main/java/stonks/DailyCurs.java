package stonks;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.Date;
import java.util.List;

public class DailyCurs {
    @JacksonXmlProperty(
            localName = "Date",
            isAttribute = true
    )
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "dd.MM.yyyy"
    )
    private Date date;
    @JacksonXmlProperty(
            localName = "name",
            isAttribute = true
    )
    private String name;
    @JacksonXmlProperty(
            localName = "Valute"
    )
    @JacksonXmlElementWrapper(
            useWrapping = false
    )
    private List<Valute> valutes;

    public DailyCurs() {
    }

    public DailyCurs(Date date, String name, List<Valute> valutes) {
        this.date = date;
        this.name = name;
        this.valutes = valutes;
    }

    public Date getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public List<Valute> getValutes() {
        return this.valutes;
    }

    public String toString() {
        String var10000 = String.valueOf(this.date);
        return "DailyCurs{date=" + var10000 + ", name='" + this.name + "', valutes=" + String.valueOf(this.valutes) + "}";
    }
}