package xyz.r0r5chach.api.patient.security;

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
}
