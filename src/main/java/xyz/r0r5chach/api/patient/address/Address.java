package xyz.r0r5chach.api.patient.address;

import java.util.List;

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
}
