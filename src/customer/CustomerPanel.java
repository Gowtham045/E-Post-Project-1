package customer;

import customer.DatasForCustomer.ConsignmentData;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.main;
import Admin.StyledButtonUi;
import customer.DatasForCustomer.InboxData;
import static customer.WalletPanel.removeWalletCurrentDetails;
import static customer.WalletPanel.setWalletCurrentDetails;
import javax.swing.plaf.ButtonUI;
import Database.DatabaseOperations;
import customer.DatasForCustomer.CustomerProfileData;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CustomerPanel extends JPanel implements ActionListener, MouseListener {

    //private
    private static final int X_FORCUSTOMER = 55, Y_FORCUSTOMER = 150, WIDTHFORCUSTOMER = 1260, HIGHTFORCUSTOMER = 570;
    private static final int R = 34, G = 34, B = 45;
    private JLabel LE_Post, IProfile, lSearch, LCustomer, userLogo;
    public static JPanel PInbox, PConsignment, PE_Post, PParcel, PProducts, PWallet, PConsignmentDetails, customerPanel;
    private Icon image = new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
    private Icon seargeImage = new ImageIcon(getClass().getResource("/Images/search_white.png"));
    private Color Buttoncolor = new Color(240, 238, 240);
    private JTextField search;

    //public variables
    public static JPanel contentForCustomer;
    public static CardLayout customerCard = null;
    public static JButton BInbox, BConsignment, BE_Post, BParcel, BProducts, BWallet;
    private Font font = new Font("Bold", Font.BOLD, 20);
    private ButtonUI ui = new StyledButtonUi();

    public CustomerPanel() {

        setLayout(null);
        //Objects For Inner Panels
        customerCard = new CardLayout();
        PWallet = new WalletPanel();
        contentForCustomer = new JPanel(customerCard);
        PE_Post = new E_PostPanel();
        PParcel = new ParcelPanel();
        PProducts = new ProductsPanel();
        PConsignmentDetails = new ConsignmentDetails();
        PInbox = new InboxPanel();

        //Adding Inner Panel to Content Panel -> contentForCustomer
        contentForCustomer.add(PInbox, "Inbox");
        contentForCustomer.add(PInbox, "Inbox");
        contentForCustomer.add(PE_Post, "E-Post");
        contentForCustomer.add(PParcel, "Parcel");
        contentForCustomer.add(PProducts, "Products");
        contentForCustomer.add(PWallet, "Wallet");
        contentForCustomer.add(PConsignmentDetails, "ConsignmentDetails");

        //Default Landing Panel
        customerCard.show(contentForCustomer, "Inbox");

        //setBounds For contentForCustomer Panel
        contentForCustomer.setBounds(X_FORCUSTOMER, Y_FORCUSTOMER, WIDTHFORCUSTOMER, HIGHTFORCUSTOMER);
        add(contentForCustomer);
        setPreferredSize(new Dimension(1350, 890));
        setVisible(true);
        setBackground(new Color(R, G, B));

        //Admin Logo
        ImageIcon logo = new ImageIcon(getClass().getResource("/Images/Group 33.png"));
        Image ima = logo.getImage();
        Image newimg = ima.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(newimg);
        
        //Labels
        LE_Post = new JLabel(logo);
        LE_Post.setFont(new Font("Segoe UI", Font.BOLD, 30));
        LE_Post.setBounds(X_FORCUSTOMER, 20, 100, 50);
        LE_Post.setForeground(Color.WHITE);
        add(LE_Post);

        LCustomer = new JLabel("Customer");
        LCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        LCustomer.setBounds(X_FORCUSTOMER + 125, 32, 160, 30);
        LCustomer.setForeground(Color.WHITE);
        add(LCustomer);

        //Search Field For Consignments
        search = new JTextField("Search ID...");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        search.setBounds(970, 32, 200, 30);
        search.addMouseListener(this);
        search.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 120, 160, 30);
                ConsignmentData.listForConsignment.clear();
                CustomerPanel.contentForCustomer.add(new ConsignmentPanel(), "Consignment");
                CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer, "Consignment");
                search(search.getText());

                customerCard.show(contentForCustomer, "Consignment");

                BInbox.setBounds(X_FORCUSTOMER, 110, 160, 30);
                BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
                BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
                BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
                BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(search.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(search.getText());
            }

            public void search(String str) {
                try {
                    if ((str.length() == 0)) {
                        ConsignmentPanel.sorter.setRowFilter(null);
                    } else {
                        ConsignmentPanel.sorter.setRowFilter(RowFilter.regexFilter(str));
                    }
                } catch (Exception e) {

                }

            }
        });
        search.setBorder(BorderFactory.createEmptyBorder(2, 5, 0, 5));
        add(search);

        //Search Logo
        lSearch = new JLabel(seargeImage);
        lSearch.setBounds(1155, 26, 100, 40);
        lSearch.addMouseListener(this);
        lSearch.setBorder(null);
        add(lSearch);

        //Profile Logo
        IProfile = new JLabel(image);
        IProfile.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == IProfile) {
                    DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
                }
                Profile_View.setCustomercProfileData();
                main.switchPage("Profile");

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
        IProfile.setBounds(1240, 22, 50, 50);
        add(IProfile);

        userLogo = new JLabel();
        userLogo.setFont(new Font("Bold", Font.BOLD, 20));
        userLogo.setBounds(1000 + 90, 30, 200, 30);
        add(userLogo);

        //Buttons Objects
        BInbox = new JButton("Inbox");
        BInbox.setFont(font);
        BInbox.setBorder(null);
        BInbox.setUI(ui);
        BInbox.setBounds(X_FORCUSTOMER, 120, 160, 30);
        BInbox.setBackground(Buttoncolor);
        BInbox.addActionListener(this);
        add(BInbox);

        BConsignment = new JButton("Consignment");
        BConsignment.setFont(font);
        BConsignment.setBackground(Buttoncolor);
        BConsignment.setUI(ui);
        BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);
        BConsignment.addActionListener(this);
        add(BConsignment);

        BE_Post = new JButton("E-Post");
        BE_Post.setFont(font);
        BE_Post.setBackground(Buttoncolor);
        BE_Post.setUI(ui);
        BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
        BE_Post.addActionListener(this);
        add(BE_Post);

        BParcel = new JButton("Parcel");
        BParcel.setFont(font);
        BParcel.setBackground(Buttoncolor);
        BParcel.setUI(ui);
        BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
        BParcel.addActionListener(this);
        add(BParcel);

        BProducts = new JButton("Products");
        BProducts.setFont(font);
        BProducts.setBackground(Buttoncolor);
        BProducts.setUI(ui);
        BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
        BProducts.addActionListener(this);
        add(BProducts);

        BWallet = new JButton("Wallet");
        BWallet.setBackground(Buttoncolor);
        BWallet.setFont(font);
        BWallet.setUI(ui);
        BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        BWallet.addActionListener(this);
        add(BWallet);

    }

    //Action Listener For Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == BInbox) {
            try {
                InboxData.ListForInbox.clear();
            } catch (Exception ex) {

            }

            PInbox = new InboxPanel();
            contentForCustomer.add(PInbox, "Inbox");
            BInbox.setBounds(X_FORCUSTOMER, 120, 160, 30);
            customerCard.show(contentForCustomer, "Inbox");

            BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);
            BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);

        } else if (o == BConsignment) {
            BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 120, 160, 30);
            try {
                ConsignmentData.listForConsignment.clear();
            } catch (Exception r) {
            }

            CustomerPanel.contentForCustomer.add(new ConsignmentPanel(), "Consignment");

            if (!ConsignmentData.isIsUpdate()) {

                customerCard.show(contentForCustomer, "Consignment");
            } else {

                customerCard.show(contentForCustomer, "update");
            }
            BInbox.setBounds(X_FORCUSTOMER, 110, 160, 30);
            BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        } else if (o == BE_Post) {
            BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 120, 160, 30);
            customerCard.show(contentForCustomer, "E-Post");

            BInbox.setBounds(X_FORCUSTOMER, 110, 160, 30);
            BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);
            BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        } else if (o == BParcel) {
            BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 120, 160, 30);
            customerCard.show(contentForCustomer, "Parcel");

            BInbox.setBounds(X_FORCUSTOMER, 110, 160, 30);
            BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);
            BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);
        } else if (o == BProducts) {
            BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 120, 160, 30);
            customerCard.show(contentForCustomer, "Products");

            BInbox.setBounds(X_FORCUSTOMER, 110, 160, 30);
            BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);
            BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);

        } else if (o == BWallet) {
            DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
            WalletPanel.Account_no.setText("Account no : " + CustomerProfileData.getAccountNumber());
            WalletPanel.UserName.setText("Username   : " + CustomerProfileData.getId());
            WalletPanel.WalletBalance.setText(CustomerProfileData.getBankBalance());
            BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 120, 160, 30);
            removeWalletCurrentDetails();
            setWalletCurrentDetails();
            customerCard.show(contentForCustomer, "Wallet");

            BInbox.setBounds(X_FORCUSTOMER, 110, 160, 30);
            BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);
            BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);

        }

    }

    //Mouse Listener For Search Logo
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == search) {
            search.setText("");
        } else if (e.getSource() == lSearch) {
            try {
                String str = search.getText();
                if ((str.length() == 0)) {
                    ConsignmentPanel.sorter.setRowFilter(null);
                } else {
                    ConsignmentPanel.sorter.setRowFilter(RowFilter.regexFilter(str));
                }
            } catch (Exception a) {

            }

            BConsignment.setBounds(X_FORCUSTOMER + 120 + 60, 120, 160, 30);
            ConsignmentData.listForConsignment.clear();
            CustomerPanel.contentForCustomer.add(new ConsignmentPanel(), "Consignment");
            customerCard.show(contentForCustomer, "Consignment");

            BInbox.setBounds(X_FORCUSTOMER, 110, 160, 30);
            BE_Post.setBounds(X_FORCUSTOMER + 180 + 180, 110, 160, 30);
            BParcel.setBounds(X_FORCUSTOMER + 180 + 180 + 180, 110, 160, 30);
            BProducts.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180, 110, 160, 30);
            BWallet.setBounds(X_FORCUSTOMER + 180 + 180 + 180 + 180 + 180, 110, 160, 30);

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
