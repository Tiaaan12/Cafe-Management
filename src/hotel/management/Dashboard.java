/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel.management;

/**
 *
 * @author Christian Devera
 */
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JButton;
import javax.swing.plaf.ComponentUI;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.*;
import hotel.management.Calculator;
import hotel.management.CoffeeCalculator;
import hotel.management.CakeCalculator;
import hotel.management.MealCalculator;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Dashboard extends javax.swing.JFrame implements ReceiptPrintable{
   
    private int x = 0;
    private double cash = 0.0;
    private PaymentHandler paymentHandler;
    private JCheckBox[] checkBoxes;
    private JSpinner[] spinners;
    private String cashierName = "Christian"; // Or dynamic based on login

    
Calculator coffeeCalculator;
Calculator cakeCalculator;
Calculator mealCalculator;
       JLabel[] nameLabels;
       JLabel[] priceLabels;
       JLabel[] imageLabels;
    
    List<CafeItem> coffeeItems = new ArrayList<>();
    List<CafeItem> cakeItems = new ArrayList<>();
    List<CafeItem> mealItems = new ArrayList<>();
    
    private void loadItems() {
    coffeeItems.add(new CafeItem("Americano", 80.0, "/resource/icons/americano.png"));
    coffeeItems.add(new CafeItem("Espresso", 80.0, "/resource/icons/espresso.png"));
    coffeeItems.add(new CafeItem("Spanish Latte", 90.0, "/resource/icons/spanish latte.png"));
    coffeeItems.add(new CafeItem("Mocha", 90.0, "/resource/icons/mocha.png"));
    coffeeItems.add(new CafeItem("Caramel Macchiato", 100.0, "/resource/icons/caramel macchiato.png"));
    coffeeItems.add(new CafeItem("Dark Mocha", 100.0, "/resource/icons/dark mocha.png"));
    coffeeItems.add(new CafeItem("White Mocha", 100.0, "/resource/icons/white mocha.png"));
    coffeeItems.add(new CafeItem("Chocolate", 100.0, "/resource/icons/hot choco.png"));
    coffeeItems.add(new CafeItem("Matcha Latte", 115.0, "/resource/icons/matcha latte.png"));
    coffeeItems.add(new CafeItem("Lemonade", 80.0, "/resource/icons/lemonade.png"));
    coffeeItems.add(new CafeItem("Earl Grey Tea", 80.0, "/resource/icons/earl grey.png"));
    coffeeItems.add(new CafeItem("Coffee Frappe", 145.0, "/resource/icons/coffee frappe.png"));
    coffeeItems.add(new CafeItem("Chocolate Frappe", 145.0, "/resource/icons/chocolate frappe.png"));
    coffeeItems.add(new CafeItem("Matcha Frappe", 145.0, "/resource/icons/matcha frappe.png"));
    coffeeItems.add(new CafeItem("Cappucino", 115.0, "/resource/icons/cappucino.png"));
    cakeItems.add(new CafeItem("Classic Cake", 100.0, "/resource/icons/classic cheesecake.png")); 
    cakeItems.add(new CafeItem("Blueberry Cake", 110.0, "/resource/icons/blueberry cheesecake.png")); 
    cakeItems.add(new CafeItem("Strawberry Cake", 110.0, "/resource/icons/strawberry cheesecake.png")); 
    cakeItems.add(new CafeItem("Red Velvet", 100.0, "/resource/icons/redvelvet.png")); 
    cakeItems.add(new CafeItem("Triple Chocolate", 110.0, "/resource/icons/triple chocolate.png")); 
    cakeItems.add(new CafeItem("Ube", 100.0, "/resource/icons/ube.png")); 
    cakeItems.add(new CafeItem("Brazo DeMercedes", 120.0, "/resource/icons/brazo de mercedes.png")); 
    cakeItems.add(new CafeItem("Strawberry Short", 110.0, "/resource/icons/strawberry shortcake.png")); 
    cakeItems.add(new CafeItem("Mocha", 100.0, "/resource/icons/mocha.png")); 
    cakeItems.add(new CafeItem("Egg pie", 80.0, "/resource/icons/egg pie.png")); 
    cakeItems.add(new CafeItem("Apple pie", 100.0, "/resource/icons/apple pie.png")); 
    cakeItems.add(new CafeItem("Pumpkin pie", 95.0, "/resource/icons/pumpkin pie.png")); 
    cakeItems.add(new CafeItem("Key Lime Pie", 100.0, "/resource/icons/keylime.png")); 
    cakeItems.add(new CafeItem("Banana Cream Pie", 90.0, "/resource/icons/banana.png")); 
    cakeItems.add(new CafeItem("Mango Cream", 110.0, "/resource/icons/mangocream.png")); 
    mealItems.add(new CafeItem("Tapsilog", 95.0, "/resource/icons/tapsilog.png"));
    mealItems.add(new CafeItem("Chicken Lasagna", 100.0, "/resource/icons/chicken lasagna.png"));
    mealItems.add(new CafeItem("Pesto Penne", 100.0, "/resource/icons/pesto penne.png"));
    mealItems.add(new CafeItem("Bacsilog", 95.0, "/resource/icons/bacsilog.png"));
    mealItems.add(new CafeItem("Spaghetti", 85.0, "/resource/icons/spaghetti.png"));
    mealItems.add(new CafeItem("Eggs Benedict", 95.0, "/resource/icons/eggs benedict.png"));
    mealItems.add(new CafeItem("Eggcheesewich", 85.0, "/resource/icons/egg and cheese sandwich.png"));
    mealItems.add(new CafeItem("Eggbaconwich", 85.0, "/resource/icons/bacon and egg sandwich.png"));
    mealItems.add(new CafeItem("Pancake Souffle", 90.0, "/resource/icons/souffle pancakes.png"));
    mealItems.add(new CafeItem("Waffles", 80.0, "/resource/icons/waffles.png"));
    mealItems.add(new CafeItem("Cinnamon Roll", 80.0, "/resource/icons/cinnamonroll.png"));
    mealItems.add(new CafeItem("Choco Croissant", 85.0, "/resource/icons/chocolate croissant.png"));
    mealItems.add(new CafeItem("Tuna Sandwich", 80.0, "/resource/icons/tuna sandwich.png"));
    mealItems.add(new CafeItem("Butter Croissant", 85.0, "/resource/icons/butter croissant.png"));
    mealItems.add(new CafeItem("Mac n Cheese", 100.0, "/resource/icons/mac and cheese.png"));
    
} 
   private static LinkedList<userAccount> accounts;
   private TransactionProcessor transactionProcessor;
   private static userAccount currentUser;

  
   /**
     * Creates new form Dashboard
     */       
    public Dashboard(LinkedList<userAccount> accounts, userAccount currentUser) {
        
        initComponents();
        this.accounts = accounts;
        this.currentUser = currentUser;
        setupComboBoxRenderer();
        this.transactionProcessor = new TransactionProcessor();
        
            JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();
    verticalScrollBar.setPreferredSize(new Dimension(10, Integer.MAX_VALUE)); // Make scrollbar thinner

    verticalScrollBar.setUI(new BasicScrollBarUI() {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(111, 80, 45); // Customize thumb (draggable bar)
            this.trackColor = new Color(252, 244, 222); // Customize track background
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    });
        
        
     
    checkBoxes = new JCheckBox[] {
    jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5,
    jCheckBox6, jCheckBox7, jCheckBox8, jCheckBox9, jCheckBox10,
    jCheckBox11, jCheckBox12, jCheckBox13, jCheckBox14, jCheckBox15
};

spinners = new JSpinner[] {
    jSpinner1, jSpinner2, jSpinner3, jSpinner4, jSpinner5,
    jSpinner6, jSpinner7, jSpinner8, jSpinner9, jSpinner10,
    jSpinner11, jSpinner12, jSpinner13, jSpinner14, jSpinner15
};  
    paymentHandler = new PaymentHandler(jTextArea, jCashField, jBtnTotal, transactionProcessor, currentUser.getUsername());
    coffeeCalculator = new CoffeeCalculator();
    cakeCalculator = new CakeCalculator();
    mealCalculator = new MealCalculator();
        setTime();
        jTxtTime.setVisible(true);
        jTxtDate.setVisible(true);
        loadItems();
         
        this.setResizable(false);
         
    nameLabels = new JLabel[] {
        nameLabel1, nameLabel2, nameLabel3, nameLabel4, nameLabel5,
        nameLabel6, nameLabel7, nameLabel8, nameLabel9, nameLabel10,
        nameLabel11, nameLabel12, nameLabel13, nameLabel14, nameLabel15
    };

    priceLabels = new JLabel[] {
        priceLabel1, priceLabel2, priceLabel3, priceLabel4, priceLabel5,
        priceLabel6, priceLabel7, priceLabel8, priceLabel9, priceLabel10,
        priceLabel11, priceLabel12, priceLabel13, priceLabel14  , priceLabel15
    };

    imageLabels = new JLabel[] {
        imageLabel1, imageLabel2, imageLabel3, imageLabel4, imageLabel5,
        imageLabel6, imageLabel7, imageLabel8, imageLabel9, imageLabel10,
        imageLabel11, imageLabel12, imageLabel13, imageLabel14, imageLabel15
    };

    updateItemsPanel(coffeeItems); // Load coffee items by default
    
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void setControlsEnabled(boolean enabled) {
    for (JCheckBox cb : checkBoxes) {
        cb.setEnabled(enabled);
    }
    for (JSpinner sp : spinners) {
        sp.setEnabled(enabled);
    }
}
    
    private void updateItemsPanel(List<CafeItem> items) {
    for (int i = 0; i < nameLabels.length; i++) {
        if (i < items.size()) {
            CafeItem item = items.get(i);

            nameLabels[i].setText(item.getName());
            priceLabels[i].setText("₱" + item.getPrice());

            ImageIcon icon = new ImageIcon(getClass().getResource(item.getImagePath()));
            Image image = icon.getImage().getScaledInstance(
                imageLabels[i].getWidth(),
                imageLabels[i].getHeight(),
                
                Image.SCALE_SMOOTH
            );
            imageLabels[i].setIcon(new ImageIcon(image));
        } else {
            // Clear unused labels
            nameLabels[i].setText("");
            priceLabels[i].setText("");
            imageLabels[i].setIcon(null);
        }
    }
}
    public void init() {      
    }
    public void javaBee() {
        jTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
       jTextArea.setText("***********JavaBee Express***********\n"
        + "Time:" + jTxtTime.getText() + " Date:" + jTxtDate.getText() + "\n"
        + "**************************************\n"
        + "No. Qty  Item               Price\n");   
                
    }
    public boolean qtyIsZero(int qty) {
        if(qty==0) {
            JOptionPane.showMessageDialog(null, "Cannot purchase without quantitiy!");
            return false;
        }
        return true;
    }
    public void reset() {
        transactionProcessor.reset();
        x = 0;
        jButtonReceipt.setEnabled(false);
        setOrderControlsEnabled(true);
        jButton1.setEnabled(false);
        jBtnTotal.setEnabled(true);
        
        jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        jSpinner3.setValue(0);
        jSpinner4.setValue(0);
        jSpinner5.setValue(0);
        jSpinner6.setValue(0);
        jSpinner7.setValue(0);
        jSpinner8.setValue(0);
        jSpinner9.setValue(0);
        jSpinner10.setValue(0);
        jSpinner11.setValue(0);
        jSpinner12.setValue(0);
        jSpinner13.setValue(0);
        jSpinner14.setValue(0);
        jSpinner15.setValue(0);
        jTaxField.setText("0.0");
        jSubtotalField.setText("0.0");
        jTotalField.setText("0.0");
        jCashField.setText("0.0");
        jCashField.setVisible(false);
        jTextArea.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox10.setSelected(false);
        jCheckBox11.setSelected(false);
        jCheckBox12.setSelected(false);
        jCheckBox13.setSelected(false);
        jCheckBox14.setSelected(false);
        jCheckBox15.setSelected(false);
        
        
    }
    
    

 public void resetSelections() {
       jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox10.setSelected(false);
        jCheckBox11.setSelected(false);
        jCheckBox12.setSelected(false);
        jCheckBox13.setSelected(false);
        jCheckBox14.setSelected(false);
        jCheckBox15.setSelected(false);
          jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        jSpinner3.setValue(0);
        jSpinner4.setValue(0);
        jSpinner5.setValue(0);
        jSpinner6.setValue(0);
        jSpinner7.setValue(0);
        jSpinner8.setValue(0);
        jSpinner9.setValue(0);
        jSpinner10.setValue(0);
        jSpinner11.setValue(0);
        jSpinner12.setValue(0);
        jSpinner13.setValue(0);
        jSpinner14.setValue(0);
        jSpinner15.setValue(0);
        
     
 }
 
 

private void handleCheckboxAction(JCheckBox checkBox, JSpinner spinner, JLabel nameLabel, CafeItem item) {
     if (checkBox.isSelected()) {
        int quantity = (int) spinner.getValue();
        if (quantity > 0) {
            double cost = transactionProcessor.addItem(item, quantity);

            if (jTextArea.getText().isEmpty() || !jTextArea.getText().contains("JavaBee")) {
                javaBee(); // Add header
            }

            x++; // line number

            String itemName = nameLabel.getText();

            // Optional: trim very long names
            if (itemName.length() > 18) {
                itemName = itemName.substring(0, 15) + "...";
            }

            // Format: "1. 2x Brewed Coffee      ₱120.00"
            String line = String.format("%-3s %-3sx %-18s ₱%6.2f\n", x + ".", quantity, itemName, cost);
            jTextArea.append(line);

            updateTotalsUI();
        } else {
            JOptionPane.showMessageDialog(null, "Quantity must be greater than zero!");
        }
    }

    // Reset checkbox and spinner after selection
    spinner.setValue(0);
    checkBox.setSelected(false);
}
   private void updateTotalsUI() {
    jSubtotalField.setText(String.format("%.2f", transactionProcessor.getTotal()));
    jTaxField.setText(String.format("%.2f", transactionProcessor.getTax()));
    jTotalField.setText(String.format("%.2f", transactionProcessor.getTotalWithTax()));
}
   public void printReceipt() {
    try {
        boolean done = jTextArea.print();  // system print dialog
        if (done) {
            JOptionPane.showMessageDialog(this, "Receipt sent to printer.");

            int choice = JOptionPane.showConfirmDialog(
                this,
                "Do you also want to save a digital copy?",
                "Save Receipt",
                JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                saveReceiptToFile(); 
            }

        } else {
            JOptionPane.showMessageDialog(this, "Printing was cancelled.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Printing error: " + e.getMessage());
    }
}

public void saveReceiptToFile() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Receipt As");

    int result = fileChooser.showSaveDialog(this); 
    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(jTextArea.getText());
            JOptionPane.showMessageDialog(this, "Receipt saved successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving receipt: " + ex.getMessage());
        }
    }
}

public void showReceiptPreview() {
    JTextArea previewArea = new JTextArea(jTextArea.getText());
    previewArea.setEditable(false);
    previewArea.setLineWrap(true);
    previewArea.setWrapStyleWord(true);
    
    JScrollPane scrollPane = new JScrollPane(previewArea);
    scrollPane.setPreferredSize(new Dimension(500, 400));

    int result = JOptionPane.showConfirmDialog(
        null,
        scrollPane,
        "Receipt Preview",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
        printReceipt();
        saveReceiptToFile();// or you can also call saveReceiptToFile() here if needed
    }
}

private void setupComboBoxRenderer() {
    categoryComboBox.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            label.setForeground(new Color(64, 42, 23));
            label.setBackground(isSelected ? new Color(255, 223, 186) : Color.WHITE);
            label.setOpaque(true);

            // Load appropriate icons (assuming you placed PNGs in /resources/)
            if ("Drinks".equals(value)) {
                label.setIcon(new ImageIcon(getClass().getResource("/resource/icons/drinks (3).png")));
            } else if ("Cake".equals(value)) {
                label.setIcon(new ImageIcon(getClass().getResource("/resource/icons/cake.png")));
            } else if ("Food".equals(value)) {
                label.setIcon(new ImageIcon(getClass().getResource("/resource/icons/food (2).png")));
            }

            return label;
        }
    });
}


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jTxtDate = new javax.swing.JLabel();
        jTxtTime = new javax.swing.JLabel();
        itemPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        imageLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        namePrice = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        priceLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        imageLabel2 = new javax.swing.JLabel();
        nameLabel2 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        priceLabel2 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel21 = new javax.swing.JPanel();
        imageLabel3 = new javax.swing.JLabel();
        nameLabel3 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        priceLabel3 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel22 = new javax.swing.JPanel();
        imageLabel4 = new javax.swing.JLabel();
        nameLabel4 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        priceLabel4 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel23 = new javax.swing.JPanel();
        imageLabel5 = new javax.swing.JLabel();
        nameLabel5 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        priceLabel5 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel24 = new javax.swing.JPanel();
        imageLabel6 = new javax.swing.JLabel();
        nameLabel6 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        priceLabel6 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel25 = new javax.swing.JPanel();
        imageLabel7 = new javax.swing.JLabel();
        nameLabel7 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        priceLabel7 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel26 = new javax.swing.JPanel();
        imageLabel8 = new javax.swing.JLabel();
        nameLabel8 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        priceLabel8 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel27 = new javax.swing.JPanel();
        imageLabel9 = new javax.swing.JLabel();
        nameLabel9 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        priceLabel9 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel28 = new javax.swing.JPanel();
        imageLabel10 = new javax.swing.JLabel();
        nameLabel10 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        priceLabel10 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel29 = new javax.swing.JPanel();
        imageLabel11 = new javax.swing.JLabel();
        nameLabel11 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        priceLabel11 = new javax.swing.JLabel();
        jSpinner11 = new javax.swing.JSpinner();
        jCheckBox11 = new javax.swing.JCheckBox();
        jPanel30 = new javax.swing.JPanel();
        imageLabel12 = new javax.swing.JLabel();
        nameLabel12 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        priceLabel12 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel31 = new javax.swing.JPanel();
        imageLabel13 = new javax.swing.JLabel();
        nameLabel13 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        priceLabel13 = new javax.swing.JLabel();
        jSpinner13 = new javax.swing.JSpinner();
        jCheckBox13 = new javax.swing.JCheckBox();
        jPanel32 = new javax.swing.JPanel();
        imageLabel14 = new javax.swing.JLabel();
        nameLabel14 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        priceLabel14 = new javax.swing.JLabel();
        jSpinner14 = new javax.swing.JSpinner();
        jCheckBox14 = new javax.swing.JCheckBox();
        jPanel33 = new javax.swing.JPanel();
        imageLabel15 = new javax.swing.JLabel();
        nameLabel15 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        priceLabel15 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        jCheckBox15 = new javax.swing.JCheckBox();
        categoryComboBox = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        jBtnTotal = new javax.swing.JButton();
        jButtonReceipt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jTaxField = new javax.swing.JTextField();
        jSubtotalField = new javax.swing.JTextField();
        jTotalField = new javax.swing.JTextField();
        jTotalField.setEditable(false);
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCashField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 202, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 220));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(80, 50, 30)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(111, 80, 55));
        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(80, 50, 30));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("心温まるひとときを、どうぞお過ごしください心温まるひとときを、どうぞお過ごしください。");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 400, 50));

        jLabel11.setBackground(new java.awt.Color(111, 80, 55));
        jLabel11.setFont(new java.awt.Font("Algerian", 1, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(80, 50, 30));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("JAVABEE EXPRESS");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 300, 50));

        btnMinimize.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMinimize.setForeground(new java.awt.Color(111, 78, 60));
        btnMinimize.setText("—");
        btnMinimize.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnMinimize.setBorderPainted(false);
        btnMinimize.setFocusPainted(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });
        jPanel3.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 2, 40, 33));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/coffee png.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(111, 78, 60));
        btnExit.setText("X");
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExitMouseReleased(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel3.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 4, 40, 32));

        jTxtDate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTxtDate.setForeground(new java.awt.Color(111, 80, 45));
        jTxtDate.setText("Tuesday 19-07-2025");
        jPanel3.add(jTxtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 170, 40));

        jTxtTime.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jTxtTime.setForeground(new java.awt.Color(111, 80, 45));
        jTxtTime.setText("9:16:35 PM");
        jPanel3.add(jTxtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 100, 40));

        itemPanel.setBackground(new java.awt.Color(255, 239, 200));
        itemPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        jPanel4.setBackground(new java.awt.Color(252, 244, 222));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel1.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel1.setText("   Name:");

        namePrice.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        namePrice.setForeground(new java.awt.Color(111, 80, 55));
        namePrice.setText("Price:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(111, 80, 55));
        jLabel6.setText("Quantity:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(111, 80, 55));
        jLabel8.setText("Purchase:");

        priceLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel1.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel1.setText("$3");

        jSpinner1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel1)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namePrice)
                    .addComponent(priceLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jLabel1.setBackground(new java.awt.Color(111, 80, 55));
        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(111, 80, 55));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu Items");

        jPanel20.setBackground(new java.awt.Color(252, 244, 222));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel2.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel2.setText("Name:");

        jLabel97.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(111, 80, 55));
        jLabel97.setText("Price:");

        jLabel98.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(111, 80, 55));
        jLabel98.setText("Quantity:");

        jLabel99.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(111, 80, 55));
        jLabel99.setText("Purchase:");

        priceLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel2.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel2.setText("$3");

        jSpinner2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(imageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(nameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel98))
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel2)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(imageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(priceLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel21.setBackground(new java.awt.Color(252, 244, 222));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel3.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel3.setText("Name:");

        jLabel103.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(111, 80, 55));
        jLabel103.setText("Price:");

        jLabel104.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(111, 80, 55));
        jLabel104.setText("Quantity:");

        jLabel105.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(111, 80, 55));
        jLabel105.setText("Purchase:");

        priceLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel3.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel3.setText("$3");

        jSpinner3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(imageLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(nameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel104))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel3)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(imageLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(priceLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel22.setBackground(new java.awt.Color(252, 244, 222));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel4.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel4.setText("Name:");

        jLabel109.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(111, 80, 55));
        jLabel109.setText("Price:");

        jLabel110.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(111, 80, 55));
        jLabel110.setText("Quantity:");

        jLabel111.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(111, 80, 55));
        jLabel111.setText("Purchase:");

        priceLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel4.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel4.setText("$3");

        jSpinner4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel110))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel4)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(nameLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(imageLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(imageLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(priceLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel23.setBackground(new java.awt.Color(252, 244, 222));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel5.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel5.setText("Name:");

        jLabel115.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(111, 80, 55));
        jLabel115.setText("Price:");

        jLabel116.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(111, 80, 55));
        jLabel116.setText("Quantity:");

        jLabel117.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(111, 80, 55));
        jLabel117.setText("Purchase:");

        priceLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel5.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel5.setText("$3");

        jSpinner5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(imageLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(nameLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel116))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel5)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(imageLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(priceLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel117, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel24.setBackground(new java.awt.Color(252, 244, 222));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel6.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel6.setText("Name:");

        jLabel121.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(111, 80, 55));
        jLabel121.setText("Price:");

        jLabel122.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(111, 80, 55));
        jLabel122.setText("Quantity:");

        jLabel123.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(111, 80, 55));
        jLabel123.setText("Purchase:");

        priceLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel6.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel6.setText("$3");

        jSpinner6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(imageLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(nameLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel122))
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel6)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(imageLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(priceLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel25.setBackground(new java.awt.Color(252, 244, 222));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel7.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel7.setText("Name:");

        jLabel127.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(111, 80, 55));
        jLabel127.setText("Price:");

        jLabel128.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(111, 80, 55));
        jLabel128.setText("Quantity:");

        jLabel129.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(111, 80, 55));
        jLabel129.setText("Purchase:");

        priceLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel7.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel7.setText("$3");

        jSpinner7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(imageLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(nameLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel128))
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel7)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(imageLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(priceLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel128)
                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel129, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel26.setBackground(new java.awt.Color(252, 244, 222));
        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel8.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel8.setText("Name:");

        jLabel133.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(111, 80, 55));
        jLabel133.setText("Price:");

        jLabel134.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(111, 80, 55));
        jLabel134.setText("Quantity:");

        jLabel135.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(111, 80, 55));
        jLabel135.setText("Purchase:");

        priceLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel8.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel8.setText("$3");

        jSpinner8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel134))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel8)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(nameLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(imageLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(imageLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(priceLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel135, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel27.setBackground(new java.awt.Color(252, 244, 222));
        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel9.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel9.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel9.setText("Name:");

        jLabel139.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(111, 80, 55));
        jLabel139.setText("Price:");

        jLabel140.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(111, 80, 55));
        jLabel140.setText("Quantity:");

        jLabel141.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(111, 80, 55));
        jLabel141.setText("Purchase:");

        priceLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel9.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel9.setText("$3");

        jSpinner9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(imageLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(nameLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel140))
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel9)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(imageLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(priceLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel140)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel141, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel28.setBackground(new java.awt.Color(252, 244, 222));
        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel10.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel10.setText("Name:");

        jLabel145.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(111, 80, 55));
        jLabel145.setText("Price:");

        jLabel146.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(111, 80, 55));
        jLabel146.setText("Quantity:");

        jLabel147.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(111, 80, 55));
        jLabel147.setText("Purchase:");

        priceLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel10.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel10.setText("$3");

        jSpinner10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel145, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel147, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel146))
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel10)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(nameLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(imageLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(imageLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(priceLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel147, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel29.setBackground(new java.awt.Color(252, 244, 222));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel11.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel11.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel11.setText("Name:");

        jLabel151.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(111, 80, 55));
        jLabel151.setText("Price:");

        jLabel152.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(111, 80, 55));
        jLabel152.setText("Quantity:");

        jLabel153.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(111, 80, 55));
        jLabel153.setText("Purchase:");

        priceLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel11.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel11.setText("$3");

        jSpinner11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner11.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel151, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel152))
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel11)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(nameLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(imageLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(imageLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151)
                    .addComponent(priceLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel153, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox11, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel30.setBackground(new java.awt.Color(252, 244, 222));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel12.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel12.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel12.setText("Name:");

        jLabel157.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(111, 80, 55));
        jLabel157.setText("Price:");

        jLabel158.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(111, 80, 55));
        jLabel158.setText("Quantity:");

        jLabel159.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(111, 80, 55));
        jLabel159.setText("Purchase:");

        priceLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel12.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel12.setText("$3");

        jSpinner12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner12.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel157, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel159, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel158))
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel12)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(nameLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(imageLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(imageLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157)
                    .addComponent(priceLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel158)
                    .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel159, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel31.setBackground(new java.awt.Color(252, 244, 222));
        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel13.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel13.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel13.setText("Name:");

        jLabel163.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(111, 80, 55));
        jLabel163.setText("Price:");

        jLabel164.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(111, 80, 55));
        jLabel164.setText("Quantity:");

        jLabel165.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(111, 80, 55));
        jLabel165.setText("Purchase:");

        priceLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel13.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel13.setText("$3");

        jSpinner13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner13.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel163, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel165, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel164))
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel13)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(nameLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(imageLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(imageLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(priceLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel165, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel32.setBackground(new java.awt.Color(252, 244, 222));
        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel14.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel14.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel14.setText("Name:");

        jLabel169.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(111, 80, 55));
        jLabel169.setText("Price:");

        jLabel170.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(111, 80, 55));
        jLabel170.setText("Quantity:");

        jLabel171.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(111, 80, 55));
        jLabel171.setText("Purchase:");

        priceLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel14.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel14.setText("$3");

        jSpinner14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner14.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel169, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel171, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel170))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceLabel14)
                        .addGap(92, 92, 92))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(imageLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel169)
                    .addComponent(priceLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel170)
                    .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel171, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox14, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel33.setBackground(new java.awt.Color(252, 244, 222));
        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        nameLabel15.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        nameLabel15.setForeground(new java.awt.Color(111, 80, 55));
        nameLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel15.setText("Name:");

        jLabel175.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(111, 80, 55));
        jLabel175.setText("Price:");

        jLabel176.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(111, 80, 55));
        jLabel176.setText("Quantity:");

        jLabel177.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(111, 80, 55));
        jLabel177.setText("Purchase:");

        priceLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        priceLabel15.setForeground(new java.awt.Color(111, 80, 55));
        priceLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel15.setText("$3");

        jSpinner15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinner15.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel175, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel177, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel176))
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel15)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(nameLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(imageLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(imageLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel175)
                    .addComponent(priceLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel176)
                    .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel177, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drinks", "Cake", "Food" }));
        categoryComboBox.setPreferredSize(new java.awt.Dimension(50, 30));
        categoryComboBox.setBackground(new Color(255, 248, 220));
        categoryComboBox.setForeground(new Color(64, 42, 23));
        categoryComboBox.setFont(new Font("SanSerif", Font.BOLD, 14));
        categoryComboBox.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45), 2));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemPanelLayout = new javax.swing.GroupLayout(itemPanel);
        itemPanel.setLayout(itemPanelLayout);
        itemPanelLayout.setHorizontalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(132, 132, 132)
                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        itemPanelLayout.setVerticalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 239, 200));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 55), 2));

        jBtnTotal.setBackground(new java.awt.Color(255, 202, 40));
        jBtnTotal.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jBtnTotal.setForeground(new java.awt.Color(111, 80, 45));
        jBtnTotal.setText("TOTAL");
        jBtnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTotalActionPerformed(evt);
            }
        });

        jButtonReceipt.setBackground(new java.awt.Color(255, 202, 40));
        jButtonReceipt.setFocusPainted(false);
        jButtonReceipt.setBorderPainted(false);
        jButtonReceipt.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButtonReceipt.setForeground(new java.awt.Color(111, 80, 45));
        jButtonReceipt.setText("RECEIPT");
        jButtonReceipt.setEnabled(false);
        jButtonReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReceiptActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 202, 40));
        jButton3.setFocusPainted(false);
        jButton3.setBorderPainted(false);
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(111, 80, 45));
        jButton3.setText("RESET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 202, 40));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(111, 80, 45));
        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 202, 40));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(111, 80, 45));
        jButton1.setText("PAYMENT");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jBtnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 239, 200));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 45), 2));
        jPanel6.setForeground(new java.awt.Color(111, 80, 45));

        jTextArea.setEditable(false);
        jTextArea.setBackground(new java.awt.Color(252, 242, 222));
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTextArea.setCaretColor(new java.awt.Color(252, 244, 222));
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea);

        jTaxField.setBackground(new java.awt.Color(255, 255, 220));
        jTaxField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTaxField.setForeground(new java.awt.Color(111, 80, 45));
        jTaxField.setText("0.0");
        jTaxField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 45)));
        jTaxField.setCaretColor(new java.awt.Color(255, 255, 220));
        jTaxField.setEditable(false);
        jTaxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTaxFieldActionPerformed(evt);
            }
        });

        jSubtotalField.setBackground(new java.awt.Color(255, 255, 220));
        jSubtotalField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSubtotalField.setForeground(new java.awt.Color(111, 80, 45));
        jSubtotalField.setText("0.0");
        jSubtotalField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 45)));
        jSubtotalField.setCaretColor(new java.awt.Color(255, 255, 220));
        jSubtotalField.setEditable(false);
        jSubtotalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubtotalFieldActionPerformed(evt);
            }
        });

        jTotalField.setBackground(new java.awt.Color(255, 255, 220));
        jTotalField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTotalField.setForeground(new java.awt.Color(111, 80, 45));
        jTotalField.setText("0.0");
        jTotalField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 80, 45)));
        jTotalField.setCaretColor(new java.awt.Color(255, 255, 220));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(111, 80, 45));
        jLabel2.setText("TAX:");

        jLabel12.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(111, 80, 45));
        jLabel12.setText("Sub Total:");

        jLabel13.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(111, 80, 45));
        jLabel13.setText("Total:");

        jCashField.setVisible(false);
        jCashField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCashField.setForeground(new java.awt.Color(111, 80, 45));
        jCashField.setText("0.0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addComponent(jSubtotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSubtotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(37, 37, 37)
                .addComponent(jCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(itemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        btnMinimize.setOpaque(true);
        btnMinimize.setBackground(Color.lightGray); // or new Color(255, 102, 102)
        btnMinimize.setContentAreaFilled(true);
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        btnMinimize.setOpaque(false);
        btnMinimize.setContentAreaFilled(false);
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
       btnExit.setOpaque(true);
    btnExit.setBackground(Color.RED); // hover = red
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setOpaque(false);
    btnExit.setBackground(null); // back to no background
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jTaxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTaxFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTaxFieldActionPerformed

    private void jSubtotalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubtotalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSubtotalFieldActionPerformed

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
             String selectedCategory = (String) categoryComboBox.getSelectedItem();
               Calculator calculator;
    // Always reset checkboxes/spinners before loading new category items
    resetSelections();

    switch (selectedCategory) {
        case "Drinks":
            updateItemsPanel(coffeeItems);
            setupComboBoxRenderer();
            break;
        case "Cake":
            updateItemsPanel(cakeItems);
            setupComboBoxRenderer();
            break;
        case "Food":
            updateItemsPanel(mealItems);
            setupComboBoxRenderer();
            break;
    }
   
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
       setControlsEnabled(true);
       jBtnTotal.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    handleCheckboxAction(jCheckBox1, jSpinner1, nameLabel1, coffeeItems.get(0));
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
     handleCheckboxAction(jCheckBox2, jSpinner2, nameLabel2, coffeeItems.get(1));
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
    handleCheckboxAction(jCheckBox3, jSpinner3, nameLabel3, coffeeItems.get(2));
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
              handleCheckboxAction(jCheckBox4, jSpinner4, nameLabel4, coffeeItems.get(3));

    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
  handleCheckboxAction(jCheckBox5, jSpinner5, nameLabel5, coffeeItems.get(4));
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
   handleCheckboxAction(jCheckBox6, jSpinner6, nameLabel6, coffeeItems.get(5));
       
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
       handleCheckboxAction(jCheckBox7, jSpinner7, nameLabel7, coffeeItems.get(6));
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
     handleCheckboxAction(jCheckBox8, jSpinner8, nameLabel8, coffeeItems.get(7));    
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
                handleCheckboxAction(jCheckBox9, jSpinner9, nameLabel9, coffeeItems.get(8));
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
           handleCheckboxAction(jCheckBox10, jSpinner10, nameLabel10, coffeeItems.get(9));
    }//GEN-LAST:event_jCheckBox10ActionPerformed
        
    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
            handleCheckboxAction(jCheckBox11, jSpinner11, nameLabel11, coffeeItems.get(10));
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
    handleCheckboxAction(jCheckBox12, jSpinner12, nameLabel12, coffeeItems.get(11));
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        handleCheckboxAction(jCheckBox13, jSpinner13, nameLabel3, coffeeItems.get(12));
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
       handleCheckboxAction(jCheckBox14, jSpinner14, nameLabel14, coffeeItems.get(13));
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
    handleCheckboxAction(jCheckBox15, jSpinner15, nameLabel15, coffeeItems.get(14));
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jBtnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTotalActionPerformed
        updateTotalsUI(); // from transactionProcessor
        
    if (jTextArea.getText().isEmpty() || !jTextArea.getText().contains("JavaBee")) {
        javaBee(); // print header
    }
    jTextArea.append("\n*************************************\nSubtotal: " + String.format("%.2f", transactionProcessor.getTotal()) + "\n"
               + "Tax: " + String.format("%.2f", transactionProcessor.getTax()) + "\n"
               + "Total: " + String.format("%.2f", transactionProcessor.getTotalWithTax()) + "\n\"*************************************");

        
        
    jBtnTotal.setEnabled(false);
    jButton1.setEnabled(true);
    }//GEN-LAST:event_jBtnTotalActionPerformed
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDialog dialog = new JDialog();
        PaymentPanel paymentPanel = new PaymentPanel(cashierName, this.transactionProcessor, jTextArea, dialog, jButtonReceipt, this);
paymentPanel.setVisible(true);

    
    
    dialog.setTitle("Payment");
    dialog.setModal(true);
    dialog.getContentPane().add(paymentPanel);
    dialog.pack();
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceiptActionPerformed
      new ReceiptPreview(this, jTextArea.getText(), 
    () -> printReceipt(), 
    () -> saveReceiptToFile()
).setVisible(true);
    }//GEN-LAST:event_jButtonReceiptActionPerformed

    private void btnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMousePressed
          btnExit.setOpaque(true);
    btnExit.setBackground(Color.RED); // keep red when pressed
    }//GEN-LAST:event_btnExitMousePressed

    private void btnExitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseReleased
            // TODO add your handling code here:
    }//GEN-LAST:event_btnExitMouseReleased
        
    public void setOrderControlsEnabled(boolean enabled) {
    for (JCheckBox checkbox : checkBoxes) {
        checkbox.setEnabled(enabled);
    }

    for (JSpinner spinner : spinners) {
        spinner.setEnabled(enabled);
    }
    jButton1.setEnabled(enabled);
}
    

       public void setTime() {
    new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }

                Date date = new Date();
                SimpleDateFormat tf = new SimpleDateFormat("h:mm:ssaa");
                SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                String time = tf.format(date);
                String[] timeParts = time.split(" ");

                SwingUtilities.invokeLater(() -> {
                    if (timeParts.length >= 2) {
                        jTxtTime.setText(timeParts[0] + " " + timeParts[1]);
                    } else {
                        jTxtTime.setText(time);
                    }
                    jTxtDate.setText(df.format(date));
                });
            }
        }
    }).start();
}

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(accounts, currentUser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JLabel imageLabel10;
    private javax.swing.JLabel imageLabel11;
    private javax.swing.JLabel imageLabel12;
    private javax.swing.JLabel imageLabel13;
    private javax.swing.JLabel imageLabel14;
    private javax.swing.JLabel imageLabel15;
    private javax.swing.JLabel imageLabel2;
    private javax.swing.JLabel imageLabel3;
    private javax.swing.JLabel imageLabel4;
    private javax.swing.JLabel imageLabel5;
    private javax.swing.JLabel imageLabel6;
    private javax.swing.JLabel imageLabel7;
    private javax.swing.JLabel imageLabel8;
    private javax.swing.JLabel imageLabel9;
    private javax.swing.JPanel itemPanel;
    private javax.swing.JButton jBtnTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonReceipt;
    private javax.swing.JTextField jCashField;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner13;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTextField jSubtotalField;
    private javax.swing.JTextField jTaxField;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTotalField;
    private javax.swing.JLabel jTxtDate;
    private javax.swing.JLabel jTxtTime;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel10;
    private javax.swing.JLabel nameLabel11;
    private javax.swing.JLabel nameLabel12;
    private javax.swing.JLabel nameLabel13;
    private javax.swing.JLabel nameLabel14;
    private javax.swing.JLabel nameLabel15;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel3;
    private javax.swing.JLabel nameLabel4;
    private javax.swing.JLabel nameLabel5;
    private javax.swing.JLabel nameLabel6;
    private javax.swing.JLabel nameLabel7;
    private javax.swing.JLabel nameLabel8;
    private javax.swing.JLabel nameLabel9;
    private javax.swing.JLabel namePrice;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel priceLabel10;
    private javax.swing.JLabel priceLabel11;
    private javax.swing.JLabel priceLabel12;
    private javax.swing.JLabel priceLabel13;
    private javax.swing.JLabel priceLabel14;
    private javax.swing.JLabel priceLabel15;
    private javax.swing.JLabel priceLabel2;
    private javax.swing.JLabel priceLabel3;
    private javax.swing.JLabel priceLabel4;
    private javax.swing.JLabel priceLabel5;
    private javax.swing.JLabel priceLabel6;
    private javax.swing.JLabel priceLabel7;
    private javax.swing.JLabel priceLabel8;
    private javax.swing.JLabel priceLabel9;
    // End of variables declaration//GEN-END:variables
}

