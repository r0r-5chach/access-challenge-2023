package xyz.r0r5chach.api.generic;

import xyz.r0r5chach.api.patient.Period;

public class IdentifiedAttribute extends PeriodicAttribute {
    protected String id;

    public IdentifiedAttribute(String id, Period period) {
        super(period);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
