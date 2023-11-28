package xyz.r0r5chach.api.patient.telecom;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.generic.IdentifiedAttribute;
import xyz.r0r5chach.api.patient.Period;

public class Contact extends IdentifiedAttribute {
    private Telecom telecom;

    public Contact(String id, Period period, Telecom telecom) {
        super(id, period);
        this.telecom = telecom;
    }

    public Telecom getTelecom() {
        return telecom;
    }

    public Document toDoc() {
        return new Document()
            .append("telecom", telecom.toDoc())
            .append("period", period)
            .append("id", id);
    }

    public static List<Document> listToDoc(List<Contact> list) {
        List<Document> out = new ArrayList<>();

        for (Contact item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
