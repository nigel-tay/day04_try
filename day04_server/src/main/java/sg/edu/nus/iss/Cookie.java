package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Cookie {
    // Write a retrieveCookie function
    public String retrieveCookie(String fact, int randomNumber, File file, FileReader fr, BufferedReader br, LineNumberReader lr) throws IOException {
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
