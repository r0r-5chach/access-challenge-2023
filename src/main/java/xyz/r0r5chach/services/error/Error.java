package xyz.r0r5chach.services.error;

import static spark.Spark.exception;
import static spark.Spark.notFound;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import spark.Request;
import spark.Response;
import xyz.r0r5chach.services.Site;

public class Error {
    public static void routes() {
        notFound(Error::notFoundPage);
        exception(LoginException.class, Error::loginNotFound);
    }
    public static String notFoundPage(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", "404 Not Found!");
        Site.renderLayout("notFound.ftl", model, res);
        return null;
    }

    public static String loginNotFound(LoginException exception, Request req, Response res) {
        Map<String,Object> model = new HashMap<>();
        model.put("error", "Login not Found!");
        Site.renderLayout("notFound.ftl", model, res);
        return null;
    }
}