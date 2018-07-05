/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technosolution;
import module.dao.UserDAO;
import module.dto.UserDTO;
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
        UserDTO user = new UserDTO("test","test",1,13);
        UserDAO userProcess = new UserDAO();
        if(userProcess.create(user)){
            System.out.println("success");
        }
        else{
            System.out.println( userProcess.error);
            System.out.println("false");
        }
        }
    
}
