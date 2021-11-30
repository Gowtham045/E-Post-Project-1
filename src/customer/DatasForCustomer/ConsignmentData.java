package customer.DatasForCustomer;

import java.sql.Date;
import java.util.*;
//Setters and Getters For Encapsulation

public class ConsignmentData {

    //public
    public static ArrayList<ConsignmentData> listForConsignment;
    //private
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
    private Date order_date;
    private Date delivery_date;
    private String status;
    private static boolean isUpdate;

    static {
        listForConsignment = new ArrayList<ConsignmentData>();
    }

    public static boolean isIsUpdate() {
        return isUpdate;
    }

    public static void setIsUpdate(boolean isUpdate) {
        ConsignmentData.isUpdate = isUpdate;
    }

    public static ArrayList getListForConsignment() {
        return listForConsignment;
    }

    public static void setListForConsignment(ArrayList aListForConsignment) {
        listForConsignment = aListForConsignment;
    }

    public String getConsignment_ID() {
        return consignment_ID;
    }

    /**
     * @param consignment_ID the consignment_ID to set
     */
    public void setConsignment_ID(String consignment_ID) {
        this.consignment_ID = consignment_ID;
    }

    /**
     * @return the customer_ID
     */
    public String getCustomer_ID() {
        return customer_ID;
    }

    /**
     * @param customer_ID the customer_ID to set
     */
    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    /**
     * @return the delivery_ID
     */
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
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    /**
     * @return the delivery_date
     */
    public Date getDelivery_date() {
        return delivery_date;
    }

    /**
     * @param delivery_date the delivery_date to set
     */
    public void setDelivery_date(Date delivery_date) {
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

}
