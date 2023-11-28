package xyz.r0r5chach.services;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import xyz.r0r5chach.db.ReadableDBHandler;
import xyz.r0r5chach.services.error.LoadingException;
import xyz.r0r5chach.services.user.User;

public class Login {
    public static void routes() {
        get("/", Login::getLogin);
        post("/", Login::postLogin);
        get("/login", Login::getLogin);
    }

    private static String getLogin(Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("title", "Login");
        User.routes();
        Site.renderLayout("login.ftl", model, res);
        return null;
    }

    private static String postLogin(Request req, Response res) throws LoadingException {
        ReadableDBHandler db = new ReadableDBHandler("users");
        String username =  req.queryParams("username");
        Map<String,Object> model = new HashMap<>();

        User.routes();
        res.redirect("/user/dash"); //TODO: remove test code

        
        // Document query = new Document();
        // query.put("username", username);
        // query.put("password", req.queryParams("password"));

        // Document result = db.getFirstResult(query);

        // if (!result.equals(null)) {
        //     Site.sessionVars.put("username", username);
        //     User.routes();

        //     if (Access.valueOf(result.getString("access")) != Access.admin) {
        //         unmap("/admin");
        //     }

        //     res.redirect("/user/dash");
        // }
        // else {
        //     throw new LoginException();
        // }

        return null;
    }
    
}
