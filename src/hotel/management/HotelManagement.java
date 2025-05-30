/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management;

/**
 *
 * @author Christian Devera
 */
import java.util.LinkedList;
public class HotelManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<userAccount> accounts = new LinkedList<>();
    accounts.add(new userAccount("Christian", "1234", "deveracv@students", "09633984325"));
    
    java.awt.EventQueue.invokeLater(() -> new Login(accounts).setVisible(true));
    
    }
    
    
}
