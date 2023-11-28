package xyz.r0r5chach.services;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import spark.Request;
import spark.Response;

public class Admin {
    public static void routes() {
        path("/admin", () -> {
            get("/dash", Admin::getDashboard);
            
            path("/create-user", () -> {
                get("/", Admin::getCreateUser);
                post("/", Admin::postCreateUser);
            });

            path("/user", () -> {
                get("/:username", Admin::getUser);
                put("/:username", Admin::putUser);
                delete("/:username", Admin::deleteUser);
            });
        });
    }

    private static String getDashboard(Request req, Response res) {
        //TODO: admin dash

        //get users from db
        //display users
        return null;
    }

    private static String getCreateUser(Request req, Response res) {
        //TODO: create-user page

        return null;
    }

    private static String postCreateUser(Request req, Response res) {
        //TODO: post user to db if unique redirect success, otherwise redirect issue

        //get post vars
        //add to update
        //update db

        return null;
    }

    private static String getUser(Request req, Response res) {
        //TODO: user page

        return null;
    }

    private static String putUser(Request req, Response res) {
        //TODO: update user in db redirect id success, otherwise issue

        //get post vars
        //add to update
        //update db

        return null;
    }

    private static String deleteUser(Request req, Response res) {
        //TODO: delete user in db

        return null;
    }
}
