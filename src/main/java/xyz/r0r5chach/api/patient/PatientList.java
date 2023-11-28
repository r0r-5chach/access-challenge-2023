package xyz.r0r5chach.api.patient;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class PatientList {
    private List<Patient> list;

    public PatientList() {
        list = new ArrayList<>();
    }

    public PatientList(Document res) {
        //TODO: Destructure response into Patients, add to list
    }

    public void add(Patient patient) {
        list.add(patient);
    }

    public List<Patient> getList() {
        return list;
    }
}
