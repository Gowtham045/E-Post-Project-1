package customer.DatasForCustomer;

//Setters and Getters For Encapsulation
public class WalletDataG {

    //private
    private static Float amount;
    private static Float balence;
    private static String transationType;
    private static Float itemWeight;
    private static Float itemPrice;
    private static String itemCode;

    public static String getTransationType() {
        return transationType;
    }

    public static void setTransationType(String transationType) {
        WalletDataG.transationType = transationType;
    }

    public static Float getAmount() {
        return amount;
    }

    public static void setAmount(Float amount) {
        WalletDataG.amount = amount;
    }

    public static Float getBalence() {
        return balence - getItemPrice();//then u need to update the balence in customer table by minus item price
    }

    public static void setBalence(Float balence) {
        WalletDataG.balence = balence;
    }

    public static Float getItemWeight() {
        return itemWeight;
    }

    public static void setItemWeight(Float aItemWeight) {
        itemWeight = aItemWeight;
    }

    public static Float getItemPrice() {
        return itemPrice;
    }

    public static void setItemPrice(Float aItemPrice) {
        itemPrice = aItemPrice;
    }

    public static String getItemCode() {
        return itemCode;
    }

    public static void setItemCode(String aItemCode) {
        itemCode = aItemCode;
    }
}
