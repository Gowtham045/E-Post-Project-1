package customer;

import Database.DatabaseOperations;
import Login.login;
import customer.DatasForCustomer.CustomerProfileData;
import customer.DatasForCustomer.WalletDataG;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import main.main;
import warehouse.Warehouse;

public class PaymentProducts implements KeyListener {

    //private
    private JDialog newdialog = new JDialog();
    private Color background_Color = new Color(34, 34, 45);
    private Color on_background_Color = new Color(254, 254, 254);
    private Color primary_Color = new Color(71, 63, 145);
    private JLabel pro_payment_product_name;
    private JLabel pro_payment_product_quantity;
    private JLabel pro_payment_amount;
    private JLabel pro_payment_password;
    private JLabel pro_payment_product_name_info;
    private JLabel pro_payment_amount_info;
    private JTextField pro_payment_product_quantity_info;
    private JPasswordField pro_payment_password_info;
    private JButton pro_payment_btn_confirm;
    private Warehouse stock;
    private int price;
    private int stockQuantity;
    private int quantity;

    public PaymentProducts(int i) {
        try {
            ArrayList<Warehouse> temp = DatabaseOperations.getStocks();

            stock = temp.get(i);
        } catch (Exception k) {
        }

        price = Integer.valueOf(stock.getItemPrice());
        WalletDataG.setBalence(5000F); // getBalanceFromDatabase
        stockQuantity = Integer.valueOf(stock.getItemQuantity());

        newdialog.setSize(600, 650);
        newdialog.setLayout(null);

        //Objects
        JLabel e_payment_auth = new JLabel("Payment");
        e_payment_auth.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_auth.setBounds(250, 30, 187, 30);
        e_payment_auth.setForeground(on_background_Color);
        newdialog.add(e_payment_auth);

        pro_payment_product_name = new JLabel("Product Name");
        pro_payment_product_quantity = new JLabel("Product Quantity");
        pro_payment_amount = new JLabel("Amount");
        pro_payment_password = new JLabel("Enter Your Password");

        pro_payment_product_name_info = new JLabel(":           " + stock.getItem());

        pro_payment_product_quantity_info = new JTextField();
        pro_payment_product_quantity_info.addKeyListener(this);

        pro_payment_amount_info = new JLabel(":           " + "");
        pro_payment_amount_info.setFont(new Font("Bold", Font.BOLD, 22));
        pro_payment_password_info = new JPasswordField();

        pro_payment_btn_confirm = new JButton("Confirm");

        //setBounds
        pro_payment_product_name.setBounds(130, 120, 200, 20);
        pro_payment_product_quantity.setBounds(130, 180, 200, 20);
        pro_payment_amount.setBounds(130, 290, 200, 20);
        pro_payment_password.setBounds(130, 350, 200, 20);

        pro_payment_product_name_info.setBounds(315, 115, 310, 30);
        pro_payment_product_quantity_info.setBounds(130, 220, 310, 30);
        pro_payment_amount_info.setBounds(315, 290, 310, 30);
        pro_payment_password_info.setBounds(130, 400, 310, 30);
        pro_payment_btn_confirm.setBounds(220, 500, 150, 40);

        //setForeground
        pro_payment_product_name.setForeground(on_background_Color);
        pro_payment_product_quantity.setForeground(on_background_Color);
        pro_payment_amount.setForeground(on_background_Color);
        pro_payment_password.setForeground(on_background_Color);

        pro_payment_product_name_info.setForeground(on_background_Color);
        pro_payment_product_quantity_info.setForeground(background_Color);
        pro_payment_amount_info.setForeground(on_background_Color);
        pro_payment_password_info.setForeground(background_Color);
        pro_payment_btn_confirm.setForeground(on_background_Color);

        pro_payment_product_name.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_product_quantity.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_amount.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_password.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_product_name_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_amount_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        newdialog.add(pro_payment_product_name);
        newdialog.add(pro_payment_product_quantity);
        newdialog.add(pro_payment_amount);
        newdialog.add(pro_payment_password);
        newdialog.add(pro_payment_product_name_info);
        newdialog.add(pro_payment_product_quantity_info);
        newdialog.add(pro_payment_amount_info);
        newdialog.add(pro_payment_password_info);
        newdialog.add(pro_payment_btn_confirm);

        //auth_password_info.setColumns(10);
        pro_payment_btn_confirm.setBackground(primary_Color);
        pro_payment_btn_confirm.setBorder(null);

        //Payment Confirm Button
        pro_payment_btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Float.parseFloat(pro_payment_amount_info.getText().trim().split(":")[1]) <= Float.parseFloat(CustomerProfileData.getBankBalance())) {
                    if (getAuthentication()) {
                        WalletDataG.setBalence(Float.valueOf(CustomerProfileData.getBankBalance()));//customer Balence
                        WalletDataG.setTransationType("Products");
                        WalletDataG.setItemWeight(Float.valueOf(quantity));
                        stock.setItemQuantity(String.valueOf(stockQuantity - quantity));
                        ArrayList<Warehouse> tempstock = new ArrayList();
                        tempstock.add(stock);
                        DatabaseOperations.updateStocks(tempstock);
                        DatabaseOperations.updateConsignment();
                        DatabaseOperations.updateWalletTransaction();
                        DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
                        JOptionPane.showMessageDialog(null, "Payment Succesfully");
                        newdialog.dispose();
                        CustomerPanel.contentForCustomer.add(new ConsignmentPanel(), "update");
                        main.switchPage("customerPanel");
                        CustomerPanel.BConsignment.setBounds(55 + 120 + 60, 120, 160, 30);
                        CustomerPanel.BProducts.setBounds(55 + 180 + 180 + 180 + 180, 120, 160, 30);
                        CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer, "update");

                    } else {
                        JOptionPane.showMessageDialog(null, "Password Incorrect.Try Again");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                }
            }

        });

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);

    }

    //Set Amount in Front end in Run Time
    @Override
    public void keyTyped(KeyEvent ke) {
        String temp = pro_payment_product_quantity_info.getText();
        if (!temp.isEmpty()) {
            try {
                quantity = Integer.valueOf(temp);
                WalletDataG.setItemPrice(Float.valueOf(quantity * price));
                pro_payment_amount_info.setText(":           " + WalletDataG.getItemPrice());

            } catch (Exception m) {
            }

        } else {
            pro_payment_amount_info.setText(":           " + "");
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        String temp = pro_payment_product_quantity_info.getText();
        if (!temp.isEmpty()) {
            try {
                quantity = Integer.valueOf(temp);
                WalletDataG.setItemPrice(Float.valueOf(quantity * price));
                pro_payment_amount_info.setText(":           " + WalletDataG.getItemPrice());

            } catch (Exception m) {
            }

        } else {
            pro_payment_amount_info.setText(":           " + "");
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        String temp = pro_payment_product_quantity_info.getText();
        if (!temp.isEmpty()) {
            try {
                quantity = Integer.valueOf(temp);
                WalletDataG.setItemPrice(Float.valueOf(quantity * price));
                pro_payment_amount_info.setText(":           " + WalletDataG.getItemPrice());

            } catch (Exception m) {
            }

        } else {
            pro_payment_amount_info.setText(":           " + "");
        }

    }

    //Authentication
    private boolean getAuthentication() {
        JTextField userID = new JTextField();
        userID.setText(Login.login.user_ID);
        ArrayList list = DatabaseOperations.getLoginCredentials(userID, pro_payment_password_info);

        try {
            int salt = Integer.parseInt(list.get(1).toString());

            String password = login.createHash(pro_payment_password_info.getText(), salt);

            if (password.equals(list.get(0).toString())) {
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Wrong E-mail/Password");
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Wrong E-mail/Password");
        }

        return false;
    }

}
