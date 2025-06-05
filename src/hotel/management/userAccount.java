/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*\
 */
public class userAccount {
     private String username;
    private String password;
    private String email;
    private String contactNumber;

    // Constructor
    public userAccount(String username, String password, String email, String contactNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    // Getters (Encapsulation: to access the private fields)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    public String getContactNumber(){
        return contactNumber;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public static boolean isValidPassword(String password) {
    return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
}
    
  public static userAccount login(String username, String password, LinkedList<userAccount> accounts) {
    for (userAccount acc : accounts) {
        if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
            return acc;  // ✅ Return the actual account if login is successful
        }
    }
    return null;  // ❌ Login failed
}
    
   public static String register(String username, String password, String email, String contactNumber, LinkedList<userAccount> accounts) {
    if (username.isEmpty() || password.isEmpty() || email.isEmpty() || contactNumber.isEmpty()) {
        return "register.empty_fields";
    }

    for (userAccount acc : accounts) {
        if (acc.getUsername().equalsIgnoreCase(username)) {
            return "register.already_exist";
        }
    }

    if (!isValidPassword(password)) {
        return "register.weak_passowrd";
    }

    // If passed all checks, register
    accounts.add(new userAccount(username, password, email, contactNumber));
    return null; // Success
}
 
    
    public static String resetPassword(String username, String email, String newPassword, String confirmPassword, LinkedList<userAccount> accounts) {
    if (username.isEmpty() || email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
        return "forgot.error.empty_fields";
    }

    for (userAccount acc : accounts) {
        if (acc.getUsername().equalsIgnoreCase(username) && acc.getEmail().equalsIgnoreCase(email)) {

            if (!isValidPassword(newPassword)) {
                 return "forgot.error.weak_password"; 
            }

            if (!newPassword.equals(confirmPassword)) {
               return "forgot.error.passwords_not_match"; 
            }

            acc.setPassword(newPassword);
            return null; // success
        }
    }

   return "forgot.error.no_account";  // Key
}
}




