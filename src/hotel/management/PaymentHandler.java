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
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentHandler {
    private JTextArea jTextArea;
    private JTextField jCashField;
    private JButton jBtnTotal;
    private TransactionProcessor transactionproProcessor;
    private String cashierName;

    public PaymentHandler(JTextArea jTextArea, JTextField jCashField, JButton jBtnTotal, TransactionProcessor transactionProcessor, String cashierName) {
        this.jTextArea = jTextArea;
        this.jCashField = jCashField;
        this.jBtnTotal = jBtnTotal;
        this.transactionproProcessor = transactionProcessor;
        this.cashierName = cashierName;
    }

  public boolean handlePayment() {
    if (transactionproProcessor.getTotal() == 0.0) {
        JOptionPane.showMessageDialog(null, "You haven't selected any item");
        return false;
    }

    String cashInput = jCashField.getText().trim();
    if (cashInput.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter the cash amount.");
        return false;
    }

    double cashPaid;
    try {
        cashPaid = Double.parseDouble(cashInput);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid cash amount. Enter a number.");
        return false;
    }

    double totalAmount = transactionproProcessor.getTotalWithTax();

    if (cashPaid < totalAmount) {
        JOptionPane.showMessageDialog(null, "Cash is not enough to pay for the total.");
        return false;
    }

    // Continue processing
    double change = cashPaid - totalAmount; 
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    String date = now.format(dateFormatter);
    String time = now.format(timeFormatter);

    jTextArea.append(
        "\n=======================================\n" +
        "                 JavaBee Express\n" +
        "---------------------------------------\n" +
        "Date: " + date + "        Time: " + time + "\n" +
        "Customer: " + cashierName + "\n" +
        "----------------------------------------\n" +
        String.format("Subtotal: \t\t%.2f\n", transactionproProcessor.getTotal()) +
        String.format("Tax (12%%): \t\t%.2f\n", transactionproProcessor.getTax()) +
        String.format("Total: \t\t\t%.2f\n", totalAmount) +
        String.format("Cash Paid: \t\t%.2f\n", cashPaid) +
        String.format("Change: \t\t%.2f\n", change) +
        "----------------------------------------\n" +
        "Transaction From: " + "JAVABEE" + " → " + cashierName +  
        "=======================================\n" +
        "         THANK YOU AND JAVA GOOD DAY!\n" +
        "=======================================\n"
    );

    jBtnTotal.setEnabled(false);  
    return true;
}
}