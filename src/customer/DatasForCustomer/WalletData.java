package customer.DatasForCustomer;

import java.util.ArrayList;

//Setters and Getters For Encapsulation
public class WalletData {

    //public
    public static ArrayList<String> MoneyOrderValues = new ArrayList<String>();
    public static ArrayList<WalletData> ListForWalletInfo;
    //private
    private String transactionid;
    private String beneficiary;
    private String customerid;
    private String recieverid;
    private String firstname;
    private String lastname;
    private String transactiontype;
    private String transactiondate;
    private String senderaccountnumber;
    private String receiveraccountnumber;
    private String amount;
    private String recievername;
    private String balance;

    static {
        ListForWalletInfo = new ArrayList<>();
    }

    public static ArrayList<WalletData> getListForWalletInfo() {
        return ListForWalletInfo;
    }

    public static void setListForWalletInfo(ArrayList<WalletData> ListForWalletInfo) {
        WalletData.ListForWalletInfo = ListForWalletInfo;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getRecieverid() {
        return recieverid;
    }

    public void setRecieverid(String recieverid) {
        this.recieverid = recieverid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }

    public String getSenderaccountnumber() {
        return senderaccountnumber;
    }

    public void setSenderaccountnumber(String senderaccountnumber) {
        this.senderaccountnumber = senderaccountnumber;
    }

    public String getReceiveraccountnumber() {
        return receiveraccountnumber;
    }

    public void setReceiveraccountnumber(String receiveraccountnumber) {
        this.receiveraccountnumber = receiveraccountnumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRecievername() {
        return recievername;
    }

    public void setRecievername(String recievername) {
        this.recievername = recievername;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
