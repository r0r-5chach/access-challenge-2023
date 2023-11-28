package xyz.r0r5chach.api.patient;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.patch.Patch;

public class PatientUpdate {
    private List<Patch> patches;

    public PatientUpdate() {
        patches = new ArrayList<>();
    }

    public void addPatch(Patch patch) {
        patches.add(patch);
    }

    public String toJson() {
        return new Document().append("patches", Patch.listToDoc(patches)).toJson();
    }
}
