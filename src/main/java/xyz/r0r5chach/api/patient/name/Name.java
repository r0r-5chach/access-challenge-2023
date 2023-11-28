package xyz.r0r5chach.api.patient.name;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.generic.IdentifiedAttribute;
import xyz.r0r5chach.api.patient.Period;


public class Name extends IdentifiedAttribute {
    private String family;
    private NameType use;
    private List<String> given, prefix, suffix;
    
    public Name(String id, Period period, List<String> prefix, List<String> given, String family, List<String> suffix, NameType use) {
        super(id, period);
        this.prefix = prefix;
        this.given = given;
        this.family = family;
        this.suffix = suffix;
        this.use = use;
    }
    
    public String getFamily() {
        return family;
    }
    public NameType getUse() {
        return use;
    }
    public List<String> getGiven() {
        return given;
    }
    public List<String> getPrefix() {
        return prefix;
    }
    public List<String> getSuffix() {
        return suffix;
    }

    public Document toDoc() {
        return new Document()
            .append("id", id)
            .append("period", period)
            .append("use", use.toString())
            .append("given", given)
            .append("prefix", prefix)
            .append("suffix", suffix);
    }

    public static List<Document> listToDoc(List<Name> list) {
        List<Document> out = new ArrayList<>();

        for (Name item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
