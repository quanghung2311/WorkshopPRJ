package SocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Quang Hung
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = null;
        int clientNumb = 0;
        try {
            listener = new ServerSocket(7777);
             System.out.println("Server is waiting to accept user...");
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }

        try {
            while (true) {
                ServiceThread st = new ServiceThread(listener.accept(), clientNumb++);
                st.start();

            }
        } finally {
            listener.close();
        }

    }
}
