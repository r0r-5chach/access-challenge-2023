package xyz.r0r5chach.api.patient;

import xyz.r0r5chach.api.patient.security.Security;

public class Meta {
    private String versionId;
    private Security security;

    public Meta(String versionId, Security security) {
        this.versionId = versionId;
        this.security = security;
    }

    public String getVersionId() {
        return versionId;
    }

    public Security getSecurity() {
        return security;
    }
}
