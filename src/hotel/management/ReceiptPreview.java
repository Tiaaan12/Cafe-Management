/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management;

/**
 *
 * @author Christian Devera
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class ReceiptPreview extends JDialog {

    public ReceiptPreview(JFrame parent, String receiptText, Runnable onPrint, Runnable onSave) {
        super(parent, "Receipt Preview", true);
        setSize(520, 700);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

      
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/hotel/management/iconn.png"));
            setIconImage(icon);
        } catch (Exception e) {
            System.out.println("Icon not found.");
        }

        
        JLabel header = new JLabel("JavaBee Receipt Preview", SwingConstants.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setOpaque(true);
        header.setBackground(new Color(255, 235, 180));
        header.setForeground(new Color(80, 40, 20));
        header.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(150, 120, 80)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

      
        JTextArea textArea = new JTextArea(receiptText);
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        textArea.setBackground(new Color(255, 253, 240)); // Light cream
        textArea.setForeground(new Color(80, 50, 20));    // Coffee brown
        textArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 180, 120), 2));

        
        JButton btnPrint = new JButton("🖨 Print");
        JButton btnSave = new JButton("💾 Save");
        JButton btnClose = new JButton("❌ Close");

        btnPrint.setBackground(new Color(255, 215, 100));
        btnSave.setBackground(new Color(220, 220, 220));
        btnClose.setBackground(new Color(255, 180, 180));

        Font btnFont = new Font("SansSerif", Font.BOLD, 13);
        btnPrint.setFont(btnFont);
        btnSave.setFont(btnFont);
        btnClose.setFont(btnFont);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(255, 253, 240));
        buttonPanel.add(btnPrint);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnClose);

        // === Add Components ===
        add(header, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // === Button Actions ===
        btnPrint.addActionListener(e -> {
            onPrint.run();
            dispose();
        });

        btnSave.addActionListener(e -> onSave.run());

        btnClose.addActionListener(e -> dispose());
    }
}