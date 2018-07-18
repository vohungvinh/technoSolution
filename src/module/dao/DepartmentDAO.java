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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.dto.DepartmentDTO;

/**
 *
 * @author Admin
 */
public class DepartmentDAO {
    public String error;
    Connection conn;
    private final String sqlReadAll="select * from department";
    private final String  sqlDelete="delete from department where DepartmentNumber =?";
    private final String sqlCheckExistId="select * from department where DepartmentNumber = ?";
    private final String sqlInsert="insert into department(DepartmentName,Finance,Decription) values(?,?,?)";
    private final String sqlUpdate ="update department set DepartmentName =?,Finance=?,Decription=? where DepartmentNumber=?";
    public DepartmentDAO() {
        conn = new Connector().getConn();
    }
    //curd
    public boolean create(DepartmentDTO dept){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlInsert);
            preSta.setString(1, dept.getDepartmentName());
            preSta.setInt(2, dept.getFinanceMN());
            preSta.setString(3, dept.getDecription());
            if(preSta.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error="khong the tao department (error query)" + System.getProperty("line.separator");
        return false;
    }
    public boolean update(DepartmentDTO dept){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlUpdate);
            preSta.setString(1, dept.getDepartmentName());
            preSta.setInt(2, dept.getFinanceMN());
            preSta.setString(3, dept.getDecription());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error ="khong ton tai department";
        return false;
    }
    public ArrayList<DepartmentDTO> readAll(){
        try {
            ArrayList<DepartmentDTO> list = new ArrayList<>();
            Statement sta = conn.createStatement();
            ResultSet rs=  sta.executeQuery(sqlReadAll);
            while(rs.next()){
                DepartmentDTO item = new DepartmentDTO();
               item.setDepartmentNumber(rs.getInt("DepartmentNumber"));
                item.setFinanceMN(rs.getInt("Finance"));
                item.setDepartmentName(rs.getString("DepartmentName"));
                item.setDecription(rs.getString("Decription"));
               list.add(item);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error ="loi query";
        return null;
    }
    public DepartmentDTO readOnce(int number){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlCheckExistId);
            preSta.setInt(1, number);
            ResultSet rs = preSta.executeQuery();
            if(rs.next()){
                DepartmentDTO dept = new DepartmentDTO();
                dept.setDecription(rs.getString("Decription"));
                dept.setDepartmentName(rs.getString("DepartmentName"));
                dept.setFinanceMN(rs.getInt("FinanceMN"));
                dept.setDepartmentName(rs.getString("DepartmentName"));
                return  dept;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public DepartmentDTO readOnce(String name){
        return null;
    }
    public boolean delete(int deptNum){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlDelete);
            preSta.setInt(1,deptNum );
            if(preSta.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error="khong ton tai department";
        return false;
    }
}
