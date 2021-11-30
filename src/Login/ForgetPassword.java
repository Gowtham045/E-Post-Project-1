package Login;

import static Database.DatabaseOperations.loginUpdate;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ForgetPassword {

    //Variables
    public static JDialog newdialog = new JDialog();

    Color background_Color = new Color(34, 34, 45);
    Color on_background_Color = new Color(254, 254, 254);
    Color primary_Color = new Color(71, 63, 145);

    JLabel fPass_User;
    JLabel fPass_Password;
    JLabel fPass_RePassword;

    JTextField fPass_User_info;
    JTextField fPass_Password_info;
    JTextField fPass_Repassword_info;

    JButton fPass_btn_confirm;

    //Constructor
    public ForgetPassword() {
        newdialog.setSize(600, 600);
        newdialog.setLayout(null);

        JLabel fPass_La = new JLabel("Forget Password");
        fPass_La.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        fPass_La.setBounds(190, 30, 187, 30);
        fPass_La.setForeground(on_background_Color);
        newdialog.add(fPass_La);

        //JLabel for Username, Password, Re-Enter Password
        fPass_User = new JLabel("UserName");
        fPass_Password = new JLabel("Password");
        fPass_RePassword = new JLabel("Re-Enter Password");

        //JTextField for Username, Password, Re-Enter Password
        fPass_User_info = new JTextField();
        fPass_Password_info = new JPasswordField();
        fPass_Repassword_info = new JPasswordField();

        //JButton For Validation
        fPass_btn_confirm = new JButton("Confirm");

        //SetBounds for JLabel Username, Password, Re-Enter Password
        fPass_User.setBounds(135, 120, 200, 20);
        fPass_Password.setBounds(135, 210, 200, 20);
        fPass_RePassword.setBounds(135, 300, 200, 20);

        //SetBounds for JTextField Username, Password, Re-Enter Password
        fPass_User_info.setBounds(135, 160, 310, 30);
        fPass_Password_info.setBounds(135, 250, 310, 30);
        fPass_Repassword_info.setBounds(135, 340, 310, 30);

        //SetBounds For JButton
        fPass_btn_confirm.setBounds(220, 440, 150, 40);

        //Forground Color for JLabel Username, Password, Re-Enter Password
        fPass_User.setForeground(on_background_Color);
        fPass_Password.setForeground(on_background_Color);
        fPass_RePassword.setForeground(on_background_Color);

        //Forground Color for JTextField Username, Password, Re-Enter Password
        fPass_User_info.setForeground(background_Color);
        fPass_Password_info.setForeground(background_Color);
        fPass_Repassword_info.setForeground(background_Color);

        //Forground Color for JButton
        fPass_btn_confirm.setForeground(on_background_Color);
        fPass_btn_confirm.setUI(new Admin.StyledButtonUi());

        //Font for JLabel Username, Password, Re-Enter Password
        fPass_User.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        fPass_Password.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        fPass_RePassword.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        //Font for JTextField Username, Password, Re-Enter Password
        fPass_User_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        fPass_Password_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        fPass_Repassword_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        //Adding components to the Dialog Box
        newdialog.add(fPass_User);
        newdialog.add(fPass_Password);
        newdialog.add(fPass_RePassword);
        newdialog.add(fPass_User_info);
        newdialog.add(fPass_Password_info);
        newdialog.add(fPass_Repassword_info);
        newdialog.add(fPass_btn_confirm);

        fPass_btn_confirm.setBackground(primary_Color);
        fPass_btn_confirm.setBorder(null);

        fPass_btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgetPassword();
            }

        });

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);
    }

    //Function that Validates and lets the user Change their Password
    public void forgetPassword() {
        int min = 200;
        int max = 400;
        int salt = (int) (Math.random() * (max - min + 1) + min);

        String userName = fPass_User_info.getText();
        String password = fPass_Password_info.getText();
        String confirmPassword = fPass_Repassword_info.getText();

        String hash_pass = Login.login.createHash(password, salt);
        String hash_confirm_pass = Login.login.createHash(confirmPassword, salt);

        if (hash_pass.isEmpty() || hash_confirm_pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter the New Password");
        }

        if (hash_pass.equals(hash_confirm_pass) || hash_pass != null || hash_confirm_pass != null) {
            loginUpdate(userName, hash_pass, hash_confirm_pass, salt);

        } else {
            JOptionPane.showMessageDialog(null, "Please make sure that Password and Confirm Password are same");
        }
    }
}
