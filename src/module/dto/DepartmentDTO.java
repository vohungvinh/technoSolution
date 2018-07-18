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
public class DepartmentDTO implements Serializable, Comparable<DepartmentDTO>{
    private int departmentNumber,financeMN;
    private String departmentName,decription;

    public DepartmentDTO( int financeMN, String departmentName, String decription) {
        this.financeMN = financeMN;
        this.departmentName = departmentName;
        this.decription = decription;
    }

    public DepartmentDTO() {
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" + "departmentNumber=" + departmentNumber + ", financeMN=" + financeMN + ", departmentName=" + departmentName + ", decription=" + decription + '}';
    }
    
    public int getDepartmentNumber() {
        return departmentNumber;
    }
    
    public int getFinanceMN() {
        return financeMN;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setFinanceMN(int financeMN) {
        this.financeMN = financeMN;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public int compareTo(DepartmentDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
