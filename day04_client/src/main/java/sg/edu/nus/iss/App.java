package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Socket socket = new Socket("localhost", 3000);
        Console cons = System.console();
        String command = "";

        try {
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String receivedInput = "";

            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            while(!(command.equals("quit"))) {
                    command = cons.readLine("Enter a prompt: ");
                    dos.writeUTF(command);
                    dos.flush();

                    receivedInput = dis.readUTF(); // This has to be here so that everytime we send out a prompt, we can refresh the value of the response
                    System.out.println(receivedInput);
            }
            dos.close();
            bos.close();
            os.close();

            dis.close();
            bis.close();
            is.close();
        }
        catch(Exception e) {
            System.out.println(e);
            socket.close();
        }
        finally {
            socket.close();
        }
    }
}
