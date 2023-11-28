package xyz.r0r5chach.services.user;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.Request;
import spark.Response;
import xyz.r0r5chach.api.Api;
import xyz.r0r5chach.api.ApiMode;
import xyz.r0r5chach.api.patient.Patient;
import xyz.r0r5chach.api.patient.PatientList;
import xyz.r0r5chach.api.patient.search.Search;
import xyz.r0r5chach.services.Site;



public class User {
    private static final Api api = new Api(ApiMode.SANDBOX);
    public static void routes() {
        path("/user", () -> {
            get("/dash", User::getDash);

            post("/results", User::postResult);

            post("/diffs/:id", User::postDiffs);

            get("/patient/:id", User::getPatient);
            });
    }

    private static String postDiffs(Request req, Response res) {
        //TODO: diffs page
        String id = req.params(":id");
        Patient result = api.getPatient(id);
        //get patient from session
        //compare
        //display comparison
        return null;
    }

    private static String getDash(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("title", "Dashboard");
        Site.renderLayout("dash.ftl", model, res);
        return null;
    }

    private static String postResult(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("title", "Dashboard");
        Site.renderLayout("results.ftl", model, res);
        return null;
    }

    private static String postResults(Request req, Response res) {
        List<String> names = Arrays.asList(req.queryParams("searchTerms").split(" "));
        Search query = new Search();
        query.setFuzzyMatch(true);
        query.setFamily(pop(names, names.size()));
        
        for (String name : names) {
            query.addGiven(name);
        }
        PatientList results = api.searchPatient(query);
        Map<String,Object> model = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();

        for (Patient result : results.getList()) {
            Map<String,Object> patient = new HashMap<>();

            patient.put("id", result.getId());
            patient.put("name", result.getName().get(0).getGiven().get(0) + result.getName().get(0).getFamily());

            list.add(patient);
        }

        model.put("title", "Results");
        model.put("results", list);

        Site.renderLayout("results.ftl", model, res);
        
        return null;
    }

    private static String getPatient(Request req, Response res) {
        //TODO: patient page
        String id = req.params(":id");

        Patient result = api.getPatient(id);

        //TODO: display data
        return null;
    }

    private static String pop(List<String> list, int index) {
        String out = list.get(index);
        list.remove(index);

        return out;
    }
}