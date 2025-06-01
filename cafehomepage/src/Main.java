import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    private static int beeX = 0;
    private static boolean movingRight = true;
    private static final int BEE_Y = 70;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("JAVABEE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        frame.setIconImage(new ImageIcon("logonobg.png").getImage());

        ImageIcon backgroundIcon = new ImageIcon("ulit3.gif");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(null);
        frame.setContentPane(backgroundLabel);
        JPanel navBar = new JPanel(new BorderLayout());
        navBar.setBounds(0, 0, frame.getWidth(), 45);
        navBar.setBackground(new Color(255, 255, 220));
        navBar.setBorder(BorderFactory.createLineBorder(new Color(111, 80, 45), 3));

        ImageIcon logoIcon = new ImageIcon("logonobg.png");
        Image scaledImage = logoIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(scaledImage);

        JLabel brand = new JLabel("JAVABEE EXPRESS ジャバビーへようこそ", logoIcon, JLabel.LEFT);
        brand.setFont(new Font("SansSerif", Font.BOLD, 22));
        brand.setForeground(new Color(111, 80, 45));
        navBar.add(brand, BorderLayout.WEST);

        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);

        String[] menuItems = {"About Us", "Contact Us", "Shop"};

        for (String item : menuItems) {
            JLabel label = new JLabel(item);
            label.setForeground(new Color(111, 80, 45));
            label.setFont(new Font("Sans", Font.BOLD, 14));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label.setBorder(BorderFactory.createEmptyBorder(0, 10, 15, 10));

            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    String clickedItem = ((JLabel) e.getSource()).getText();

                    switch (clickedItem) {
                        case "About Us":
                            JOptionPane.showMessageDialog(frame, "This small café system \nwas made with care \nby Caparuzo, Devera, \nHernandez, and Ogbac \nbuilt to serve you with \nlove and a smile.");
                            break;
                        case "Contact Us":
                            JOptionPane.showMessageDialog(frame, "You can reach us at:\nEmail: support@javacafe.com\nPhone: 0912-345-6789");
                            break;
                        case "Shop":
                            JOptionPane.showMessageDialog(frame, "Browse our products:\n- Coffee Beans\n- Merch\n- Gift Cards\nComing soon!");
                            break;
                        default:
                            JOptionPane.showMessageDialog(frame, clickedItem + " clicked!");
                    }
                }
            });
            menuPanel.add(label);
        }
        JLabel hamburger = new JLabel("☰");
        hamburger.setFont(new Font("SansSerif", Font.BOLD, 22));
        hamburger.setForeground(new Color(111, 80, 45));
        hamburger.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hamburger.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPopupMenu dropdownMenu = new JPopupMenu();
        dropdownMenu.setBorder(BorderFactory.createLineBorder(new Color(111, 80, 45), 2));
        dropdownMenu.setBackground(new Color(255, 255, 220));

        JMenuItem signOutItem = new JMenuItem("Sign Out");
        signOutItem.setFont(new Font("SansSerif", Font.BOLD, 14));
        signOutItem.setBackground(new Color(255, 255, 220));
        signOutItem.setForeground(new Color(111, 80, 45));
        signOutItem.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        signOutItem.addActionListener(e -> {
            UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.BOLD, 14));
            UIManager.put("OptionPane.background", new Color(255, 255, 220));
            UIManager.put("Panel.background", new Color(255, 255, 220));
            UIManager.put("OptionPane.foreground", new Color(111, 80, 45));
            UIManager.put("Button.background", new Color(255, 255, 220));
            UIManager.put("Button.foreground", new Color(111, 80, 45));

            int confirm = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to sign out?",
                    "Sign Out",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "Signed out successfully!", "Signed Out.", JOptionPane.PLAIN_MESSAGE);
            }
        });

        dropdownMenu.add(signOutItem);
        hamburger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dropdownMenu.show(hamburger, 0, hamburger.getHeight());
            }
        });

        menuPanel.add(hamburger);
        navBar.add(menuPanel, BorderLayout.EAST);
        backgroundLabel.add(navBar);
        ImageIcon beeRight = new ImageIcon("beeRR.png");
        ImageIcon beeLeft = new ImageIcon("beeL.png");
        JLabel beeLabel = new JLabel(beeRight);
        beeLabel.setBounds(beeX, BEE_Y, 50, 50);
        backgroundLabel.add(beeLabel);

        Timer beeTimer = new Timer(15, e -> {
            if (movingRight) {
                beeX += 2;
                if (beeX >= frame.getWidth() - 100) {
                    movingRight = false;
                    beeLabel.setIcon(beeLeft);
                }
            } else {
                beeX -= 2;
                if (beeX <= 0) {
                    movingRight = true;
                    beeLabel.setIcon(beeRight);
                }
            }
            beeLabel.setLocation(beeX, BEE_Y);
        });
        beeTimer.start();
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.setBounds(0, 180, frame.getWidth(), 300);

        JLabel line1 = new JLabel("JAVA");
        JLabel line2 = new JLabel("GOOD");
        JLabel line3 = new JLabel("DAY!");

        JPanel highlightPanel = new JPanel();
        highlightPanel.setOpaque(true);
        highlightPanel.setBackground(new Color(255, 255, 255, 100));
        highlightPanel.setLayout(new BoxLayout(highlightPanel, BoxLayout.Y_AXIS));
        highlightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (JLabel label : new JLabel[]{line1, line2, line3}) {
            label.setFont(new Font("Georgia", Font.BOLD, 60));
            label.setForeground(new Color(111, 80, 45));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            highlightPanel.add(label);
        }

        JButton orderNow = new JButton("Order Now");
        orderNow.setFont(new Font("SansSerif", Font.BOLD, 18));
        orderNow.setForeground(Color.WHITE);
        orderNow.setBackground(new Color(111, 80, 45));
        orderNow.setFocusPainted(false);
        orderNow.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderNow.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        orderNow.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                orderNow.setBackground(new Color(254, 201, 13));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                orderNow.setBackground(new Color(111, 80, 45));
            }
        });

        highlightPanel.add(Box.createVerticalStrut(20));
        highlightPanel.add(orderNow);
        highlightPanel.setPreferredSize(new Dimension(700, 250));
        highlightPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(111, 80, 45), 2),
                BorderFactory.createEmptyBorder(5, 20, 25, 20)
        ));

        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(highlightPanel);


        backgroundLabel.add(centerPanel);

        frame.setVisible(true);
    }
}
