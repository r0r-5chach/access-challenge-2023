package xyz.r0r5chach.api.patient.relationship;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class Relationship {
    private RelationshipType code;
    private String display;
    public Relationship(RelationshipType code, String display) {
        this.code = code;
        this.display = display;
    }
    public RelationshipType getCode() {
        return code;
    }
    public String getDisplay() {
        return display;
    }

    public Document toDoc() {
        return new Document()
            .append("code", code.toString())
            .append("display", display);
    }

    public static List<Document> listToDoc(List<Relationship> list) {
        List<Document> out = new ArrayList<>();

        for (Relationship item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
