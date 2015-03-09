package ic.doc;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();


    @Test
    public void knowsAboutSpa() throws Exception {
        assertThat(queryProcessor.process("Imperial"), containsString("university"));
    }

    @Test
    public void addNumbers() {

        assertEquals(queryProcessor.process("0c39ca90: what is 5 plus 18"), "23");

    }

    @Test
    public void sutractNumbers() {

        assertEquals(queryProcessor.process("q=55a9bcf0: what is 10 minus 1"), "9");

    }

    @Test
    public void multiplyNumbers() {

        assertEquals(queryProcessor.process("/?q=28a22cb0: what is 0 multiplied by 12"), "0");

    }



    @Test
    public void largest() {

        String q = "fcdbb0c0: which of the following numbers is the largest: 80, 333, 77, 96";
        assertEquals("333", queryProcessor.process(q));

    }

    @Ignore
    @Test
    public void prime() {
    	String q = "/?q=4a9df0b0: which of the following numbers are primes: 223, 77";
    	assertEquals("223", queryProcessor.process(q));
    }
   
    @Test
    public void plusplus() {
    	String q = "/?q=80a75e00: what is 5 plus 11 plus 3";
    	assertEquals("19", queryProcessor.process(q));
    }



    @Test
    public void addAndMultiplyNumbers() {

        assertEquals(queryProcessor.process("00829e10: what is 14 multiplied by 18 plus 16"), "268");

    }

    @Test
    public void addAndMultiplyNumbers2() {

        assertEquals(queryProcessor.process("?q=0c8df980:what is 12 multiplied by 7 plus 7"), "91");

    }


    @Test
    public void plusMultipledBy() {

        assertEquals(queryProcessor.process("23e5ff50: what is 12 plus 17 multiplied by 10"), "182");

    }



}
