package customer.DatasForCustomer;

import java.util.*;

//Setters and Getters For Encapsulation
public class InboxData {

    //private
    public static ArrayList<InboxData> ListForInbox;
    private String message_ID;
    private String message;
    private String sender_name;
    private String receiver_name;
    private String sent_Date;
    private String time;
    private String customer_Id;
    private String receiver_Id;
    private String subject;

    static {
        ListForInbox = new ArrayList<InboxData>();

    }

    public static ArrayList getListForInbox() {
        return ListForInbox;
    }

    public String getMessage_ID() {
        return message_ID;
    }

    public void setMessage_ID(String message_ID) {
        this.message_ID = message_ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receover_name) {
        this.receiver_name = receiver_name;
    }

    public String getSent_Date() {
        return sent_Date;
    }

    public void setSent_Date(String sent_Date) {
        this.sent_Date = sent_Date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getReceiver_Id() {
        return receiver_Id;
    }

    public void setReceiver_Id(String receiver_Id) {
        this.receiver_Id = receiver_Id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
