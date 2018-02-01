import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main extends dbConnection {
    private static test_db_insert_and_connect db = new test_db_insert_and_connect();



    public static void main(String[] args) {

        get("/",(req, res) -> {

            return new ModelAndView(null, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/login", (req, res) -> {
            String inputUsername = req.queryParams("username");
            String inputPassword = req.queryParams("password");
            boolean userExist = false;
            db.getUsernameAndPassword(inputUsername,inputPassword);
            System.out.println(inputUsername + "\t" + db.getDbUsername() + "\t" + inputPassword);
            if (db.getDbUsername().equals(inputUsername) && db.getDbPassword().equals(inputPassword))
            {
                userExist = true;
            }

            Map<String, String> model = new HashMap<>();
            model.put("username", req.queryParams("username"));
            if (userExist == true) {
                return new ModelAndView(model, "login.hbs");
            }
            else
            {
                return new ModelAndView(model, "index.hbs");
            }

        }, new HandlebarsTemplateEngine());


    }

}

