package ic.doc.web;

import ic.doc.QueryProcessor;

import java.io.PrintWriter;

public class ResultsPage extends HtmlPage {

    private final String query;

    public ResultsPage(String query) {
        this.query = query;
    }

    @Override
    protected void writeContentTo(PrintWriter writer) {
        String result = new QueryProcessor().process(query);
        writer.append(result);
        
    }
}
