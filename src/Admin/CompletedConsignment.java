package Admin;

import static Admin.OnGoingConsignment.selectedData;
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

public class CompletedConsignment extends JPanel {

    //Private Variables
    private JScrollPane scroll;

    //Public Variables
    public static JTable table;
    public static DefaultTableModel model;

    //Constructer
    CompletedConsignment() {

        //Column values
        String[] columns = {"Consignment ID", "From", "To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        //Table
        table = new JTable(model);
        table.setRowHeight(30);
        table.setBorder(border);
        table.setSelectionBackground(new Color(255, 255, 200));

        //ListSelection Listener
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectRow = table.getSelectedRow();
                if (selectRow != -1) {
                    selectedData = (String) table.getValueAt(selectRow, 0);
                    Consignment.consignment.setConsignmentDetails(selectedData);
                    AdminPanel.card = "CompletedConsignment";
                    AdminPanel.adminCard.show(AdminPanel.contentForAdmin, "ConsignmentDetails");
                    table.clearSelection();
                }
            }
        });

        //Header
        JTableHeader tab = table.getTableHeader();
        tab.setBackground(new Color(71, 63, 145));
        tab.setForeground(Color.white);

        //Scroll Bar
        scroll = new JScrollPane(table);
        scroll.setBounds(30, 30, 1200, 500);
        scroll.setVisible(true);

        this.setLayout(null);
        this.setBackground(Color.white);
        this.add(scroll);
    }

}
