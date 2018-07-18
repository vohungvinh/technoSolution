/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technosolution;
import java.util.ArrayList;
import java.util.HashMap;
import module.dao.*;
import module.dto.*;
/**
 *
 * @author Admin
 */
public class TechnoSolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       RoleDAO roleDao = new RoleDAO();
       UserDAO user = new UserDAO();
        UserDTO dto = new UserDTO("wre@yahoo.com", "testn", 1);
        if(user.create(dto)){
            System.out.println("succes ");
        }
        else{
            System.out.println("fail");
        }
//        System.out.println("list = " + roleDao.readAllHM().get("nhan vien").getRole());
        }
    
    
}
