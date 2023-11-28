package xyz.r0r5chach.api.patient.telecom;

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
}
