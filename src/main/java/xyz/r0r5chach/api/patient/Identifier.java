package xyz.r0r5chach.api.patient;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.generic.PeriodicAttribute;

public class Identifier extends PeriodicAttribute {
    private URL system;
    private String value;

    public Identifier(URL system, String value, Period period) {
        super(period);
        this.system = system;
        this.value = value;
    }

    public URL getSystem() {
        return system;
    }

    public String getValue() {
        return value;
    }

    public Document toDoc() {
        return new Document()
            .append("system", system)
            .append("value", value)
            .append("period", period.toDoc());
    }

    public static List<Document> listToDoc(List<Identifier> list) {
        List<Document> out = new ArrayList<>();

        for (Identifier item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
