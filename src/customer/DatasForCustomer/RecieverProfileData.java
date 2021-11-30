package customer.DatasForCustomer;

import java.sql.Date;

//Setters and Getters For Encapsulation
public class RecieverProfileData {

    //private
    private static String id;
    private static String firstName;
    private static String lastName;
    private static Date dob;
    private static int age;
    private static String contactNumber;
    private static String gender;
    private static String address;
    private static String state;
    private static String district;
    private static String pinCode;
    private static String bankBalance;
    private static String accountNumber;

    public static String getId() {
        return id;
    }

    public static void setId(String aId) {
        id = aId;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String aLastName) {
        lastName = aLastName;
    }

    public static Date getDob() {
        return dob;
    }

    public static void setDob(Date aDob) {
        dob = aDob;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int aAge) {
        age = aAge;
    }

    public static String getContactNumber() {
        return contactNumber;
    }

    public static void setContactNumber(String aContactNumber) {
        contactNumber = aContactNumber;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String aGender) {
        gender = aGender;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String aAddress) {
        address = aAddress;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String aState) {
        state = aState;
    }

    public static String getDistrict() {
        return district;
    }

    public static void setDistrict(String aDistrict) {
        district = aDistrict;
    }

    public static String getPinCode() {
        return pinCode;
    }

    public static void setPinCode(String aPinCode) {
        pinCode = aPinCode;
    }

    public static String getBankBalance() {
        return bankBalance;
    }

    public static void setBankBalance(String aBankBalance) {
        bankBalance = aBankBalance;
    }

    public static String getAccountNumber() {
        return accountNumber;
    }

    public static void setAccountNumber(String aAccountNumber) {
        accountNumber = aAccountNumber;
    }

}
