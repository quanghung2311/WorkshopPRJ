
package RMI;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Quang Hung
 */
public class Model {
    public static Employee getEmployee(String id) {
        Employee e = null;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Emp_YourID where Emp_Id ='" + id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String employeeID = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String gender = rs.getString(4);
                String email = rs.getString(5);
                e = new Employee(employeeID, lastName, firstName, gender, email);

            }
            conn.close();

        } catch (Exception ex) {

        }
        return e;
    }
    //-------------------------------------------------------------------- 


    public static void addNewEmployee(Employee e)  {

        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "INSERT INTO Emp_YourID VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getId());
            stmt.setString(2, e.getLastName());
            stmt.setString(3, e.getFirstName());
            stmt.setString(4, e.getGender());
            stmt.setString(5, e.getEmail());
            stmt.executeUpdate();
            conn.close();

        } catch (Exception ex) {

        }

    }
    //--------------------------------------------------------------------   

 
    public static void updateEmployee(String id, Employee e)  {
        Connection conn;
        String sql = "Update Emp_YourID Set Emp_Id=?, Last_Name = ?, First_Name = ?, Gender =? , Email = ? Where Emp_Id =  ?";
        try {
            conn = ConnectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getId());
            stmt.setString(2, e.getLastName());
            stmt.setString(3, e.getFirstName());
            stmt.setString(4, e.getGender());
            stmt.setString(5, e.getEmail());
            stmt.setString(6, id);
            stmt.execute();
            conn.close();

        } catch (Exception ex) {

        }

    }

    //--------------------------------------------------------------------     
    public static ArrayList<Employee> display()  {
        ArrayList<Employee> list = new ArrayList<>();
        Employee e = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "Select * from Emp_YourID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String employeeID = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String gender = rs.getString(4);
                String email = rs.getString(5);
                e = new Employee(employeeID, lastName, firstName, gender, email);
                list.add(e);

            }
            conn.close();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return list;
    }
    //--------------------------------------------------------------------  

    
    public static void delete(String id)  {
        Connection conn;
        conn = ConnectDB.getConnection();
        String sql = "Delete from Emp_YourID where Emp_Id = '" + id + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (Exception ex) {

        }
    }

    
    public static ArrayList<Employee> getList()  {
        ArrayList<Employee> list = new ArrayList();

        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "Select * from Emp_YourID";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String employeeID = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String gender = rs.getString(4);
                String mail = rs.getString(5);
                list.add(new Employee(employeeID, lastName, firstName, gender, mail));
            }
            conn.close();

        } catch (Exception ex) {

        }
        return list;
    }
}
