package xyz.r0r5chach.api;

import static org.bson.Document.parse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;

import org.bson.Document;

import xyz.r0r5chach.api.patient.Patient;
import xyz.r0r5chach.api.patient.PatientList;
import xyz.r0r5chach.api.patient.PatientUpdate;
import xyz.r0r5chach.api.patient.search.Search;

public class Api {
    private final String baseUrl;

    public Api(ApiMode mode) {
        baseUrl = setBaseUrl(mode);
    }

    public Patient getPatient(String id) {
        String endpoint = baseUrl + "/Patient/" + id;
        Document res = getRequest(endpoint);

        return new Patient(res);
    }

    public PatientList getRelatedPeople(String id) {
        String endpoint = baseUrl + "/Patient/" + id + "/RelatedPerson";
        Document res = getRequest(endpoint);
        
        return new PatientList(res);
    }

    public void updatePatient(String id, PatientUpdate update) {
        String endpoint = baseUrl + "/Patient/" + id;

        Builder req = createRequest(endpoint, true);
        req.method("PATCH", BodyPublishers.ofString(update.toJson()));    
    }

    public PatientList searchPatient(Search patient) {
        String endpoint = baseUrl + "/Patient/?" + patient.toParamsString();
        Document res = getRequest(endpoint);

        return new PatientList(res);
    }

    private Builder createRequest(String endpoint, boolean patch) {
        return HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .headers(generateHeaders(patch));
    }

    private String tryRequest(Builder req) {
        try {
            return HttpClient.newHttpClient().send(req.build(), HttpResponse.BodyHandlers.ofString()).body();
        }
        catch (IOException | InterruptedException e) {
            return null;
        }
    }

    private Document getRequest(String endpoint) {
        Builder req = createRequest(endpoint, false);
        req.method("GET", BodyPublishers.noBody());

        Document res = parse(tryRequest(req));

        return res;
    }

    private String setBaseUrl(ApiMode mode) {
        return switch(mode) {
            case SANDBOX -> "https://sandbox.api.service.nhs.uk/personal-demographics/FHIR/R4/";
            case INTEGRATION -> "https://int.api.service.nhs.uk/personal-demographics/FHIR/R4/";
            case PRODUCTION -> "https://api.service.nhs.uk/personal-demographics/FHIR/R4/";
        };
    }

    private String[] generateHeaders(boolean patch) {
        String[] headers;
        if (patch) {
            headers = new String[]
                {"accept", "application/fhir+json",
                "content-type", "application/json-patch+json",
                "nhsd-end-user-organisation-ods", "Y12345"};
        }
        else {
            headers = new String[]
                {"accept", "application/fhir+json",
                "nhsd-end-user-organisation-ods", "Y12345"};
        }

        return headers;
    }
}