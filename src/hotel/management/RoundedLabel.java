/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Christian Devera
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;

public class RoundedLabel extends JLabel {

    public RoundedLabel(String text, Icon icon) {
        super(text, icon, JLabel.LEFT);
        setOpaque(false); // We paint background ourselves
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setForeground(Color.WHITE); // Text color
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Smooth corners
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color (brown)
        g2.setColor(new Color(118, 80, 45));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        // Paint the label’s text and icon
        super.paintComponent(g);
    }
}