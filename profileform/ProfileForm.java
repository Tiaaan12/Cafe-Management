package profileform;

import javax.swing.*;
import java.awt.*;
public class ProfileForm extends JFrame {

    public ProfileForm() {
        setTitle("JAVABEE EXPRESS - Profile");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(243, 239, 220));
        JLabel logoLabel = new JLabel("🐝 JAVABEE EXPRESS ジャバビーへようこそ");
        logoLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(107, 79, 59));
        logoutButton.setForeground(Color.WHITE);
        headerPanel.add(logoLabel, BorderLayout.WEST);
        headerPanel.add(logoutButton, BorderLayout.EAST);

        // Profile Info Panel
        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.setBackground(new Color(243, 239, 220));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        JLabel nameLabel = new JLabel("Name: Vanna Victoria E. Hernandez");
        JLabel emailLabel = new JLabel("Email: vannavictoria@email.com");
        JLabel tierLabel = new JLabel("Membership Tier: GOLD");
        JLabel pointsLabel = new JLabel("Points: 210 pts");

        Font infoFont = new Font("SansSerif", Font.PLAIN, 16);
        nameLabel.setFont(infoFont);
        emailLabel.setFont(infoFont);
        tierLabel.setFont(infoFont);
        pointsLabel.setFont(infoFont);

        infoPanel.add(nameLabel);
        infoPanel.add(emailLabel);
        infoPanel.add(tierLabel);
        infoPanel.add(pointsLabel);

        // Membership Card Panel
        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(new Color(200, 213, 185));
        cardPanel.setPreferredSize(new Dimension(600, 100));
        cardPanel.setBorder(BorderFactory.createTitledBorder("🪪 GOLD MEMBER CARD"));
        JLabel benefitsLabel = new JLabel("☕ 20% discount, priority order, free drink");
        benefitsLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        cardPanel.add(benefitsLabel);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        JButton claimBtn = new JButton("Claim Voucher");
        JButton qrBtn = new JButton("View QR Code 🔳");

        claimBtn.setBackground(new Color(107, 79, 59));
        claimBtn.setForeground(Color.WHITE);
        qrBtn.setBackground(new Color(107, 79, 59));
        qrBtn.setForeground(Color.WHITE);

        buttonPanel.add(claimBtn);
        buttonPanel.add(qrBtn);

        // Main Body Layout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(243, 239, 220));
        centerPanel.add(infoPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(cardPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(buttonPanel);

        add(headerPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProfileForm().setVisible(true));
    }
} 

