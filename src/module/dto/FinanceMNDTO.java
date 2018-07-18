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
public class FinanceMNDTO {
    private int employeeId,Department1,Department2;

    public FinanceMNDTO(int Department1, int Department2) {
        this.Department1 = Department1;
        this.Department2 = Department2;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public FinanceMNDTO() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "FinanceMN{" + "employeeId=" + employeeId + ", Department1=" + Department1 + ", Department2=" + Department2 + '}';
    }

    public int getDepartment1() {
        return Department1;
    }

    public void setDepartment1(int Department1) {
        this.Department1 = Department1;
    }

    public int getDepartment2() {
        return Department2;
    }

    public void setDepartment2(int Department2) {
        this.Department2 = Department2;
    }
    
}
