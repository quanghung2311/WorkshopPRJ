package SocketThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static java.lang.System.in;
import java.net.Socket;
import static java.rmi.server.LogStream.log;

/**
 *
 * @author Quang Hung
 */
public class ServiceThread extends Thread {

    private int clientNumb;
    private Socket socketOfServer;

    public ServiceThread(Socket socketOfServer, int clientNumb) {
        this.clientNumb = clientNumb;
        this.socketOfServer = socketOfServer;
        log("New connection with client#" + this.clientNumb + "at" + socketOfServer);
    }

    public static void log(String message) {
        System.out.println(message);
    }

    @Override
    public void run() {
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            while (true) {
                String line = is.readLine();
                System.out.println("" + clientNumb + ":" + line);
                os.write("" + clientNumb + ">> " + line);
                os.newLine();
                os.flush();
                if (line.equalsIgnoreCase("Quit")) {

                    os.newLine();
                    os.flush();
                    break;
                }
            }
        } catch (IOException ex) {
            System.err.println("Client " + clientNumb + " just exited!");
        }
    }

}
