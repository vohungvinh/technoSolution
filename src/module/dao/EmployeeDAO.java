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
import module.dto.EmployeeDTO;
import module.dto.UserDTO;
/**
 *
 * @author Admin
 */
public class EmployeeDAO {
    public String error="";
    Connection conn;
    private final String sqlUserIdEm ="select EmployeeNumber,UserId from employee";
    private final String sqlDelete="delete from employee where employeeNumber = ?";
    private final String sqlCreate ="insert into employee(Name,DepartmentId,Manager,UserId) values (?,?,?,?)";
    private final String sqlReadAll ="select * from employee inner join users on employee.UserId = users.UserId";
    private final String sqlReadOne="select * from employee where employeeNumber = ?";
    private final String sqlUserEmployeeN="select UserId,Name from employee";
    private final String sqlIdName="select EmployeeNumber,Name from employee";
    public EmployeeDAO() {
        conn = new Connector().getConn();
    }
   //curd
    /**
     * 
     * @param employee
     * @return 
     */
    public boolean create(EmployeeDTO employee){
        boolean check = true;
        UserDAO user = new UserDAO();
        DepartmentDAO dept = new DepartmentDAO();
        //
        if(!user.checkMail(employee.getUserId().getEmail())){
            check = false;
            error ="email da ton tai"+ System.getProperty("line.separator");
        
        }
        if(dept.readOnce(employee.getDepartment()) == null){
            error ="department not exist"+ System.getProperty("line.separator");
            check = false;
            
        }
        if(!check){
            return false;
        }
        try {
            int userId = user.FindByMail(employee.getUserId().getEmail()).getUserId();
            PreparedStatement preSta = conn.prepareStatement(sqlCreate);
            preSta.setString(1, employee.getName());
            preSta.setInt(2, employee.getDepartment());
            preSta.setInt(3, employee.getManager());
            preSta.setInt(4, userId);
            if(preSta.executeUpdate()>1){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            error ="loi query";
            return false;
        }
    }
    public boolean update (EmployeeDTO employee){
        return true;
    }
    public ArrayList<EmployeeDTO> readAll(){
        try {
            ArrayList<EmployeeDTO> list = new ArrayList<>();
            Statement sta = conn.createStatement();
            
            ResultSet rs = sta.executeQuery(sqlReadAll);
            while(rs.next()){
                EmployeeDTO lItem = new EmployeeDTO();
                UserDTO user;
                lItem.setDepartment(rs.getInt("DepartmentId"));
                lItem.setManager(rs.getInt("Manager"));
                lItem.setName(rs.getString("Name"));
                String mail = rs.getString("Email");
                int role = rs.getInt("RoleId");
                String pass = rs.getString("Pass");
                int userId = rs.getInt("UserId");
                user = new UserDTO(pass, mail, userId, role);
                lItem.setUserId(user);
                list.add(lItem);
            }
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public HashMap<Integer,Integer> userEmHM(){
        HashMap<Integer,Integer> list = new HashMap<>();
        try {
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sqlUserIdEm);
            while(rs.next()){
                list.put(rs.getInt("UserId"), rs.getInt("EmployeeNumber"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public EmployeeDTO readEach(int employeeNumber){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlReadOne);
            preSta.setInt(1, employeeNumber);
            ResultSet rs = preSta.executeQuery();
            if(rs.next()){
                EmployeeDTO em = new EmployeeDTO();
                em.setName(rs.getString("Name"));
                em.setManager(rs.getInt("Manager"));
                em.setDepartment(rs.getInt("Department"));
                return em;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean delete(int employeeNumber){
        PreparedStatement preSta;
        try {
            preSta = conn.prepareStatement(sqlDelete);
            preSta.setInt(1, employeeNumber);
            if(preSta.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return false;
    }
    //hash map
    public HashMap<Integer,Integer> UserEmployeeN(){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlUserEmployeeN);
            ResultSet rs = preSta.executeQuery();
            HashMap<Integer,Integer> list = new HashMap<>();
            while(rs.next()){
                list.put(rs.getInt("UserId"), rs.getInt("EmployeeNumber"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public HashMap<Integer,String> HMIdName(){
        HashMap<Integer,String> list = new HashMap<>();
        try {
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sqlIdName);
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.put(id, name);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error += "loi query"+ System.getProperty("line.separator");
        return null;
    }
}
