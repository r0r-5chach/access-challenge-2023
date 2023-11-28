package xyz.r0r5chach.api.patient;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class GeneralPractitioner {
    private String id, type;
    private Identifier identifier;
    
    public GeneralPractitioner(String id, String type, Identifier identifier) {
        this.id = id;
        this.type = type;
        this.identifier = identifier;
    }
    
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public Identifier getIdentifier() {
        return identifier;
    }

    public Document toDoc() {
        return new Document()   
            .append("id", id)
            .append("type", type)
            .append("identifier", identifier.toDoc());
    }

    public static List<Document> listToDoc(List<GeneralPractitioner> list) {
        List<Document> out = new ArrayList<>();

        for (GeneralPractitioner item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
