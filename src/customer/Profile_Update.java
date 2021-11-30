package customer;


import Admin.StyledButtonUi;
import static Database.DatabaseOperations.profileUpdationOnSave;
import customer.DatasForCustomer.CustomerProfileData;
import customer.DatasForCustomer.ProfileUpdateData;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.main;

public class Profile_Update extends JPanel implements MouseListener {

    //private 
    private Icon ProfIcon, BackIcon;
    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private JLabel FirstNameLabel, LastNameLabel, DOBLabel, AgeLabel, ContactNumberLabel, AddressLabel, AccountNumberLabel, PinCodeLabel, StateLabel, DistrictLabel;
    private static JTextField FirstNameValue, LastNameValue, DOBValue, AgeValue, ContactNumberValue, AccountNumberValue, StateValue, PinCodeValue, DistrictValue;
    private JLabel Collon1,Collon2, Collon3, Collon4, Collon5, Collon6, Collon7,Collon8, Collon9, Collon10;
    private static JTextArea AddressValue;
    private JButton ProfIconLabel, BackIconLabel;
    private JButton SaveButton;
    private int X = 230, Y = 90;
    private int R = 34, G = 34, B = 45;
    private int labelFontSize = 20;

    //public
    public static JLabel UserNameTop;

    public Profile_Update() {

        //profile image
        ProfIcon = new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
        ProfIconLabel = new JButton(ProfIcon);
        ProfIconLabel.setBounds(X - 150, Y - 70, 120, 120);
        ProfIconLabel.setVisible(true);
        ProfIconLabel.setBackground(new Color(R, G, B));
        ProfIconLabel.setContentAreaFilled(false);
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
        UserNameTop = new JLabel(CustomerProfileData.getId());
        UserNameTop.setBounds(X, Y - 80, 1000, 150);
        UserNameTop.setFont(new Font("Bold", Font.BOLD, labelFontSize + 20));
        UserNameTop.setForeground(Color.WHITE);
        add(UserNameTop);
        
        
        //First Name Label 
        FirstNameLabel = new JLabel("FIRST NAME");
        FirstNameLabel.setBounds(X - 150, Y, 200, 150);
        FirstNameLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        FirstNameLabel.setForeground(Color.WHITE);
        Collon1 = new JLabel(":");
        Collon1.setBounds(X + 60 + 30, Y, 20, 150);
        Collon1.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon1.setForeground(Color.WHITE);

        //First Name Value TextField
        FirstNameValue = new JTextField();
        FirstNameValue.setBounds(X + 240 - 120, Y + 60, 300, 35);
        FirstNameValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        FirstNameValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        FirstNameValue.setBackground(Color.WHITE);
        FirstNameValue.setForeground(Color.GRAY);
        FirstNameValue.addMouseListener(this);

        add(FirstNameLabel);
        add(Collon1);
        add(FirstNameValue);

        //Last Name Label
        LastNameLabel = new JLabel("LAST NAME");
        LastNameLabel.setBounds(X + 240 + 220, Y, 200, 150);
        LastNameLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        LastNameLabel.setForeground(Color.WHITE);
        Collon2 = new JLabel(":");
        Collon2.setBounds(X + 450 + 150 + 40 + 30 + 10, Y, 20, 150);
        Collon2.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon2.setForeground(Color.WHITE);

        //Last Name Values TextField
        LastNameValue = new JTextField();
        LastNameValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60, 300, 35);
        LastNameValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        LastNameValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        LastNameValue.setBackground(Color.WHITE);
        LastNameValue.setForeground(Color.GRAY);
        LastNameValue.addMouseListener(this);

        add(LastNameLabel);
        add(Collon2);
        add(LastNameValue);

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
        DOBValue = new JTextField();
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
        AgeLabel = new JLabel("AGE");
        AgeLabel.setBounds(X + 240 + 220, Y + 70, 200, 150);
        AgeLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        AgeLabel.setForeground(Color.WHITE);
        Collon4 = new JLabel(":");
        Collon4.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70, 20, 150);
        Collon4.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon4.setForeground(Color.WHITE);

        //Age Value TextField
        AgeValue = new JTextField();
        AgeValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70, 300, 35);
        AgeValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        AgeValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        AgeValue.setBackground(Color.WHITE);
        AgeValue.setForeground(Color.GRAY);
        AgeValue.addMouseListener(this);

        add(AgeLabel);
        add(Collon4);
        add(AgeValue);

        //Contact Number Label
        ContactNumberLabel = new JLabel("CONTACT NUMBER");
        ContactNumberLabel.setBounds(X - 150, Y + 70 + 70, 200, 150);
        ContactNumberLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        ContactNumberLabel.setForeground(Color.WHITE);
        Collon5 = new JLabel(":");
        Collon5.setBounds(X + 60 + 30, Y + 70 + 70, 20, 150);
        Collon5.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon5.setForeground(Color.WHITE);

        //Contact Number Value TextField
        ContactNumberValue = new JTextField();
        ContactNumberValue.setBounds(X + 240 - 120, Y + 60 + 70 + 70, 300, 35);
        ContactNumberValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        ContactNumberValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        ContactNumberValue.setBackground(Color.WHITE);
        ContactNumberValue.setForeground(Color.GRAY);
        ContactNumberValue.addMouseListener(this);

        add(ContactNumberLabel);
        add(Collon5);
        add(ContactNumberValue);

        //Martial Status Label
        AccountNumberLabel = new JLabel("Account Number");
        AccountNumberLabel.setBounds(X + 240 + 220, Y + 70 + 70, 200, 150);
        AccountNumberLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        AccountNumberLabel.setForeground(Color.WHITE);
        Collon6 = new JLabel(":");
        Collon6.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70 + 70, 20, 150);
        Collon6.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon6.setForeground(Color.WHITE);

        //Martial Status Value TextField
        AccountNumberValue = new JTextField();
        AccountNumberValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70 + 70, 300, 35);
        AccountNumberValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        AccountNumberValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        AccountNumberValue.setBackground(Color.WHITE);
        AccountNumberValue.setForeground(Color.GRAY);
        AccountNumberValue.addMouseListener(this);

        add(AccountNumberLabel);
        add(Collon6);
        add(AccountNumberValue);

        //Salary Label
        StateLabel = new JLabel("State");
        StateLabel.setBounds(X - 150, Y + 70 + 70 + 70, 200, 150);
        StateLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        StateLabel.setForeground(Color.WHITE);
        Collon7 = new JLabel(":");
        Collon7.setBounds(X + 60 + 30, Y + 70 + 70 + 70, 20, 150);
        Collon7.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon7.setForeground(Color.WHITE);

        //Salary Value TextField
        StateValue = new JTextField();
        StateValue.setBounds(X + 240 - 120, Y + 60 + 70 + 70 + 70, 300, 35);
        StateValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        StateValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        StateValue.setBackground(Color.WHITE);
        StateValue.setForeground(Color.GRAY);
        StateValue.addMouseListener(this);

        add(StateLabel);
        add(Collon7);
        add(StateValue);

        //Designation Label
        DistrictLabel = new JLabel("District");
        DistrictLabel.setBounds(X + 240 + 220, Y + 70 + 70 + 70, 200, 150);
        DistrictLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        DistrictLabel.setForeground(Color.WHITE);
        Collon8 = new JLabel(":");
        Collon8.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70 + 70 + 70, 20, 150);
        Collon8.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon8.setForeground(Color.WHITE);

        //Designayion Value TextField
        DistrictValue = new JTextField();
        DistrictValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70 + 70 + 70, 300, 35);
        DistrictValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        DistrictValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        DistrictValue.setBackground(Color.WHITE);
        DistrictValue.setForeground(Color.GRAY);
        DistrictValue.addMouseListener(this);

        add(DistrictLabel);
        add(Collon8);
        add(DistrictValue);

        //Premanent Address Label
        PinCodeLabel = new JLabel("PinCode");
        PinCodeLabel.setBounds(X - 150, Y + 70 + 70 + 70 + 70, 230, 150);
        PinCodeLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        PinCodeLabel.setForeground(Color.WHITE);
        Collon9 = new JLabel(":");
        Collon9.setBounds(X + 60 + 30, Y + 70 + 70 + 70 + 70, 20, 150);
        Collon9.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        Collon9.setForeground(Color.WHITE);

        //Permanent Address Value TextField
        PinCodeValue = new JTextField();
        PinCodeValue.setBounds(X + 240 - 120, Y + 60 + 70 + 70 + 70 + 70, 300, 35);
        PinCodeValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        PinCodeValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        PinCodeValue.setBackground(Color.WHITE);
        PinCodeValue.setForeground(Color.GRAY);
        PinCodeValue.addMouseListener(this);

        add(PinCodeLabel);
        add(Collon9);
        add(PinCodeValue);

        //Temporary Address Label
        AddressLabel = new JLabel("ADDRESS");
        AddressLabel.setBounds(X + 240 + 220, Y + 70 + 70 + 70 + 70, 230, 150);
        AddressLabel.setFont(new Font("Segoe UI", Font.BOLD, labelFontSize));
        AddressLabel.setForeground(Color.WHITE);
        Collon10 = new JLabel(":");
        Collon10.setBounds(X + 450 + 150 + 40 + 30 + 10, Y + 70 + 70 + 70 + 70, 20, 150);
        Collon10.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon10.setForeground(Color.WHITE);

        //Temporary Address Value TextField
        AddressValue = new JTextArea();
        AddressValue.setBounds(X + 240 + 300 + 100 + 60 + 10, Y + 60 + 70 + 70 + 70 + 70, 300, 100);
        AddressValue.setFont(new Font("Segoe UI", Font.PLAIN, labelFontSize));
        AddressValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        AddressValue.setBackground(Color.WHITE);
        AddressValue.setForeground(Color.GRAY);
        AddressValue.setLineWrap(true);
        AddressValue.setWrapStyleWord(true);
        AddressValue.addMouseListener(this);

        add(AddressLabel);
        add(Collon10);
        add(AddressValue);

        //button
        SaveButton = new JButton("Save");
        SaveButton.setBounds(X + 400, Y + 550, 100, 30);
        SaveButton.setForeground(new Color(245, 245, 245));
        SaveButton.setBackground(new Color(71, 63, 145));
        SaveButton.setUI(new StyledButtonUi());
        SaveButton.addActionListener((c) -> {

            ProfileUpdateData.setFIRST_NAME(FirstNameValue.getText());
            ProfileUpdateData.setLAST_NAME(LastNameValue.getText());
            ProfileUpdateData.setDOB(DOBValue.getText());
            ProfileUpdateData.setAGE(AgeValue.getText());
            ProfileUpdateData.setCONTACT_NUMBER(ContactNumberValue.getText());
            //ProfileUpdateData.setGENDER( bg.getSelection().getActionCommand());
            ProfileUpdateData.setPIN_CODE(PinCodeValue.getText());
            ProfileUpdateData.setSTATE(StateValue.getText());
            ProfileUpdateData.setDISTRICT(DistrictValue.getText());
            ProfileUpdateData.setADDRESS(AddressValue.getText());
            ProfileUpdateData.setACCOUNT_NUMBER(AccountNumberValue.getText());
            if (phoneNumberValidation(ContactNumberValue.getText())) {
                profileUpdationOnSave();

            } else {
                JOptionPane.showMessageDialog(null, "Enter Valid Number");
            }
        });

        add(SaveButton);

        setBounds(0, 0, 1350, 890);
        setBackground(new Color(R, G, B));
        setLayout(null);
        setVisible(true);

    }

    //Validations
    static boolean phoneNumberValidation(String number) {
        String regex = "(0/91)?[7-9][0-9]{9}";
        return number.matches(regex);
    }

    static boolean pincodeValidate(String code) {
        String regex = "[0-9]";
        return code.matches(regex);
    }

    //Listener The Back Button to Switch
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == BackIconLabel) {
            main.switchPage("Profile");
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

    public static void setDataForProfileUpdate(){
         FirstNameValue.setText(CustomerProfileData.getFirstName());
            LastNameValue.setText(CustomerProfileData.getLastName());
            DOBValue.setText(CustomerProfileData.getDob().toString());
            AgeValue.setText(String.valueOf(CustomerProfileData.getAge()));
            ContactNumberValue.setText(CustomerProfileData.getContactNumber());
            PinCodeValue.setText(CustomerProfileData.getPinCode());
            StateValue.setText(CustomerProfileData.getState());
            DistrictValue.setText(CustomerProfileData.getDistrict());
            AddressValue.setText(CustomerProfileData.getAddress());
            AccountNumberValue.setText(CustomerProfileData.getAccountNumber());
           
        
    }
}
