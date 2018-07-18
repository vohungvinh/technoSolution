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
public class LoginDTO {
    UserDTO user;
    int departmentId;

    public LoginDTO(UserDTO user, int departmentId) {
        this.user = user;
        this.departmentId = departmentId;
    }

    public LoginDTO() {
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    
}
