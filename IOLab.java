package IO_Stream_Lab;

/**
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 */

import java.io.*;
import java.net.*;
import java.net.URL;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class IOLab {

    public static String readTestResults(String s)  {

        String result = "";

        try{
            File file = new File("src/main/resources/" + s);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){
                result += scan.nextLine();
            }

            System.out.println(result);
            return result;
        }

        catch (FileNotFoundException e) {
            return "";
        }

    }

    public static void appendTestResult(String s, String s1) {
        File file = new File("src/main/resources/" + s);

        try {
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(s1);
            out.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readDateTime(String s) {

        try{
            int count =0;
            String time = "";

            URL url = new URL(s);
            Scanner scan = new Scanner(url.openStream());
            String getInput = scan.nextLine();
            String arr [] = getInput.split(",");
            for (String word : arr){
                count++;
                if (word.contains("day_of_week")){
                    time = arr[count-2];
                }
            }
            arr = time.split(":",2);
            time = arr[1].replaceAll("\"", "");
            System.out.println(time);
            return time;
        }

       catch (FileNotFoundException | MalformedURLException e){
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
