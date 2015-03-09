package ic.doc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    Pattern sum = Pattern.compile("what is ([0-9]+) plus ([0-9]+)");

    Pattern largest = Pattern.compile("which of the following numbers is the largest");


    public String process(String query) {




        if (query.contains("Imperial")) {
            return "Imperial is a university in London.";
        }
        if (query.contains("Hi!")) {
            return "Hello!";
        }
        if (query.contains("Bye!")) {
            return "Goodbye!";
        }
        if (query.contains("Does it deploy?")) {
            return "Let's see!";
        }

        Matcher m = sum.matcher(query);
        if (m.find()) {

            int a = Integer.parseInt(m.group(1));
            int b = Integer.parseInt(m.group(2));

            return a + b + "";

        }




        return "";
    }
}
