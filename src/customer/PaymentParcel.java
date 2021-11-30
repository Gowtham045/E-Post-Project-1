package customer;

import Admin.StyledButtonUi;
import customer.DatasForCustomer.CustomerProfileData;
import customer.DatasForCustomer.ParcelData;
import customer.DatasForCustomer.WalletDataG;
import main.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PaymentParcel extends JPanel implements MouseListener {

    // private
    private Color background_Color = new Color(34, 34, 45);
    private Color on_background_Color = new Color(254, 254, 254);
    private Color primary_Color = new Color(71, 63, 145);
    //panel
    private JPanel p_payment_Panel;
    private JLabel p_payment_title;
    private JButton p_payment_btn_confirm;
    private JLabel p_payment_btn_back;

    //Left Label
    private JLabel p_payment_beneficiary;
    private JLabel p_payment_amount;
    private JLabel p_payment_to;
    private JLabel p_payment_contact;
    private JLabel p_payment_type;
    private JLabel p_payment_weight;
    private JLabel p_payment_firstName;
    private JLabel p_payment_lastName;
    private JLabel p_payment_address;
    private JLabel p_payment_state;
    private JLabel p_payment_district;
    private JLabel p_payment_pincode;

    //Content Label
    private static JLabel p_payment_beneficiary_info;
    private static JLabel p_payment_amount_info;
    private static JLabel p_payment_to_info;
    private static JLabel p_payment_contact_info;
    private static JLabel p_payment_type_info;
    private static JLabel p_payment_weight_info;
    private static JLabel p_payment_firstName_info;
    private static JLabel p_payment_lastName_info;
    private static JTextArea p_payment_address_info;
    private static JLabel p_payment_state_info;
    private static JLabel p_payment_district_info;
    private static JLabel p_payment_pincode_info;

    int X_FORCUSTOMER = 0, Y_FORCUSTOMER = 100, WIDTHFORCUSTOMER = 1260, HIGHTFORCUSTOMER = 750;

    public PaymentParcel() {

        p_payment_Panel = new JPanel();

        p_payment_btn_confirm = new JButton();
        p_payment_btn_back = new JLabel(new ImageIcon(getClass().getResource("/Images/arrow_back_button.png")));
        p_payment_btn_back.addMouseListener(this);

        //Label
        p_payment_title = new JLabel("Payment");
        p_payment_beneficiary = new JLabel("Beneficiary");
        p_payment_amount = new JLabel("Amount");
        p_payment_to = new JLabel("To");
        p_payment_contact = new JLabel("Contact No.");
        p_payment_type = new JLabel("Type");
        p_payment_weight = new JLabel("Item Weight");
        p_payment_firstName = new JLabel("First Name");
        p_payment_lastName = new JLabel("Last Name");
        p_payment_address = new JLabel("Address");
        p_payment_state = new JLabel("State");
        p_payment_district = new JLabel("District");
        p_payment_pincode = new JLabel("Pincode");

        //Content Label
        p_payment_beneficiary_info = new JLabel();
        p_payment_amount_info = new JLabel();
        p_payment_to_info = new JLabel();
        p_payment_contact_info = new JLabel();
        p_payment_type_info = new JLabel();
        p_payment_weight_info = new JLabel();
        p_payment_firstName_info = new JLabel();
        p_payment_lastName_info = new JLabel();
        p_payment_address_info = new JTextArea();
        p_payment_state_info = new JLabel();
        p_payment_district_info = new JLabel();
        p_payment_pincode_info = new JLabel();

        p_payment_address_info.setBackground(background_Color);
        p_payment_address_info.setEditable(false);
        p_payment_address_info.setHighlighter(null);
        p_payment_address_info.setLineWrap(true);

        //Button and title
        p_payment_title.setBounds(585, 25, 200, 50);
        p_payment_btn_confirm.setBounds(585, 675 + 80, 150, 40);
        p_payment_btn_confirm.setBackground(primary_Color);
        p_payment_btn_confirm.setText("Confirm");
        p_payment_btn_confirm.setForeground(on_background_Color);
        p_payment_btn_confirm.setBorder(null);
        p_payment_btn_confirm.setUI(new StyledButtonUi());

        p_payment_btn_back.setBounds(25, 25, 40, 40);
        p_payment_btn_back.setBackground(null);
        p_payment_btn_back.setBorder(null);
        try {
            Image img = ImageIO.read(getClass().getResource("/Images/arroe_back_button.png"));
            p_payment_btn_back.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
//            System.out.println(ex);
        }

        //Label Bounds
        p_payment_beneficiary.setBounds(120, 0 + 80, 150, 50);
        p_payment_amount.setBounds(120, 50 + 80, 150, 50);
        p_payment_to.setBounds(120, 100 + 80, 150, 50);
        p_payment_contact.setBounds(120, 150 + 80, 150, 50);
        p_payment_type.setBounds(120, 200 + 80, 150, 50);
        p_payment_weight.setBounds(120, 250 + 80, 150, 50);
        p_payment_firstName.setBounds(120, 300 + 80, 150, 50);
        p_payment_lastName.setBounds(120, 350 + 80, 150, 50);
        p_payment_address.setBounds(120, 400 + 80, 150, 50);
        p_payment_state.setBounds(120, 500 + 80, 150, 50);
        p_payment_district.setBounds(120, 550 + 80, 150, 50);
        p_payment_pincode.setBounds(120, 600 + 80, 150, 50);

        //Content Label Bounds
        p_payment_beneficiary_info.setBounds(400, 0 + 80, 250, 50);
        p_payment_amount_info.setBounds(400, 50 + 80, 200, 50);
        p_payment_to_info.setBounds(400, 100 + 80, 200, 50);
        p_payment_contact_info.setBounds(400, 150 + 80, 200, 50);
        p_payment_type_info.setBounds(400, 200 + 80, 200, 50);
        p_payment_weight_info.setBounds(400, 250 + 80, 200, 50);
        p_payment_firstName_info.setBounds(400, 300 + 80, 250, 50);
        p_payment_lastName_info.setBounds(400, 350 + 80, 250, 50);
        p_payment_address_info.setBounds(400, 410 + 80, 800, 90);
        p_payment_state_info.setBounds(400, 500 + 80, 200, 50);
        p_payment_district_info.setBounds(400, 550 + 80, 200, 50);
        p_payment_pincode_info.setBounds(400, 600 + 80, 150, 50);

        //Label Text Color
        p_payment_title.setForeground(on_background_Color);
        p_payment_beneficiary.setForeground(on_background_Color);
        p_payment_amount.setForeground(on_background_Color);
        p_payment_to.setForeground(on_background_Color);
        p_payment_contact.setForeground(on_background_Color);
        p_payment_type.setForeground(on_background_Color);
        p_payment_weight.setForeground(on_background_Color);
        p_payment_firstName.setForeground(on_background_Color);
        p_payment_lastName.setForeground(on_background_Color);
        p_payment_address.setForeground(on_background_Color);
        p_payment_state.setForeground(on_background_Color);
        p_payment_district.setForeground(on_background_Color);
        p_payment_pincode.setForeground(on_background_Color);

        //Content Label Text Color
        p_payment_beneficiary_info.setForeground(on_background_Color);
        p_payment_amount_info.setForeground(on_background_Color);
        p_payment_to_info.setForeground(on_background_Color);
        p_payment_contact_info.setForeground(on_background_Color);
        p_payment_type_info.setForeground(on_background_Color);
        p_payment_weight_info.setForeground(on_background_Color);
        p_payment_firstName_info.setForeground(on_background_Color);
        p_payment_lastName_info.setForeground(on_background_Color);
        p_payment_address_info.setForeground(on_background_Color);
        p_payment_state_info.setForeground(on_background_Color);
        p_payment_district_info.setForeground(on_background_Color);
        p_payment_pincode_info.setForeground(on_background_Color);

        //Label Font
        p_payment_title.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        p_payment_beneficiary.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_amount.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_to.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_contact.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_type.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_weight.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_firstName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_address.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_state.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_district.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_pincode.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        //Content Label Font
        p_payment_beneficiary_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_amount_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_to_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_contact_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_type_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_weight_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_firstName_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_lastName_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_address_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_state_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_district_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_pincode_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        p_payment_Panel.setBounds(X_FORCUSTOMER, Y_FORCUSTOMER, WIDTHFORCUSTOMER, HIGHTFORCUSTOMER);
        p_payment_Panel.setPreferredSize(new Dimension(1350, 890));

        //Add to Panel
        add(p_payment_title);
        add(p_payment_beneficiary);
        add(p_payment_amount);
        add(p_payment_to);
        add(p_payment_contact);
        add(p_payment_type);
        add(p_payment_weight);
        add(p_payment_firstName);
        add(p_payment_lastName);
        add(p_payment_address);
        add(p_payment_state);
        add(p_payment_district);
        add(p_payment_pincode);

        add(p_payment_beneficiary_info);
        add(p_payment_amount_info);
        add(p_payment_to_info);
        add(p_payment_contact_info);
        add(p_payment_type_info);
        add(p_payment_weight_info);
        add(p_payment_firstName_info);
        add(p_payment_lastName_info);
        add(p_payment_address_info);
        add(p_payment_state_info);
        add(p_payment_district_info);
        add(p_payment_pincode_info);
        add(p_payment_btn_confirm);
        add(p_payment_btn_back);

        p_payment_btn_confirm.addActionListener((o) -> {
            if (Float.parseFloat(p_payment_amount_info.getText()) <= Float.parseFloat(CustomerProfileData.getBankBalance())) {
                new AuthenticationForParcel();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient BankBalance:" + CustomerProfileData.getBankBalance());
            }
        });

        //Panel
        setLayout(null);
        setBackground(background_Color);
        setPreferredSize(new Dimension(1350, 850));
        setVisible(true);

    }

    //setDataForParcelPanel this set details int front end of this class
    public static void setDataForParcelPanel() {
        p_payment_beneficiary_info.setText(ParcelData.getFirstName() + " " + ParcelData.getLastName());
        p_payment_amount_info.setText(WalletDataG.getItemPrice().toString());
        p_payment_to_info.setText(ParcelData.getTo());
        p_payment_contact_info.setText(ParcelData.getPhoneNumber().toString());
        p_payment_type_info.setText("Parcel");
        p_payment_weight_info.setText(WalletDataG.getItemWeight().toString());
        p_payment_firstName_info.setText(ParcelData.getFirstName());
        p_payment_lastName_info.setText(ParcelData.getLastName());
        p_payment_address_info.setText(ParcelData.getAddress());
        p_payment_state_info.setText(ParcelData.getState());
        p_payment_district_info.setText(ParcelData.getDistrict());
        p_payment_pincode_info.setText(ParcelData.getPincode());
    }

    //MouseClick Listener For Page Switching
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == p_payment_btn_back) {
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
