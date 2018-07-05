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
    private final String emailRegex ="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private final String sqlInsertUser="insert into users(Email,Pass,RoleId,EmployeeNumber) values(?,?,?,?)";
    private final String sqlCheckMailExists = "select Email from users where Email = ?";
    public UserDAO() {
        conn = new Connector().getConn();
    }
    /**
     * 
     * @param mail
     * @return true if mail in correct form va chua tt trong database
     */
    private boolean checkMail(String mail){
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
    /**
     * 
     * @param id
     * @return 
     */
    private boolean checkManager(int id){
        
        return true;
    }
    //curd
    public boolean create(UserDTO user){
        boolean check = checkMail(user.getEmail());
        if(check){
             try {
            PreparedStatement preSta = conn.prepareStatement(sqlInsertUser);
            preSta.setString(1, user.getEmail());
            preSta.setString(2, user.getPassword());
            preSta.setInt(3, user.getRole());
            preSta.setInt(4,user.getEmployeeNumber());
            if(preSta.executeUpdate() > 0){
                return true;
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
            
        }
        return false;
       
    }
    public boolean update(){
        return true;
    }
    public ArrayList<UserDTO> readAll(){
        return null;
    }
    public ArrayList<UserDTO> read(ArrayList<String> gets,String table,ArrayList<String> cols, ArrayList<String> values){
        error ="";
        String where="";
        String item="";
        String getClause="";
        if(cols.size() != values.size()){
            error="cols's size must = values's size";
            return null;
        }
        for (int i = 0; i < values.size(); i++) {
             item += cols.get(i) + " = " + values.get(i);
            if(i < values.size() -1){
                item +=",";
            }
            
        }
        for (int i = 0; i < gets.size(); i++) {
            getClause += gets.get(i);
            if(i < gets.size()-1){
                getClause +=',';
            }
        }
       
        return null;
    }
    public boolean delete(int eNumber){
        return true;
    }
}
