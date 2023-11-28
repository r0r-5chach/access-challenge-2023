package xyz.r0r5chach.api.patient;

import java.net.URL;

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
}
