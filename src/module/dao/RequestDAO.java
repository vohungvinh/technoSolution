/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.dao;

import java.sql.Connection;
import java.util.ArrayList;
import module.dto.RequestDTO;

/**
 *
 * @author Admin
 */
public class RequestDAO {
    Connection conn;
    private final String sqlInsert="insert into request";
    public RequestDAO() {
        conn = new Connector().getConn();
    }
    //curd
    public boolean create(RequestDTO request){
        return true;
    }
    public boolean update(){
        return true;
    }
    public ArrayList<RequestDTO> readAll(){
        return null;
    }
    public RequestDTO readOne(int requestNumber){
        return null;
    }
    public boolean update(RequestDTO request){
        return true;
    }
    public boolean delete( int requestNumber){
        return true;
    }
}
