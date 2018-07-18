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
public class RolesDTO {
    private int role;
    private String decription,name;

    public RolesDTO( String decription, String name) {

        this.decription = decription;
        this.name = name;
    }

    public RolesDTO() {
    }

    public void setRole(int role) {
         this.role = role;
    }
    
    public int getRole() {
        return role;
    }
    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDTO{" + "role=" + role + ", decription=" + decription + ", name=" + name + '}';
    }
    
}
