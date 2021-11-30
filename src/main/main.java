package main;

import Admin.*;
import javax.swing.*;
import java.awt.*;
import Login.*;
import customer.*;
import Delivery.*;

public class main extends JFrame {

    //Static Variables
    public static JPanel mainPanel;
    static CardLayout card;
    public static Component main;

    //Constructure
    main() {
        //CardLayout
        card = new CardLayout();

        //Main Panel
        mainPanel = new JPanel(card);
        mainPanel.setBackground(new Color(34, 34, 45));
        mainPanel.setPreferredSize(new Dimension(1350, 890));

        Front front = new Front();
        login login = new login();
        register register = new register();
        CustomerPanel customerPanel = new CustomerPanel();
        AdminPanel adminPanel = new AdminPanel();
        Profile_View profileView = new Profile_View();
        Profile_Update profileUpdate = new Profile_Update();
        AdminProfileView adminProfileVi = new AdminProfileView();
        AdminProfileUpdate adminprofileUp = new AdminProfileUpdate();
        delivery deliveryPanel = new delivery();
        DeliveryProfileView deliveryProfileView = new DeliveryProfileView();
        DeliveryProfileUpdate deliveryProfileUpdate = new DeliveryProfileUpdate();
        AdminDeliveryProfile ADeliveryProfile = new AdminDeliveryProfile();
        AdminCustomerProfile ACustomerProfile = new AdminCustomerProfile();
        PaymentEPost paymentEPost = new PaymentEPost();
        PaymentParcel paymentParcel = new PaymentParcel();
        MoneyOrder moneyOrder = new MoneyOrder();

        //Adding Components to the Main Panel
        mainPanel.add(front, "front");
        mainPanel.add(login, "login");
        mainPanel.add(register, "register");
        mainPanel.add(customerPanel, "customerPanel");
        mainPanel.add(adminPanel, "AdminPanel");
        mainPanel.add(profileView, "Profile");
        mainPanel.add(profileUpdate, "Profile update");
        mainPanel.add(adminProfileVi, "AdminProfileView");
        mainPanel.add(adminprofileUp, "AdminProfileUpdate");
        mainPanel.add(paymentEPost, "paymentEPost");
        mainPanel.add(paymentParcel, "paymentParcel");
        mainPanel.add(moneyOrder, "money order");
        mainPanel.add(deliveryPanel, "deliveryPanel");
        mainPanel.add(deliveryProfileView, "deliveryProfileView");
        mainPanel.add(deliveryProfileUpdate, "deliveryProfileUpdate");
        mainPanel.add(ADeliveryProfile, "AdminDeliveryprofile");
        mainPanel.add(ACustomerProfile, "ACustomerProfile");

        //Adding components to CardLayout 
        card.first(mainPanel);

        JScrollPane scroll = new JScrollPane(mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 0, 2000, 1000);
        this.add(scroll);
        this.pack();
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("E-Post");
        Front.execute();
    }

    //Function to Switch Page
    static public void switchPage(String pageName) {
        card.show(mainPanel, pageName);
    }

    //Main Function
    public static void main(String[] args) {
        new main();
    }

}
