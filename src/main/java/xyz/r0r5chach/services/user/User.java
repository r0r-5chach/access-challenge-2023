package xyz.r0r5chach.services.user;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.unmap;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import org.bson.Document;

import spark.Request;
import spark.Response;
import xyz.r0r5chach.db.ReadableDBHandler;
import xyz.r0r5chach.services.Site;

public class User {
    public static void routes() {
        path("/", () -> {
            get("/", User::getLogin);
            post("/", User::postLogin);

            get("/search", User::getSearch);

            post("/results", User::postResults);

            get("/diffs/:id", User::getDiffs);

            get("/patient/:id", User::getPatient);
        });
        
    }

    private static String getLogin(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("title", "Login");
        Site.renderLayout("login.ftl", model, res);
        return null;
    }

    private static String postLogin(Request req, Response res) throws LoginException {
        ReadableDBHandler db = new ReadableDBHandler("users");
        String username =  req.queryParams("username");
        Map<String,Object> model = new HashMap<>();
        
        Document query = new Document();
        query.put("username", username);
        query.put("password", req.queryParams("password"));

        Document result = db.getFirstResult(query);

        if (!result.equals(null)) {
            Site.sessionVars.put("username", username);

            if (Access.valueOf(result.getString("access")) != Access.admin) {
                unmap("/admin");
            }

            model.put("title", "Search");

            Site.renderLayout("search.ftl", model, res);
        }
        else {
            throw new LoginException();
        }

        return null;
    }

    private static String getDiffs(Request req, Response res) {
        //TODO: diffs page

        //get patient from session
        //get record from api
        //compare
        //display comparison
        return null;
    }

    private static String getSearch(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("title", "Advanced Search");
        Site.renderLayout("search.ftl", model, res);
        return null;
    }

    private static String postResults(Request req, Response res) {
        //TODO: return results from api

        //get form vars
        //api search
        //display results
        return null;
    }

    private static String getPatient(Request req, Response res) {
        //TODO: patient page

        //get patient from session
        //display data
        return null;
    }
}