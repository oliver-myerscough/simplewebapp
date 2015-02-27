package ic.doc;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("Imperial")) {
            return "Imperial is a university in London.";
        }
        if (query.contains("Hi!")) {
            return "Hello!";
        }
        return "";
    }
}
