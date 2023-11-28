package xyz.r0r5chach.api.patient.telecom;

import xyz.r0r5chach.api.generic.IdentifiedAttribute;
import xyz.r0r5chach.api.patient.Period;

public class Telecom extends IdentifiedAttribute {
    private String value;
    private TelecomSystemType system;
    private TelecomUseType use;
    
    public Telecom(String id, String value, Period period, TelecomSystemType system, TelecomUseType use) {
        super(id, period);
        this.value = value;
        this.system = system;
        this.use = use;
    }
    
    public String getValue() {
        return value;
    }
    public TelecomSystemType getSystem() {
        return system;
    }
    public TelecomUseType getUse() {
        return use;
    }
}
