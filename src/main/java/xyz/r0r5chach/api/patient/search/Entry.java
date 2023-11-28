package xyz.r0r5chach.api.patient.search;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.patient.Patient;

public class Entry {
    private String fullUrl;
    private double searchScore;
    private Patient resource;
    public Entry(String fullUrl, double searchScore, Patient resource) {
        this.fullUrl = fullUrl;
        this.searchScore = searchScore;
        this.resource = resource;
    }
    public String getFullUrl() {
        return fullUrl;
    }
    public double getSearchScore() {
        return searchScore;
    }
    public Patient getResource() {
        return resource;
    }

    public Document toDoc() {
        return new Document()
            .append("fullUrl", fullUrl)
            .append("searchScore", searchScore)
            .append("resource", resource.toDoc());
    }

    public static List<Document> listToDoc(List<Entry> list) {
        List<Document> out = new ArrayList<>();

        for (Entry item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
