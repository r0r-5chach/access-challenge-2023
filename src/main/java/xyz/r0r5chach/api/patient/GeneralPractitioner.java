package xyz.r0r5chach.api.patient;

public class GeneralPractitioner {
    private String id, type;
    private Identifier identifier;
    
    public GeneralPractitioner(String id, String type, Identifier identifier) {
        this.id = id;
        this.type = type;
        this.identifier = identifier;
    }
    
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public Identifier getIdentifier() {
        return identifier;
    }

    
}
