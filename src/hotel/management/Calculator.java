/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management;

/**
 *
 * @author Christian Devera
 */

    public abstract class Calculator {
    protected double taxRate = 0.02;

    public abstract double computeTotal(double itemTotal);

    public double computeTax(double itemTotal) {
        return itemTotal * taxRate;
    }
}


class CoffeeCalculator extends Calculator {
    @Override
    public double computeTotal(double itemTotal) {
        return itemTotal + computeTax(itemTotal);
    }
}

 class CakeCalculator extends Calculator {
    @Override
    public double computeTotal(double itemTotal) {
        return itemTotal + computeTax(itemTotal); 
    }
}

 class MealCalculator extends Calculator {
    @Override
    public double computeTotal(double itemTotal) {
        return itemTotal + computeTax(itemTotal); 
    }
}