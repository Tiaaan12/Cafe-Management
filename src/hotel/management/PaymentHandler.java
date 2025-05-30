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

    public void handlePayment() {
    // Check if total is zero (no items selected)
    if (transactionproProcessor.getTotal() == 0.0) {
        JOptionPane.showMessageDialog(null, "You haven't selected any item");
        return;
    }

    // Get cash input from JTextField
    String cashInput = jCashField.getText().trim();

    // Check if cash input is empty
    if (cashInput.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter the cash amount.");
        return;
    }

    double cashPaid;

    // Try to parse cash input to double
    try {
        cashPaid = Double.parseDouble(cashInput);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid cash amount. Enter a number.");
        return;
    }

    double totalAmount = transactionproProcessor.getTotalWithTax();

    // Check if cash is enough
    if (cashPaid < totalAmount) {
        JOptionPane.showMessageDialog(null, "Cash is not enough to pay for the total.");
        return;
    }

    double change = cashPaid - totalAmount;
        LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    String date = now.format(dateFormatter);
    String time = now.format(timeFormatter);
    // Print receipt details in the JTextArea
    jTextArea.append(
    "\n========================================\n" +
    "                 JavaBee Express\n" +
    "--------------------------------------------------\n" +
    "Date: " + date + "        Time: " + time + "\n" +
    "Cashier: " + cashierName + "\n" +
    "---------------------------------------------------\n" +
    String.format("Subtotal: \t\t%.2f\n", transactionproProcessor.getTotal()) +
    String.format("Tax (12%%): \t\t%.2f\n", transactionproProcessor.getTax()) +
    String.format("Total: \t\t\t%.2f\n", totalAmount) +
    String.format("Cash Paid: \t\t%.2f\n", cashPaid) +
    String.format("Change: \t\t%.2f\n", change) +
    "---------------------------------------------------\n" +
    "Transaction From: " + cashierName + "  →  Customer\n" +
    "========================================\n" +
    "         THANK YOU AND JAVA GOOD DAY!\n" +
    "========================================\n"
);;

    // Disable total button to prevent repeated payment
    jBtnTotal.setEnabled(false);
    
    
}
}