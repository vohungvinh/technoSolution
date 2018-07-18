/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class UserDTO implements Serializable, Comparable<UserDTO>{
    private String password,email;
    private int role,userId;

    public UserDTO(String email, String password,int role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public UserDTO(String password, String email, int userId, int role) {
        this.password = password;
        this.email = email;
        this.role = role;
        this.userId = userId;
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
        return "UserDTO{" + "password=" + password + ", email=" + email +  ", role=" + role + ", userId=" + userId + '}';
    }

    @Override
    public int compareTo(UserDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
