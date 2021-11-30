package customer;

import Admin.StyledButtonUi;
import Database.DatabaseOperations;
import customer.DatasForCustomer.ParcelData;
import customer.DatasForCustomer.RecieverProfileData;
import customer.DatasForCustomer.WalletDataG;
import main.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ParcelPanel extends JPanel implements ActionListener, KeyListener {

    //private
    private JButton BSend;
    private JLabel LPrice_Description, LItem_Price, LItem_Weight, LTo, LFirstName, LLastName, LAddress, LState, LDistrict, LPincode, LPhoneNumber;
    private JTextField TItem_Price, TItem_Weight, TTo, TFirstname, TLastName, TPincode, TPhoneNumber;
    private JTextArea TAddress;
    private JComboBox CState, CDistrict;
    private Font font = new Font("Segoe UI", Font.PLAIN, 22);
    private Font fontForText = new Font("Bold", Font.PLAIN, 17);
    private Border border;
    private JRadioButton Less_Than_1Kg, More_than_1kg, More_than_10kg, More_than_11kg;
    private ButtonGroup btngrb;
    private Color Cbutton = new Color(71, 63, 144);
    private static Vector<String> infoState = new Vector();
    private static Vector<String> infoCity = new Vector();

    public ParcelPanel() {
        setLayout(null);
        //Label
        LTo = new JLabel("To");
        LTo.setBounds(40, 25, 25, 40);
        LTo.setFont(font);
        add(LTo);

        //border
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        //TO TextField
        TTo = new JTextField();
        TTo.setBounds(40, 70, 200, 28);
        TTo.setBorder(border);
        TTo.setFont(fontForText);
        //Key Listener For TTo to Automatic Fetching
        TTo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String temp = TTo.getText();
                if (DatabaseOperations.CheckIdPresentOrNot(temp)) {
                    DatabaseOperations.getReciverProfileForCustomerPanel(temp);
                    setData("1");
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String temp = TTo.getText();
                if (DatabaseOperations.CheckIdPresentOrNot(temp)) {
                    DatabaseOperations.getReciverProfileForCustomerPanel(temp);
                    setData("1");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String temp = TTo.getText();
                if (DatabaseOperations.CheckIdPresentOrNot(temp)) {
                    DatabaseOperations.getReciverProfileForCustomerPanel(temp);
                    setData("1");
                }

            }
        });
        //Mouse Listener For to set null for refereshing
        TTo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String temp = TTo.getText();
                if (DatabaseOperations.CheckIdPresentOrNot(temp)) {
                    DatabaseOperations.getReciverProfileForCustomerPanel(temp);
                    setData("1");
                } else {
                    TTo.setText("");
                    TFirstname.setText("");
                    TLastName.setText("");
                    TPincode.setText("");
                    TPhoneNumber.setText("");
                    TAddress.setText("");
                    CState.setSelectedItem("");
                    CDistrict.setSelectedItem("");
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
        });
        //Objects 
        add(TTo);

        LFirstName = new JLabel("FirstName");
        LFirstName.setFont(font);
        LFirstName.setBounds(40, 100, 100, 40);
        add(LFirstName);

        TFirstname = new JTextField();
        TFirstname.setBounds(40, 145, 200, 28);
        TFirstname.setBorder(border);
        TFirstname.setFont(fontForText);
        add(TFirstname);

        LLastName = new JLabel("LastName");
        LLastName.setFont(font);
        LLastName.setBounds(350, 100, 100, 40);
        add(LLastName);

        TLastName = new JTextField();
        TLastName.setBounds(350, 145, 200, 28);
        TLastName.setBorder(border);
        TLastName.setFont(fontForText);
        add(TLastName);

        LAddress = new JLabel("Address");
        LAddress.setFont(font);
        LAddress.setBounds(40, 175, 100, 40);
        add(LAddress);

        TAddress = new JTextArea();
        TAddress.setBounds(40, 215, 565, 100);
        TAddress.setLineWrap(true);
        TAddress.setBorder(border);
        TAddress.setFont(fontForText);
        add(TAddress);

        LState = new JLabel("State");
        LState.setBounds(40, 318, 60, 40);
        LState.setFont(font);
        add(LState);

        CState = new JComboBox(this.getState());
        CState.setBounds(40, 360, 200, 28);
        CState.setFont(font);
        add(CState);

        LDistrict = new JLabel("District");
        LDistrict.setFont(font);
        LDistrict.setBounds(350, 318, 80, 40);
        add(LDistrict);

        CDistrict = new JComboBox(this.getCity());
        CDistrict.setBounds(350, 318 + 42, 200, 28);
        CDistrict.setFont(font);
        add(CDistrict);

        LPincode = new JLabel("Pincode");
        LPincode.setBounds(40, 400, 80, 40);
        LPincode.setFont(font);
        add(LPincode);

        TPincode = new JTextField();
        TPincode.setBounds(40, 440, 200, 28);
        TPincode.setBorder(border);
        TPincode.setFont(fontForText);
        add(TPincode);

        LPhoneNumber = new JLabel("Phone Number");
        LPhoneNumber.setBounds(350, 400, 200, 40);
        LPhoneNumber.setFont(font);
        add(LPhoneNumber);

        TPhoneNumber = new JTextField();
        TPhoneNumber.setBounds(350, 400 + 42, 200, 28);
        TPhoneNumber.setFont(fontForText);
        TPhoneNumber.setBorder(border);
        add(TPhoneNumber);

        LItem_Weight = new JLabel("Item Weight");
        LItem_Weight.setBounds(680, 25, 130, 40);
        LItem_Weight.setFont(font);
        add(LItem_Weight);

        TItem_Weight = new JTextField();
        TItem_Weight.setBounds(680, 65, 200, 28);
        TItem_Weight.setFont(fontForText);
        TItem_Weight.addKeyListener(this);
        add(TItem_Weight);

        LItem_Price = new JLabel("Item Price");
        LItem_Price.setBounds(680 + 270, 25, 130, 40);
        LItem_Price.setFont(font);
        add(LItem_Price);
        WalletDataG.setAmount(5F);//fees for E-post

        TItem_Price = new JTextField();
        TItem_Price.setBounds(680 + 270, 65, 200, 28);
        TItem_Price.setFont(font);
        add(TItem_Price);

        LPrice_Description = new JLabel("Price Description");
        LPrice_Description.setFont(font);
        LPrice_Description.setBounds(680, 65 + 50, 170, 40);
        add(LPrice_Description);

        Less_Than_1Kg = new JRadioButton(" Less than 1kg 150Rs");
        Less_Than_1Kg.setBounds(680 + 50, 65 + 50 + 50, 300, 40);
        Less_Than_1Kg.setFont(font);
        add(Less_Than_1Kg);

        More_than_1kg = new JRadioButton(" More than 1-10Kg 300Rs");
        More_than_1kg.setBounds(680 + 50, 65 + 50 + 50 + 50, 300, 40);
        More_than_1kg.setFont(font);
        add(More_than_1kg);

        More_than_10kg = new JRadioButton(" More than 10-11Kg 350Rs");
        More_than_10kg.setBounds(680 + 50, 65 + 50 + 50 + 50 + 50, 300, 40);
        More_than_10kg.setFont(font);
        add(More_than_10kg);

        More_than_11kg = new JRadioButton(" More than 11-12Kg 350Rs");
        More_than_11kg.setBounds(680 + 50, 65 + 50 + 50 + 50 + 50 + 50, 300, 40);
        More_than_11kg.setFont(font);
        add(More_than_11kg);

        btngrb = new ButtonGroup();
        btngrb.add(Less_Than_1Kg);
        btngrb.add(More_than_1kg);
        btngrb.add(More_than_10kg);
        btngrb.add(More_than_11kg);

        BSend = new JButton("Send");
        BSend.setBounds((1260 / 2) - 20, 520, 120, 30);
        BSend.setBackground(Cbutton);
        BSend.setForeground(Color.white);
        BSend.setFont(font);
        BSend.addActionListener(this);
        BSend.setUI(new StyledButtonUi());
        add(BSend);

    }

    //Paint method to Draw Line
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(630, 100, 1260 / 2, 450);
        g2.draw(lin);
    }

    //City and State info
    public Vector getState() {

        infoState.add("Andhra Pradesh");
        infoState.add("Haryana");
        infoState.add("Manipur");
        infoState.add("Sikkim");
        infoState.add("Andhra Pradesh");
        infoState.add("Arunachal Pradesh");
        infoState.add("Himachal Pradesh");
        infoState.add("Meghalaya");
        infoState.add("Tamil Nadu");
        infoState.add("Assam");
        infoState.add("Jharkhand");
        infoState.add("Mizoram");
        infoState.add("Telangana");
        infoState.add("Bihar");
        infoState.add("Karnataka");
        infoState.add("Nagaland");
        infoState.add("Tripura");
        infoState.add("Chhattisgarh");
        infoState.add("Kerala");
        infoState.add("Odisha");
        infoState.add("Uttarakhand");
        infoState.add("Goa");
        infoState.add("Madhya Pradesh");
        infoState.add("Punjab");
        infoState.add("Uttar Pradesh");
        infoState.add("Gujarat");
        infoState.add("Maharashtra");
        infoState.add("Rajasthan");
        infoState.add("West Bengal");
        infoState.add("Haryana");
        infoState.add("Manipur");
        infoState.add("Sikkim");

        return infoState;
    }

    public Vector getCity() {
        infoCity.add("Chennai");
        infoCity.add("Coimbatore");
        infoCity.add("Madurai");
        infoCity.add("Tiruchirappalli");
        infoCity.add("Tiruppur");
        infoCity.add("Salem");
        infoCity.add("Erode");
        infoCity.add("Tirunelveli");
        infoCity.add("Vellore");
        infoCity.add("Thoothukkudi");
        infoCity.add("Dindigul");
        infoCity.add("Thanjavur");
        infoCity.add("Ranipet");
        infoCity.add("Sivakasi");
        infoCity.add("Karur");
        infoCity.add("Udhagamandalam");
        infoCity.add("Hosur");
        infoCity.add("Nagercoil");
        infoCity.add("Kanchipuram");
        infoCity.add("Kumarapalayam");
        infoCity.add("Karaikkudi");
        infoCity.add("Neyveli");
        infoCity.add("Cuddalore");
        infoCity.add("Kumbakonam");
        infoCity.add("Tiruvannamalai");
        infoCity.add("Pollachi");
        infoCity.add("Rajapalayam");
        infoCity.add("Gudiyatham");
        infoCity.add("Pudukkottai");
        infoCity.add("Vaniyambadi");
        infoCity.add("Ambur");
        infoCity.add("Nagapattinam");
        return infoCity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String temp = TTo.getText();
        if (DatabaseOperations.CheckIdPresentOrNot(temp)) {
            DatabaseOperations.getReciverProfileForCustomerPanel(temp);
            setData("1");
            setDataForParcel();
        } else {
            setData("2");
            setDataForParcel();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!TItem_Weight.getText().isEmpty()) {
            try {
                Float temp = Float.valueOf(TItem_Weight.getText());
                WalletDataG.setItemPrice(temp * WalletDataG.getAmount());
                TItem_Price.setText(String.valueOf(WalletDataG.getItemPrice()));
            } catch (Exception t) {

            }

        } else {
            TItem_Price.setText("");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //Automatic fetching Data From Database and set that Data in all components in the front end for Customer
    public void setData(String s) {
        if (s.equals("1")) {
            TTo.setText(RecieverProfileData.getId());
            TFirstname.setText(RecieverProfileData.getFirstName());
            TLastName.setText(RecieverProfileData.getLastName());
            TPincode.setText(RecieverProfileData.getPinCode());
            TPhoneNumber.setText(RecieverProfileData.getContactNumber());
            TAddress.setText(RecieverProfileData.getAddress());
            CState.setSelectedItem(RecieverProfileData.getState());
            CDistrict.setSelectedItem(RecieverProfileData.getDistrict());

        } else if (s.equals("2")) {
            TTo.setText("");
        }

    }

    //setting Data in EPost Class For Data Encapsulation
    private void setDataForParcel() {
        int validCount = 0;
        String regex4 = "^[0-9]+{10}";

        boolean check4 = phoneNumberValidation(TPhoneNumber.getText());
        if (!check4) {
            JOptionPane.showMessageDialog(null, "Enter valid PhoneNumber");
            validCount++;
        } else {
            ParcelData.setPhoneNumber(new Long(TPhoneNumber.getText()));
        }
        ParcelData.setTo(TTo.getText());
        ParcelData.setFirstName(TFirstname.getText());
        ParcelData.setLastName(TLastName.getText());
        ParcelData.setPincode(TPincode.getText());
        ParcelData.setAddress(TAddress.getText());
        ParcelData.setState(CState.getSelectedItem().toString());
        ParcelData.setDistrict(CDistrict.getSelectedItem().toString());

        ParcelData.setItemPrice(WalletDataG.getItemPrice());

        String regex1 = "^[A-Za-z]+";
        String value1 = ParcelData.getFirstName();
        boolean check1 = Pattern.matches(regex1, value1);
        if (!check1) {
            JOptionPane.showMessageDialog(null, "Enter valid First name");
            validCount++;
        }
        String value2 = ParcelData.getLastName();
        boolean check2 = Pattern.matches(regex1, value2);
        if (!check2) {
            JOptionPane.showMessageDialog(null, "Enter valid Last name");
            validCount++;
        }
        String regex3 = "^[0-9]+";
        String value3 = ParcelData.getPincode();
        boolean check3 = Pattern.matches(regex3, value3);
        if (!check3) {
            JOptionPane.showMessageDialog(null, "Enter valid Pincode");
            validCount++;
        }

        String regex5 = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
        String value5 = TItem_Weight.getText();
        boolean check5 = Pattern.matches(regex5, value5);
        if (!check5 || TItem_Weight.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter valid Weight");
            validCount++;
        } else {
            ParcelData.setItemWeight(Float.valueOf(TItem_Weight.getText()));
            WalletDataG.setItemWeight(Float.valueOf(TItem_Weight.getText()));
        }
        if (TAddress.getText().isEmpty()) {
            validCount++;
            JOptionPane.showMessageDialog(null, "Enter Address");
        }

        if (validCount == 0) {
            PaymentParcel.setDataForParcelPanel();
            main.switchPage("paymentParcel");
        }

    }

    static boolean phoneNumberValidation(String number) {
        String regex = "(0/91)?[7-9][0-9]{9}";
        return number.matches(regex);
    }

}
