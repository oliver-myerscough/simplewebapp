package ic.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {



    Pattern multSum = Pattern.compile("what is ([0-9]+) multiplied by ([0-9]+) plus ([0-9]+)");

	Pattern plusplus = Pattern.compile("what is ([0-9]+) plus ([0-9]+) plus ([0-9]+)");
    Pattern sumMult = Pattern.compile("what is ([0-9]+) multiplied by ([0-9]+) plus ([0-9]+)");

    Pattern sum = Pattern.compile("what is ([0-9]+) plus ([0-9]+)");
    Pattern minus = Pattern.compile("what is ([0-9]+) minus ([0-9]+)");
    Pattern multiply = Pattern.compile("what is ([0-9]+) multiplied by ([0-9]+)");
    

    Pattern largest = Pattern.compile("which of the following numbers is the largest");
    Pattern number = Pattern.compile("[0-9]+");
    
    Pattern prime = Pattern.compile("which of the following numbers are primes");

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

        if (query.contains("banana")) {
            return "yellow";
        }

        if (query.contains("Eiffel tower")) {
            return "Paris";
        }

        if (query.contains("Spain")) {
            return "Peseta";
        }


        if (query.contains("Prime Minister")) {
            return "David Cameron";
        }
        
        Matcher mplus = plusplus.matcher(query);
        if (mplus.find()) {

            int a = Integer.parseInt(mplus.group(1));
            int b = Integer.parseInt(mplus.group(2));
            int c = Integer.parseInt(mplus.group(3));

            return a + b + c + "";

        }


        Matcher mSumMult = sumMult.matcher(query);
        if (mSumMult.find()) {

            int a = Integer.parseInt(mSumMult.group(1));
            int b = Integer.parseInt(mSumMult.group(2));
            int c = Integer.parseInt(mSumMult.group(3));

            return a + b * c + "";

        }

        Matcher mMultSum = multSum.matcher(query);
        if (mMultSum.find()) {

            int a = Integer.parseInt(mMultSum.group(1));
            int b = Integer.parseInt(mMultSum.group(2));
            int c = Integer.parseInt(mMultSum.group(3));

            return a * b + c + "";

        }


        Matcher m = sum.matcher(query);
        if (m.find()) {

            int a = Integer.parseInt(m.group(1));
            int b = Integer.parseInt(m.group(2));

            return a + b + "";

        }
        
        

        Matcher mMInus = minus.matcher(query);
        ;
        if (mMInus.find()) {

            int a = Integer.parseInt(mMInus.group(1));
            int b = Integer.parseInt(mMInus.group(2));

            return a - b + "";

        }


        Matcher mMult = multiply.matcher(query);
        if (mMult.find()) {

            int a = Integer.parseInt(mMult.group(1));
            int b = Integer.parseInt(mMult.group(2));

            return a * b + "";

        }


        Matcher m2 = largest.matcher(query);
        if (m2.find()) {

            int max = Integer.MIN_VALUE;
            Matcher numberMatcher = number.matcher(query);

            while (numberMatcher.find()) {
                int v = Integer.parseInt(numberMatcher.group());
                max = Math.max(max, v);
            }


            return max + "";

        }

        Matcher m3 = prime.matcher(query);
        if (m3.find()) {

            Matcher numberMatcher = number.matcher(query);

            List<Integer> primeNums = new ArrayList<Integer>();

            while (numberMatcher.find()) {
                int v = Integer.parseInt(numberMatcher.group());
                if (isPrime(v)) {
                    primeNums.add(v);
                }

                return primeNums.toString() + "";

            }
        }

        /*
        // optional default is GET
        try {


            URL obj = new URL("http://cloud-vm-47-183.doc.ic.ac.uk:8080/api/q=" + query);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");


            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

        return "";



    }
    
    public static Boolean isPrime(int num){ 
        if(num==2){ 
          return(true);
        }
        for(int i=2;i<=(int)Math.sqrt(num)+1;i++){ 
          if(num%i==0){ 
            return(false);
          }
        }
        return(true); 
      }
}
