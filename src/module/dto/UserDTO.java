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
public class UserDTO {
    private String password,email;
    private int employeeNumber,role,userId;

    public UserDTO(String email, String password, int role , int employeeNumber) {
        this.password = password;
        this.email = email;
        this.employeeNumber = employeeNumber;
        this.role = role;
    }

    public UserDTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "password=" + password + ", email=" + email + ", employeeNumber=" + employeeNumber + ", role=" + role + ", userId=" + userId + '}';
    }


    
}
