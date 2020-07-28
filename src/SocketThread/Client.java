package SocketThread;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.Scanner;


/**
 *
 * @author Quang Hung
 */
public class Client {
    
    private static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {

        final String serverHost = "localhost";
        Socket socketOfClient = null;
        BufferedWriter os = null;
        BufferedReader is = null;
        try {
            socketOfClient = new Socket(serverHost, 7777);

            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));

            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
            return;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            return;
        }
        try {

            os.newLine();
            os.flush();
            System.out.println("<< Message >>");
            System.out.println("Enter to chat: ");
            while (true) {
                String str = sc.nextLine();
                os.write(str);
                os.newLine(); 
                os.flush();  
                if(str.equalsIgnoreCase("Quit")) break;
                if (str.equalsIgnoreCase("Quit")) {
                    String responseLine = null;
                    while ((responseLine = is.readLine()) != null) {
                        System.out.println("Server: " + responseLine);
                        if ((responseLine.indexOf("Quit") != -1)) {
                            break;
                        }
                    }
                    break;
                }
            }
            os.close();
            is.close();
            socketOfClient.close();
        } catch (UnknownHostException ex) {
            System.err.println("Trying to connect to unknown host: " + ex);
        } catch (IOException ex) {
            System.err.println("IOException: " + ex);
        }
    }

   
}
