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
import module.dto.RolesDTO;

/**
 *
 * @author Admin
 */
public class RoleDAO {

    Connection conn;
    private final String sqlUpdate ="update roles set Decription =?,Name =? where Role =?";
    private final String sqlInsertRoles ="insert into roles(Name,Decription) values(?,?)";
    private final String sqlReadAll="select * from roles";
    private final String sqlDelete="delete from roles where Role=?";
    private final String sqlReadOne="select * from roles where Role = ?";
    public RoleDAO() {
        conn = new Connector().getConn();
    }
    //curd
    public boolean create(RolesDTO role){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlInsertRoles);
            preSta.setString(1, role.getName());
            preSta.setString(2, role.getDecription());
            
            if(preSta.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ArrayList<RolesDTO> readAll(){
        ArrayList<RolesDTO> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sqlReadAll);
            while(rs.next()){
                RolesDTO item = new RolesDTO();
                item.setDecription(rs.getString("Decription"));
                item.setName(rs.getString("Name"));
                item.setRole(rs.getInt("Role"));
                list.add(item);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public HashMap<String,RolesDTO> readAllHM(){
        try {
            HashMap<String,RolesDTO> list = new HashMap<>();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sqlReadAll);
            while(rs.next()){
                RolesDTO item = new RolesDTO();
                item.setDecription(rs.getString("Decription"));
                item.setName(rs.getString("Name"));
                item.setRole(rs.getInt("Role"));
                list.put(item.getName(),item);    
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public RolesDTO readOne(int id){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlReadOne);
            preSta.setInt(1, id);
            ResultSet rs = preSta.executeQuery();
            if(rs.next()){
                RolesDTO role = new RolesDTO();
                role.setRole(rs.getInt("Role"));
                role.setName(rs.getString("Name"));
                role.setDecription(rs.getString("Decription"));
                return role;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean update(RolesDTO role){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlUpdate);
            preSta.setString(1, role.getDecription());
            preSta.setString(2, role.getName());
            preSta.setInt(3, role.getRole());
            if(preSta.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean delete(int roleId){
        try {
            PreparedStatement preSta = conn.prepareStatement(sqlDelete);
            preSta.setInt(1, roleId);
            if(preSta.executeUpdate()>1){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
