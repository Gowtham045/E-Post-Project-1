package Admin;

import Consignment.consignment;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import main.main;
import warehouse.Warehouse;

public class AdminPanel extends JPanel implements ActionListener, MouseListener {

    //Private Variables
    private JLabel LE_Post, IProfile;
    private Icon image = new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
    private Icon imag = new ImageIcon(getClass().getResource("/Images/search_white.png"));
    private int xForInbox = 0, xForConsignment = 0, xForE_post = 0, xForParcel = 0, xForProducts = 0, xForWallets = 0;
    private JPanel pNewconsignment, pOnGoingConsignment, pCompletedConsignment, pCustomer, pDelivery, pConsignmentDetails, pStocks;
    private int X_FORCUSTOMER = 55, Y_FORCUSTOMER = 150, WIDTHFORCUSTOMER = 1260, HIGHTFORCUSTOMER = 570;
    private int R = 34, G = 34, B = 45;
    private Color Buttoncolor = new Color(240, 238, 240);
    private JTextArea search;
    private JLabel LAdmin;
    private Font font = new Font("Bold", Font.BOLD, 20);
    private JLabel userLogo;
    private JLabel lSearch;

    //Public Variables
    public static JPanel contentForAdmin;
    public static CardLayout adminCard;
    public static JButton bNew, bOnGoing, bCompleted, bCustomer, bDelivery, bStocks;
    public static String card = "NewConsignment";

    //Contructer
    public AdminPanel() {

        //Admin Panel
        adminCard = new CardLayout();
        contentForAdmin = new JPanel(adminCard);

        pNewconsignment = new NewConsignment();
        pOnGoingConsignment = new OnGoingConsignment();
        pCompletedConsignment = new CompletedConsignment();
        pCustomer = new customerDetails();
        pDelivery = new deliveryDetails();
        pStocks = new Stocks();
        pConsignmentDetails = new ConsignmentDetails();

        //Admin Logo
        ImageIcon logo = new ImageIcon(getClass().getResource("/Images/Group 33.png"));
        Image ima = logo.getImage();
        Image newimg = ima.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(newimg);

        //Creating Admin Pages
        contentForAdmin.add(pNewconsignment, "NewConsignment");
        contentForAdmin.add(pOnGoingConsignment, "OnGoingConsignment");
        contentForAdmin.add(pCompletedConsignment, "CompletedConsignment");
        contentForAdmin.add(pCustomer, "CustomerDetails");
        contentForAdmin.add(pDelivery, "DeliveryDetails");
        contentForAdmin.add(pStocks, "Stocks");
        contentForAdmin.add(pConsignmentDetails, "ConsignmentDetails");

        consignment.setNewdAdminConsignmentDetails();
        adminCard.first(contentForAdmin);
        contentForAdmin.setBounds(X_FORCUSTOMER, Y_FORCUSTOMER, WIDTHFORCUSTOMER, HIGHTFORCUSTOMER);
        add(contentForAdmin);

        //E Post Label
        LE_Post = new JLabel(logo);
        LE_Post.setBounds(X_FORCUSTOMER, 20, 100, 50);
        LE_Post.setForeground(Color.WHITE);
        add(LE_Post);

        //Admin Label
        LAdmin = new JLabel("Admin");
        LAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        LAdmin.setBounds(X_FORCUSTOMER + 125, 32, 160, 30);
        LAdmin.setForeground(Color.WHITE);
        add(LAdmin);

        //Search TextArea
        search = new JTextArea("Search ID...");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        search.setBounds(970, 32, 200, 30);
        search.addMouseListener(this);
        add(search);

        //Search Logo
        lSearch = new JLabel(imag);
        lSearch.setBounds(1155, 26, 100, 40);
        lSearch.addMouseListener(this);
        lSearch.setBorder(null);
        add(lSearch);

        //Profile Image
        IProfile = new JLabel(image);
        IProfile.addMouseListener(this);
        IProfile.setBounds(1240, 22, 50, 50);
        add(IProfile);

        //username logo
        userLogo = new JLabel();
        userLogo.setFont(new Font("Bold", Font.BOLD, 20));
        userLogo.setBounds(1000 + 90, 30, 200, 30);
        add(userLogo);

        //New Consignment Button
        bNew = new JButton("New");
        bNew.setFont(font);
        bNew.setBorder(null);
        bNew.setUI(new StyledButtonUi());
        bNew.setBounds(X_FORCUSTOMER, 120, 160, 30);
        bNew.setBackground(Buttoncolor);
        bNew.addActionListener(this);
        add(bNew);

        //on Going Consignment Button
        bOnGoing = new JButton("On Going");
        bOnGoing.setFont(font);
        bOnGoing.setBackground(Buttoncolor);
        bOnGoing.setBounds(X_FORCUSTOMER + 180, 110, 160, 30);
        bOnGoing.setUI(new StyledButtonUi());
        bOnGoing.addActionListener(this);
        add(bOnGoing);

        //Completed Consignment Button
        bCompleted = new JButton("Completed");
        bCompleted.setFont(font);
        bCompleted.setBackground(Buttoncolor);
        bCompleted.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
        bCompleted.setUI(new StyledButtonUi());
        bCompleted.addActionListener(this);
        add(bCompleted);

        //Customer Consignment Button
        bCustomer = new JButton("Customer");
        bCustomer.setFont(font);
        bCustomer.setBackground(Buttoncolor);
        bCustomer.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
        bCustomer.setUI(new StyledButtonUi());
        bCustomer.addActionListener(this);
        add(bCustomer);

        //Delivery Consignment Button
        bDelivery = new JButton("Delivery");
        bDelivery.setFont(font);
        bDelivery.setBackground(Buttoncolor);
        bDelivery.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
        bDelivery.setUI(new StyledButtonUi());
        bDelivery.addActionListener(this);
        add(bDelivery);

        //Stocks Consignment Button
        bStocks = new JButton("Stocks");
        bStocks.setBackground(Buttoncolor);
        bStocks.setFont(font);
        bStocks.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        bStocks.setUI(new StyledButtonUi());
        bStocks.addActionListener(this);
        add(bStocks);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1350, 890));
        this.setVisible(true);
        this.setBackground(new Color(R, G, B));

    }

    //Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == bNew) {
            card = "NewConsignment";
            consignment.setNewdAdminConsignmentDetails();
            adminCard.show(contentForAdmin, "NewConsignment");
            bNew.setBounds(X_FORCUSTOMER, 120, 160, 30);
            bOnGoing.setBounds(X_FORCUSTOMER + 180, 110, 160, 30);
            bCompleted.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            bCustomer.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            bDelivery.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            bStocks.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);

        } else if (o == bOnGoing) {
            card = "OnGoingConsignment";
            adminCard.show(contentForAdmin, "OnGoingConsignment");

            bNew.setBounds(X_FORCUSTOMER, 110, 160, 30);
            bOnGoing.setBounds(X_FORCUSTOMER + 180, 120, 160, 30);
            bCompleted.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            bCustomer.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            bDelivery.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            bStocks.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
            consignment.setOngoingAdminConsignmentDetails();
        } else if (o == bCompleted) {
            card = "CompletedConsignment";
            consignment.setCompletedAdminConsignmentDetails();
            adminCard.show(contentForAdmin, "CompletedConsignment");

            bNew.setBounds(X_FORCUSTOMER, 110, 160, 30);
            bOnGoing.setBounds(X_FORCUSTOMER + 180, 110, 160, 30);
            bCompleted.setBounds(X_FORCUSTOMER + 180 + 180, 120, 160, 30);
            bCustomer.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            bDelivery.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            bStocks.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        } else if (o == bCustomer) {
            card = "CustomerDetails";
            profile.CustomerProfile.setCustomerDetails();
            adminCard.show(contentForAdmin, "CustomerDetails");

            bNew.setBounds(X_FORCUSTOMER, 110, 160, 30);
            bOnGoing.setBounds(X_FORCUSTOMER + 180, 110, 160, 30);
            bCompleted.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            bCustomer.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 120, 160, 30);
            bDelivery.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            bStocks.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        } else if (o == bDelivery) {
            card = "DeliveryDetails";
            profile.DeliveryProfile.setDeliveryDetails();
            adminCard.show(contentForAdmin, "DeliveryDetails");

            bNew.setBounds(X_FORCUSTOMER, 110, 160, 30);
            bOnGoing.setBounds(X_FORCUSTOMER + 180, 110, 160, 30);
            bCompleted.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            bCustomer.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            bDelivery.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 120, 160, 30);
            bStocks.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        } else if (o == bStocks) {
            card = "Stocks";
            adminCard.show(contentForAdmin, "Stocks");
            Warehouse.setStocks();

            bNew.setBounds(X_FORCUSTOMER, 110, 160, 30);
            bOnGoing.setBounds(X_FORCUSTOMER + 180, 110, 160, 30);
            bCompleted.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            bCustomer.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            bDelivery.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            bStocks.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 120, 160, 30);
        }

    }

    //Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == search) {
            search.setText("");
        } else if (e.getSource() == IProfile) {
            profile.AdminProfile.setAdminProfile(Login.login.user_ID);
            main.switchPage("AdminProfileView");
        } else if (e.getSource() == lSearch) {
            try {
                String con = search.getText();
                consignment.setConsignmentDetails(con);
                adminCard.show(contentForAdmin, "ConsignmentDetails");
            } catch (Exception ls) {
                JOptionPane.showMessageDialog(AdminPanel.contentForAdmin, "Consignment not Found");
            }
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
