package xyz.r0r5chach.api.patient.search;

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
}
