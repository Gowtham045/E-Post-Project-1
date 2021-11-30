package Consignment;

import Admin.OnGoingConsignment;
import Admin.CompletedConsignment;
import Admin.ConsignmentDetails;
import Admin.NewConsignment;
import Database.DatabaseOperations;
import Delivery.DeliveryConsignment;
import Delivery.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class consignment {

    //Private Variables
    private String consignment_ID;
    private String customer_ID;
    private String delivery_ID;
    private String receiver_ID;
    private String item_code;
    private String item;
    private Float item_price;
    private Float item_weight;
    private String receiver_first_name;
    private String receiver_last_name;
    private String receiver_address;
    private Long receiver_contact_number;
    private String customer_first_name;
    private String customer_last_name;
    private Long customer_contact_number;
    private String shipping_address;
    private String payment_method;
    private java.sql.Date order_date;
    private java.sql.Date delivery_date;
    private String status;

    //Set Consignment ID
    public void setConsignment_ID(String consignment_ID) {
        this.consignment_ID = consignment_ID;
    }

    //get Consignment ID
    public String getConsignment_ID() {
        return consignment_ID;
    }

    //get customer ID
    public String getCustomer_ID() {
        return customer_ID;
    }

    //Set Customer ID
    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    //get Delivery ID
    public String getDelivery_ID() {
        return delivery_ID;
    }

    /**
     * @param delivery_ID the delivery_ID to set
     */
    public void setDelivery_ID(String delivery_ID) {
        this.delivery_ID = delivery_ID;
    }

    /**
     * @return the receiver_ID
     */
    public String getReceiver_ID() {
        return receiver_ID;
    }

    /**
     * @param receiver_ID the receiver_ID to set
     */
    public void setReceiver_ID(String receiver_ID) {
        this.receiver_ID = receiver_ID;
    }

    /**
     * @return the item_code
     */
    public String getItem_code() {
        return item_code;
    }

    /**
     * @param item_code the item_code to set
     */
    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the item_price
     */
    public Float getItem_price() {
        return item_price;
    }

    /**
     * @param item_price the item_price to set
     */
    public void setItem_price(Float item_price) {
        this.item_price = item_price;
    }

    /**
     * @return the item_weight
     */
    public Float getItem_weight() {
        return item_weight;
    }

    /**
     * @param item_weight the item_weight to set
     */
    public void setItem_weight(Float item_weight) {
        this.item_weight = item_weight;
    }

    /**
     * @return the receiver_first_name
     */
    public String getReceiver_first_name() {
        return receiver_first_name;
    }

    /**
     * @param receiver_first_name the receiver_first_name to set
     */
    public void setReceiver_first_name(String receiver_first_name) {
        this.receiver_first_name = receiver_first_name;
    }

    /**
     * @return the receiver_last_name
     */
    public String getReceiver_last_name() {
        return receiver_last_name;
    }

    /**
     * @param receiver_last_name the receiver_last_name to set
     */
    public void setReceiver_last_name(String receiver_last_name) {
        this.receiver_last_name = receiver_last_name;
    }

    /**
     * @return the receiver_address
     */
    public String getReceiver_address() {
        return receiver_address;
    }

    /**
     * @param receiver_address the receiver_address to set
     */
    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    /**
     * @return the receiver_contact_number
     */
    public Long getReceiver_contact_number() {
        return receiver_contact_number;
    }

    /**
     * @param receiver_contact_number the receiver_contact_number to set
     */
    public void setReceiver_contact_number(Long receiver_contact_number) {
        this.receiver_contact_number = receiver_contact_number;
    }

    /**
     * @return the customer_first_name
     */
    public String getCustomer_first_name() {
        return customer_first_name;
    }

    /**
     * @param customer_first_name the customer_first_name to set
     */
    public void setCustomer_first_name(String customer_first_name) {
        this.customer_first_name = customer_first_name;
    }

    /**
     * @return the customer_last_name
     */
    public String getCustomer_last_name() {
        return customer_last_name;
    }

    /**
     * @param customer_last_name the customer_last_name to set
     */
    public void setCustomer_last_name(String customer_last_name) {
        this.customer_last_name = customer_last_name;
    }

    /**
     * @return the customer_contact_number
     */
    public Long getCustomer_contact_number() {
        return customer_contact_number;
    }

    /**
     * @param customer_contact_number the customer_contact_number to set
     */
    public void setCustomer_contact_number(Long customer_contact_number) {
        this.customer_contact_number = customer_contact_number;
    }

    /**
     * @return the shipping_address
     */
    public String getShipping_address() {
        return shipping_address;
    }

    /**
     * @param shipping_address the shipping_address to set
     */
    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    /**
     * @return the payment_method
     */
    public String getPayment_method() {
        return payment_method;
    }

    /**
     * @param payment_method the payment_method to set
     */
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    /**
     * @return the order_date
     */
    public java.sql.Date getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(java.sql.Date order_date) {
        this.order_date = order_date;
    }

    /**
     * @return the delivery_date
     */
    public java.sql.Date getDelivery_date() {
        return delivery_date;
    }

    /**
     * @param delivery_date the delivery_date to set
     */
    public void setDelivery_date(java.sql.Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    //function to set all the values for consignment in Consignment page for Admin
    public static void setConsignmentDetails(String id) {
        consignment details = DatabaseOperations.getConsignmentDetails(id);
        ConsignmentDetails.vConsignDetail.setText(details.getConsignment_ID());
        ConsignmentDetails.vItem.setText(details.getItem());
        ConsignmentDetails.vItemPrice.setText(Float.toString(details.getItem_price()));
        ConsignmentDetails.vItemWeight.setText(Float.toString(details.getItem_weight()));
        ConsignmentDetails.vItemCode.setText(details.getItem_code());
        ConsignmentDetails.vAgentId.setText(details.getDelivery_ID());
        ConsignmentDetails.vOrderDate.setText(details.getOrder_date().toString());
        ConsignmentDetails.vDeliverDate.setText(details.getDelivery_date().toString());
        ConsignmentDetails.vPayment.setText(details.getPayment_method());
        ConsignmentDetails.vStatus.setText(details.getStatus());
        ConsignmentDetails.vSenderId.setText(details.getCustomer_ID());
        ConsignmentDetails.vSeFirstName.setText(details.getCustomer_first_name());
        ConsignmentDetails.vSeLastName.setText(details.getCustomer_last_name());
        ConsignmentDetails.vSeConstact.setText(details.getCustomer_contact_number().toString());
        ConsignmentDetails.vSeAddress.setText(details.getShipping_address());
        ConsignmentDetails.vReceId.setText(details.getReceiver_ID());
        ConsignmentDetails.vReceFirstName.setText(details.getReceiver_first_name());
        ConsignmentDetails.vReceLastName.setText(details.getReceiver_last_name());
        ConsignmentDetails.vReceContact.setText(details.getReceiver_contact_number().toString());
        ConsignmentDetails.vReceAdress.setText(details.getReceiver_address());
        ConsignmentDetails.setProgress(details.getStatus());
    }

    //function to set all the values for consignment in Consignment page for Delivery
    public static void setDeliveryConsignmentDetails(String id) {

        consignment details = DatabaseOperations.getConsignmentDetails(id);
        DeliveryConsignment.vConsignDetail.setText(details.getConsignment_ID());
        DeliveryConsignment.vItem.setText(details.getItem());
        DeliveryConsignment.vItemPrice.setText(Float.toString(details.getItem_price()));
        DeliveryConsignment.vItemWeight.setText(Float.toString(details.getItem_weight()));
        DeliveryConsignment.vItemCode.setText(details.getItem_code());
        DeliveryConsignment.vAgentId.setText(details.getDelivery_ID());
        DeliveryConsignment.vOrderDate.setText(details.getOrder_date().toString());
        DeliveryConsignment.vDeliverDate.setText(details.getDelivery_date().toString());
        DeliveryConsignment.vPayment.setText(details.getPayment_method());
        DeliveryConsignment.vStatus.setText(details.getStatus());
        DeliveryConsignment.vSenderId.setText(details.getCustomer_ID());
        DeliveryConsignment.vSeFirstName.setText(details.getCustomer_first_name());
        DeliveryConsignment.vSeLastName.setText(details.getCustomer_last_name());
        DeliveryConsignment.vSeConstact.setText(details.getCustomer_contact_number().toString());
        DeliveryConsignment.vSeAddress.setText(details.getShipping_address());
        DeliveryConsignment.vReceId.setText(details.getReceiver_ID());
        DeliveryConsignment.vReceFirstName.setText(details.getReceiver_first_name());
        DeliveryConsignment.vReceLastName.setText(details.getReceiver_last_name());
        DeliveryConsignment.vReceContact.setText(details.getReceiver_contact_number().toString());
        DeliveryConsignment.vReceAdress.setText(details.getReceiver_address());
        DeliveryConsignment.setProgress(details.getStatus());
    }

    //Function to set the values for the table in Ongoing consignment page
    public static void setOngoingAdminConsignmentDetails() {

        OnGoingConsignment.table.getSelectionModel().clearSelection();

        while (OnGoingConsignment.model.getRowCount() > 0) {
            OnGoingConsignment.model.removeRow(0);

        }

        ArrayList<consignment> listForDeliveryConsignment = DatabaseOperations.getOngoingAdminConsignmentDetails();
        for (int i = 0; i < listForDeliveryConsignment.size(); i++) {
            consignment temp = listForDeliveryConsignment.get(i);
            OnGoingConsignment.model.addRow(new Object[]{temp.getConsignment_ID(), temp.getCustomer_ID(), temp.getReceiver_ID(), temp.getItem(), temp.getDelivery_ID(), temp.getPayment_method(), temp.getDelivery_date(), temp.getStatus()});
        }

    }

    //Function to set values for the table in  completed Consignment page
    public static void setCompletedAdminConsignmentDetails() {
        CompletedConsignment.table.getSelectionModel().clearSelection();

        while (CompletedConsignment.model.getRowCount() > 0) {
            CompletedConsignment.model.removeRow(0);

        }

        ArrayList<consignment> listForDeliveryConsignment = DatabaseOperations.getCompletedAdminConsignmentDetails();
        for (int i = 0; i < listForDeliveryConsignment.size(); i++) {
            consignment temp = listForDeliveryConsignment.get(i);
            CompletedConsignment.model.addRow(new Object[]{temp.getConsignment_ID(), temp.getCustomer_ID(), temp.getReceiver_ID(), temp.getItem(), temp.getDelivery_ID(), temp.getPayment_method(), temp.getDelivery_date(), temp.getStatus()});
        }
    }

    //Function to set values for the table in  new  Consignment page
    public static void setNewdAdminConsignmentDetails() {
        NewConsignment.table.getSelectionModel().clearSelection();

        while (NewConsignment.newModel.getRowCount() > 0) {
            NewConsignment.newModel.removeRow(0);

        }

        ArrayList<consignment> listForDeliveryConsignment = DatabaseOperations.getNewAdminConsignmentDetails();
        for (int i = 0; i < listForDeliveryConsignment.size(); i++) {
            consignment temp = listForDeliveryConsignment.get(i);
            NewConsignment.newModel.addRow(new Object[]{temp.getConsignment_ID(), temp.getCustomer_ID(), temp.getReceiver_ID(), temp.getItem(), "", temp.getPayment_method(), temp.getDelivery_date(), temp.getStatus()});

        }
    }

    //Function to set values for the table in delivery ongoing page 
    public static void setOngoingDeliveryConsignmentDetails() {
        ongoing.table.getSelectionModel().clearSelection();
        DefaultTableModel dm = (DefaultTableModel) ongoing.table.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();;
        ArrayList<consignment> listForDeliveryConsignment = DatabaseOperations.getOnGoingDeliveryConsignmentDetails();
        for (int i = 0; i < listForDeliveryConsignment.size(); i++) {
            consignment temp = listForDeliveryConsignment.get(i);
            ongoing.model.addRow(new Object[]{temp.getConsignment_ID(), temp.getCustomer_ID(), temp.getReceiver_ID(), temp.getItem(), temp.getDelivery_ID(), temp.getPayment_method(), temp.getDelivery_date(), temp.getStatus()});
        }
    }

    //Function to set Values for the table in delivery Completed page
    public static void setCompletedDeliveryConsignmentDetails() {
        while (completed.model1.getRowCount() > 0) {
            completed.model1.removeRow(0);
        }
        ArrayList<consignment> listForCompletedDeliveryConsignment = DatabaseOperations.getCompletedDeliveryConsignmentDetails();
        for (int i = 0; i < listForCompletedDeliveryConsignment.size(); i++) {
            consignment temp1 = listForCompletedDeliveryConsignment.get(i);
            completed.model1.addRow(new Object[]{temp1.getConsignment_ID(), temp1.getCustomer_ID(), temp1.getReceiver_ID(), temp1.getItem(), temp1.getDelivery_ID(), temp1.getPayment_method(), temp1.getDelivery_date(), temp1.getStatus()});
        }
    }
}
