package xyz.r0r5chach.api.patient.address;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.generic.IdentifiedAttribute;
import xyz.r0r5chach.api.patient.Period;

public class Address extends IdentifiedAttribute {
    private String postCode;
    private AddressUseType use;
    private AddressTempType text;
    private List<String> lines;

    public Address(String id, List<String> lines, String postCode, Period period, AddressUseType use, AddressTempType text) {
        super(id, period);
        this.lines = lines;
        this.postCode = postCode;
        this.use = use;
        this.text = text;
    }
    public String getPostCode() {
        return postCode;
    }
    public AddressUseType getUse() {
        return use;
    }
    public AddressTempType getText() {
        return text;
    }
    public List<String> getLines() {
        return lines;
    }

    public Document toDoc() {
        return new Document()
            .append("id", id)
            .append("period", period)
            .append("postCode", postCode)
            .append("use", use.toString())
            .append("text", text.toString())
            .append("lines", lines);
    }

    public static List<Document> listToDoc(List<Address> list) {
        List<Document> out = new ArrayList<>();

        for (Address item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
