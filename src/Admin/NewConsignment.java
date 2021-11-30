package Admin;

import Database.DatabaseOperations;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import profile.DeliveryProfile;

public class NewConsignment extends JPanel implements ItemListener {

    //Private Variables
    public static JTable table;
    public static DefaultTableModel newModel;

    //Private Variables
    private JScrollPane scroll;
    private int font = 16;
    private int font1 = 16;
    private Font text = new Font("Verdana", Font.BOLD, font);
    private Font text1 = new Font("arial", Font.BOLD, font1);
    private int Select;
    private JComboBox<String> comboBox;
    private String value;

    //Constructer
    NewConsignment() {

        //Column Values     
        String[] columns = {"Consignment ID", "From", "To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};

        Border border = new LineBorder(new Color(71, 63, 145), 1, true);

        newModel = new DefaultTableModel();
        newModel.setColumnIdentifiers(columns);
        //Table
        table = new JTable(newModel);
        table.setRowHeight(30);
        table.setBorder(border);
        table.setRowSelectionAllowed(true);

        //List Selection Listener
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                Select = table.getSelectedRow();
            }
        });
        //Combobox
        TableColumn testColumn = table.getColumnModel().getColumn(4);
        comboBox = new JComboBox<>(NewConsignment.getDeliveryMembers());
        comboBox.addItemListener(this);
        comboBox.setFont(text1);
        testColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //Header
        JTableHeader tab = table.getTableHeader();
        tab.setBackground(new Color(71, 63, 145));
        tab.setForeground(Color.white);

        //Scroll
        scroll = new JScrollPane(table);
        scroll.setBounds(30, 30, 1200, 500);
        scroll.setVisible(true);

        this.add(scroll);
        this.setLayout(null);
        this.setBackground(Color.white);
    }

    //Function to get the all the delivery members id to set in new consignment table 
    public static String[] getDeliveryMembers() {
        ArrayList<DeliveryProfile> details = Database.DatabaseOperations.getDeliveryDetails();
        String[] delivery = new String[details.size()];
        for (int i = 0; i < details.size(); i++) {
            DeliveryProfile temp = details.get(i);
            if (!temp.getId().equals("Keshav B")) {
                delivery[i] = temp.getId();
            }
        }
        return delivery;
    }

    //Item Listener
    @Override
    public void itemStateChanged(ItemEvent e) {
        try{
        if (Select != -1) {
            int column = 0;
            String newStatus = comboBox.getSelectedItem().toString();
            value = table.getModel().getValueAt(Select, column).toString();
            DatabaseOperations.updateConsignmentDelivery(newStatus, value);
            Consignment.consignment.setNewdAdminConsignmentDetails();
        }
    }catch(Exception E){}
    }

}
