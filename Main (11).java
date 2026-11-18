/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}PRODUCT SALES REPORT - 2026

******************************************
TOTAL PRODUCT SALES:153
AVERAGE PRODUCT SALES:17
MOST POPULAR PRODUCT: Cozy Nights Monarch(25)
}
import java.util.Scanner;

public class Product implements IProducts {
    // Single-dimensional array - product names
    private String[] productNames = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    // Two-dimensional array - sales[product][month]
    // 3 products x 3 months
    private int[][] sales = new int[3][3];
    private Scanner scanner = new Scanner(System.in);

    // Method 1: Obtaining products sold
    @Override
    public void captureSales() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) +
                        " for " + productNames[i] + " mattress: ");
                sales[i]…
                    // Two-dimensional array - sales[product][month]
    // 3 products x 3 months
    private int[][] sales = new int[3][3];
    private Scanner scanner = new Scanner(System.in);

    // Method 1: Obtaining products sold
    @Override
    public void captureSales() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) +
                        " for " + productNames[i] + " mattress: ");
                sales[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
    }

    // Method 2: Calculating total products sold
    @Override
    public int getTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    // Method 3: Calculating the average products sold
    @Override
    public double getAverageProductsSold() {
        int total = getTotalProductsSold();
        return (double) total / (3 * 3);
    }

    // Method 4: Determining the most popular product
    // Based on the highest single month sales - like in the sample
    @Override
    public String getMostPopularProduct() {
        int max = sales[0][0];
        int maxProductIndex = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sales[i][j] > max) {
                    max = sales[i][j];
                    maxProductIndex = i;
                }
            }
        }
        return productNames[maxProductIndex] + "(" + max + ")";
    }

    // Method 5: Displaying the report
    @Override
    public void displayReport() {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("**************");
        System.out.println("TOTAL PRODUCT SALES: " + getTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) getAverageProductsSold());
        System.out.println("MOST POPULAR PRODUCT: " + getMostPopularProduct());
    }
}
package test;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    // Test data from the sample screenshot
    // Monarch: 25,18,20 | Barbados: 15,10,12 | Phuket: 18,15,20
    int[][] testSales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };

    // Unit Test 1 - from your photo
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(testSales);
        int expected = 153;
        int actual = product.GetTotalProductsSold();

        assertEquals(expected, actual);
    }

    // Unit Test 2 - from your photo
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(testSales);
        double expected = 17.0;
        double actual = product.GetAverageProductSold();
        assertEquals(expected, actual, 0.01);
    }

    // Unit Test 3 - Most Popular (usually the 3rd test)
    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(testSales);
        String expected = "Cozy Nights Monarch(25)";
        String actual = product.GetMostPopularProduct();
        assertEquals(expected, actual);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    // To store sales - Q2 says "display and store"
    private ArrayList<String> salesList = new ArrayList<>();

    public ProductApp() {
        setTitle("Product App");
        setSize(550, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Menu Bar - File Edit (like in screenshot)
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // Customer Name Label + TextField
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(40, 40, 140, 30);
        add(lblCustomer);

        txtCustomerName = new JTextField("Joe Bloggs");
        txtCustomerName.setBounds(190, 40, 300, 30);
        add(txtCustomerName);

        // Select Product Label + ComboBox
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(40, 100, 140, 30);
        add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(190, 100, 300, 30);
        add(cmbProduct);

        // Enter Price Label + TextField
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(40, 160, 140, 30);
        add(lblPrice);

        txtPrice = new JTextField("3500");
        txtPrice.setBounds(190, 160, 300, 30);
        add(txtPrice);

        // PROCESS Button
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(190, 220, 300, 40);
        btnProcess.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnProcess);

        // Button Action
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });
    }

    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Calculations
            double vat = price * 0.15;          // 15%
            double commission = price * 0.05;   // 5%
            double total = price + vat + commission;

            // Store the sale
            String record = customerName + " | " + productName + " | Price: R" + price
                    + " | VAT: R" + vat + " | Commission: R" + commission + " | Total: R" + total;
            salesList.add(record);

            // Display - like a receipt
            String message = "Customer Name: " + customerName +
                    "\nProduct Name: " + productName +
                    "\nPrice: R" + price +
                    "\nVAT Amount (15%): R" + vat +
                    "\nCommission Amount (5%): R" + commission +
                    "\nTotal Sale Amount: R" + total;

            JOptionPane.showMessageDialog(this, message, "Sale Processed", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductApp().setVisible(true);
                Customer Name: Joe Bloggs
Product Name: Cozy Nights Monarch
Price: R3500.0
VAT Amount (15%): R525.0
Commission Amount (5%): R175.0
Total Sale Amount: R4200.0
            }
            
swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(550, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Menu Bar - File Edit
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        public ProductApp() {
        setTitle("Product App");
        setSize(550, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Menu Bar - File Edit
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // Q2.2 - Text box for Customer Name
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(40, 40, 140, 30);
        add(lblCustomer);

        txtCustomerName = new JTextField("Joe Bloggs");
        txtCustomerName.setBounds(190, 40, 300, 30);
        add(txtCustomerName);

        // Q2.2 - Combo box for Product Name
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(40, 100, 140, 30);
        add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(190, 100, 300, 30);
        add(cmbProduct);

        // Q2.2 - Text box for Product Price
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(40, 160, 140, 30);
        add(lblPrice);

        txtPrice = new JTextField("3500");
        txtPrice.setBounds(190, 160, 300, 30);
        add(txtPrice);

        // PROCESS Button
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(190, 220, 300, 40);
        btnProcess.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnProcess);

        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });
    }

    // Q2.3 - When Process is clicked
    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Calculations
            double vat = price * 0.15;          // VAT 15%
            double commission = price * 0.05;    // Commission 5%
            double total = price + vat + commission;

            // 1. Show Message Dialog - EXACT format from screenshot
            String message = "Customer Name: " + customerName +
                    "\nProduct: " + productName +
                    "\nVAT: R " + vat +
                    "\nCOMMISSION: R " + commission +
                    "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // 2. Save to data.txt - EXACT format from screenshot
            try {
                FileWriter fw = new FileWriter("data.txt", true); // true = append, don't overwrite
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("DATA LOG");
                bw.newLine();
                bw.write("************");
                bw.newLine();
                bw.write("Customer Name: " + customerName);
                bw.newLine();
                bw.write("Product: " + productName);
                bw.newLine();
                bw.newLine();
                bw.write("Product: " + productName);
                bw.newLine();
                bw.write("VAT: R " + vat);
                bw.newLine();
                bw.write("COMMISSION: R " + commission);
                bw.newLine();
                bw.write("TOTAL: R " + total);
                bw.newLine();
                bw.write("************");
                bw.newLine();
                bw.newLine();

                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductApp().setVisible(true);
            }
        }
        public class ProductCalculations implements IProductCalculations {

    private double price;

    // Constructor - we pass the price in
    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * 0.15; // VAT 15%
    }

    @Override
    public double GetCommission() {
        return price * 0.05; // Commission 5%
    }

    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(550, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Q2.4 - MENU SYSTEM
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools…
                // Q2.4 - MENU SYSTEM
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Menu Actions
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close application
            }
        });

        processItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale(); // Same logic as Process button
            }
        });

        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomerName.setText("");
                txtPrice.setText("");
                cmbProduct.setSelectedIndex(0); // Reset to first product
            }
        });

        // Q2.2 - Customer Name
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(40, 40, 140, 30);
        add(lblCustomer);

        txtCustomerName = new JTextField("Joe Bloggs");
        txtCustomerName.setBounds(190, 40, 300, 30);
        add(txtCustomerName);

        // Q2.2 - Product Combo
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(40, 100, 140, 30);
        add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(190, 100, 300, 30);
        add(cmbProduct);

        // Q2.2 - Price
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(40, 160, 140, 30);
        add(lblPrice);

        txtPrice = new JTextField("3500");
        txtPrice.setBounds(190, 160, 300, 30);
        add(txtPrice);

        // PROCESS Button
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(190, 220, 300, 40);
        btnProcess.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnProcess);

        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });
    }

    // Q2.3 - Process + Save to data.txt
    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Use ProductCalculations class - Q2.5
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Popup - exact format from scr…
            
                private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Use ProductCalculations class - Q2.5
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Popup - exact format from screenshot
            String message = "Customer Name: " + customerName +
                    "\nProduct: " + productName +
                    "\nVAT: R " + vat +
                    "\nCOMMISSION: R " + commission +
                    "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt
            try {
                FileWriter fw = new FileWriter("data.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("DATA LOG");
                bw.newLine();
                bw.write("************");
                bw.newLine();
                bw.write("Customer Name: " + customerName);
                bw.newLine();
                bw.write("Product: " + productName);
                bw.newLine();
                bw.write("VAT: R " + vat);
                bw.newLine();
                bw.write("COMMISSION: R " + commission);
                bw.newLine();
                bw.write("TOTAL: R " + total);
                bw.newLine();
                bw.write("************");
                bw.newLine();
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductApp().setVisible(true);
            }
        });
    }
}

 