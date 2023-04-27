package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        // String portNumber = "";
        File cookieFile = new File("cookie.txt");

        // For retrieveCookie method
        FileReader fr = null;
        BufferedReader br = null;
        LineNumberReader lr = null;
        String cookieFact = "";
        int randomNumber = 0;

        System.out.println(retrieveCookie(cookieFact, randomNumber, cookieFile, fr, br, lr));
    }
    // Write a start server function

    // Write a retrieveCookie function
    public static String retrieveCookie(String fact, int randomNumber, File file, FileReader fr, BufferedReader br, LineNumberReader lr) throws IOException {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            randomNumber = (int) Math.round(Math.random() * 6);
            for (int i = 1; i <= 6; i++) {
                fact = br.readLine();
                if (i == randomNumber) {
                    br.close();
                    return fact;
                }
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            fr.close();
        }

        return fact;
    }
}
