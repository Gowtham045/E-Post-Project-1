package customer;

import Admin.StyledButtonUi;
import Database.DatabaseOperations;
import Login.login;
import customer.DatasForCustomer.ConsignmentData;
import customer.DatasForCustomer.CustomerProfileData;
import main.*;
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

public class AuthenticationForParcel {

    //private
    private JDialog newdialog = new JDialog();
    private Color background_Color = new Color(34, 34, 45);
    private Color on_background_Color = new Color(254, 254, 254);
    private Color primary_Color = new Color(71, 63, 145);
    private JLabel auth_password;
    private JPasswordField auth_password_info;
    private JButton auth_btn_confirm;

    public AuthenticationForParcel() {
        newdialog.setSize(600, 450);
        newdialog.setLayout(null);

        JLabel e_payment_auth = new JLabel("Authentication");
        e_payment_auth.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_auth.setBounds(220, 30, 187, 20);
        e_payment_auth.setForeground(on_background_Color);
        newdialog.add(e_payment_auth);

        //Object Creation
        auth_password = new JLabel("Enter Your Password");
        auth_password_info = new JPasswordField();
        auth_btn_confirm = new JButton("Confirm");

        //setBounds
        auth_password.setBounds(135, 120, 200, 20);
        auth_password_info.setBounds(135, 160, 310, 30);
        auth_btn_confirm.setBounds(220, 250, 150, 40);

        //setForeground
        auth_password.setForeground(on_background_Color);
        auth_password_info.setForeground(background_Color);
        auth_btn_confirm.setForeground(on_background_Color);

        //Font
        auth_password.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        //Adding Component
        newdialog.add(auth_password);
        newdialog.add(auth_password_info);
        newdialog.add(auth_btn_confirm);

        auth_btn_confirm.setBackground(primary_Color);
        auth_btn_confirm.setBorder(null);
        auth_btn_confirm.setUI(new StyledButtonUi());

        //Action Listener For Confirm Button
        auth_btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (getAuthentication()) {
                    try {
                        WalletDataG.setBalence(Float.valueOf(CustomerProfileData.getBankBalance()));//
                        WalletDataG.setItemCode(DatabaseOperations.getStocks().get(1).getitemCode());
                        WalletDataG.setTransationType("Parcel");
                        WalletDataG.setAmount(Float.valueOf(DatabaseOperations.getStocks().get(1).getItemPrice()));//fees for Parcel 1kg

                    } catch (Exception l) {
                        System.out.println("Authentication Parcel" + l.toString());
                    }

                    Database.DatabaseOperations.updateConsignment();
                    Database.DatabaseOperations.updateWalletTransaction();
                    ConsignmentData.listForConsignment.clear();
                    ConsignmentData.setIsUpdate(true);
                    DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
                    JOptionPane.showMessageDialog(null, "Payment Successfull");
                    CustomerPanel.contentForCustomer.add(new ConsignmentPanel(), "update");
                    main.switchPage("customerPanel");
                    CustomerPanel.BParcel.setBounds(55 + 180 + 180 + 180, 110, 160, 30);
                    CustomerPanel.BConsignment.setBounds(55 + 120 + 60, 120, 160, 30);
                    CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer, "update");
                    newdialog.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password");

                }

            }

        });

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);

    }

    //Authentication
    private boolean getAuthentication() {
        JTextField userID = new JTextField();
        userID.setText(Login.login.user_ID);
        ArrayList list = DatabaseOperations.getLoginCredentials(userID, auth_password_info);

        try {
            int salt = Integer.parseInt(list.get(1).toString());

            String password = login.createHash(auth_password_info.getText(), salt);

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
