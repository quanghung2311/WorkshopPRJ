
package RMI;

import java.io.Serializable;

/**
 *
 * @author Quang Hung
 */
public class Employee implements Serializable{

    private String id;
    private String lastName;
    private String firstName;
    private String gender;
    private String email;

    public Employee() {
    }

    public Employee(String id, String lastName, String firstName, String gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender + ", email=" + email + '}';
    }
    
    
}
