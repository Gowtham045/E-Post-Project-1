package customer;

import Admin.StyledButtonUi;
import Database.DatabaseOperations;
import main.*;
import java.awt.Color;
import customer.DatasForCustomer.*;
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
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class E_PostPanel extends JPanel implements ActionListener {

    // private
    private JButton BSend;
    private JLabel LTo, LFirstName, LLastName, LAddress, LState, LDistrict, LPincode, LPhoneNumber, LMessage;
    private JTextField TTo, TFirstname, TLastName, TPincode, TPhoneNumber, TSubject;
    private JTextArea TAddress, Message;
    private JComboBox CState, CDistrict;
    private JCheckBox SoftCopy, HardCopy;
    private boolean isSoftCopySelected, isHardCopySelected;
    private Font font = new Font("Segoe UI", Font.PLAIN, 22);
    private Font fontForText = new Font("Segoe UI", Font.PLAIN, 17);
    private Border border;
    private Color Cpanel = new Color(254, 254, 254);
    private Color Cback = new Color(34, 34, 44);
    private Color Cbutton = new Color(71, 63, 144);
    //Information For City and State in India
    private static Vector<String> infoState = new Vector();
    private static Vector<String> infoCity = new Vector();

    public E_PostPanel() {
        setLayout(null);
        //Label Object
        LTo = new JLabel("To");
        LTo.setBounds(40, 25, 25, 40);
        LTo.setFont(font);
        add(LTo);

        border = BorderFactory.createLineBorder(Color.BLACK, 1);

        //To TextField
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
        //Mouse Listener For TTO
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
        add(TTo);

        //Objects 
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
        TAddress.setLineWrap(true);
        TAddress.setBounds(40, 215, 565, 100);
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

        LMessage = new JLabel("Message");
        LMessage.setBounds(680, 25, 130, 40);
        LMessage.setFont(font);
        add(LMessage);

        TSubject = new JTextField();
        TSubject.setBounds(680, 70, 500, 28);
        TSubject.setFont(fontForText);
        TSubject.setBorder(border);
        add(TSubject);

        Message = new JTextArea();
        Message.setLineWrap(true);
        Message.setFont(fontForText);
        Message.setBorder(border);
        JScrollPane messageScrool = new JScrollPane(Message);
        messageScrool.setBounds(680, 110, 500, 442 - 32 - 50);
        add(messageScrool);

        SoftCopy = new JCheckBox("Soft Copy");
        SoftCopy.setBounds(300, 60, 123, 40);
        SoftCopy.setFont(font);
        SoftCopy.addChangeListener((c) -> {
            AbstractButton absB = (AbstractButton) c.getSource();
            ButtonModel bMod = absB.getModel();
            isSoftCopySelected = bMod.isSelected();
        });
        add(SoftCopy);

        HardCopy = new JCheckBox("HardCopy");
        HardCopy.setBounds(450, 60, 125, 40);
        HardCopy.setFont(font);
        HardCopy.addChangeListener((e) -> {
            AbstractButton absB = (AbstractButton) e.getSource();
            ButtonModel bMod = absB.getModel();
            isHardCopySelected = bMod.isSelected();
        });
        add(HardCopy);

        BSend = new JButton("Send");
        BSend.setBounds((1260 / 2) - 20, 520, 120, 30);
        BSend.setBackground(Cbutton);
        BSend.setForeground(Color.white);
        BSend.setFont(font);
        BSend.addActionListener(this);
        BSend.setUI(new StyledButtonUi());
        add(BSend);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(630, 100, 1260 / 2, 450);
        g2.draw(lin);
    }

    // State information
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

    //City Information
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

    //actionListener For Send Button
    @Override
    public void actionPerformed(ActionEvent e) {
        String temp = TTo.getText();
        if (isSoftCopySelected == true && DatabaseOperations.CheckIdPresentOrNot(temp)) {
            DatabaseOperations.getReciverProfileForCustomerPanel(temp);
            setData("1");
            setDataForEPost();
        } else if (DatabaseOperations.CheckIdPresentOrNot(temp)) {
            DatabaseOperations.getReciverProfileForCustomerPanel(temp);
            setData("1");
            setDataForEPost();
        } else if (isHardCopySelected == true && !DatabaseOperations.CheckIdPresentOrNot(temp)) {
            setData("2");
            setDataForEPost();
        } else if (isHardCopySelected == true) {
            DatabaseOperations.getReciverProfileForCustomerPanel(temp);
            setData("1");
            setDataForEPost();
        } else {
            JOptionPane.showMessageDialog(null, "Receiver ID is Mandatory for Soft Copy");
        }

    }

    //Automatic fetching Data From Database and set that Data in all components in the front end for Customer
    private void setData(String s) {
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
    private void setDataForEPost() {
        int validCount = 0;
        String regex4 = "^[0-9]+{10}";

        boolean check4 = phoneNumberValidation(TPhoneNumber.getText());
        if (!check4) {
            JOptionPane.showMessageDialog(null, "Enter valid PhoneNumber");
            validCount++;
        }
        else{
            EPostData.setPhoneNumber(new Long(TPhoneNumber.getText()));
        }
        EPostData.setTo(TTo.getText());
        EPostData.setFirstName(TFirstname.getText());
        EPostData.setLastName(TLastName.getText());
        EPostData.setPincode(TPincode.getText());
        
        EPostData.setSubject(TSubject.getText());
        EPostData.setAddress(TAddress.getText());
        EPostData.setMessage(Message.getText());
        EPostData.setState(CState.getSelectedItem().toString());
        EPostData.setDistrict(CDistrict.getSelectedItem().toString());
        EPostData.setHardCopy(isHardCopySelected);
        EPostData.setSoftCopy(isSoftCopySelected);
        WalletDataG.setItemWeight(1F);
        String regex1 = "^[A-Za-z]+";
        String value1 = EPostData.getFirstName();
        boolean check1 = Pattern.matches(regex1, value1);
        if (!check1) {
            JOptionPane.showMessageDialog(null, "Enter valid First name");
            validCount++;
        }
        String value2 = EPostData.getLastName();
        boolean check2 = Pattern.matches(regex1, value2);
        if (!check2) {
            JOptionPane.showMessageDialog(null, "Enter valid Last name");
            validCount++;
        }
        String regex3 = "^[0-9]+";
        String value3 = EPostData.getPincode();
        boolean check3 = Pattern.matches(regex3, value3);
        if (!check3) {
            JOptionPane.showMessageDialog(null, "Enter valid Pincode");
            validCount++;
        }
        if(TSubject.getText().isEmpty()){
            validCount++;
            JOptionPane.showMessageDialog(null, "Enter  Message Subject");
        }
        if(TAddress.getText().isEmpty()){
            validCount++;
            JOptionPane.showMessageDialog(null, "Enter Address");
        }
        if(Message.getText().isEmpty()){
            validCount++;
            JOptionPane.showMessageDialog(null, "Enter Message");
        }
        
        if (validCount == 0) {
            PaymentEPost.setDataForEPostPayment();
            main.switchPage("paymentEPost");
        }

    }
    static boolean phoneNumberValidation(String number) {
        String regex = "(0/91)?[7-9][0-9]{9}";
        return number.matches(regex);
    }

}
