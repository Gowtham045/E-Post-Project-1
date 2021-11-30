package Delivery;

import Consignment.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import main.main;

public class delivery extends JPanel implements ActionListener, MouseListener {

    //Private Variables
    private Icon image = new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
    private JLabel LCustomer;
    private JLabel LE_Post, IProfile;
    private JTextArea search;
    private JLabel userLogo;
    private JButton BCompleted, BOngoing;
    private int X_FORCUSTOMER = 55, Y_FORCUSTOMER = 150, WIDTHFORCUSTOMER = 1260, HIGHTFORCUSTOMER = 570;
    private Font font = new Font("Bold", Font.BOLD, 20);
    private int R = 34, G = 34, B = 45;
    private Color Buttoncolor = new Color(240, 238, 240);
    private Icon imag = new ImageIcon(getClass().getResource("/Images/search_white.png"));
    private JLabel lSearch;

    //Public Varaibles
    public static CardLayout deliveryCard;
    public static JPanel PCompleted, Pongoing, PDeliveryConsignment;
    public static JPanel ContentForDelivery;
    public static String card;

    //Constructor
    public delivery() {
        setLayout(null);

        //CardLayout       
        deliveryCard = new CardLayout();
        ContentForDelivery = new JPanel(deliveryCard);

        //JPanel
        Pongoing = new ongoing();
        PCompleted = new completed();
        PDeliveryConsignment = new DeliveryConsignment();

        //Adding to the Panel
        ContentForDelivery.add(Pongoing, "ongoing");
        ContentForDelivery.add(PCompleted, "completed");
        ContentForDelivery.add(PDeliveryConsignment, "PDeliveryConsignment");
        ContentForDelivery.setBounds(X_FORCUSTOMER, Y_FORCUSTOMER, WIDTHFORCUSTOMER, HIGHTFORCUSTOMER);
        deliveryCard.first(ContentForDelivery);
        add(ContentForDelivery);
        setPreferredSize(new Dimension(1350, 890));
        setVisible(true);
        setBackground(new Color(R, G, B));

        //Delivery Logo
        ImageIcon logo = new ImageIcon(getClass().getResource("/Images/Group 33.png"));
        Image ima = logo.getImage();
        Image newimg = ima.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(newimg);

        //JLabel
        LE_Post = new JLabel(logo);
        LE_Post.setBounds(X_FORCUSTOMER, 20, 100, 50);
        LE_Post.setForeground(Color.WHITE);
        add(LE_Post);

        LCustomer = new JLabel("Delivery");
        LCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        LCustomer.setBounds(X_FORCUSTOMER + 125, 32, 160, 30);
        LCustomer.setForeground(Color.WHITE);
        add(LCustomer);

        search = new JTextArea("Search ID...");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        search.setBounds(970, 32, 200, 30);
        search.setBorder(BorderFactory.createEmptyBorder(2, 5, 0, 5));
        search.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                search.setText("");
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
        add(search);

        lSearch = new JLabel(imag);
        lSearch.setBounds(1155, 26, 100, 40);
        lSearch.setBorder(null);
        add(lSearch);
        lSearch.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String con = search.getText();
                    consignment.setDeliveryConsignmentDetails(con);
                    deliveryCard.show(ContentForDelivery, "PDeliveryConsignment");
                } catch (Exception e3) {
                    JOptionPane.showMessageDialog(delivery.ContentForDelivery, "Consignment not Found");
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

        IProfile = new JLabel(image);
        IProfile.addMouseListener(this);
        IProfile.setBounds(1240, 22, 50, 50);
        add(IProfile);

        userLogo = new JLabel();
        userLogo.setFont(new Font("Bold", Font.BOLD, 20));
        userLogo.setBounds(1000 + 90, 30, 200, 30);
        add(userLogo);

        BOngoing = new JButton("OnGoing");
        BOngoing.setFont(font);
        BOngoing.setBorder(null);
        BOngoing.setUI(new StyledButtonUI());
        BOngoing.setBackground(Buttoncolor);
        BOngoing.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);

        BOngoing.addActionListener((e2)
                -> {
            card = "ongoing";
            consignment.setOngoingDeliveryConsignmentDetails();
            BCompleted.setBounds(X_FORCUSTOMER, 110, 160, 30);
            BOngoing.setBounds(X_FORCUSTOMER + 120 + 60, 120, 160, 30);
            deliveryCard.show(ContentForDelivery, "ongoing");
        });
        add(BOngoing);

        BCompleted = new JButton("Completed");
        BCompleted.setFont(font);
        BCompleted.setBorder(null);
        BCompleted.setUI(new StyledButtonUI());
        BCompleted.setBounds(X_FORCUSTOMER + 1, 120, 160, 30);
        BCompleted.setBackground(Buttoncolor);

        BCompleted.addActionListener((e1)
                -> {

            card = "completed";
            consignment.setCompletedDeliveryConsignmentDetails();
            BCompleted.setBounds(X_FORCUSTOMER - 2, 120, 160, 30);
            BOngoing.setBounds(X_FORCUSTOMER + 120 + 60, 110, 160, 30);
            deliveryCard.show(ContentForDelivery, "completed");
        });
        add(BCompleted);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == IProfile) {
            profile.DeliveryProfile.setDeliverydeliveryProfile(Login.login.user_ID);
            main.switchPage("deliveryProfileView");
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
