package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Quang Hung
 */
public interface RMIInterface extends Remote {

    Employee getEmployee(String id) throws RemoteException;

    void addNewEmployee(Employee e) throws RemoteException;

    void updateEmployee(String id, Employee e) throws RemoteException;

    ArrayList<Employee> getList() throws RemoteException;

    ArrayList<Employee> display() throws RemoteException;

    public void delete(String id) throws RemoteException;

}
