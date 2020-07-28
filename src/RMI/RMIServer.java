package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Quang Hung
 */
public class RMIServer {

    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1098/RMIServer";
        EmployeeDB server;
        try {
            server = new EmployeeDB();
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + "is running.");
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}
