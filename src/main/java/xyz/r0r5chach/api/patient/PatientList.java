package xyz.r0r5chach.api.patient;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.patient.search.Entry;

public class PatientList {
    private List<Patient> list;

    public PatientList() {
        list = new ArrayList<>();
    }

    public PatientList(Document res) {
        this();
        List<Entry> entry = res.getList("entry", Entry.class, null);

        for (Entry item : entry) {
            list.add(item.getResource());
        }

    }

    public void add(Patient patient) {
        list.add(patient);
    }

    public List<Patient> getList() {
        return list;
    }
}
