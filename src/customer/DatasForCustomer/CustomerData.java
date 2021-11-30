package customer.DatasForCustomer;

import java.sql.Date;

//Setters and Getters For Encapsulation
public class CustomerData {

    //private
    private String customer_ID;
    private String first_name;
    private String last_name;
    private Date dob;
    private int age;
    private int contact_number;
    private String gender;
    private String address;
    private String state;
    private String district;
    private int pin_code;
    private float bank_balance;
    private int account_number;

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the pin_code
     */
    public int getPin_code() {
        return pin_code;
    }

    /**
     * @param pin_code the pin_code to set
     */
    public void setPin_code(int pin_code) {
        this.pin_code = pin_code;
    }

    /**
     * @return the bank_balance
     */
    public float getBank_balance() {
        return bank_balance;
    }

    /**
     * @param bank_balance the bank_balance to set
     */
    public void setBank_balance(float bank_balance) {
        this.bank_balance = bank_balance;
    }

    /**
     * @return the account_number
     */
    public int getAccount_number() {
        return account_number;
    }

    /**
     * @param account_number the account_number to set
     */
    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }
}
