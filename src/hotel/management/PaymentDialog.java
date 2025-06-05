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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class PaymentDialog extends JDialog {
    private JTextField cashField;
    private JButton confirmButton, cancelButton;
    private JPanel numberPadPanel;
    private JLabel titleLabel;
    private Color foregroundColor = new Color(111, 80, 45);
    private Color backgroundColor = new Color(252, 244, 222);
    private Color buttonYellow = new Color(255, 235, 59); // bright yellow

    PaymentDialog(Dashboard aThis, PaymentListener paymentListener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public interface PaymentListener {
    void onConfirm(double amount);
    void onCancel();
}


    public PaymentDialog(JFrame parent) {
        super(parent, true);
        setUndecorated(true); // no default title bar
        setSize(450, 300);
        setLocationRelativeTo(parent);

        // Outer border panel with yellow line border
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBorder(new LineBorder(buttonYellow, 3));
        setContentPane(outerPanel);

        // Top panel: Custom title bar
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(backgroundColor);
        titleBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        titleLabel = new JLabel("JavaBee Express");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(foregroundColor);

        // You can load an icon here if you have one, e.g.:
        // ImageIcon icon = new ImageIcon(getClass().getResource("/path/to/icon.png"));
        // JLabel iconLabel = new JLabel(icon);
        // titleBar.add(iconLabel, BorderLayout.WEST);

        titleBar.add(titleLabel, BorderLayout.CENTER);

        // Add close button on title bar
        JButton closeBtn = new JButton("X");
        closeBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        closeBtn.setForeground(foregroundColor);
        closeBtn.setBackground(backgroundColor);
        closeBtn.setFocusPainted(false);
        closeBtn.setBorder(null);
        closeBtn.setOpaque(true);
        closeBtn.addActionListener(e -> dispose());
        titleBar.add(closeBtn, BorderLayout.EAST);

        outerPanel.add(titleBar, BorderLayout.NORTH);

        // Main split panel: Left with image, Right with payment form
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Left panel with placeholder for environment image
        JPanel leftPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Replace this with your actual background image if you want
                g.setColor(new Color(200, 230, 200)); // light greenish placeholder
                g.fillRect(0, 0, getWidth(), getHeight());

                // Example text to simulate environment image
                g.setColor(new Color(80, 130, 80));
                g.setFont(new Font("SansSerif", Font.BOLD, 18));
                g.drawString("Environment", 30, getHeight() / 2);
            }
        };
        leftPanel.setPreferredSize(new Dimension(180, 0));
        mainPanel.add(leftPanel);

        // Right panel with payment controls
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(backgroundColor);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Cash input panel (label + textfield)
        JPanel cashInputPanel = new JPanel(new BorderLayout(5, 5));
        cashInputPanel.setBackground(backgroundColor);

        JLabel cashLabel = new JLabel("Cash:");
        cashLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        cashLabel.setForeground(foregroundColor);

        cashField = new JTextField();
        cashField.setFont(new Font("SansSerif", Font.BOLD, 14));
        cashField.setForeground(foregroundColor);
        cashField.setBackground(Color.WHITE);
        cashField.setHorizontalAlignment(JTextField.RIGHT);

        cashInputPanel.add(cashLabel, BorderLayout.WEST);
        cashInputPanel.add(cashField, BorderLayout.CENTER);

        rightPanel.add(cashInputPanel, BorderLayout.NORTH);

        // Number pad panel: buttons 0-9 arranged horizontally next to cash input
        numberPadPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        numberPadPanel.setBackground(backgroundColor);

        // Add number buttons 1-9
        for (int i = 1; i <= 9; i++) {
            JButton btn = createNumberButton(String.valueOf(i));
            numberPadPanel.add(btn);
        }
        // Add empty button to fill grid slot
        numberPadPanel.add(new JLabel(""));
        // Add 0 button
        JButton zeroBtn = createNumberButton("0");
        numberPadPanel.add(zeroBtn);
        // Add backspace button
        JButton backspaceBtn = new JButton("←");
        backspaceBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        backspaceBtn.setBackground(buttonYellow);
        backspaceBtn.setForeground(foregroundColor);
        backspaceBtn.setFocusPainted(false);
        backspaceBtn.addActionListener(e -> {
            String text = cashField.getText();
            if (!text.isEmpty()) {
                cashField.setText(text.substring(0, text.length() - 1));
            }
        });
        numberPadPanel.add(backspaceBtn);

        rightPanel.add(numberPadPanel, BorderLayout.CENTER);

        // Buttons panel with Confirm and Cancel buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonsPanel.setBackground(backgroundColor);

        confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        confirmButton.setBackground(buttonYellow);
        confirmButton.setForeground(foregroundColor);
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(e -> {
            // Handle confirm payment logic here
            String cashText = cashField.getText();
            // Example: just print to console
            System.out.println("Confirm clicked, cash entered: " + cashText);
            dispose();
        });

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        cancelButton.setBackground(buttonYellow);
        cancelButton.setForeground(foregroundColor);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(e -> dispose());

        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);

        rightPanel.add(buttonsPanel, BorderLayout.SOUTH);

        mainPanel.add(rightPanel);

        outerPanel.add(mainPanel, BorderLayout.CENTER);
    }
    
    private JButton createNumberButton(String number) {
        JButton btn = new JButton(number);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setBackground(buttonYellow);
        btn.setForeground(new Color(111, 80, 45));
        btn.setFocusPainted(false);
        btn.addActionListener(e -> cashField.setText(cashField.getText() + number));
        return btn;
    }
   
    // Test main to run the dialog standalone
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dashboard");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JButton openPaymentBtn = new JButton("Open Payment Dialog");
            openPaymentBtn.addActionListener(e -> {
                PaymentDialog dlg = new PaymentDialog(frame);
                dlg.setVisible(true);
            });

            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(openPaymentBtn);
            frame.setVisible(true);
        });
    }
}
