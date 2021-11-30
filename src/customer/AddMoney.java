package customer;

import Admin.StyledButtonUi;
import Database.DatabaseOperations;
import Login.login;
import customer.DatasForCustomer.WalletDataG;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddMoney {

    //private variables
    private JDialog newdialog = new JDialog();
    private Color background_Color = new Color(34, 34, 45);
    private Color on_background_Color = new Color(254, 254, 254);
    private Color primary_Color = new Color(71, 63, 145);
    private JLabel addMoney_pbank_name, addMoney_username, addMoney_amount, addMoney_password;
    private JTextField addMoney_pbank_name_info, addMoney_username_info, addMoney_amount_info;
    private JButton addMoney_btn_confirm;
    private JPasswordField addMoney_password_info;

    public AddMoney() {
        newdialog.setBounds(375, 50, 600, 700);
        newdialog.setLayout(null);

        JLabel e_payment_auth = new JLabel("Add Money");
        e_payment_auth.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_auth.setBounds(220, 30, 187, 30);
        e_payment_auth.setForeground(on_background_Color);
        newdialog.add(e_payment_auth);

        //Label
        addMoney_pbank_name = new JLabel("Bank Name");
        addMoney_username = new JLabel("Username");
        addMoney_amount = new JLabel("Amount");
        addMoney_password = new JLabel("Password");
        //TextField
        addMoney_pbank_name_info = new JTextField();
        addMoney_username_info = new JTextField();
        addMoney_amount_info = new JTextField();
        addMoney_password_info = new JPasswordField();

        addMoney_btn_confirm = new JButton("Confirm");

        //setBounds
        addMoney_pbank_name.setBounds(135, 120, 200, 20);
        addMoney_username.setBounds(135, 210, 200, 20);
        addMoney_amount.setBounds(135, 300, 200, 20);
        addMoney_password.setBounds(135, 390, 200, 20);

        addMoney_pbank_name_info.setBounds(135, 160, 310, 30);
        addMoney_username_info.setBounds(135, 250, 310, 30);
        addMoney_amount_info.setBounds(135, 340, 310, 30);
        addMoney_password_info.setBounds(135, 440, 310, 30);

        addMoney_btn_confirm.setBounds(220, 540, 150, 40);

        //Forground
        addMoney_pbank_name.setForeground(on_background_Color);
        addMoney_username.setForeground(on_background_Color);
        addMoney_amount.setForeground(on_background_Color);
        addMoney_password.setForeground(on_background_Color);

        addMoney_pbank_name_info.setForeground(background_Color);
        addMoney_username_info.setForeground(background_Color);
        addMoney_amount_info.setForeground(background_Color);
        addMoney_password_info.setForeground(background_Color);

        addMoney_btn_confirm.setForeground(on_background_Color);
        addMoney_btn_confirm.setUI(new StyledButtonUi());

        //setFont
        addMoney_pbank_name.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        addMoney_username.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        addMoney_amount.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        addMoney_password.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        //AddComponent
        newdialog.add(addMoney_pbank_name);
        newdialog.add(addMoney_username);
        newdialog.add(addMoney_amount);
        newdialog.add(addMoney_password);
        newdialog.add(addMoney_pbank_name_info);
        newdialog.add(addMoney_username_info);
        newdialog.add(addMoney_amount_info);
        newdialog.add(addMoney_password_info);
        newdialog.add(addMoney_btn_confirm);

        addMoney_btn_confirm.setBackground(primary_Color);
        addMoney_btn_confirm.setBorder(null);

        //Action Listener For Button
        addMoney_btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getAuthentication()) {
                    try {
                        WalletDataG.setBalence(Float.valueOf(WalletPanel.WalletBalance.getText()));
                        WalletDataG.setItemPrice(-1 * Float.valueOf(addMoney_amount_info.getText()));
                    } catch (Exception r) {
                    }
                    DatabaseOperations.updateCustomerBalence();
                    WalletPanel.WalletBalance.setText(String.valueOf(WalletDataG.getBalence()));
                    addMoney_password_info.getText();
                    DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
                    JOptionPane.showMessageDialog(null, "Money has been transfered successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                }

                newdialog.dispose();
            }

        });

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);

    }

    //Authentication for Add Money
    private boolean getAuthentication() {
        JTextField userID = new JTextField();
        userID.setText(Login.login.user_ID);
        ArrayList list = DatabaseOperations.getLoginCredentials(userID, addMoney_password_info);

        try {
            int salt = Integer.parseInt(list.get(1).toString());

            String password = login.createHash(addMoney_password_info.getText(), salt);

            if (password.equals(list.get(0).toString())) {

                return true;

            } else {
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Wrong E-mail/Password");
        }

        return false;
    }

}
