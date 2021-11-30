package customer;

import Database.*;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

class ConsignmentPanel extends JPanel {

    //private
    private TableModel model;
    private JScrollPane scroll;
    //public
    public static TableRowSorter sorter;
    public JTable table;

    public ConsignmentPanel() {

        this.setLayout(null);
        this.setBackground(Color.white);
        //Rows
        Object[][] rows = DatabaseOperations.getCustomerConsignmentDetails();
        //columns
        String[] columns = {"S.NO", "Consignment ID", "From", "To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);

        model = new DefaultTableModel(rows, columns);
        sorter = new TableRowSorter(model);

        //Object For Table
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        table.setRowSorter(sorter);
        table.setRowHeight(30);
        table.setBorder(border);
        table.setRowSelectionAllowed(true);

        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //ListSelectionListener to Listen Selected Row
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                int[] selectedRow = table.getSelectedRows();
                Integer data = (Integer) table.getValueAt(selectedRow[0], 0);
                int temp = data - 1;
                ConsignmentDetails ob = (ConsignmentDetails) CustomerPanel.PConsignmentDetails;
                ob.setConignmentDetails(temp);
                CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer, "ConsignmentDetails");

            }

        });

        //Table header
        JTableHeader tab = table.getTableHeader();
        tab.setBackground(new Color(71, 63, 145));
        tab.setForeground(Color.white);

        //adding Table in Scroll Pane
        scroll = new JScrollPane(table);

        scroll.setBounds(30, 30, 1200, 500);
        scroll.setVisible(true);
        this.add(scroll);
    }

}
