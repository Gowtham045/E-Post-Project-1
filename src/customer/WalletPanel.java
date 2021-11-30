package customer;

import Admin.StyledButtonUi;
import Database.DatabaseOperations;
import customer.DatasForCustomer.CustomerProfileData;
import customer.DatasForCustomer.WalletData;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import main.main;

public class WalletPanel extends JPanel {

    // private 
    private JButton bE_pay, bMoney_Order, bAdd_Money;
    private JScrollPane sp;
    private Color panel = new Color(254, 254, 254);
    private Color back = new Color(34, 34, 44);
    private Color button = new Color(71, 63, 144);
    private static final int font = 16;
    private Font text = new Font("Verdana", Font.BOLD, font);
    private static JTable table;
    private int y = 120;
    private static final Object column_name[] = {"ID", "Type", "Date", "Beneficiary", "Receivers Id", "Amount", "Balance"};
    private Object row[] = {};

    //Public
    public static JLabel UserName, Account_no, WalletBalance, icon;
    public static DefaultTableModel model;
    
    WalletPanel() {
        
        this.setLayout(null);
        this.setBounds(55, 150, 1260, 570);
        
        model = new DefaultTableModel();
        
        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        for (Object c : column_name) {
            model.addColumn(c);
        }
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(button);
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(text);

        //table.setBackground(button);
        sp = new JScrollPane(table);
        sp.setBounds(160, 100 + 40, 950 + 50, 350);
        sp.setBackground(back);
        sp.setFont(new Font("Segoe UI", Font.BOLD, 20));
        sp.setVisible(true);
        
        bMoney_Order = new JButton("Money Order");
        bAdd_Money = new JButton("Add Money");
        
        UserName = new JLabel();
        Account_no = new JLabel();
        WalletBalance = new JLabel();
        bE_pay = new JButton("E-Pay");
        bMoney_Order = new JButton("Money Order");
        bAdd_Money = new JButton("Add Money");
        UserName.setBounds(100, 30, 500, 50);
        UserName.setFont(new Font("Segoe UI", Font.PLAIN, font));
        
        Account_no.setBounds(100, 60, 500, 50);
        Account_no.setFont(new Font("Segoe UI", Font.PLAIN, font));
        
        WalletBalance.setBounds(980, 10, 200, 100);
        WalletBalance.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        bE_pay.setBounds(350, 520, 150, 30);
        bE_pay.setBackground(button);
        bE_pay.setForeground(Color.white);
        bE_pay.setFont(new Font("Segoe UI", Font.BOLD, font));
        bE_pay.addActionListener((l) -> {
            new EPay();
        });
        bE_pay.setUI(new StyledButtonUi());
        
        bMoney_Order.setBounds(550, 520, 150, 30);
        bMoney_Order.setBackground(button);
        bMoney_Order.setForeground(Color.white);
        bMoney_Order.addActionListener((l) -> {//outer Panel switching
            main.switchPage("money order");
        });
        
        bMoney_Order.setFont(new Font("Segoe UI", Font.BOLD, font));
        bMoney_Order.setUI(new StyledButtonUi());
        
        bAdd_Money.setBounds(750, 520, 150, 30);
        bAdd_Money.setBackground(button);
        bAdd_Money.setForeground(Color.white);
        bAdd_Money.addActionListener((l) -> {
            new AddMoney();
        });
        bAdd_Money.setFont(new Font("Segoe UI", Font.BOLD, font));
        bAdd_Money.setUI(new StyledButtonUi());
        
        ImageIcon ion = new ImageIcon(getClass().getResource("/Images/wallet.png"));
        icon = new JLabel(ion);
        icon.setBounds(1010, 0, 200, 100);
        icon.setVisible(true);
        this.add(Account_no);
        this.add(UserName);
        this.add(WalletBalance);
        this.add(icon);
        this.add(bMoney_Order);
        this.add(bE_pay);
        this.add(bAdd_Money);
        this.add(sp);
        
    }

    //setWalletCurrentDetails
    static void setWalletCurrentDetails() {
        ArrayList<WalletData> list = DatabaseOperations.getCurrentWalletDetails();
        
        for (int i = 0; i < list.size(); i++) {
            WalletData temp = list.get(i);
            
            Object row[] = new Object[7];
            row[0] = (temp.getTransactionid());
            
            row[1] = (temp.getTransactiontype());
            
            row[2] = (temp.getTransactiondate());
            
            row[3] = (temp.getBeneficiary());
            
            row[4] = (temp.getRecieverid());
            
            row[5] = (temp.getAmount());
            
            row[6] = (temp.getBalance());
            
            try {
                model.addRow(row);
            } catch (Exception e) {
                System.out.println("addrow" + e.toString());
            }
            
        }
        try {
            WalletPanel.WalletBalance.setText(CustomerProfileData.getBankBalance());
           // WalletBalance.setText(list.get(list.size() - 1).getBalance());
        } catch (Exception o) {
        }
        
    }

    //removeWalletCurrentDetails
    static void removeWalletCurrentDetails() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
}
