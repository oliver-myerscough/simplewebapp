package ic.doc;

public class QueryProcessor {

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
        if (query.contains("Does it work?")) {
            return "Let's see!";
        }
        return "";
    }
}
