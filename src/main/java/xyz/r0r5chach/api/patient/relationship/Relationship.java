package xyz.r0r5chach.api.patient.relationship;

public class Relationship {
    private RelationshipType code;
    private String display;
    public Relationship(RelationshipType code, String display) {
        this.code = code;
        this.display = display;
    }
    public RelationshipType getCode() {
        return code;
    }
    public String getDisplay() {
        return display;
    }
}
