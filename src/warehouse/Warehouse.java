package warehouse;

import Database.DatabaseOperations;
import java.util.ArrayList;
import Admin.*;

public class Warehouse {

    //Private Variables
    String itemCode;
    String item;
    String itemPrice;
    String itemQuantity;

    //Empty constructure
    public Warehouse() {
    }

    public Warehouse(String code, String quantity) {
        this.itemCode = code;
        this.itemQuantity = quantity;
    }

    //Getting Item Code
    public String getitemCode() {
        return itemCode;
    }

    //Getting Item
    public String getItem() {
        return item;
    }

    //Getting ItemPrice
    public String getItemPrice() {
        return itemPrice;
    }

    //Getting ItemQuantity
    public String getItemQuantity() {
        return itemQuantity;
    }

    //Setting ItemCode
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    //Setting Item
    public void setItem(String item) {
        this.item = item;
    }

    //Setting ItemPrice
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    //Setting ItemQuantity
    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    //Sets and Displayes All the values in Warhouse Panel
    public static void setStocks() {
        //Gets An ArrayList of Stocks from DatabaseOperations
        ArrayList<Warehouse> stock = DatabaseOperations.getStocks();

        for (int i = 0; i < stock.size(); i++) {
            Warehouse temp = stock.get(i);

            if (temp.getitemCode().equals("WH0004")) {
                Stocks.envelopeQuantity_Info.setText(temp.getItemQuantity());
            } else if (temp.getitemCode().equals("WH0005")) {
                Stocks.postCardQuantity_Info.setText(temp.getItemQuantity());
            } else if (temp.getitemCode().equals("WH0006")) {
                Stocks.inlandLetterQuantity_Info.setText(temp.getItemQuantity());
            } else if (temp.getitemCode().equals("WH0007")) {
                Stocks.postageStampQuantity_Info.setText(temp.getItemQuantity());
            } else if (temp.getitemCode().equals("WH0008")) {
                Stocks.postageStamp1Quantity_Info.setText(temp.getItemQuantity());
            } else if (temp.getitemCode().equals("WH0009")) {
                Stocks.collectorStampQuantity_Info.setText(temp.getItemQuantity());
            } else if (temp.getitemCode().equals("WH0010")) {
                Stocks.revenueStampQuantity_Info.setText(temp.getItemQuantity());
            }

        }
    }
}
