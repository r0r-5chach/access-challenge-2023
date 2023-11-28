package xyz.r0r5chach.services;

import static spark.Spark.staticFiles;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import spark.Response;
import xyz.r0r5chach.services.error.Error;
import xyz.r0r5chach.services.user.User;

public class Site {
    public static Configuration templateEngine;
    public static Map<String,Object> sessionVars;

    public static void initSite(Configuration cfg) {
        templateEngine = cfg;
        staticFiles.location("/public");
        initPaths();
    }

    private static String renderTemplate(String view, Map<String, Object> model, Response res) {
        try {
            Writer out = new OutputStreamWriter(res.raw().getOutputStream());
            templateEngine.getTemplate(view).process(model, out);
        } 
        catch (TemplateException | IOException e) {
            return "Error Loading Page";
        }
        return null;
    }

    public static String renderLayout(String view, Map<String, Object> model, Response res) {
        model.put("content", view);
        model.put("date", Integer.toString(LocalDate.now().getYear()));
        renderTemplate("layout.ftl", model, res);
        return null;
    }

    private static void initPaths() {
        Error.routes();
        User.routes();
        Admin.routes();
    }
}