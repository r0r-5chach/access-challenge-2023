package xyz.r0r5chach.api.patient.security;

import org.bson.Document;

public class Security {
    private String system;
    private SecurityCode code;
    private SecurityDisplay display;

    public Security(String system, SecurityCode code, SecurityDisplay display) {
        this.system = system;
        this.code = code;
        this.display = display;
    }

    public String getSystem() {
        return system;
    }
    public SecurityCode getCode() {
        return code;
    }
    public SecurityDisplay getDisplay() {
        return display;
    }

    public Document toDoc() {
        return new Document()
            .append("system", system)
            .append("code", code.toString())
            .append("display", display.toString());
    }
}
