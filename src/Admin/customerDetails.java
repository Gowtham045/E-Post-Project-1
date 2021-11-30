package Admin;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import main.main;

public class customerDetails extends JPanel implements ListSelectionListener {

    //Private Variables
    private JScrollPane tableScroll;

    //Public Variables
    public static JTable customerDetailsTable;
    public static DefaultTableModel customermodel;

    //Constructer
    public customerDetails() {
        //Column Values
        String[] columns = {"Customer ID", "First Name", "Last Name", "DOB", "Age", "Contact Number", "Gender", "Bank Balance"};

        Border border = new LineBorder(new Color(71, 63, 145), 1, true);
        //Customer Table
        customermodel = new DefaultTableModel();
        customermodel.setColumnIdentifiers(columns);
        customerDetailsTable = new JTable(customermodel);
        customerDetailsTable.setRowHeight(30);
        customerDetailsTable.setBorder(border);
        customerDetailsTable.setRowSelectionAllowed(true);
        //Header
        JTableHeader tableHeader = customerDetailsTable.getTableHeader();
        tableHeader.setBackground(new Color(71, 63, 145));
        tableHeader.setForeground(Color.WHITE);

        //List Listener
        ListSelectionModel customerDetailSelect = customerDetailsTable.getSelectionModel();
        customerDetailSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        customerDetailSelect.addListSelectionListener(this);

        //Scroll bar
        tableScroll = new JScrollPane(customerDetailsTable);
        tableScroll.setBounds(30, 30, 1200, 500);
        tableScroll.setVisible(true);

        this.add(tableScroll);
        this.setBackground(Color.WHITE);
        this.setBounds(45, 250, 1250, 590);
        this.setLayout(null);
        this.setVisible(true);
    }

    //Item Listener
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectRow = customerDetailsTable.getSelectedRow();
        if (selectRow != -1) {
            String selectedData = (String) customerDetailsTable.getValueAt(selectRow, 0);
            profile.CustomerProfile.setCustomerProfile(selectedData);
            main.switchPage("ACustomerProfile");
            customerDetailsTable.clearSelection();
        }
    }

}
