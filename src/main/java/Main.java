import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main extends dbConnection {
    private static dbConnection dbc;


    public static void main(String[] args) {
        dbc.connect();
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

