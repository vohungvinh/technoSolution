/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.dto.FinanceMNDTO;

/**
 *
 * @author Admin
 */
public class FinanceMNDAO {
    Connection conn;
    public String error="";
    private final String sqlCreate="insert into financeMN(DepartmentNumber,DepartmentNumber2,EmployeeId) values (?,?,?)";
    private final String sqlReadOne="select * from financeMN where EmployeeId= ?";
    public FinanceMNDAO() {
        conn = new Connector().getConn();
    }
    // curd
    public boolean create(FinanceMNDTO financeMN){
        boolean check = true;
        EmployeeDAO emDao =new EmployeeDAO();
        DepartmentDAO deptDao = new DepartmentDAO();
        error ="";
        // check employeeid is exists? in table finance?
        if(readOne(financeMN.getEmployeeId()) == null){
            error += "employeeId da ton tai trong financeMN"+System.getProperty("line.seperator");
            check = false;
        }
        // check employeeId ton tai trong employee?
        if(emDao.readEach(financeMN.getEmployeeId()) == null){
            error += "employeeId khong ton tai trong employee"+System.getProperty("line.seperator");
            check = false;
        }
        // check department ton tai
        //if()
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlCreate);
            preSta.setInt(1, financeMN.getDepartment1());
            preSta.setInt(2, financeMN.getDepartment2());
            preSta.setInt(3, financeMN.getEmployeeId());
            if(preSta.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FinanceMNDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean update(FinanceMNDTO financeMN){
        
        return true;
    }
    public ArrayList<FinanceMNDTO> readAll(){
        return null;
    }
    public FinanceMNDTO readOne(int employeeNum){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlReadOne);
            preSta.setInt(1, employeeNum);
            ResultSet rs = preSta.executeQuery();
            if(rs.next()){
                FinanceMNDTO item = new FinanceMNDTO();
                item.setDepartment1(rs.getInt("Department1"));
                item.setDepartment2(rs.getInt("Department2"));
               item.setEmployeeId(rs.getInt("EmployeeId"));
               return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FinanceMNDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error += "khong co emNum"+System.getProperty("line.seperator");
        return null;
    }
   public boolean delete(int employeeNum){
       return true;
   }
}
