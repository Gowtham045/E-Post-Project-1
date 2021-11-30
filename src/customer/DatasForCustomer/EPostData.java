package customer.DatasForCustomer;
//Setters and Getters For Encapsulation

public class EPostData {

    //private
    private static String To;
    private static String FirstName;
    private static String LastName;
    private static String Address;
    private static String State;
    private static String District;
    private static String Pincode;
    private static Long PhoneNumber;
    private static String Subject;
    private static String Message;
    private static boolean SoftCopy;
    private static boolean HardCopy;
    private static boolean isPasswordCorrect;

    public static String getTo() {
        return To;
    }

    public static void setTo(String aTo) {
        To = aTo;
    }

    public static String getFirstName() {
        return FirstName;
    }

    public static void setFirstName(String aFirstName) {
        FirstName = aFirstName;
    }

    public static String getLastName() {
        return LastName;
    }

    public static void setLastName(String aLastName) {
        LastName = aLastName;
    }

    public static String getAddress() {
        return Address;
    }

    public static void setAddress(String aAddress) {
        Address = aAddress;
    }

    public static String getState() {
        return State;
    }

    public static void setState(String aState) {
        State = aState;
    }

    public static String getDistrict() {
        return District;
    }

    public static void setDistrict(String aDistrict) {
        District = aDistrict;
    }

    public static String getPincode() {
        return Pincode;
    }

    public static void setPincode(String aPincode) {
        Pincode = aPincode;
    }

    public static Long getPhoneNumber() {
        return PhoneNumber;
    }

    public static void setPhoneNumber(Long aPhoneNumber) {
        PhoneNumber = aPhoneNumber;
    }

    public static String getSubject() {
        return Subject;
    }

    public static void setSubject(String aSubject) {
        Subject = aSubject;
    }

    public static String getMessage() {
        return Message;
    }

    public static void setMessage(String aMessage) {
        Message = aMessage;
    }

    public static boolean isSoftCopy() {
        return SoftCopy;
    }

    public static void setSoftCopy(boolean aSoftCopy) {
        SoftCopy = aSoftCopy;
    }

    public static boolean isHardCopy() {
        return HardCopy;
    }

    public static void setHardCopy(boolean aHardCopy) {
        HardCopy = aHardCopy;
    }

    public static boolean isIsPasswordCorrect() {
        return isPasswordCorrect;
    }

    public static void setIsPasswordCorrect(boolean aIsPasswordCorrect) {
        isPasswordCorrect = aIsPasswordCorrect;
    }

}
