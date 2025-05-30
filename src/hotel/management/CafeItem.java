/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management;

/**
 *
 * @author Christian Devera
 */
public class CafeItem {
     private String name;
    private double price;
    private String imagePath;

    public CafeItem(String name, double price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImagePath() { return imagePath; }
}
    
 class CoffeeItem extends CafeItem {
    public CoffeeItem(String name, double price, String imagePath) {
        super(name, price, imagePath);
    }
}

 class CakeItem extends CafeItem {
    public CakeItem(String name, double price, String imagePath) {
        super(name, price, imagePath);
    }
}
