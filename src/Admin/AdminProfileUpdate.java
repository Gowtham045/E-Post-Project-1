package Admin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.regex.Pattern;
import main.main;
import profile.AdminProfile;

public class AdminProfileUpdate extends JPanel implements MouseListener, ActionListener {

    //Private Variables
    private Icon ProfIcon, BackIcon;
    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private JLabel firstNameLabel, lastNameLabel, contactNoLabel, DOBLabel, ageLabel, pAddressLabel, tAddressLabel, martialLabel, designationLabel, salaryLabel, stateLabel, districtLabel;
    private JLabel Collon1, Collon2, Collon3, Collon4, Collon5, Collon6, Collon7, Collon8, Collon9, Collon10, Collon11, Collon12;
    private JButton ProfIconLabel, BackIconLabel;
    private JButton SaveButton;
    private String[] martialStatusValues = {"Single", "Married", "Divorced"};
    private int X = 230, Y = 90;
    private int R = 34, G = 34, B = 45;
    private int labelFontSize = 20;

    //Public Variables
    public static JLabel UserNameTop;
    public static JTextArea pAddressValue, tAddressValue;
    public static JComboBox martialValue;
    public static JTextField firstNameValue, lastNameValue, contactNoValue, DOBValue, ageValue, JoinDateValue, designationValue, salaryValue, stateValue, districtValue;

    public AdminProfileUpdate() {

        //profile image
        ProfIcon = new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
        ProfIconLabel = new JButton(ProfIcon);
        ProfIconLabel.setBounds(X - 130, Y - 75, 120, 120);
        ProfIconLabel.setVisible(true);
        ProfIconLabel.setBackground(new Color(R, G, B));
        ProfIconLabel.setBorder(emptyBorder);
        add(ProfIconLabel);

        //back icon
        BackIcon = new ImageIcon(getClass().getResource("/Images/arrow_back_button.png"));
        BackIconLabel = new JButton(BackIcon);
        BackIconLabel.setBounds(10, 10, 30, 30);
        BackIconLabel.setVisible(true);
        BackIconLabel.setBackground(new Color(R, G, B));
        BackIconLabel.setBorder(emptyBorder);
        BackIconLabel.setContentAreaFilled(false);
        BackIconLabel.addMouseListener(this);
        add(BackIconLabel);

        //Usernametop
        UserNameTop = new JLabel("Hello world");
        UserNameTop.setBounds(X, Y - 90, 1000, 150);
        UserNameTop.setFont(new Font("Bold", Font.BOLD, labelFontSize + 20));
        UserNameTop.setForeground(Color.WHITE);
        add(UserNameTop);

        //First Name Label 
        firstNameLabel = new JLabel("FIRST NAME");
        firstNameLabel.setBounds(X - 150, Y, 200, 150);
        firstNameLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        firstNameLabel.setForeground(Color.WHITE);
        Collon1 = new JLabel(":");
        Collon1.setBounds(X + 60 + 30, Y, 20, 150);
        Collon1.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon1.setForeground(Color.WHITE);

        //First Name Value TextField
        firstNameValue = new JTextField("First Name");
        firstNameValue.setBounds(X + 240 - 120, Y + 60, 300, 35);
        firstNameValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        firstNameValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        firstNameValue.setBackground(Color.WHITE);
        firstNameValue.setForeground(Color.GRAY);
        firstNameValue.addMouseListener(this);

        add(firstNameLabel);
        add(Collon1);
        add(firstNameValue);

        //Last Name Label
        lastNameLabel = new JLabel("LAST NAME");
        lastNameLabel.setBounds(X + 240 + 220, Y, 200, 150);
        lastNameLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        lastNameLabel.setForeground(Color.WHITE);
        Collon2 = new JLabel(":");
        Collon2.setBounds(X + 450 + 150 + 40 + 30 + 10, Y, 20, 150);
        Collon2.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon2.setForeground(Color.WHITE);

        //Last Name Values TextField
        lastNameValue = new JTextField("Last Name");
        lastNameValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60, 300, 35);
        lastNameValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        lastNameValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        lastNameValue.setBackground(Color.WHITE);
        lastNameValue.setForeground(Color.GRAY);
        lastNameValue.addMouseListener(this);

        add(lastNameLabel);
        add(Collon2);
        add(lastNameValue);

        //DOB Label
        DOBLabel = new JLabel("DOB");
        DOBLabel.setBounds(X - 150, Y + 70, 200, 150);
        DOBLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        DOBLabel.setForeground(Color.WHITE);
        Collon3 = new JLabel(":");
        Collon3.setBounds(X + 60 + 30, Y + 70, 20, 150);
        Collon3.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon3.setForeground(Color.WHITE);

        //DOB Value TextField
        DOBValue = new JTextField("DOB");
        DOBValue.setBounds(X + 240 - 120, Y + 60 + 70, 300, 35);
        DOBValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        DOBValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        DOBValue.setBackground(Color.WHITE);
        DOBValue.setForeground(Color.GRAY);
        DOBValue.addMouseListener(this);

        add(DOBLabel);
        add(Collon3);
        add(DOBValue);

        //Age Label
        ageLabel = new JLabel("AGE");
        ageLabel.setBounds(X + 240 + 220, Y + 70, 200, 150);
        ageLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        ageLabel.setForeground(Color.WHITE);
        Collon4 = new JLabel(":");
        Collon4.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70, 20, 150);
        Collon4.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon4.setForeground(Color.WHITE);

        //Age Value TextField
        ageValue = new JTextField("AGE");
        ageValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70, 300, 35);
        ageValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        ageValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        ageValue.setBackground(Color.WHITE);
        ageValue.setForeground(Color.GRAY);
        ageValue.addMouseListener(this);

        add(ageLabel);
        add(Collon4);
        add(ageValue);

        //Contact Number Label
        contactNoLabel = new JLabel("CONTACT NUMBER");
        contactNoLabel.setBounds(X - 150, Y + 70 + 70, 200, 150);
        contactNoLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        contactNoLabel.setForeground(Color.WHITE);
        Collon5 = new JLabel(":");
        Collon5.setBounds(X + 60 + 30, Y + 70 + 70, 20, 150);
        Collon5.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon5.setForeground(Color.WHITE);

        //Contact Number Value TextField
        contactNoValue = new JTextField("Contact Number");
        contactNoValue.setBounds(X + 240 - 120, Y + 60 + 70 + 70, 300, 35);
        contactNoValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        contactNoValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        contactNoValue.setBackground(Color.WHITE);
        contactNoValue.setForeground(Color.GRAY);
        contactNoValue.addMouseListener(this);

        add(contactNoLabel);
        add(Collon5);
        add(contactNoValue);

        //Martial Status Label
        martialLabel = new JLabel("MARTIAL STATUS");
        martialLabel.setBounds(X + 240 + 220, Y + 70 + 70, 200, 150);
        martialLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        martialLabel.setForeground(Color.WHITE);
        Collon6 = new JLabel(":");
        Collon6.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70 + 70, 20, 150);
        Collon6.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon6.setForeground(Color.WHITE);

        //Martial Status Value TextField
        martialValue = new JComboBox(martialStatusValues);
        martialValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70 + 70, 300, 35);
        martialValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));

        add(martialLabel);
        add(Collon6);
        add(martialValue);

        //Salary Label
        salaryLabel = new JLabel("SALARY");
        salaryLabel.setBounds(X - 150, Y + 70 + 70 + 70, 200, 150);
        salaryLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        salaryLabel.setForeground(Color.WHITE);
        Collon7 = new JLabel(":");
        Collon7.setBounds(X + 60 + 30, Y + 70 + 70 + 70, 20, 150);
        Collon7.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon7.setForeground(Color.WHITE);

        //Salary Value TextField
        salaryValue = new JTextField("Salary");
        salaryValue.setBounds(X + 240 - 120, Y + 60 + 70 + 70 + 70, 300, 35);
        salaryValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        salaryValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        salaryValue.setBackground(Color.WHITE);
        salaryValue.setForeground(Color.GRAY);
        salaryValue.addMouseListener(this);

        add(salaryLabel);
        add(Collon7);
        add(salaryValue);

        //Designation Label
        designationLabel = new JLabel("DESIGNATION");
        designationLabel.setBounds(X + 240 + 220, Y + 70 + 70 + 70, 200, 150);
        designationLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        designationLabel.setForeground(Color.WHITE);
        Collon8 = new JLabel(":");
        Collon8.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70 + 70 + 70, 20, 150);
        Collon8.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon8.setForeground(Color.WHITE);

        //Designayion Value TextField
        designationValue = new JTextField("Designation");
        designationValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70 + 70 + 70, 300, 35);
        designationValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        designationValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        designationValue.setBackground(Color.WHITE);
        designationValue.setForeground(Color.GRAY);
        designationValue.addMouseListener(this);

        add(designationLabel);
        add(Collon8);
        add(designationValue);

        //State Label
        stateLabel = new JLabel("STATE");
        stateLabel.setBounds(X - 150, Y + 70 + 70 + 70 + 70, 200, 150);
        stateLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        stateLabel.setForeground(Color.WHITE);
        Collon9 = new JLabel(":");
        Collon9.setBounds(X + 60 + 30, Y + 70 + 70 + 70 + 70, 20, 150);
        Collon9.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon9.setForeground(Color.WHITE);

        //State Value TextField
        stateValue = new JTextField("State");
        stateValue.setBounds(X + 240 - 120, Y + 60 + 70 + 70 + 70 + 70, 300, 35);
        stateValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        stateValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        stateValue.setBackground(Color.WHITE);
        stateValue.setForeground(Color.GRAY);
        stateValue.addMouseListener(this);

        add(stateLabel);
        add(Collon9);
        add(stateValue);

        //District Label
        districtLabel = new JLabel("DISTRICT");
        districtLabel.setBounds(X + 240 + 220, Y + 70 + 70 + 70 + 70, 200, 150);
        districtLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        districtLabel.setForeground(Color.WHITE);
        Collon10 = new JLabel(":");
        Collon10.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70 + 70 + 70 + 70, 20, 150);
        Collon10.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon10.setForeground(Color.WHITE);

        //District Value TextField
        districtValue = new JTextField("District");
        districtValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70 + 70 + 70 + 70, 300, 35);
        districtValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        districtValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        districtValue.setBackground(Color.WHITE);
        districtValue.setForeground(Color.GRAY);
        districtValue.addMouseListener(this);

        add(districtLabel);
        add(Collon10);
        add(districtValue);

        //Premanent Address Label
        pAddressLabel = new JLabel("PERMANENT ADDRESS");
        pAddressLabel.setBounds(X - 150, Y + 70 + 70 + 70 + 70 + 70, 230, 150);
        pAddressLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        pAddressLabel.setForeground(Color.WHITE);
        Collon11 = new JLabel(":");
        Collon11.setBounds(X + 60 + 30, Y + 70 + 70 + 70 + 70 + 70, 20, 150);
        Collon11.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon11.setForeground(Color.WHITE);

        //Permanent Address Value TextField
        pAddressValue = new JTextArea("Permanent Address");
        pAddressValue.setBounds(X + 240 - 120, Y + 60 + 70 + 70 + 70 + 70 + 70, 300, 100);
        pAddressValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        pAddressValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        pAddressValue.setBackground(Color.WHITE);
        pAddressValue.setForeground(Color.GRAY);
        pAddressValue.setLineWrap(true);
        pAddressValue.setWrapStyleWord(true);
        pAddressValue.addMouseListener(this);

        add(pAddressLabel);
        add(Collon11);
        add(pAddressValue);

        //Temporary Address Label
        tAddressLabel = new JLabel("TEMPRORY ADDRESS");
        tAddressLabel.setBounds(X + 240 + 220, Y + 70 + 70 + 70 + 70 + 70, 230, 150);
        tAddressLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        tAddressLabel.setForeground(Color.WHITE);
        Collon12 = new JLabel(":");
        Collon12.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70 + 70 + 70 + 70 + 70, 20, 150);
        Collon12.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon12.setForeground(Color.WHITE);

        //Temporary Address Value TextField
        tAddressValue = new JTextArea("Temprory Address");
        tAddressValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70 + 70 + 70 + 70 + 70, 300, 100);
        tAddressValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        tAddressValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        tAddressValue.setBackground(Color.WHITE);
        tAddressValue.setForeground(Color.GRAY);
        tAddressValue.setLineWrap(true);
        tAddressValue.setWrapStyleWord(true);
        tAddressValue.addMouseListener(this);

        add(tAddressLabel);
        add(Collon12);
        add(tAddressValue);

        //Save Button 
        SaveButton = new JButton("Save");
        SaveButton.setBounds(X + 400, Y + 600, 100, 30);
        SaveButton.setForeground(Color.WHITE);
        SaveButton.setBackground(new Color(71, 63, 145));
        SaveButton.addActionListener(this);
        SaveButton.setUI(new StyledButtonUi());
        add(SaveButton);

        setBounds(0, 0, 1350, 890);
        setBackground(new Color(R, G, B));
        setLayout(null);
        setVisible(true);

    }

    //Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == BackIconLabel) {
            AdminProfile.setAdminProfile(Login.login.user_ID);
            main.switchPage("AdminProfileView");
        } else if (e.getSource() == firstNameValue) {
            firstNameValue.setText("");
        } else if (e.getSource() == lastNameValue) {
            lastNameValue.setText("");
        } else if (e.getSource() == DOBValue) {
            DOBValue.setText("");
        } else if (e.getSource() == ageValue) {
            ageValue.setText("");
        } else if (e.getSource() == contactNoValue) {
            contactNoValue.setText("");
        } else if (e.getSource() == salaryValue) {
            salaryValue.setText("");
        } else if (e.getSource() == designationValue) {
            designationValue.setText("");
        } else if (e.getSource() == stateValue) {
            stateValue.setText("");
        } else if (e.getSource() == districtValue) {
            districtValue.setText("");
        } else if (e.getSource() == pAddressValue) {
            pAddressValue.setText("");
        } else if (e.getSource() == tAddressValue) {
            tAddressValue.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = firstNameValue.getText();
        String lastName = lastNameValue.getText();
        String DOB = DOBValue.getText();
        String age = ageValue.getText();
        String contactNumber = contactNoValue.getText();
        String designation = designationValue.getText();
        String state = stateValue.getText();
        String district = districtValue.getText();

        if (!Pattern.matches("^([A-Za-z])+$", firstName)) {
            JOptionPane.showMessageDialog(this, "First Name should contain only Characters");
        } else if (firstName.length() < 3) {
            JOptionPane.showMessageDialog(this, "First Name should contain atleast 4 Characters");
        } else if (lastName.length() < 1) {
            JOptionPane.showMessageDialog(this, "Enter last Name");
        } else if (!Pattern.matches("^([0-9]{4})-([0-9]{2})-([0-9]{2})$", DOB)) {
            JOptionPane.showMessageDialog(this, "Enter date in yyyy-mm-dd format");
        } else if (!Pattern.matches("^[0-9]+$", age)) {
            JOptionPane.showMessageDialog(this, "Enter valid age");
        } else if (!Pattern.matches("^[0-9]*$", contactNumber) || contactNumber.length() != 10) {
            JOptionPane.showMessageDialog(this, "Enter valid Phone Number");
        } else if (!Pattern.matches("^([A-Za-z ])+$", designation)) {
            JOptionPane.showMessageDialog(this, "Designation should contain only characters");
        } else if (!Pattern.matches("^([A-Za-z])+$", state)) {
            JOptionPane.showMessageDialog(this, "state should contain only characters");
        } else if (!Pattern.matches("^([A-Za-z])+$", district)) {
            JOptionPane.showMessageDialog(this, "district should contain only characters");
        } else {
            AdminProfile details = new AdminProfile();

            details.setFirstName(firstName);
            details.setLastName(lastName);
            details.setAge(Integer.parseInt(age));
            details.setContactNumber(contactNumber);
            details.setMartialStatus(martialValue.getSelectedItem().toString());
            details.setSalary(Integer.parseInt(salaryValue.getText()));
            details.setDesignation(designation);
            details.setState(state);
            details.setDistrict(district);
            details.setPermanentAddress(pAddressValue.getText());
            details.setTemporaryAddress(tAddressValue.getText());
            details.setDob(Date.valueOf(DOBValue.getText()));
            Database.DatabaseOperations.updateAdminProfile(details);
            AdminProfile.setAdminProfile(Login.login.user_ID);
            main.switchPage("AdminProfileView");
        }

    }

}
