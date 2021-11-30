package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import main.main;

public class AdminCustomerProfile extends JPanel implements ActionListener, MouseListener {

    //private variables
    private Icon ProfIcon, BackIcon;
    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private JLabel CustomerIDLabel, FirstNameLabel, LastNameLabel, DOBLabel, AgeLabel, ContactNumberLabel, GenderLabel, AddressLabel, BankBalanceLabel, AccountNumberLabel;
    private JLabel Collon1, Collon2, Collon3, Collon4, Collon5, Collon6, Collon7, Collon8, Collon9, Collon10;
    private JButton ProfIconLabel, BackIconLabel;
    private int X = 230, Y = 90;
    private int R = 34, G = 34, B = 45;
    private int labelFontSize = 20;

    //public variables
    public static JLabel UserNameTop;
    public static JLabel CustomerIDValue, FirstNameValue, LastNameValue, DOBValue, AgeValue, ContactNumberValue, GenderValue, AddressValue, BankBalanceValue, AccountNumberValue;

    //Constructer
    public AdminCustomerProfile() {

        //ProfileIcon
        ProfIcon = new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
        ProfIconLabel = new JButton(ProfIcon);
        ProfIconLabel.setBounds(X - 150, Y - 70, 120, 120);
        ProfIconLabel.setVisible(true);
        ProfIconLabel.setBackground(new Color(R, G, B));
        ProfIconLabel.setBorder(emptyBorder);
        ProfIconLabel.setContentAreaFilled(false);
        add(ProfIconLabel);

        //back icon
        BackIcon = new ImageIcon(getClass().getResource("/Images/arrow_back_button.png"));
        BackIconLabel = new JButton(BackIcon);
        BackIconLabel.setBounds(10, 10, 30, 30);
        BackIconLabel.setBackground(new Color(R, G, B));
        BackIconLabel.setBorder(emptyBorder);
        BackIconLabel.setVisible(true);
        BackIconLabel.setContentAreaFilled(false);
        BackIconLabel.addMouseListener(this);
        add(BackIconLabel);

        //Usernametop
        UserNameTop = new JLabel("Hello world");
        UserNameTop.setBounds(X, Y - 80, 1000, 150);
        UserNameTop.setFont(new Font("Bold", Font.BOLD, labelFontSize + 20));
        UserNameTop.setForeground(Color.WHITE);
        add(UserNameTop);

        // costumer id label
        CustomerIDLabel = new JLabel("Costumer ID");
        CustomerIDLabel.setBounds(X, Y, 200, 150);
        CustomerIDLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        CustomerIDLabel.setForeground(Color.WHITE);
        Collon1 = new JLabel(":");
        Collon1.setBounds(X + 200, Y, 20, 150);
        Collon1.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon1.setForeground(Color.WHITE);

        //costumer id value label
        CustomerIDValue = new JLabel("Costumer ID");
        CustomerIDValue.setBounds(X + 240, Y, 800, 150);
        CustomerIDValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        CustomerIDValue.setForeground(Color.WHITE);

        add(CustomerIDLabel);
        add(Collon1);
        add(CustomerIDValue);

        //first name label
        FirstNameLabel = new JLabel("First Name");
        FirstNameLabel.setBounds(X, Y + 60, 200, 150);
        FirstNameLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        FirstNameLabel.setForeground(Color.WHITE);
        Collon2 = new JLabel(":");
        Collon2.setBounds(X + 200, Y + 60, 20, 150);
        Collon2.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon2.setForeground(Color.WHITE);

        //fisrt name Value label
        FirstNameValue = new JLabel("First Name");
        FirstNameValue.setBounds(X + 240, Y + 60, 800, 150);
        FirstNameValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        FirstNameValue.setForeground(Color.WHITE);

        add(FirstNameLabel);
        add(Collon2);
        add(FirstNameValue);

        //last name label
        LastNameLabel = new JLabel("Last Name");
        LastNameLabel.setBounds(X, Y + 120, 200, 150);
        LastNameLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        LastNameLabel.setForeground(Color.WHITE);
        Collon3 = new JLabel(":");
        Collon3.setBounds(X + 200, Y + 120, 20, 150);
        Collon3.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon3.setForeground(Color.WHITE);

        //last name value label
        LastNameValue = new JLabel("Last Name");
        LastNameValue.setBounds(X + 240, Y + 120, 800, 150);
        LastNameValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        LastNameValue.setForeground(Color.WHITE);

        add(LastNameLabel);
        add(Collon3);
        add(LastNameValue);

        //DOB label
        DOBLabel = new JLabel("DOB");
        DOBLabel.setBounds(X, Y + 180, 200, 150);
        DOBLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        DOBLabel.setForeground(Color.WHITE);
        Collon4 = new JLabel(":");
        Collon4.setBounds(X + 200, Y + 180, 20, 150);
        Collon4.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon4.setForeground(Color.WHITE);

        //DOB value label
        DOBValue = new JLabel("DOB");
        DOBValue.setBounds(X + 240, Y + 180, 800, 150);
        DOBValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        DOBValue.setForeground(Color.WHITE);

        add(DOBLabel);
        add(Collon4);
        add(DOBValue);

        //Age label
        AgeLabel = new JLabel("Age");
        AgeLabel.setBounds(X, Y + 240, 200, 150);
        AgeLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        AgeLabel.setForeground(Color.WHITE);
        Collon5 = new JLabel(":");
        Collon5.setBounds(X + 200, Y + 240, 20, 150);
        Collon5.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon5.setForeground(Color.WHITE);

        //Age value label
        AgeValue = new JLabel("Age");
        AgeValue.setBounds(X + 240, Y + 240, 800, 150);
        AgeValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        AgeValue.setForeground(Color.WHITE);

        add(AgeLabel);
        add(Collon5);
        add(AgeValue);

        //contact number label
        ContactNumberLabel = new JLabel("Contact Number");
        ContactNumberLabel.setBounds(X, Y + 300, 200, 150);
        ContactNumberLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        ContactNumberLabel.setForeground(Color.WHITE);
        Collon6 = new JLabel(":");
        Collon6.setBounds(X + 200, Y + 300, 20, 150);
        Collon6.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon6.setForeground(Color.WHITE);

        //contact number  value label
        ContactNumberValue = new JLabel("Contact Number");
        ContactNumberValue.setBounds(X + 240, Y + 300, 800, 150);
        ContactNumberValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        ContactNumberValue.setForeground(Color.WHITE);

        add(ContactNumberLabel);
        add(Collon6);
        add(ContactNumberValue);

        //gender label
        GenderLabel = new JLabel("Gender");
        GenderLabel.setBounds(X, Y + 360, 200, 150);
        GenderLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        GenderLabel.setForeground(Color.WHITE);
        Collon7 = new JLabel(":");
        Collon7.setBounds(X + 200, Y + 360, 20, 150);
        Collon7.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon7.setForeground(Color.WHITE);

        //Gender value label
        GenderValue = new JLabel("Gender");
        GenderValue.setBounds(X + 240, Y + 360, 800, 150);
        GenderValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        GenderValue.setForeground(Color.WHITE);

        add(GenderLabel);
        add(Collon7);
        add(GenderValue);

        //address label
        AddressLabel = new JLabel("Address");
        AddressLabel.setBounds(X, Y + 420, 200, 150);
        AddressLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        AddressLabel.setForeground(Color.WHITE);
        Collon8 = new JLabel(":");
        Collon8.setBounds(X + 200, Y + 420, 20, 150);
        Collon8.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon8.setForeground(Color.WHITE);

        //address value label
        AddressValue = new JLabel("Address");
        AddressValue.setBounds(X + 240, Y + 420, 800, 150);
        AddressValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        AddressValue.setForeground(Color.WHITE);

        add(AddressLabel);
        add(Collon8);
        add(AddressValue);

        //bank balance label
        BankBalanceLabel = new JLabel("Bank Balance");
        BankBalanceLabel.setBounds(X, Y + 510, 200, 150);
        BankBalanceLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        BankBalanceLabel.setForeground(Color.WHITE);
        Collon9 = new JLabel(":");
        Collon9.setBounds(X + 200, Y + 510, 20, 150);
        Collon9.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon9.setForeground(Color.WHITE);

        //bank balance value label
        BankBalanceValue = new JLabel("Bank Balance");
        BankBalanceValue.setBounds(X + 240, Y + 510, 800, 150);
        BankBalanceValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        BankBalanceValue.setForeground(Color.WHITE);

        add(BankBalanceValue);
        add(Collon9);
        add(BankBalanceLabel);

        //AccountNumber label
        AccountNumberLabel = new JLabel("Account Number");
        AccountNumberLabel.setBounds(X, Y + 570, 200, 150);
        AccountNumberLabel.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        AccountNumberLabel.setForeground(Color.WHITE);
        Collon10 = new JLabel(":");
        Collon10.setBounds(X + 200, Y + 570, 20, 150);
        Collon10.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        Collon10.setForeground(Color.WHITE);

        //AccountNumber value label
        AccountNumberValue = new JLabel("Account Number");
        AccountNumberValue.setBounds(X + 240, Y + 570, 800, 150);
        AccountNumberValue.setFont(new Font("Bold", Font.BOLD, labelFontSize));
        AccountNumberValue.setForeground(Color.WHITE);

        add(AccountNumberValue);
        add(Collon10);
        add(AccountNumberLabel);

        setBounds(0, 0, 1350, 890);
        setBackground(new Color(R, G, B));
        setLayout(null);
        setVisible(true);

    }

    //Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        main.switchPage("Profile update");
    }

    //Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == BackIconLabel) {
            main.switchPage("AdminPanel");
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

}
