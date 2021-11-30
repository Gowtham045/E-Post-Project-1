package customer;

import Admin.FancyprogressBar;
import customer.DatasForCustomer.ConsignmentData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

class ConsignmentDetails extends JPanel implements ActionListener {

    //Public
    public static JProgressBar pick_transit, order_pick, transit_complete;
    public static JLabel order, pick, transit, complete;
    
    //private Label
    private JLabel consignDetail, item, itemPrice, itemWeight, itemCode, agentId, orderDate, deliverDate, payment, status;
    private JLabel billingDetail, senderId, seFirstName, seLastName, seConstact, seAddress;
    private JLabel shipDetails, receId, receFirstName, receLastName, receContact, receAdress;
    private JLabel vItem, vItemPrice, vItemWeight, vItemCode, vAgentId, vOrderDate, vDeliverDate, vPayment, vStatus;
    private JLabel vSenderId, vSeFirstName, vSeLastName, vSeConstact;
    private JLabel vReceId, vReceFirstName, vReceLastName, vReceContact;
    private JTextArea vReceAdress, vSeAddress;
    //icon
    private Icon icon;
    //Back button
    private JButton back;
    //Panel
    private JPanel details;
    //Color
    private static Color bg = new Color(34, 34, 45);
    private static Color fg = new Color(254, 254, 254);
    private static Color pri = new Color(71, 63, 145);

    public ConsignmentDetails() {
        //Object For Panel
        details = new JPanel(null);
        details.setBackground(fg);
        details.setPreferredSize(new Dimension(1260, 590));

        //Font
        Font font = new Font("Segoe UI", Font.BOLD, 22);
        Font fon = new Font("Segoe UI", Font.PLAIN, 18);
        icon = new ImageIcon(getClass().getResource("/Images/back.png"));

        //back Button
        back = new JButton(icon);
        back.setBounds(10, 10, 30, 30);
        back.setBackground(fg);
        back.setBorder(null);
        back.addActionListener(this);
        details.add(back);

        //Objects For Label
        consignDetail = new JLabel("Consignment Details");
        consignDetail.setFont(font);
        item = new JLabel("Item             :");
        item.setFont(fon);
        itemPrice = new JLabel("ItemPrice      :");
        itemPrice.setFont(fon);
        itemWeight = new JLabel("Item Weight  :");
        itemWeight.setFont(fon);
        itemCode = new JLabel("Item Code   :");
        itemCode.setFont(fon);
        agentId = new JLabel("Agent ID      :");
        agentId.setFont(fon);
        orderDate = new JLabel("Order Date  :");
        orderDate.setFont(fon);
        deliverDate = new JLabel("Delivery Date  :");
        deliverDate.setFont(fon);
        payment = new JLabel("Payment         :");
        payment.setFont(fon);
        status = new JLabel("Status            :");
        status.setFont(fon);

        vItem = new JLabel("E Post");
        vItem.setFont(fon);
        vItemPrice = new JLabel("5");
        vItemPrice.setFont(fon);
        vItemWeight = new JLabel("5 g");
        vItemWeight.setFont(fon);
        vItemCode = new JLabel("!@#$%");
        vItemCode.setFont(fon);
        vAgentId = new JLabel("12345");
        vAgentId.setFont(fon);
        vOrderDate = new JLabel("29.09.2001");
        vOrderDate.setFont(fon);
        vDeliverDate = new JLabel("29.09.2021");
        vDeliverDate.setFont(fon);
        vPayment = new JLabel("E PAY");
        vPayment.setFont(fon);
        vStatus = new JLabel("Delivered");
        vStatus.setFont(fon);

        billingDetail = new JLabel("Billing Details");
        billingDetail.setFont(font);
        senderId = new JLabel("Sender ID          :");
        senderId.setFont(fon);
        seFirstName = new JLabel("First Name         :");
        seFirstName.setFont(fon);
        seLastName = new JLabel("Last Name         :");
        seLastName.setFont(fon);
        seConstact = new JLabel("Contact Number :");
        seConstact.setFont(fon);
        seAddress = new JLabel("Address            :");
        seAddress.setFont(fon);

        //value Label
        vSenderId = new JLabel("1223241");
        vSenderId.setFont(fon);
        vSeFirstName = new JLabel("Keshav");
        vSeFirstName.setFont(fon);
        vSeLastName = new JLabel("B");
        vSeLastName.setFont(fon);
        vSeConstact = new JLabel("8754275064");
        vSeConstact.setFont(fon);

        vSeAddress = new JTextArea();
        vSeAddress.setFont(fon);
        vSeAddress.setLineWrap(true);
        vSeAddress.setWrapStyleWord(true);
        vSeAddress.setEditable(false);

        vReceAdress = new JTextArea();
        vReceAdress.setFont(fon);
        vReceAdress.setLineWrap(true);
        vReceAdress.setWrapStyleWord(true);
        vReceAdress.setEditable(false);

        shipDetails = new JLabel("Shipping Details");
        shipDetails.setFont(font);
        receId = new JLabel("Reciever ID       :");
        receId.setFont(fon);
        receFirstName = new JLabel("First Name         :");
        receFirstName.setFont(fon);
        receLastName = new JLabel("Last Name         :");
        receLastName.setFont(fon);
        receContact = new JLabel("Contact Number :");
        receContact.setFont(fon);
        receAdress = new JLabel("Address            :");
        receAdress.setFont(fon);

        vReceId = new JLabel("12345");
        vReceId.setFont(fon);
        vReceFirstName = new JLabel("Arvind");
        vReceFirstName.setFont(fon);
        vReceLastName = new JLabel("M");
        vReceLastName.setFont(fon);
        vReceContact = new JLabel("123456789");
        vReceContact.setFont(fon);

        //setBounds
        consignDetail.setBounds(80, 40, 240, 40);
        item.setBounds(100, 80, 200, 40);
        itemPrice.setBounds(100, 120, 240, 40);
        itemWeight.setBounds(100, 160, 240, 40);
        itemCode.setBounds(500, 80, 240, 40);
        agentId.setBounds(500, 120, 240, 40);
        orderDate.setBounds(500, 160, 240, 40);
        deliverDate.setBounds(930, 80, 240, 40);
        payment.setBounds(930, 120, 240, 40);
        status.setBounds(930, 160, 240, 40);

        vItem.setBounds(220, 80, 240, 40);
        vItemPrice.setBounds(220, 120, 240, 40);
        vItemWeight.setBounds(220, 160, 240, 40);
        vItemCode.setBounds(650, 80, 240, 40);
        vAgentId.setBounds(650, 120, 240, 40);
        vOrderDate.setBounds(650, 160, 240, 40);
        vDeliverDate.setBounds(1080, 80, 240, 40);
        vPayment.setBounds(1080, 120, 240, 40);
        vStatus.setBounds(1080, 160, 240, 40);

        billingDetail.setBounds(80, 210, 240, 40);
        senderId.setBounds(100, 250, 240, 40);
        seFirstName.setBounds(100, 290, 240, 40);
        seLastName.setBounds(100, 330, 240, 40);
        seConstact.setBounds(100, 370, 240, 40);
        seAddress.setBounds(100, 410, 240, 40);

        vSenderId.setBounds(270, 250, 240, 40);
        vSeFirstName.setBounds(270, 290, 240, 40);
        vSeLastName.setBounds(270, 330, 240, 40);
        vSeConstact.setBounds(270, 370, 240, 40);
        vSeAddress.setBounds(270, 420, 350, 80);

        shipDetails.setBounds(660, 210, 240, 40);
        receId.setBounds(680, 250, 240, 40);
        receFirstName.setBounds(680, 290, 240, 40);
        receLastName.setBounds(680, 330, 240, 40);
        receContact.setBounds(680, 370, 240, 40);
        receAdress.setBounds(680, 410, 240, 40);

        vReceId.setBounds(840, 250, 240, 40);
        vReceFirstName.setBounds(840, 290, 240, 40);
        vReceLastName.setBounds(840, 330, 240, 40);
        vReceContact.setBounds(840, 370, 240, 40);
        vReceAdress.setBounds(840, 420, 350, 80);

        //adding Component
        details.add(vItem);
        details.add(vItemCode);
        details.add(vItemPrice);
        details.add(vItemWeight);
        details.add(vAgentId);
        details.add(vOrderDate);
        details.add(vDeliverDate);
        details.add(vPayment);
        details.add(vStatus);

        details.add(vSenderId);
        details.add(vSeFirstName);
        details.add(vSeLastName);
        details.add(vSeConstact);
        details.add(vSeAddress);

        details.add(vReceId);
        details.add(vReceFirstName);
        details.add(vReceLastName);
        details.add(vReceContact);
        details.add(vReceAdress);

        details.add(shipDetails);
        details.add(receId);
        details.add(receFirstName);
        details.add(receLastName);
        details.add(receContact);
        details.add(receAdress);

        details.add(billingDetail);
        details.add(senderId);
        details.add(seFirstName);
        details.add(seLastName);
        details.add(seConstact);
        details.add(seAddress);

        details.add(item);
        details.add(itemPrice);
        details.add(itemWeight);
        details.add(itemCode);
        details.add(agentId);
        details.add(orderDate);
        details.add(deliverDate);
        details.add(payment);
        details.add(status);
        details.add(consignDetail);
        
        order_pick = new JProgressBar();
        order_pick.setBounds(180, 550, 300, 15);
        order_pick.setBackground(pri);
        order_pick.setForeground(bg);
        order_pick.setUI(new FancyprogressBar());
        order_pick.setMaximum(100);
        order_pick.setValue(100);
        details.add(order_pick);

        pick_transit = new JProgressBar();
        pick_transit.setBounds(300 + 180, 550, 300, 15);
        pick_transit.setForeground(bg);
        pick_transit.setUI(new FancyprogressBar());
        pick_transit.setBackground(pri);
        pick_transit.setMaximum(100);
        pick_transit.setMinimum(100);
        details.add(pick_transit);

        transit_complete = new JProgressBar();
        transit_complete.setBounds(300 + 180 + 300, 550, 300, 15);
        transit_complete.setForeground(fg);
        transit_complete.setUI(new FancyprogressBar());
        transit_complete.setBackground(pri);
        transit_complete.setMaximum(100);
        transit_complete.setMinimum(0);
        details.add(transit_complete);

        order = new JLabel("Order Placed");
        order.setBounds(130, 520, 200, 30);
        order.setFont(font);
        order.setForeground(bg);
        details.add(order);

        pick = new JLabel("Picked-Up");
        pick.setBounds(130 + 300, 520, 200, 30);
        pick.setFont(font);
        pick.setForeground(bg);
        details.add(pick);

        transit = new JLabel("In-Transit");
        transit.setBounds(130 + 300 + 300, 520, 200, 30);
        transit.setFont(font);
        transit.setForeground(bg);
        details.add(transit);

        complete = new JLabel("Completed");
        complete.setBounds(130 + 300 + 300 + 300, 520, 200, 30);
        complete.setFont(font);
        complete.setForeground(bg);
        details.add(complete);

        JScrollPane scroll = new JScrollPane(details);
        scroll.setPreferredSize(new Dimension(1260, 570));
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);

        this.add(scroll);

    }
    //Funtion to set the progress bar
    public static void setProgress(String s) {
        if (s.equals("Order Placed") || s.equals("In-Order")) {
            order_pick.setBackground(pri);
            order_pick.setForeground(fg);
            order_pick.setValue(0);
            pick_transit.setBackground(fg);
            pick_transit.setForeground(fg);
            pick_transit.setValue(0);
            transit_complete.setBackground(fg);
            transit_complete.setForeground(fg);
            transit_complete.setValue(0);
            order.setForeground(pri);
            pick.setForeground(fg);
            transit.setForeground(fg);
            complete.setForeground(fg);
        } else if (s.equals("PickedUp")) {
            order_pick.setBackground(pri);
            order_pick.setForeground(pri);
            order_pick.setValue(100);
            pick_transit.setBackground(pri);
            pick_transit.setForeground(pri);
            pick_transit.setValue(0);
            transit_complete.setBackground(pri);
            transit_complete.setForeground(fg);
            transit_complete.setValue(0);
            order.setForeground(pri);
            pick.setForeground(pri);
            transit.setForeground(fg);
            complete.setForeground(fg);
        } else if (s.equals("In-Transit")) {
            order_pick.setBackground(pri);
            order_pick.setForeground(pri);
            order_pick.setValue(100);
            pick_transit.setBackground(pri);
            pick_transit.setForeground(pri);
            pick_transit.setValue(100);
            transit_complete.setBackground(pri);
            transit_complete.setForeground(fg);
            transit_complete.setValue(0);
            order.setForeground(pri);
            pick.setForeground(pri);
            transit.setForeground(pri);
            complete.setForeground(fg);
        } else if (s.equals("Completed")) {
            order_pick.setBackground(pri);
            order_pick.setForeground(pri);
            order_pick.setValue(100);
            pick_transit.setBackground(pri);
            pick_transit.setForeground(pri);
            pick_transit.setValue(100);
            transit_complete.setBackground(pri);
            transit_complete.setForeground(pri);
            transit_complete.setValue(100);
            order.setForeground(pri);
            pick.setForeground(pri);
            transit.setForeground(pri);
            complete.setForeground(pri);
        }

    }

    //set ConignmentDetails in Conignment Panel
    public void setConignmentDetails(int Index) {
        ConsignmentData Data = ConsignmentData.listForConsignment.get(Index);
        vSenderId.setText(Data.getCustomer_ID());
        vSeFirstName.setText(Data.getCustomer_first_name());
        vSeLastName.setText(Data.getCustomer_last_name());
        vSeConstact.setText(Data.getCustomer_contact_number().toString());
        vSeAddress.setText(Data.getShipping_address().toString());
        vReceId.setText(Data.getReceiver_ID());
        vReceFirstName.setText(Data.getReceiver_first_name());
        vReceLastName.setText(Data.getReceiver_last_name());
        vReceContact.setText(Data.getReceiver_contact_number().toString());
        vReceAdress.setText(Data.getReceiver_address());
        vItem.setText(Data.getItem());
        vItemPrice.setText(Data.getItem_price().toString());
        vItemWeight.setText(Data.getItem_weight().toString());
        vItemCode.setText(Data.getItem_code());
        vAgentId.setText(Data.getDelivery_ID());
        vOrderDate.setText(Data.getOrder_date().toString());
        vDeliverDate.setText(Data.getDelivery_date().toString());
        vPayment.setText(Data.getPayment_method());
        vStatus.setText(Data.getStatus());
        setProgress(Data.getStatus());

    }

    //Action Listener for Back Button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ConsignmentData.isIsUpdate()) {

            CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer, "Consignment");
        } else {

            CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer, "update");
        }
    }

}
