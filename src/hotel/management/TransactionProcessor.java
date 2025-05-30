/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management;

/**
 *
 * @author Christian Devera
 */
import javax.swing.*;
import java.util.*;

    import javax.swing.*;
import java.text.DecimalFormat;

public class TransactionProcessor {
    private double total = 0.0;
    private final double taxRate = 0.12;

    public double addItem(CafeItem item, int quantity) {
        double cost = item.getPrice() * quantity;
        total += cost;
        return cost;
    }

    public double getTotal() { return total; }
    public double getTax() { return total * taxRate; }
    public double getTotalWithTax() { return total + getTax(); }

    public void reset() {
        total = 0.0;
    }
}