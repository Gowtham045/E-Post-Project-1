package Login;

import main.main;
import Admin.StyledButtonUi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class register extends JPanel implements ActionListener, ItemListener {

    JPanel registerPanel;
    MaskFormatter mask;

    //Private Variables
    private JLabel registerLabel, firstNameLabel, lastNameLabel, usernameLabel, phoneNumberLabel, passwordLabel,
            confirmPasswordLabel, DOBLabel, ageLabel, stateLabel, districtLabel, addressLabel, pincodeLabel, registerMessageLabel, genderLabel;
    private JTextField firstNameText, lastNameText, usernameText, phoneNumberText, passwordText, confirmPasswordText, ageText, stateText, districtText, pincodeText;
    private JFormattedTextField DOBText;

    private JTextArea addressTextArea;
    private JButton registerButton, backButton, registerLoginButton;
    private ButtonGroup gender;
    private JRadioButton gMale, gFemale, gOther;

    String userGender = "";

    //Constructor
    public register() {
        Color fg = new Color(35, 34, 45);
        Color bg = new Color(254, 254, 254);
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        registerPanel = new JPanel(null);
        registerPanel.setPreferredSize(new Dimension(1350, 890));
        registerPanel.setBackground(new Color(34, 34, 45));

        //Register Label
        registerLabel = new JLabel("Register");
        registerLabel.setBounds(600, 10, 150, 50);
        registerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        registerLabel.setForeground(Color.WHITE);

        //FirstName Label
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(330, 60, 150, 40);
        firstNameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        firstNameLabel.setForeground(Color.WHITE);

        //FirstName TextField
        firstNameText = new JTextField(20);
        firstNameText.setBounds(330, 110, 300, 40);
        firstNameText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        firstNameText.setForeground(Color.BLACK);

        //LastName Label
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(750, 60, 150, 40);
        lastNameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        lastNameLabel.setForeground(Color.WHITE);

        //LastName TextField
        lastNameText = new JTextField(20);
        lastNameText.setBounds(750, 110, 300, 40);
        lastNameText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        lastNameText.setForeground(Color.BLACK);

        //Username Label
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(330, 160, 150, 40);
        usernameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        usernameLabel.setForeground(Color.WHITE);

        //Username TextField
        usernameText = new JTextField(20);
        usernameText.setBounds(330, 210, 300, 40);
        usernameText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        usernameText.setForeground(Color.BLACK);

        //Phone Number Label
        phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(750, 160, 150, 40);
        phoneNumberLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        phoneNumberLabel.setForeground(Color.WHITE);

        //Phone Number TextField
        phoneNumberText = new JTextField(20);
        phoneNumberText.setBounds(750, 210, 300, 40);
        phoneNumberText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        phoneNumberText.setForeground(Color.BLACK);

        //Password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(330, 260, 150, 40);
        passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        passwordLabel.setForeground(Color.WHITE);

        //Password TextField
        passwordText = new JPasswordField(20);
        passwordText.setBounds(330, 310, 300, 40);
        passwordText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        passwordText.setForeground(Color.BLACK);

        //Confirm Password Label
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(750, 260, 200, 40);
        confirmPasswordLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        confirmPasswordLabel.setForeground(Color.WHITE);

        //Confirm Password TextField
        confirmPasswordText = new JPasswordField(20);
        confirmPasswordText.setBounds(750, 310, 300, 40);
        confirmPasswordText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        confirmPasswordText.setForeground(Color.BLACK);

        //DOB Label
        DOBLabel = new JLabel("DOB (yyyy-mm-dd)");
        DOBLabel.setBounds(330, 360, 200, 40);
        DOBLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        DOBLabel.setForeground(Color.WHITE);

        //DOB Formatted Text Field
        try {
            mask = new MaskFormatter("##/##/####");
            DOBText = new JFormattedTextField(mask);
            DOBText.setToolTipText("dd-mm-yyyy");
            DOBText.setColumns(12);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DOBText.setBounds(330, 410, 300, 40);
        DOBText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        DOBText.setForeground(Color.BLACK);

        //Age Label
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(750, 360, 150, 40);
        ageLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        ageLabel.setForeground(Color.WHITE);

        //Age TextField
        ageText = new JTextField(20);
        ageText.setBounds(750, 410, 300, 40);
        ageText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        ageText.setForeground(Color.BLACK);

        //State Label
        stateLabel = new JLabel("State");
        stateLabel.setBounds(330, 460, 150, 40);
        stateLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        stateLabel.setForeground(Color.WHITE);

        //State TextField
        stateText = new JTextField(20);
        stateText.setBounds(330, 510, 300, 40);
        stateText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        stateText.setForeground(Color.BLACK);

        //District Label
        districtLabel = new JLabel("District");
        districtLabel.setBounds(750, 460, 150, 40);
        districtLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        districtLabel.setForeground(Color.WHITE);

        //District TextField
        districtText = new JTextField(20);
        districtText.setBounds(750, 510, 300, 40);
        districtText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        districtText.setForeground(Color.BLACK);

        //Address label
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(330, 560, 150, 40);
        addressLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        addressLabel.setForeground(Color.WHITE);

        //Address TextArea
        addressTextArea = new JTextArea(20, 20);
        addressTextArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        addressTextArea.setBounds(330, 610, 720, 70);

        //Pincode label
        pincodeLabel = new JLabel("Pincode");
        pincodeLabel.setBounds(330, 690, 150, 40);
        pincodeLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        pincodeLabel.setForeground(Color.WHITE);

        //Pincode textField
        pincodeText = new JTextField(20);
        pincodeText.setBounds(330, 730, 300, 40);
        pincodeText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        pincodeText.setForeground(Color.BLACK);

        //Gender label
        genderLabel = new JLabel("Gender");
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        genderLabel.setBounds(750, 690, 150, 40);

        //Button Group for gender
        gender = new ButtonGroup();

        //Radio Buttons for Gender
        gMale = new JRadioButton("Male");
        gMale.setBounds(750, 730, 100, 40);
        gMale.setBackground(fg);
        gMale.setForeground(bg);
        gMale.setFont(font);
        gFemale = new JRadioButton("Female");
        gFemale.setBounds(850, 730, 100, 40);
        gFemale.setBackground(fg);
        gFemale.setForeground(bg);
        gFemale.setFont(font);
        gOther = new JRadioButton("Other");
        gOther.setBounds(950, 730, 100, 40);
        gOther.setBackground(fg);
        gOther.setForeground(bg);
        gOther.setFont(font);
        gender.add(gMale);
        gender.add(gFemale);
        gender.add(gOther);

        gMale.addItemListener(this);
        gFemale.addItemListener(this);
        gOther.addItemListener(this);

        //Register JButton
        registerButton = new JButton("Register");
        registerButton.setBounds(615, 800, 130, 40);
        registerButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        registerButton.setBackground(new Color(71, 63, 145));
        registerButton.setForeground(Color.WHITE);
        registerButton.setBorder(null);
        registerButton.setUI(new StyledButtonUi());

        registerButton.addActionListener(this);

        //RegisterMessage Label
        registerMessageLabel = new JLabel("Already have an Account?");
        registerMessageLabel.setBounds(550, 840, 300, 40);
        registerMessageLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        registerMessageLabel.setForeground(Color.WHITE);

        //Register login Button
        registerLoginButton = new JButton("Login!");
        registerLoginButton.setBounds(720, 840, 100, 40);
        registerLoginButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        registerLoginButton.setBackground(new Color(34, 34, 45));
        registerLoginButton.setForeground(Color.WHITE);
        registerLoginButton.setBorder(null);
        registerLoginButton.setRequestFocusEnabled(false);
        registerLoginButton.setContentAreaFilled(false);
        registerLoginButton.addActionListener(this);

        //Image Icon For back Button
        ImageIcon backImage = new ImageIcon(getClass().getResource("/Images/arrow_back_button.png"));

        //Back Button
        backButton = new JButton(backImage);
        backButton.setBounds(20, 20, 50, 50);
        backButton.setBackground(new Color(34, 34, 45));
        backButton.setBorder(null);
        backButton.addActionListener(this);

        //Adding components to Register Panel
        registerPanel.add(registerLabel);
        registerPanel.add(firstNameLabel);
        registerPanel.add(firstNameText);
        registerPanel.add(lastNameLabel);
        registerPanel.add(lastNameText);
        registerPanel.add(usernameLabel);
        registerPanel.add(usernameText);
        registerPanel.add(phoneNumberLabel);
        registerPanel.add(phoneNumberText);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordText);
        registerPanel.add(confirmPasswordLabel);
        registerPanel.add(confirmPasswordText);
        registerPanel.add(DOBLabel);
        registerPanel.add(DOBText);
        registerPanel.add(ageLabel);
        registerPanel.add(ageText);
        registerPanel.add(stateLabel);
        registerPanel.add(stateText);
        registerPanel.add(districtLabel);
        registerPanel.add(districtText);
        registerPanel.add(addressLabel);
        registerPanel.add(addressTextArea);
        registerPanel.add(pincodeLabel);
        registerPanel.add(pincodeText);
        registerPanel.add(registerButton);
        registerPanel.add(registerMessageLabel);
        registerPanel.add(registerLoginButton);
        registerPanel.add(backButton);
        registerPanel.add(gMale);
        registerPanel.add(gFemale);
        registerPanel.add(gOther);
        registerPanel.add(genderLabel);

        this.add(registerPanel);
    }

    //Function that Validates and lets the user Register
    public void register() {
        long count = Database.DatabaseOperations.accountNumberIncrement();

        //Getting all the entered Values
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String userName = usernameText.getText();
        String phoneNumber = phoneNumberText.getText();
        String password = passwordText.getText();
        String confirmPassword = confirmPasswordText.getText();
        String DOB = DOBText.getText();
        String age = ageText.getText();
        String state = stateText.getText();
        String district = districtText.getText();
        String address = addressTextArea.getText();
        String pincode = pincodeText.getText();
        long accountNumber = 3350700000l + count + 1;

        ArrayList list = new ArrayList();

        //adding the entered Values to an ArrayList
        list.add(userName);
        list.add(firstName);
        list.add(lastName);
        list.add(DOB);
        list.add(age);
        list.add(phoneNumber);
        list.add(userGender);
        list.add(address);
        list.add(state);
        list.add(district);
        list.add(pincode);
        list.add(new Float(0));
        list.add(accountNumber);
        list.add(password);
        list.add(confirmPassword);

        try {
            Database.DatabaseOperations.checkCredentials(list);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Enter All the Details");
        }
    }

    //Listener For Radio Button
    @Override
    public void itemStateChanged(ItemEvent e) {
        ItemSelectable itemselected = e.getItemSelectable();

        if (itemselected == gMale) {
            userGender = "Male";
        } else if (itemselected == gFemale) {
            userGender = "Female";
        } else if (itemselected == gOther) {
            userGender = "Other";
        }
    }

    //ActionListener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            register();
        } else if (e.getSource() == registerLoginButton || e.getSource() == backButton) {
            main.switchPage("login");
        }

    }
}
