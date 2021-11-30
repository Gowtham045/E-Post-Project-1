package customer;


import Admin.StyledButtonUi;
import customer.DatasForCustomer.CustomerProfileData;
import customer.DatasForCustomer.EPostData;
import customer.DatasForCustomer.WalletDataG;
import main.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public class PaymentEPost extends JPanel implements MouseListener {

    // private
    private Color background_Color = new Color(34, 34, 45);
    private Color on_background_Color = new Color(254, 254, 254);
    private Color primary_Color = new Color(71, 63, 145);
    private JPanel p_payment_Panel;
    private JLabel e_payment_title;
    private JButton e_payment_btn_confirm;
    private JLabel e_payment_btn_back;
    private JPopupMenu e_payment_authentication;
    //Left Label
    private JLabel e_payment_beneficiary;
    private JLabel e_payment_amount;
    private JLabel e_payment_to;
    private JLabel e_payment_contact;
    private JLabel e_payment_type;
    private JLabel e_payment_firstName;
    private JLabel e_payment_lastName;
    private JLabel e_payment_address;
    private JLabel e_payment_state;
    private JLabel e_payment_district;
    private JLabel e_payment_pincode;
    private JLabel e_payment_message;

    //Content Label
    private static JLabel e_payment_beneficiary_info;
    private static JLabel e_payment_amount_info;
    private static JLabel e_payment_to_info;
    private static JLabel e_payment_contact_info;
    private static JLabel e_payment_type_info;
    private static JLabel e_payment_firstName_info;
    private static JLabel e_payment_lastName_info;
    private static JTextArea e_payment_address_info;
    private static JLabel e_payment_state_info;
    private static JLabel e_payment_district_info;
    private static JLabel e_payment_pincode_info;
    private static JTextArea e_payment_message_info;

    int X_FORCUSTOMER = 0, Y_FORCUSTOMER = 100, WIDTHFORCUSTOMER = 1260, HIGHTFORCUSTOMER = 750;

    public PaymentEPost() {

        p_payment_Panel = new JPanel();

        e_payment_btn_confirm = new JButton();
        e_payment_btn_confirm.addActionListener((a) -> {
            if(Float.parseFloat(e_payment_amount_info.getText())<= Float.parseFloat(CustomerProfileData.getBankBalance())){
            new AuthenticationForE_Post();
            }else{
                JOptionPane.showMessageDialog(this, "Insufficient Balance :"+CustomerProfileData.getBankBalance() );
            }

        });
        e_payment_btn_back = new JLabel(new ImageIcon(getClass().getResource("/Images/arrow_back_button.png")));
        e_payment_btn_back.addMouseListener(this);

        //Label
        e_payment_title = new JLabel("Payment");
        e_payment_beneficiary = new JLabel("Beneficiary");
        e_payment_amount = new JLabel("Amount");
        e_payment_to = new JLabel("To");
        e_payment_contact = new JLabel("Contact No.");
        e_payment_type = new JLabel("Type");
        e_payment_firstName = new JLabel("First Name");
        e_payment_lastName = new JLabel("Last Name");
        e_payment_address = new JLabel("Address");
        e_payment_state = new JLabel("State");
        e_payment_district = new JLabel("District");
        e_payment_pincode = new JLabel("Pincode");
        e_payment_message = new JLabel("Subject");

        //Content Label
        e_payment_beneficiary_info = new JLabel();
        e_payment_amount_info = new JLabel();
        e_payment_to_info = new JLabel();
        e_payment_contact_info = new JLabel();
        e_payment_type_info = new JLabel();
        e_payment_firstName_info = new JLabel();
        e_payment_lastName_info = new JLabel();
        e_payment_address_info = new JTextArea();
        e_payment_state_info = new JLabel();
        e_payment_district_info = new JLabel();
        e_payment_pincode_info = new JLabel();
        e_payment_message_info = new JTextArea();

        e_payment_address_info.setBackground(background_Color);
        e_payment_address_info.setEditable(false);
        e_payment_address_info.setHighlighter(null);
        e_payment_address_info.setLineWrap(true);

        e_payment_message_info.setBackground(background_Color);
        e_payment_message_info.setEditable(false);
        e_payment_message_info.setHighlighter(null);
        e_payment_message_info.setLineWrap(true);

        //Button and title
        e_payment_title.setBounds(585, 25, 200, 50);
        e_payment_btn_confirm.setBounds(585, 755 + 10, 150, 40);
        e_payment_btn_confirm.setBackground(primary_Color);
        e_payment_btn_confirm.setText("Confirm");
        e_payment_btn_confirm.setForeground(on_background_Color);
        e_payment_btn_confirm.setBorder(null);
        e_payment_btn_confirm.setUI(new StyledButtonUi());

        e_payment_btn_back.setBounds(25, 25, 40, 40);
        e_payment_btn_back.setBackground(null);
        e_payment_btn_back.setBorder(null);

        //Label Bounds
        e_payment_beneficiary.setBounds(120, 80, 150, 50);
        e_payment_amount.setBounds(120, 50 + 80, 150, 50);
        e_payment_to.setBounds(120, 100 + 80, 150, 50);
        e_payment_contact.setBounds(120, 150 + 80, 150, 50);
        e_payment_type.setBounds(120, 200 + 80, 150, 50);
        e_payment_firstName.setBounds(120, 250 + 80, 150, 50);
        e_payment_lastName.setBounds(120, 300 + 80, 150, 50);
        e_payment_address.setBounds(120, 350 + 80, 150, 50);
        e_payment_state.setBounds(120, 450 + 80, 150, 50);
        e_payment_district.setBounds(120, 500 + 80, 150, 50);
        e_payment_pincode.setBounds(120, 550 + 80, 150, 50);
        e_payment_message.setBounds(120, 600 + 80, 150, 50);

        //Content Label Bounds
        e_payment_beneficiary_info.setBounds(400, 0 + 80, 300, 50);
        e_payment_amount_info.setBounds(400, 50 + 80, 300, 50);
        e_payment_to_info.setBounds(400, 100 + 80, 150, 50);
        e_payment_contact_info.setBounds(400, 150 + 80, 150, 50);
        e_payment_type_info.setBounds(400, 200 + 80, 300, 50);
        e_payment_firstName_info.setBounds(400, 250 + 80, 300, 50);
        e_payment_lastName_info.setBounds(400, 300 + 80, 300, 50);
        e_payment_address_info.setBounds(400, 360 + 80, 800, 90);
        e_payment_state_info.setBounds(400, 450 + 80, 300, 50);
        e_payment_district_info.setBounds(400, 500 + 80, 300, 50);
        e_payment_pincode_info.setBounds(400, 550 + 80, 150, 50);
        e_payment_message_info.setBounds(400, 610 + 80, 800, 90);

        //Label Text Color
        e_payment_title.setForeground(on_background_Color);
        e_payment_beneficiary.setForeground(on_background_Color);
        e_payment_amount.setForeground(on_background_Color);
        e_payment_to.setForeground(on_background_Color);
        e_payment_contact.setForeground(on_background_Color);
        e_payment_type.setForeground(on_background_Color);
        e_payment_firstName.setForeground(on_background_Color);
        e_payment_lastName.setForeground(on_background_Color);
        e_payment_address.setForeground(on_background_Color);
        e_payment_state.setForeground(on_background_Color);
        e_payment_district.setForeground(on_background_Color);
        e_payment_pincode.setForeground(on_background_Color);
        e_payment_message.setForeground(on_background_Color);

        //Content Label Text Color
        e_payment_beneficiary_info.setForeground(on_background_Color);
        e_payment_amount_info.setForeground(on_background_Color);
        e_payment_to_info.setForeground(on_background_Color);
        e_payment_contact_info.setForeground(on_background_Color);
        e_payment_type_info.setForeground(on_background_Color);
        e_payment_firstName_info.setForeground(on_background_Color);
        e_payment_lastName_info.setForeground(on_background_Color);
        e_payment_address_info.setForeground(on_background_Color);
        e_payment_state_info.setForeground(on_background_Color);
        e_payment_district_info.setForeground(on_background_Color);
        e_payment_pincode_info.setForeground(on_background_Color);
        e_payment_message_info.setForeground(on_background_Color);

        //Label Font
        e_payment_title.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        e_payment_beneficiary.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_amount.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_to.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_contact.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_type.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_firstName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_address.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_state.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_district.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_pincode.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_message.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        //Content Label Font
        e_payment_beneficiary_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_amount_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_to_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_contact_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_type_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_firstName_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_lastName_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_address_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_state_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_district_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_pincode_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_message_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        //Add to Panel
        add(e_payment_title);
        add(e_payment_beneficiary);
        add(e_payment_amount);
        add(e_payment_to);
        add(e_payment_contact);
        add(e_payment_type);
        add(e_payment_firstName);
        add(e_payment_lastName);
        add(e_payment_address);
        add(e_payment_state);
        add(e_payment_district);
        add(e_payment_pincode);
        add(e_payment_message);

        add(e_payment_beneficiary_info);
        add(e_payment_amount_info);
        add(e_payment_to_info);
        add(e_payment_contact_info);
        add(e_payment_type_info);
        add(e_payment_firstName_info);
        add(e_payment_lastName_info);
        add(e_payment_address_info);
        add(e_payment_state_info);
        add(e_payment_district_info);
        add(e_payment_pincode_info);
        add(e_payment_btn_confirm);
        add(e_payment_message_info);
        add(e_payment_btn_back);

        //Panel
        setLayout(null);
        setBackground(background_Color);
        setSize(1350, 890);

        //Popup
        e_payment_authentication = new JPopupMenu("Authentication");

        e_payment_authentication.setBackground(background_Color);
        e_payment_authentication.setBounds(X_FORCUSTOMER, Y_FORCUSTOMER, 1000, 1000);
        e_payment_authentication.setLayout(null);

    }

    //setDataForEPostPayment details in front end of this class
    public static void setDataForEPostPayment() {
        e_payment_beneficiary_info.setText(EPostData.getFirstName() + " " + EPostData.getLastName());
        e_payment_amount_info.setText(WalletDataG.getAmount().toString());
        e_payment_to_info.setText(EPostData.getTo());
        e_payment_contact_info.setText(EPostData.getPhoneNumber().toString());
        e_payment_type_info.setText("E-Post");

        e_payment_firstName_info.setText(EPostData.getFirstName());
        e_payment_lastName_info.setText(EPostData.getLastName());
        e_payment_address_info.setText(EPostData.getAddress());
        e_payment_state_info.setText(EPostData.getState());
        e_payment_district_info.setText(EPostData.getDistrict());
        e_payment_pincode_info.setText(EPostData.getPincode());
        e_payment_message_info.setText(EPostData.getSubject());

    }

    //MouseClick Listener For Page Switching
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == e_payment_btn_back) {
            main.switchPage("customerPanel");
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
