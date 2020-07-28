package RMI;

import Model.Book;
import RMI.Employee;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Quang Hung
 */
public class EmployeeDB extends UnicastRemoteObject implements RMIInterface {

    public EmployeeDB() throws RemoteException {

    }

    public Employee getEmployee(String id) throws RemoteException {
        return Model.getEmployee(id);
        
    }
 

    @Override
    public void addNewEmployee(Employee e) throws RemoteException {

        Model.addNewEmployee(e);

    }


    @Override
    public void updateEmployee(String id, Employee e) throws RemoteException {
       Model.updateEmployee(id, e);

    }

   
    public ArrayList<Employee> display() throws RemoteException {
       return Model.display();
    }
 

    @Override
    public void delete(String id) throws RemoteException {
      Model.delete(id);
    }

    @Override
    public ArrayList<Employee> getList() throws RemoteException {

        return Model.getList();
    }

}
