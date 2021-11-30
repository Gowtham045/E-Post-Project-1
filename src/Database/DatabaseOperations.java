package Database;

import Admin.AdminPanel;
import Login.ForgetPassword;
import Consignment.*;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import customer.DatasForCustomer.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import main.main;
import warehouse.*;
import profile.*;

public class DatabaseOperations {

    private static Connection connection;

    public static Connection getConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","E_Post", "123");
        } catch (Exception ex) {
            System.out.println("  " + ex);
        }
        return connection;
    }

    //getCustomerConsignmentDetails
    public static Object[][] getCustomerConsignmentDetails() {
        try {
            Connection con = DatabaseOperations.getConnection();
            String Customer_ID = Login.login.user_ID;
            String query = "select *from Consignment where customer_ID='" + Customer_ID + "'";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);
            while (res.next()) {
                ConsignmentData ob = new ConsignmentData();

                ob.setConsignment_ID(res.getString("consignment_ID"));
                ob.setCustomer_ID(res.getString("customer_ID"));
                ob.setDelivery_ID(res.getString("delivery_ID"));
                ob.setReceiver_ID(res.getString("receiver_ID"));
                ob.setItem_code(res.getString("item_code"));
                ob.setItem(res.getString("item"));
                ob.setItem_price(res.getFloat("item_price"));
                ob.setItem_weight(res.getFloat("item_weight"));
                ob.setReceiver_first_name(res.getString("receiver_first_name"));
                ob.setReceiver_last_name(res.getString("receiver_last_name"));
                ob.setReceiver_address(res.getString("receiver_address"));
                ob.setReceiver_contact_number(res.getLong("receiver_contact_number"));
                ob.setCustomer_first_name(res.getString("customer_first_name"));
                ob.setCustomer_last_name(res.getString("customer_last_name"));
                ob.setCustomer_contact_number(res.getLong("customer_contact_number"));
                ob.setShipping_address(res.getString("shipping_address"));
                ob.setPayment_method(res.getString("payment_method"));
                ob.setOrder_date(res.getDate("order_date"));
                ob.setDelivery_date(res.getDate("delivery_date"));
                ob.setStatus(res.getString("status"));

                ConsignmentData.listForConsignment.add(ob);

            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Error in getCustomerConsignmentDetails---->" + ex.toString());
        }
        Object[][] row = {};
        try {
            row = new Object[ConsignmentData.listForConsignment.size()][9];
            int i = 0;
            for (ConsignmentData Data : ConsignmentData.listForConsignment) {
                row[i][0] = i + 1;
                row[i][1] = Data.getConsignment_ID();
                row[i][2] = Data.getCustomer_first_name();
                row[i][3] = Data.getReceiver_first_name();
                row[i][4] = Data.getItem();
                row[i][5] = Data.getDelivery_ID();
                row[i][6] = Data.getPayment_method();
                row[i][7] = Data.getOrder_date();
                row[i][8] = Data.getStatus();
                i++;

            }
        } catch (Exception m) {
            JOptionPane.showMessageDialog(null, "You have no consignments");
        }

        return row;
    }

    public static ArrayList getOnGoingDeliveryConsignmentDetails() {
        ArrayList<consignment> list = new ArrayList<consignment>();
        try {
            Connection con = DatabaseOperations.getConnection();
            String Delivery_Id = Login.login.user_ID;
            String query = "select *from Consignment where delivery_ID='" + Delivery_Id + "'";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);

            while (res.next()) {
                String Status = res.getString("status");
                if (!Status.equals("Completed")) {
                    consignment od = new consignment();

                    od.setConsignment_ID(res.getString("consignment_ID"));
                    od.setCustomer_ID(res.getString("customer_ID"));
                    od.setDelivery_ID(res.getString("delivery_ID"));
                    od.setReceiver_ID(res.getString("receiver_ID"));
                    od.setItem_code(res.getString("item_code"));
                    od.setItem(res.getString("item"));
                    od.setItem_price(res.getFloat("item_price"));
                    od.setItem_weight(res.getFloat("item_weight"));
                    od.setReceiver_first_name(res.getString("receiver_first_name"));
                    od.setReceiver_last_name(res.getString("receiver_last_name"));
                    od.setReceiver_address(res.getString("receiver_address"));
                    od.setReceiver_contact_number(res.getLong("receiver_contact_number"));
                    od.setCustomer_first_name(res.getString("customer_first_name"));
                    od.setCustomer_last_name(res.getString("customer_last_name"));
                    od.setCustomer_contact_number(res.getLong("customer_contact_number"));
                    od.setShipping_address(res.getString("shipping_address"));
                    od.setPayment_method(res.getString("payment_method"));
                    od.setOrder_date(res.getDate("order_date"));
                    od.setDelivery_date(res.getDate("delivery_date"));
                    od.setStatus(res.getString("status"));

                    list.add(od);
                }
                
            }
            con.close();

        } catch (Exception ex) {
            System.out.println("Error in OngoingConsignmentDetails---->" + ex.toString());
        }

        return list;
    }

    public static ArrayList getCompletedDeliveryConsignmentDetails() {
        ArrayList<consignment> list = new ArrayList<consignment>();
        try {
            Connection con = DatabaseOperations.getConnection();
            String Delivery_Id = Login.login.user_ID;

            String Status = "Completed";
            String query = "select *from Consignment where delivery_ID='" + Delivery_Id + "'and status = '" + Status + "'";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);
            while (res.next()) {
                consignment od = new consignment();

                od.setConsignment_ID(res.getString("consignment_ID"));
                od.setCustomer_ID(res.getString("customer_ID"));
                od.setDelivery_ID(res.getString("delivery_ID"));
                od.setReceiver_ID(res.getString("receiver_ID"));
                od.setItem_code(res.getString("item_code"));
                od.setItem(res.getString("item"));
                od.setItem_price(res.getFloat("item_price"));
                od.setItem_weight(res.getFloat("item_weight"));
                od.setReceiver_first_name(res.getString("receiver_first_name"));
                od.setReceiver_last_name(res.getString("receiver_last_name"));
                od.setReceiver_address(res.getString("receiver_address"));
                od.setReceiver_contact_number(res.getLong("receiver_contact_number"));
                od.setCustomer_first_name(res.getString("customer_first_name"));
                od.setCustomer_last_name(res.getString("customer_last_name"));
                od.setCustomer_contact_number(res.getLong("customer_contact_number"));
                od.setShipping_address(res.getString("shipping_address"));
                od.setPayment_method(res.getString("payment_method"));
                od.setOrder_date(res.getDate("order_date"));
                od.setDelivery_date(res.getDate("delivery_date"));
                od.setStatus(res.getString("status"));

                list.add(od);

            }
            con.close();

        } catch (Exception ex) {
            System.out.println("Error in CompletedConsignmentDetails---->" + ex.toString());
        }

        return list;
    }

    public static void UpdateDeliveryDeatils(String conid, String Status) {
        Connection con = DatabaseOperations.getConnection();
        try {
            String query = "update Consignment set status='" + Status + "'where consignment_Id ='" + conid + "'";
            PreparedStatement smt = con.prepareStatement(query);
            smt.execute(query);
            getConnection().setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Successful");
            con.close();
        } catch (Exception e1) {
            System.out.println("Update---->" + e1.toString());
        }
    }

    //CheckIdPresentOrNot
    public static boolean CheckIdPresentOrNot(String UserId) {
        try {
            Connection con = DatabaseOperations.getConnection();
            Statement st = con.createStatement();
            String query = "select * from customer where customer_ID='" + UserId + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                return true;

            }
            con.close();
        } catch (SQLException ex) {

            System.out.println("Error in checkIdPresentOrNot Function (DatabaseOperations)---->" + ex.toString());

        }
        return false;

    }

    public static void WalletUpdatationOnMoneyOrder() {

        try {
            String senderid = "", recieverid = "", recieverName = "", balanceS = "", balanceR = "", rcontact = "", firstnamesender = "", lastnamesender = "", contactnumbersender = "";
            Connection con = DatabaseOperations.getConnection();
            String saccountnoquery = "select account_number from Customer where customer_id='" + Login.login.user_ID + "'";
            PreparedStatement stSAccNo = con.prepareStatement(saccountnoquery);
            ResultSet rs1 = stSAccNo.executeQuery(saccountnoquery);
            if (rs1.next()) {
                senderid = rs1.getString(1);
            }

            String raccountnoquery = "select account_number from Customer where customer_id='" + WalletData.MoneyOrderValues.get(0) + "'";
            PreparedStatement stRAccNo = con.prepareStatement(raccountnoquery);
            ResultSet rs2 = stRAccNo.executeQuery(raccountnoquery);
            if (rs2.next()) {
                recieverid = rs2.getString(1);
            }

            String rnamequery = "select first_name from Customer where customer_id='" + WalletData.MoneyOrderValues.get(0) + "'";
            PreparedStatement rnamest = con.prepareStatement(rnamequery);
            ResultSet rs3 = rnamest.executeQuery(rnamequery);
            if (rs3.next()) {
                recieverName = rs3.getString(1);
            }

            String bsquery = "select bank_balance from Customer where customer_id='" + Login.login.user_ID + "'";
            PreparedStatement stsbal = con.prepareStatement(bsquery);
            ResultSet rs4 = stsbal.executeQuery(bsquery);
            if (rs4.next()) {
                balanceS = rs4.getString(1);
            }

            String brquery = "select bank_balance from Customer where customer_id='" + WalletData.MoneyOrderValues.get(0) + "'";
            PreparedStatement strbal = con.prepareStatement(brquery);
            ResultSet rs5 = strbal.executeQuery(brquery);
            if (rs5.next()) {
                balanceR = rs5.getString(1);
            }

            String q = "insert into wallet values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(q);

            st.setString(1, getTransactionIdGenerator());
            st.setString(2, Login.login.user_ID);
            st.setString(3, WalletData.MoneyOrderValues.get(0));
            st.setString(4, WalletData.MoneyOrderValues.get(2));
            st.setString(5, WalletData.MoneyOrderValues.get(3));
            st.setString(6, WalletData.MoneyOrderValues.get(4));
            st.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
            st.setString(8, senderid);
            st.setString(9, recieverid);
            st.setString(10, WalletData.MoneyOrderValues.get(1));
            st.setString(11, recieverName);
            st.setString(12, Integer.toString(Integer.parseInt(balanceS) - Integer.parseInt(WalletData.MoneyOrderValues.get(1))));
            st.executeUpdate();

            String q1 = "update customer  set BANK_BALANCE='" + Integer.toString(Integer.parseInt(balanceS) - Integer.parseInt(WalletData.MoneyOrderValues.get(1))) + "' where customer_id='Kishore P'";
            PreparedStatement stq1 = con.prepareStatement(q1);
            stq1.executeQuery();

            String q2 = "update customer set BANK_BALANCE='" + Integer.toString(Integer.parseInt(balanceR) + Integer.parseInt(WalletData.MoneyOrderValues.get(1))) + "' where customer_id='" + WalletData.MoneyOrderValues.get(0) + "'";
            PreparedStatement stq2 = con.prepareStatement(q2);
            stq2.executeQuery();

            String q3 = "select contact_number from customer where customer_id='" + recieverid + "'";
            PreparedStatement rcontactnumber = con.prepareStatement(q3);
            ResultSet rs6 = rcontactnumber.executeQuery(q3);
            if (rs6.next()) {
                rcontact = rs6.getString(1);
            }
            String q4 = "select first_name,last_name,contact_number from customer where customer_id='" + Login.login.user_ID + "'";
            PreparedStatement flnamesender = con.prepareStatement(q4);
            ResultSet rs7 = flnamesender.executeQuery(q4);
            if (rs7.next()) {
                firstnamesender = rs7.getString("first_name");
                lastnamesender = rs7.getString("last_name");
                contactnumbersender = rs7.getString("contact_number");

            }

            String consignmentQuery = "insert into consignment (consignment_id,CUSTOMER_ID,RECEIVER_ID,ITEM,RECEIVER_FIRST_NAME,RECEIVER_LAST_NAME,RECEIVER_ADDRESS,RECEIVER_CONTACT_NUMBER,CUSTOMER_FIRST_NAME,CUSTOMER_LAST_NAME, CUSTOMER_CONTACT_NUMBER,SHIPPING_ADDRESS,PAYMENT_METHOD,ORDER_DATE,DELIVERY_DATE, STATUS,item_code ,delivery_ID, item_weight) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st1 = con.prepareStatement(consignmentQuery);
            st1.setString(1, getConsignmentIdGenerator());
            st1.setString(2, Login.login.user_ID);

            st1.setString(3, WalletData.MoneyOrderValues.get(0));
            st1.setString(4, "MoneyOrder");
            st1.setString(5, WalletData.MoneyOrderValues.get(2));
            st1.setString(6, WalletData.MoneyOrderValues.get(3));
            st1.setString(7, WalletData.MoneyOrderValues.get(5));
            st1.setString(8, rcontact);
            st1.setString(9, firstnamesender);
            st1.setString(10, lastnamesender);
            st1.setString(11, contactnumbersender);
            st1.setString(12, WalletData.MoneyOrderValues.get(5));
            st1.setString(13, "E-Pay");
            st1.setDate(14, java.sql.Date.valueOf(java.time.LocalDate.now()));
            st1.setDate(15, java.sql.Date.valueOf(java.time.LocalDate.now()));
            st1.setString(16, "completed");
            st1.setString(17, "WH0003");
            st1.setString(18, "Keshav B");
            st1.setFloat(19, 1F);
            st1.executeUpdate();

            con.setAutoCommit(true);
            con.close();
            updateCustomerBalenceWallet();
            DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
            

        } catch (Exception e) {
            System.out.println("Error in WalletUpdatationOnMoneyOrder() in DatabaseOperations------->" + e.toString());
        }
    }
     public static void updateCustomerBalenceWallet() {
        try {
            String query = "update customer set bank_balance=? where customer_ID=?";
            Connection con = DatabaseOperations.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            String balence=Integer.toString(Integer.parseInt(CustomerProfileData.getBankBalance()) - Integer.parseInt(WalletData.MoneyOrderValues.get(1)));
            pst.setString(1, balence);
            pst.setString(2, Login.login.user_ID);
            con.setAutoCommit(true);
            pst.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Your Balence Updated Succesfully in Your Wallet and Remaining Balence is: " + balence);
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "CustomerBalence Update Failed ID:" + e.toString());
        }
    }

    //ConsignmentIdGenerator
    public static String getConsignmentIdGenerator() {
        try {
            Connection con = DatabaseOperations.getConnection();
            Statement st = con.createStatement();
            String stsql = "select count(*) from CONSIGNMENT";
            ResultSet rs = st.executeQuery(stsql);
            rs.next();
            int c = rs.getInt(1);
            con.setAutoCommit(true);

            String s = "CONID";
            con.close();
            return s + Integer.toString(c + 1);
        } catch (Exception ex1) {
            System.out.println("Error in getconsignmentIdGenerator---->" + ex1.toString());
        }

        return "";
    }

    //getTransactionIdGenerator
    public static String getTransactionIdGenerator() {
        try {
            Connection con = DatabaseOperations.getConnection();
            Statement st = con.createStatement();
            String stsql = "select count(*) from WALLET";
            ResultSet rs = st.executeQuery(stsql);
            rs.next();
            int c = rs.getInt(1);
            con.setAutoCommit(true);
            String s = "TRANSID";
            con.close();
            return s + Integer.toString(c + 1);
        } catch (Exception ex1) {
            System.out.println("Error in getTransactionIdGenerator---->" + ex1.toString());
        }

        return "";
    }

    //getMessageIdGenerator
    public static String getMessageIdGenerator() {
        try {
            Connection con = DatabaseOperations.getConnection();
            Statement st = con.createStatement();
            String stsql = "select count(*) from INBOX";
            ResultSet rs = st.executeQuery(stsql);
            rs.next();
            int c = rs.getInt(1);
            con.setAutoCommit(true);
            String s = "MSGID";
            con.close();
            return s + Integer.toString(c + 1);

        } catch (Exception ex1) {
            System.out.println("Error in getTransactionIdGenerator---->" + ex1.toString());
        }
        return "";
    }

    //Database Login credentials
    public static ArrayList getLoginCredentials(JTextField usernameTextField, JTextField passwordField) {

        ArrayList loginCredentials = new ArrayList();

        try {
            String userName = usernameTextField.getText();
            String userPassword = passwordField.getText();

            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select user_ID from Login where user_ID like '" + userName + "'");
            boolean next = rs.next();

            if (next) {
                ResultSet rspass = st.executeQuery("select password,salt,login_type from Login where user_ID like '" + userName + "'");
                if (rspass.next()) {
                    String pass = rspass.getString("password");
                    String salt = rspass.getString("salt");
                    String type = rspass.getString("login_type");

                    loginCredentials.add(pass);
                    loginCredentials.add(salt);
                    loginCredentials.add(type);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

        return loginCredentials;
    }

    public static void loginCreate(ArrayList list) {
        String userName = list.get(0).toString();

        int min = 200;
        int max = 400;
        int salt = (int) (Math.random() * (max - min + 1) + min);

        String hash_pass = Login.login.createHash(list.get(13).toString(), salt);
        String hash_confirm_pass = Login.login.createHash(list.get(14).toString(), salt);

        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select user_ID  from Login where user_ID  like '" + userName + "'");
            boolean next = rs.next();

            if (next) {
                JOptionPane.showMessageDialog(null, "You have Already Registered to E-Post");
            } else {
                String sql = "INSERT INTO Login VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                    stmt.setString(1, list.get(0).toString());
                    stmt.setString(2, list.get(5).toString());
                    stmt.setString(3, "Customer");
                    stmt.setInt(4, salt);
                    stmt.setString(5, hash_pass);

                    stmt.executeUpdate();
                    getConnection().setAutoCommit(true);


                    customerCreate(list);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    public static int accountNumberIncrement() {
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select COUNT(*) from Customer");
            rs.next();

            int count = rs.getInt(1);

            return count;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            return 1;
        }
    }

    public static void customerCreate(ArrayList list) {

        String userName = list.get(0).toString();

        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select customer_ID  from Customer where customer_ID  like '" + userName + "'");
            boolean next = rs.next();

            if (next) {
                JOptionPane.showMessageDialog(null, "You have Already Registered to E-Post");
            } else {
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                java.util.Date date = (java.util.Date) format.parse(list.get(3).toString());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                    stmt.setString(1, list.get(0).toString());
                    stmt.setString(2, list.get(1).toString());
                    stmt.setString(3, list.get(2).toString());
                    stmt.setDate(4, sqlDate);
                    stmt.setString(5, list.get(4).toString());
                    stmt.setString(6, list.get(5).toString());
                    stmt.setString(7, list.get(6).toString());
                    stmt.setString(8, list.get(7).toString());
                    stmt.setString(9, list.get(8).toString());
                    stmt.setString(10, list.get(9).toString());
                    stmt.setString(11, list.get(10).toString());
                    stmt.setFloat(12, (Float)list.get(11));
                    stmt.setString(13, list.get(12).toString());

                    stmt.executeUpdate();
                    getConnection().setAutoCommit(true);
                    JOptionPane.showMessageDialog(null, "Registration Success!");
                    main.switchPage("login");

                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    public static void checkCredentials(ArrayList list) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date date = (java.util.Date) format.parse(list.get(3).toString());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Dushanbe"));
        java.util.Date todayDate = Date.valueOf(today);

        long ageInMillis = System.currentTimeMillis() - date.getTime();
        long years = (ageInMillis / (365 * 24 * 60 * 60 * 1000l));
        long leftover = ageInMillis % (365 * 24 * 60 * 60 * 1000l);
        long days = leftover / (24 * 60 * 60 * 1000l);

        int actualAge = (int) years;

        if (!list.get(1).toString().equals("") && list.get(1).toString().chars().allMatch(Character::isLetter) && !list.get(2).toString().equals("") && list.get(2).toString().chars().allMatch(Character::isLetter)) {
            if (list.get(0).toString().chars().count() > 3) {
                if (list.get(5).toString().matches("\\d{10}")) {
                    if (list.get(13).toString().equals(list.get(14).toString())) {
                        if (!date.after(todayDate)) {
                            if (Integer.parseInt(list.get(4).toString()) == actualAge) {
                                if (!list.get(8).toString().equals("") && !list.get(9).toString().equals("") && list.get(8).toString().matches("^[a-zA-Z\\s]*$") && list.get(9).toString().matches("^[a-zA-Z\\s]*$")) {
                                    if (!list.get(7).toString().equals("")) {
                                        if (list.get(10).toString().matches("\\d{6}")) {
                                            if (!list.get(6).toString().equals("")) {
                                                Database.DatabaseOperations.loginCreate(list);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Please Selete your Gender");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Invalid Pincode");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Please Enter your Address");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid State or District");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Enter your Age ACTUAL Age!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "You cannot be Born in the Future");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password and Confirm Password does not match");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username should be a minimun of 4 Characters");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid FirstName Or LastName");
        }

    }

    public static void loginUpdate(String userName, String password, String confirmPassword, int salt) {
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select user_ID  from Login where user_ID like '" + userName + "'");
            boolean next = rs.next();

            if (next) {
                String query = "UPDATE Login SET password = '" + password + "', salt = '" + salt + "' WHERE user_ID = '" + userName + "'";
                st.executeUpdate(query);
                getConnection().setAutoCommit(true);
                JOptionPane.showMessageDialog(null, "Successful");
                ForgetPassword.newdialog.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Account Does not Exist. Please Register");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    //updateInbox
    public static void updateInbox() {
        try {

            String query = "INSERT INTO Inbox VALUES(?,?,?,?,?,?,?,?,?)";
            Connection con = DatabaseOperations.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, DatabaseOperations.getMessageIdGenerator());
            pst.setString(2, EPostData.getMessage());
            pst.setString(3, CustomerProfileData.getFirstName());//userName
            pst.setString(4, EPostData.getFirstName());
            pst.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));//new java.sql.Date(System.currentTimeMillis())
            pst.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));//new java.sql.Timestamp(9000)
            pst.setString(7, Login.login.user_ID);//Customer ID
            pst.setString(8, EPostData.getTo());//Receiver ID
            pst.setString(9, EPostData.getSubject());
            pst.executeUpdate();
            con.setAutoCommit(true);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inbox Updated Failed ID:" + e.toString());
        }
    }

    //updateConsignment
    public static void updateConsignment() {
        try {
            String query = "INSERT INTO Consignment VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con = DatabaseOperations.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            String ID = DatabaseOperations.getConsignmentIdGenerator();
            pst.setString(1, ID);//consignment_ID
            pst.setString(2, Login.login.user_ID);//customer_ID
            pst.setString(3, "Keshav B");//delivery_ID
            if (WalletDataG.getTransationType().equals("E-Post")) {
                pst.setString(4, EPostData.getTo());//receiver_ID
            }
            if (WalletDataG.getTransationType().equals("Parcel")) {
                pst.setString(4, ParcelData.getTo());//receiver_ID 
            }
            if (WalletDataG.getTransationType().equals("Products")) {
                pst.setString(4, Login.login.user_ID);//receiver_ID
            }
            pst.setString(5, WalletDataG.getItemCode());//item_code
            pst.setString(6, WalletDataG.getTransationType());//item
            pst.setFloat(7, WalletDataG.getItemPrice());//item_price+
            pst.setFloat(8, WalletDataG.getItemWeight());//item_weight
            if (WalletDataG.getTransationType().equals("E-Post")) {
                pst.setString(9, EPostData.getFirstName());//receiver_first_name  
                pst.setString(10, EPostData.getLastName()); //receiver_last_name  
                pst.setString(11, EPostData.getAddress()); //receiver_address 
                pst.setLong(12, EPostData.getPhoneNumber()); //receiver_contact_number   
            } else if (WalletDataG.getTransationType().equals("Parcel")) {
                pst.setString(9, ParcelData.getFirstName());//receiver_first_name                                             
                pst.setString(10, ParcelData.getLastName()); //receiver_last_name             
                pst.setString(11, ParcelData.getAddress()); //receiver_address 
                pst.setLong(12, ParcelData.getPhoneNumber()); //receiver_contact_number    
            } else if (WalletDataG.getTransationType().equals("Products")) {
                pst.setString(9, CustomerProfileData.getFirstName());//current log in customer first_name                                             
                pst.setString(10, CustomerProfileData.getLastName()); //current log in customer Last_name  
                pst.setString(11, CustomerProfileData.getAddress()); //current log in customer receiver_address 
                pst.setLong(12, Long.valueOf(CustomerProfileData.getContactNumber())); //receiver_contact_number      
            }
            pst.setString(13, CustomerProfileData.getFirstName());      //customer_first_name 
            pst.setString(14, CustomerProfileData.getLastName());           //customer_last_name 
            pst.setLong(15, Long.valueOf(CustomerProfileData.getContactNumber()));   //customer_contact_number
            pst.setString(16, CustomerProfileData.getAddress());//shipping_address
            pst.setString(17, "E-Pay");  //payment_method 
            pst.setDate(18, java.sql.Date.valueOf(java.time.LocalDate.now()));//order_date DATE
            pst.setDate(19, java.sql.Date.valueOf(java.time.LocalDate.now()));  //delivery_date DATE                                                    
            pst.setString(20, "Order Placed");//status 
            pst.executeUpdate();
            con.setAutoCommit(true);
            con.close();
            DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Consignment Update Failed ID:" + e.toString());
        }
    }

    //updateCustomerBalence
    public static void updateCustomerBalence() {
        try {
            String query = "update customer set bank_balance=? where customer_ID=?";
            Connection con = DatabaseOperations.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setFloat(1, WalletDataG.getBalence());
            pst.setString(2, Login.login.user_ID);
            con.setAutoCommit(true);
            pst.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Your Balence Updated Succesfully in Your Wallet and Remaining Balence is: " + WalletDataG.getBalence());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CustomerBalence Update Failed ID:" + e.toString());
        }
    }

    //updateWalletTransaction
    public static void updateWalletTransaction() {
        try {
            String query = "INSERT INTO Wallet VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con = DatabaseOperations.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, DatabaseOperations.getTransactionIdGenerator());
            pst.setString(2, Login.login.user_ID);//Customer ID
            pst.setString(3, "Admin001");//Reciver Id
            if (WalletDataG.getTransationType().equals("E-Post")) {
                pst.setString(4, EPostData.getFirstName());
                pst.setString(5, EPostData.getLastName());
            }
            if (WalletDataG.getTransationType().equals("Parcel")) {
                pst.setString(4, ParcelData.getFirstName());
                pst.setString(5, ParcelData.getLastName());
            }
            if (WalletDataG.getTransationType().equals("Products")) {
                pst.setString(4, CustomerProfileData.getFirstName());//current log in user first name
                pst.setString(5, CustomerProfileData.getLastName()); //current log in user Last name    
            }
            pst.setString(6, WalletDataG.getTransationType());
            pst.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));//new java.sql.Date(System.currentTimeMillis())
            pst.setLong(8, Long.valueOf(CustomerProfileData.getAccountNumber()));//current logged in customer's wallet account number
            pst.setLong(9, 350700000);//Admin Account Number
            pst.setFloat(10, WalletDataG.getAmount());//amount
            pst.setString(11, "Admin");//money reciever name
            pst.setFloat(12, WalletDataG.getBalence());//balence
            pst.executeUpdate();
            con.setAutoCommit(true);
            con.close();
            
            updateCustomerBalence();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wallet  Updated Failed ID:" + e.toString());
        }
    }

    //getStocks
    public static ArrayList<Warehouse> getStocks() {
        ArrayList<Warehouse> stocks = new ArrayList<Warehouse>();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * from warehouse";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Warehouse temp = new Warehouse();
                temp.setItemCode(rs.getString("S_ITEM_CODE"));
                temp.setItem(rs.getString("S_ITEM"));
                temp.setItemPrice(rs.getString("S_ITEM_PRICE"));
                temp.setItemQuantity(rs.getString("S_ITEM_QUANTITY"));
                stocks.add(temp);
            }
            con.close();
        } catch (Exception e) {
            System.out.print(e);
        }
        return stocks;
    }

    //updateStocks
    public static void updateStocks(ArrayList<Warehouse> stock) {
        for (int i = 0; i < stock.size(); i++) {
            Warehouse temp = stock.get(i);
            try {
                Connection con = getConnection();
                Statement st = con.createStatement();
                String query = "update warehouse set S_Item_Quantity = ? where s_item_Code = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, temp.getItemQuantity());
                pst.setString(2, temp.getitemCode());
                pst.executeQuery();
                con.setAutoCommit(true);
                con.close();
                JOptionPane.showMessageDialog(AdminPanel.contentForAdmin, "Stocks Updated");
            } catch (Exception e) {
                //System.out.println(e);
            }

        }

    }

    public static AdminProfile getAdminProfile(String id) {
        AdminProfile details = new AdminProfile();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Admin where Admin_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                details.setId(rst.getString("ADMIN_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setJoinDate(rst.getDate("JOIN_DATE"));
                details.setExperience(rst.getInt("EXPERIANCE"));
                details.setAge(rst.getInt("AGE"));
                details.setMartialStatus(rst.getString("MARTIAL_STATUS"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setPermanentAddress(rst.getString("PERMANENT_ADDRESS"));
                details.setTemporaryAddress(rst.getString("TEMPORARY_ADDRESS"));
                details.setSalary(rst.getInt("SALARY"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
                details.setDesignation(rst.getString("DESIGNATION"));
            }
            con.close();
        } catch (Exception e) {
            ////System.out.println(e);
        }
        return details;
    }

    public static ArrayList<CustomerProfile> getCustomerDetails() {
        ArrayList<CustomerProfile> customerDetails = new ArrayList<CustomerProfile>();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Customer";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                CustomerProfile details = new CustomerProfile();
                details.setId(rst.getString("CUSTOMER_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setAge(rst.getInt("AGE"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setAddress(rst.getString("ADDRESS"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
                details.setPinCode(rst.getString("PIN_CODE"));
                details.setBankBalance(rst.getString("BANK_BALANCE"));
                details.setAccountNumber(rst.getString("ACCOUNT_NUMBER"));
                customerDetails.add(details);
            }
            con.close();
        } catch (Exception e) {
            ////System.out.println(e);
        }
        return customerDetails;
    }

    public static ArrayList<DeliveryProfile> getDeliveryDetails() {
        ArrayList<DeliveryProfile> deliveryDetails = new ArrayList<DeliveryProfile>();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Delivery";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                DeliveryProfile details = new DeliveryProfile();
                details.setId(rst.getString("DELIVERY_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setJoinDate(rst.getDate("JOIN_DATE"));
                details.setAge(rst.getInt("AGE"));
                details.setMartialStatus(rst.getString("MARTIAL_STATUS"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setPermanentAddress(rst.getString("PERMANENT_ADDRESS"));
                details.setTemporaryAddress(rst.getString("TEMPORARY_ADDRESS"));
                details.setSalary(rst.getInt("SALARY"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
                deliveryDetails.add(details);
            }
            con.close();
        } catch (Exception e) {
            ////System.out.println(e);
        }
        return deliveryDetails;
    }

    //getInboxDetails
    public static void getInboxDetails() {

        try {
            Connection con = DatabaseOperations.getConnection();
            String cId = Login.login.user_ID;
            String query = "select * from Inbox where receiver_ID='" + cId + "'";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);
            while (res.next()) {
                InboxData obj = new InboxData();
                obj.setMessage_ID(res.getString("messaage_ID"));
                obj.setMessage(res.getString("message"));
                obj.setSender_name(res.getString("sender_name"));
                obj.setReceiver_name(res.getString("receiver_ID"));
                obj.setSent_Date(res.getString("sent_Date"));
                obj.setTime(res.getString("time"));
                obj.setCustomer_Id(res.getString("customer_Id"));
                obj.setReceiver_Id(res.getString("receiver_Id"));
                obj.setSubject(res.getString("subject"));
                InboxData.ListForInbox.add(obj);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error in getInboxDetails  " + e.toString());
        }

    }

    //Customer Profile update
    public static void profileUpdationOnSave() {
        try {
            Connection con = DatabaseOperations.getConnection();
            String cId = Login.login.user_ID;

            String query = "update customer set first_name=?,last_name=?,DOB=?,AGE=?,CONTACT_NUMBER=?,GENDER=?, ADDRESS=?,STATE=?,DISTRICT=?,PIN_CODE=?,ACCOUNT_NUMBER=? where customer_id=?";
            PreparedStatement profileUpdateQuery = con.prepareStatement(query);
            profileUpdateQuery.setString(1, ProfileUpdateData.getFIRST_NAME());

            profileUpdateQuery.setString(2, ProfileUpdateData.getLAST_NAME());

            profileUpdateQuery.setDate(3, java.sql.Date.valueOf(ProfileUpdateData.getDOB()));

            profileUpdateQuery.setString(4, ProfileUpdateData.getAGE());

            profileUpdateQuery.setString(5, ProfileUpdateData.getCONTACT_NUMBER());

            profileUpdateQuery.setString(6, ProfileUpdateData.getGENDER());

            profileUpdateQuery.setString(7, ProfileUpdateData.getADDRESS());
            profileUpdateQuery.setString(8, ProfileUpdateData.getSTATE());
            profileUpdateQuery.setString(9, ProfileUpdateData.getDISTRICT());
            profileUpdateQuery.setString(10, ProfileUpdateData.getPIN_CODE());
            profileUpdateQuery.setString(11, ProfileUpdateData.getACCOUNT_NUMBER());

            profileUpdateQuery.setString(12, Login.login.user_ID);

            profileUpdateQuery.executeQuery();

            JOptionPane.showMessageDialog(null, "Updation Successful!");
            con.setAutoCommit(true);
            con.close();

        } catch (Exception e) {
            System.out.println("Exception in profileUpdationOnSave() : DatabaseOperations----->" + e.toString());
        }
    }

    //Wallet Table Details
    public static ArrayList<WalletData> getCurrentWalletDetails() {
        ArrayList<WalletData> list = new ArrayList<WalletData>();
        try {

            Connection con = DatabaseOperations.getConnection();
            String Cid = Login.login.user_ID;
            String query = "select * from wallet where customer_id='" + Cid + "'";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);
            while (res.next()) {
                WalletData ob = new WalletData();
                ob.setTransactionid(res.getString("transaction_id"));
                ob.setTransactiontype(res.getString("TRANSACTION_TYPE"));
                ob.setTransactiondate(res.getString("TRANSACTION_DATE"));
                ob.setRecieverid(res.getString("RECEIVER_ID"));
                ob.setBeneficiary(res.getString("first_name") + " " + res.getString("last_name"));
                ob.setAmount(res.getString("Amount"));
                ob.setBalance(res.getString("balance"));
                list.add(ob);
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Exception in getCurrentWalletDetails() : databaseoperations---->" + e.toString());

        }
        return list;
    }

    //Customer profile Details
    public static CustomerProfile getCustomerProfile(String id) {
        CustomerProfile details = new CustomerProfile();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Customer where CUSTOMER_ID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                details.setId(rst.getString("CUSTOMER_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setAge(rst.getInt("AGE"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setAddress(rst.getString("ADDRESS"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
                details.setPinCode(rst.getString("PIN_CODE"));
                details.setBankBalance(rst.getString("BANK_BALANCE"));
                details.setAccountNumber(rst.getString("ACCOUNT_NUMBER"));
            }
            con.close();
        } catch (Exception e) {
            ////System.out.println(e);
        }
        return details;
    }

    //Customer Profile
    public static void getCustomerProfileForCustomerPanel(String id) {

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Customer where CUSTOMER_ID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                CustomerProfileData.setId(rst.getString("CUSTOMER_ID"));
                CustomerProfileData.setFirstName(rst.getString("FIRST_NAME"));
                CustomerProfileData.setLastName(rst.getString("LAST_NAME"));
                CustomerProfileData.setDob(rst.getDate("DOB"));
                CustomerProfileData.setAge(rst.getInt("AGE"));
                CustomerProfileData.setContactNumber(rst.getString("CONTACT_NUMBER"));
                CustomerProfileData.setGender(rst.getString("GENDER"));
                CustomerProfileData.setAddress(rst.getString("ADDRESS"));
                CustomerProfileData.setState(rst.getString("STATE"));
                CustomerProfileData.setDistrict(rst.getString("DISTRICT"));
                CustomerProfileData.setPinCode(rst.getString("PIN_CODE"));
                CustomerProfileData.setBankBalance(rst.getString("BANK_BALANCE"));
                CustomerProfileData.setAccountNumber(rst.getString("ACCOUNT_NUMBER"));
            }
            con.close();
        } catch (Exception e) {
//            ////System.out.println(e);
        }

    }

    //reciever Profile Details
    public static void getReciverProfileForCustomerPanel(String id) {

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Customer where CUSTOMER_ID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                RecieverProfileData.setId(rst.getString("CUSTOMER_ID"));
                RecieverProfileData.setFirstName(rst.getString("FIRST_NAME"));
                RecieverProfileData.setLastName(rst.getString("LAST_NAME"));
                RecieverProfileData.setDob(rst.getDate("DOB"));
                RecieverProfileData.setAge(rst.getInt("AGE"));
                RecieverProfileData.setContactNumber(rst.getString("CONTACT_NUMBER"));
                RecieverProfileData.setGender(rst.getString("GENDER"));
                RecieverProfileData.setAddress(rst.getString("ADDRESS"));
                RecieverProfileData.setState(rst.getString("STATE"));
                RecieverProfileData.setDistrict(rst.getString("DISTRICT"));
                RecieverProfileData.setPinCode(rst.getString("PIN_CODE"));
                RecieverProfileData.setBankBalance(rst.getString("BANK_BALANCE"));
                RecieverProfileData.setAccountNumber(rst.getString("ACCOUNT_NUMBER"));
            }
        } catch (Exception e) {
//            ////System.out.println(e);
        }

    }

    //Delivery Details for Admin
    public static DeliveryProfile getDeliveryProfile(String id) {
        DeliveryProfile details = new DeliveryProfile();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Delivery where DELIVERY_ID =?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                details.setId(rst.getString("DELIVERY_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setJoinDate(rst.getDate("JOIN_DATE"));
                details.setAge(rst.getInt("AGE"));
                details.setMartialStatus(rst.getString("MARTIAL_STATUS"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setPermanentAddress(rst.getString("PERMANENT_ADDRESS"));
                details.setTemporaryAddress(rst.getString("TEMPORARY_ADDRESS"));
                details.setSalary(rst.getInt("SALARY"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
            }
            con.close();
        } catch (Exception e) {
            ////System.out.println(e);
        }
        return details;
    }

    //getConsignmentDetails
    public static consignment getConsignmentDetails(String id) {
        consignment ob = new consignment();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from consignment where CONSIGNMENT_ID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ob.setConsignment_ID(res.getString("consignment_ID"));
                ob.setCustomer_ID(res.getString("customer_ID"));
                ob.setDelivery_ID(res.getString("delivery_ID"));
                ob.setReceiver_ID(res.getString("receiver_ID"));
                ob.setItem_code(res.getString("item_code"));
                ob.setItem(res.getString("item"));
                ob.setItem_price(res.getFloat("item_price"));
                ob.setItem_weight(res.getFloat("item_weight"));
                ob.setReceiver_first_name(res.getString("receiver_first_name"));
                ob.setReceiver_last_name(res.getString("receiver_last_name"));
                ob.setReceiver_address(res.getString("receiver_address"));
                ob.setReceiver_contact_number(res.getLong("receiver_contact_number"));
                ob.setCustomer_first_name(res.getString("customer_first_name"));
                ob.setCustomer_last_name(res.getString("customer_last_name"));
                ob.setCustomer_contact_number(res.getLong("customer_contact_number"));
                ob.setShipping_address(res.getString("shipping_address"));
                ob.setPayment_method(res.getString("payment_method"));
                ob.setOrder_date(res.getDate("order_date"));
                ob.setDelivery_date(res.getDate("delivery_date"));
                ob.setStatus(res.getString("status"));

            }
            con.close();
        } catch (Exception e) {
        }
        return ob;
    }

    //Ongoing Consignment detail table for admin
    public static ArrayList<consignment> getOngoingAdminConsignmentDetails() {
        ArrayList<consignment> ongoingconsignment = new ArrayList<consignment>();
        try {
            Connection con = DatabaseOperations.getConnection();
            String query = "select * from Consignment";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);

            while (res.next()) {
                String Status = res.getString("status");
                if (!Status.equals("Completed") && !res.getString("Delivery_id").equals("Keshav B")) {
                    consignment od = new consignment();

                    od.setConsignment_ID(res.getString("consignment_ID"));
                    od.setCustomer_ID(res.getString("customer_ID"));
                    od.setDelivery_ID(res.getString("delivery_ID"));
                    od.setReceiver_ID(res.getString("receiver_ID"));
                    od.setItem_code(res.getString("item_code"));
                    od.setItem(res.getString("item"));
                    od.setItem_price(res.getFloat("item_price"));
                    od.setItem_weight(res.getFloat("item_weight"));
                    od.setReceiver_first_name(res.getString("receiver_first_name"));
                    od.setReceiver_last_name(res.getString("receiver_last_name"));
                    od.setReceiver_address(res.getString("receiver_address"));
                    od.setReceiver_contact_number(res.getLong("receiver_contact_number"));
                    od.setCustomer_first_name(res.getString("customer_first_name"));
                    od.setCustomer_last_name(res.getString("customer_last_name"));
                    od.setCustomer_contact_number(res.getLong("customer_contact_number"));
                    od.setShipping_address(res.getString("shipping_address"));
                    od.setPayment_method(res.getString("payment_method"));
                    od.setOrder_date(res.getDate("order_date"));
                    od.setDelivery_date(res.getDate("delivery_date"));
                    od.setStatus(res.getString("status"));

                    ongoingconsignment.add(od);
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Error in OngoingConsignmentDetails---->" + ex.toString());
        }
        return ongoingconsignment;
    }

    //Completed consignment details for admin
    public static ArrayList<consignment> getCompletedAdminConsignmentDetails() {
        ArrayList<consignment> completedConsignment = new ArrayList<consignment>();
        try {
            Connection con = DatabaseOperations.getConnection();
            String query = "select * from Consignment";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);

            while (res.next()) {
                String Status = res.getString("status");
                if (Status.equals("Completed")) {
                    consignment od = new consignment();

                    od.setConsignment_ID(res.getString("consignment_ID"));
                    od.setCustomer_ID(res.getString("customer_ID"));
                    od.setDelivery_ID(res.getString("delivery_ID"));
                    od.setReceiver_ID(res.getString("receiver_ID"));
                    od.setItem_code(res.getString("item_code"));
                    od.setItem(res.getString("item"));
                    od.setItem_price(res.getFloat("item_price"));
                    od.setItem_weight(res.getFloat("item_weight"));
                    od.setReceiver_first_name(res.getString("receiver_first_name"));
                    od.setReceiver_last_name(res.getString("receiver_last_name"));
                    od.setReceiver_address(res.getString("receiver_address"));
                    od.setReceiver_contact_number(res.getLong("receiver_contact_number"));
                    od.setCustomer_first_name(res.getString("customer_first_name"));
                    od.setCustomer_last_name(res.getString("customer_last_name"));
                    od.setCustomer_contact_number(res.getLong("customer_contact_number"));
                    od.setShipping_address(res.getString("shipping_address"));
                    od.setPayment_method(res.getString("payment_method"));
                    od.setOrder_date(res.getDate("order_date"));
                    od.setDelivery_date(res.getDate("delivery_date"));
                    od.setStatus(res.getString("status"));

                    completedConsignment.add(od);
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Error in OngoingConsignmentDetails---->" + ex.toString());
        }
        return completedConsignment;
    }

    //New Consignment details for admin
    public static ArrayList<consignment> getNewAdminConsignmentDetails() {
        ArrayList<consignment> newConsignment = new ArrayList<consignment>();
        try {
            Connection con = DatabaseOperations.getConnection();
            String query = "select * from Consignment";
            PreparedStatement st1 = con.prepareStatement(query);
            ResultSet res = st1.executeQuery(query);

            while (res.next()) {
                String Status = res.getString("delivery_ID");
                if (Status.equals("Keshav B")) {
                    consignment od = new consignment();

                    od.setConsignment_ID(res.getString("consignment_ID"));
                    od.setCustomer_ID(res.getString("customer_ID"));
                    od.setDelivery_ID(res.getString("delivery_ID"));
                    od.setReceiver_ID(res.getString("receiver_ID"));
                    od.setItem_code(res.getString("item_code"));
                    od.setItem(res.getString("item"));
                    od.setItem_price(res.getFloat("item_price"));
                    od.setItem_weight(res.getFloat("item_weight"));
                    od.setReceiver_first_name(res.getString("receiver_first_name"));
                    od.setReceiver_last_name(res.getString("receiver_last_name"));
                    od.setReceiver_address(res.getString("receiver_address"));
                    od.setReceiver_contact_number(res.getLong("receiver_contact_number"));
                    od.setCustomer_first_name(res.getString("customer_first_name"));
                    od.setCustomer_last_name(res.getString("customer_last_name"));
                    od.setCustomer_contact_number(res.getLong("customer_contact_number"));
                    od.setShipping_address(res.getString("shipping_address"));
                    od.setPayment_method(res.getString("payment_method"));
                    od.setOrder_date(res.getDate("order_date"));
                    od.setDelivery_date(res.getDate("delivery_date"));
                    od.setStatus(res.getString("status"));

                    newConsignment.add(od);
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Error in NewAdminConsignmentDetails---->" + ex.toString());
        }
        return newConsignment;
    }

    //Update Admin Profile for Admin
    public static void updateAdminProfile(AdminProfile details) {
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "update Admin set FIRST_NAME = ?, LAST_NAME = ?, DOB = ?, AGE = ?, CONTACT_NUMBER = ?, MARTIAL_STATUS = ?, SALARY = ?, DESIGNATION = ?, STATE = ?, DISTRICT = ?, PERMANENT_ADDRESS = ?, TEMPORARY_ADDRESS = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, details.getFirstName());
            pst.setString(2, details.getLastName());
            pst.setDate(3, details.getDob());
            pst.setInt(4, details.getAge());
            pst.setString(5, details.getContactNumber());
            pst.setString(6, details.getMartialStatus());
            pst.setInt(7, details.getSalary());
            pst.setString(8, details.getDesignation());
            pst.setString(9, details.getState());
            pst.setString(10, details.getDistrict());
            pst.setString(11, details.getPermanentAddress());
            pst.setString(12, details.getTemporaryAddress());
            pst.executeQuery();
            con.setAutoCommit(true);
            con.close();
            JOptionPane.showMessageDialog(main.mainPanel, "Update Admin Successful");
        } catch (Exception e) {
            ////System.out.println(e);
        }
    }

    //Update Delivery Profile for Delivery
    public static void updateDeliveryProfile(DeliveryProfile details, String id) {
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "update Delivery set FIRST_NAME = ?, LAST_NAME = ?, DOB = ?, AGE = ?, CONTACT_NUMBER = ?, MARTIAL_STATUS = ?, SALARY = ?,STATE = ?, DISTRICT = ?, PERMANENT_ADDRESS = ?, TEMPORARY_ADDRESS = ? where DELIVERY_ID ='" + id + "' ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, details.getFirstName());
            pst.setString(2, details.getLastName());
            pst.setDate(3, details.getDob());
            pst.setInt(4, details.getAge());
            pst.setString(5, details.getContactNumber());
            pst.setString(6, details.getMartialStatus());
            pst.setInt(7, details.getSalary());
            pst.setString(9, details.getDistrict());
            pst.setString(8, details.getState());
            pst.setString(10, details.getPermanentAddress());
            pst.setString(11, details.getTemporaryAddress());
            pst.executeQuery();
            con.setAutoCommit(true);
            con.close();
            JOptionPane.showMessageDialog(main.mainPanel, "Update Delivery Successful");
        } catch (Exception e) {
            ////System.out.println(e);
        }
    }

    //Updating consignment details form delivery
    public static void updateConsignmentDelivery(String delivery_id, String consignment_id) {
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "update consignment set delivery_id = ? where consignment_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, delivery_id);
            pst.setString(2, consignment_id);
            pst.executeQuery();
            con.close();
        } catch (Exception e) {
        }
    }
}
