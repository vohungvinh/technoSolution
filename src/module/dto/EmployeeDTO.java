/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.dto;

/**
 *
 * @author Admin
 */
public class EmployeeDTO {
    private int employeeNumber,manager,department;
    private String name;
    private UserDTO userId;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int manager, String name, int department, UserDTO userId) {
        this.manager = manager;
        this.name = name;
        this.department = department;
        this.userId = userId;
    }

    public UserDTO getUserId() {
        return userId;
    }

    public void setUserId(UserDTO userId) {
        this.userId = userId;
    }

    
    @Override
    public String toString() {
        return "EmployeeDTO{" + "employeeNumber=" + employeeNumber + ", manager=" + manager + ", name=" + name +  ", department=" + department + '}';
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Object setUserId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
