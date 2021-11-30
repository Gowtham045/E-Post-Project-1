package Admin;

import java.awt.Color;
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

public class OnGoingConsignment extends JPanel {

    //Private Variables
    private ListSelectionModel select;
    private JScrollPane scroll;

    //Public Variables
    public static JTable table;
    public static String selectedData;
    public static DefaultTableModel model;
    public static String[] columns = {"Consignment ID", "From", "To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};

    OnGoingConsignment() {

        //Border
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        //Table
        table = new JTable(model);
        table.setRowHeight(30);
        table.setBorder(border);
        table.setSelectionBackground(new Color(255, 255, 200));

        //List Listener
        select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectRow = table.getSelectedRow();
                if (selectRow != -1) {
                    selectedData = (String) table.getValueAt(selectRow, 0);
                    Consignment.consignment.setConsignmentDetails(selectedData);
                    AdminPanel.card = "OnGoingConsignment";
                    AdminPanel.adminCard.show(AdminPanel.contentForAdmin, "ConsignmentDetails");
                    table.clearSelection();
                }
            }
        });

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

}
