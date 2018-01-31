import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main extends dbConnection {
    private static test_db_insert_and_connect db;


    public static void main(String[] args) {
        db.getUsernameAndPassword("Raw-Materials", "gunnar");
        get("/",(req, res) -> {
            return new ModelAndView(null, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/login", (req, res) -> {

            Map<String, String> model = new HashMap<>();
            model.put("username", req.queryParams("username"));
            return new ModelAndView(model, "login.hbs");
        }, new HandlebarsTemplateEngine());


    }
}

