import org.apache.commons.math3.primes.Primes;
import rita.RiString;
import rita.RiTa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by user on 8/16/2017.
 */
public class RailwayChildren {

    static String pageText;
    static RiString lowerCase;
    static RiString riString;
    static String noPunc;
    static Map<String, Integer> output;

    public static void main(String[] args) {
        performOperation();
    }

    public static Map<String,Integer> performOperation() {


        URL url = null;
        try {
            url = new URL("http://www.loyalbooks.com/download/text/Railway-Children-by-E-Nesbit.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection conn = null;
        try {
            conn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                pageText = reader.lines().collect(Collectors.joining("\n"));
                System.out.println(pageText);
                    riString = new RiString(pageText);
                System.out.println(riString);

                    lowerCase = riString.toLowerCase();
    //                System.out.println(lowerCase.toString());
                    noPunc = RiTa.trimPunctuation(lowerCase.toString());
                    System.out.println(noPunc.toString());
                    output = RiTa.concordance(noPunc);
                    printOccurrences(output);
                    System.out.println(output);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  output;
    }

    public static Map<String, Integer> printOccurrences(Map<String, Integer> occurrences) {
        for (String key : occurrences.keySet()) {
            if (Primes.isPrime(occurrences.get(key))) {
              System.out.println(key+" - "+occurrences.get(key));
            }
        }
        return occurrences;
    }
}
