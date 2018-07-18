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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.dto.*;

/**
 *
 * @author Admin
 */
public class UserDAO {
    Connection conn;
    public String error;
    private final String sqlLogin ="select * from users where (Email= ?) and (Pass= ?)";
    private final String sqlDeleteUser ="delete from users where UserId =?";
    private final String emailRegex ="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    
    private final String sqlInsertUser="insert into users(Email,Pass,RoleId) values(?,?,?)";
    private final String sqlReadAll="select * from users";
    private final String sqlCheckMailExists = "select Email from users where Email = ?";
    private final String sqlFindByMail ="select * from users where Email =?";
    private final String sqlUpdateUser ="update users set Email = ?,Pass=?,RoleId=? where UserId=?";
    private final String sqlCheckManage ="select employee.Name, employee.EmployeeNumber from employee,users where (employee.EmployeeNumber = users.EmployeeNumber) and (users.RoleId =2) and (users.UserId = ?)";
    public UserDAO() {
        conn = new Connector().getConn();
    }
    /**
     * check true if mail in correct form and not exists in database
     * @param String mail
     * 
     * @return boolean 
     */
    public boolean checkMail(String mail){
        error ="";
        boolean check = mail.matches(emailRegex);
        if(!check){
            error ="mail sai dinh dang";
            return false;
        }
        // check mail da ton tai trong database chua
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlCheckMailExists);
            preSta.setString(1, mail);
            ResultSet rs= preSta.executeQuery();
            if(rs.next()){
                error="mail da ton tai";
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
    }
    
    //curd
    /**
     * true if create success
     * false if create false
     * @param user UserDTO
     * @return boolean 
     */
    public boolean create(UserDTO user){
        error = "";
        boolean check = checkMail(user.getEmail());
        if(check){
             try {
            PreparedStatement preSta = conn.prepareStatement(sqlInsertUser);
            preSta.setString(1, user.getEmail());
            preSta.setString(2, user.getPassword());
            preSta.setInt(3, user.getRole());
            if(preSta.executeUpdate() > 0){
                return true;
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }          
        }
        return false;
       
    }
    /**
     * true if update success
     * false if update false=
     * @param user UserDTO
     * @return boolean 
     */
    public boolean update(UserDTO user){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlUpdateUser);
            preSta.setString(1,user.getEmail());
            preSta.setString(2, user.getPassword());
            preSta.setInt(3, user.getRole());
            preSta.setInt(4, user.getUserId());
            if(preSta.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error="khong ton tai userId"+ user.getUserId();
        return false;
    }
    public UserDTO FindByMail(String mail){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlFindByMail);
            preSta.setString(1, mail);
            ResultSet rs=  preSta.executeQuery();
            if(rs.next()){
                UserDTO users = new UserDTO();
                users.setUserId(rs.getInt("UserId"));
                users.setEmail(rs.getString("Email"));
                users.setPassword(rs.getString("Pass"));
                users.setRole(rs.getInt("RoleId"));
                return users;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return null;
        }
    }
    public ArrayList<UserDTO> readAll(){
        ArrayList<UserDTO> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sqlReadAll);
            while(rs.next()){
                UserDTO item = new UserDTO();
                item.setEmail(rs.getString("Email"));
                item.setPassword(rs.getString("Pass"));
                item.setRole(rs.getInt("RoleId"));
                item.setUserId(rs.getInt("UserId"));
                list.add(item);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error="loi query readAll";
        return null;
    }
    /**
     * delete if create success
     * delete if create false
     * @param userId int
     * @return boolean 
     */
    public boolean delete(int userId){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlDeleteUser);
            preSta.setInt(1, userId);
            if(preSta.executeUpdate() >0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            error ="khong ton cai user "+ userId;
            return false;
        }
    }
    /**
     * if login success return userDTO else null 
     * @param mail String
     * @param password String
     * @return UserDTO or null
     */
    public UserDTO login(String mail,String password){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlLogin);
            preSta.setString(1, mail);
            preSta.setString(2, password);
            ResultSet rs = preSta.executeQuery();
            if(rs.next()){
                UserDTO user = new UserDTO();
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Pass"));
                user.setRole(rs.getInt("RoleId"));
                user.setUserId(rs.getInt("UserId"));
                return user;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        error ="thong tin dang nhap sai";
        return null;
    }
}
