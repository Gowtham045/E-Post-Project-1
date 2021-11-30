package profile;

import Admin.AdminCustomerProfile;
import Admin.customerDetails;
import Database.DatabaseOperations;
import java.sql.Date;
import java.util.ArrayList;
//Customer Object Class

public class CustomerProfile {

    private int age;
    private String id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String contactNumber;
    private String gender;
    private String address;
    private String state;
    private String district;
    private String pinCode;
    private String bankBalance;
    private String accountNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(String bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //Function to set CustomerDetails table in admin     
    public static void setCustomerDetails() {

        customerDetails.customerDetailsTable.getSelectionModel().clearSelection();

        while (customerDetails.customermodel.getRowCount() > 0) {
            customerDetails.customermodel.removeRow(0);
        }

        ArrayList<CustomerProfile> listForDeliveryConsignment = DatabaseOperations.getCustomerDetails();
        for (int i = 0; i < listForDeliveryConsignment.size(); i++) {
            CustomerProfile temp = listForDeliveryConsignment.get(i);
            customerDetails.customermodel.addRow(new Object[]{temp.getId(), temp.getFirstName(), temp.getLastName(), temp.getDob(), temp.getAge(), temp.getContactNumber(), temp.getGender(), temp.getBankBalance()});
        }
    }

    //Function to set Customer profile in Admin
    public static void setCustomerProfile(String id) {
        CustomerProfile details = DatabaseOperations.getCustomerProfile(id);

        AdminCustomerProfile.CustomerIDValue.setText(details.getId());
        AdminCustomerProfile.FirstNameValue.setText(details.getFirstName());
        AdminCustomerProfile.LastNameValue.setText(details.getLastName());
        AdminCustomerProfile.DOBValue.setText(details.getDob().toString());
        AdminCustomerProfile.AgeValue.setText(Integer.toString(details.getAge()));
        AdminCustomerProfile.ContactNumberValue.setText(details.getContactNumber());
        AdminCustomerProfile.GenderValue.setText(details.getGender());
        AdminCustomerProfile.AddressValue.setText(details.getAddress());
        AdminCustomerProfile.BankBalanceValue.setText(details.getBankBalance());
        AdminCustomerProfile.AccountNumberValue.setText(details.getAccountNumber());
        AdminCustomerProfile.UserNameTop.setText(details.getFirstName() + " " + details.getLastName());

    }

}
