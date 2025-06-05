    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management;

/**
 *
 * @author Christian Devera
 */
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguageManager {
    private static ResourceBundle bundle;
     private String currentLanguage;
public void setLanguage(String languageCode) {
    try {
        Locale locale = new Locale(languageCode);
        bundle = ResourceBundle.getBundle("hotel.management.Messages", locale);
        currentLanguage = languageCode;
    } catch (MissingResourceException e) {
        System.err.println("Missing resource bundle for language: " + languageCode);
        // fallback to English
        bundle = ResourceBundle.getBundle("hotel.management.Messages", new Locale("en"));
        currentLanguage = "en";
    }
}

    public static String get(String key) {
        return bundle.getString(key);
    }
    
    
    
     public String getCurrentLanguageCode() {
        return currentLanguage;
    }
}
