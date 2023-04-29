package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
        Cookie cookieInstance = new Cookie();

        // Write a start server function
        ServerSocket server = new ServerSocket(3000);
        Socket socket = server.accept();

        try {
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String receivedInput = dis.readUTF();

            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            if (receivedInput.equals("quote")) {
                dos.writeUTF(cookieInstance.retrieveCookie(cookieFact, randomNumber, cookieFile, fr, br, lr));
                dos.flush();
            }
        }
        catch(Exception e) {
            System.out.println(e);
            socket.close();
            server.close();
        }
        finally {
            socket.close();
            server.close();
        }

    }
}
