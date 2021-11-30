package Delivery;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class completed extends JPanel {

    //Private Variables
    private String column_name[] = {"Con-ID", "From", "To", "Item", "Delivery Id", "Payment ", "Date", "Status"};
    private Border border = new LineBorder(new Color(71, 63, 145), 1, true);
    private JTable table1;
    private JScrollPane sp;
    private Color panel = new Color(240, 238, 240);
    private Color back = new Color(34, 34, 44);
    private Color button = new Color(71, 63, 144);
    private int font = 16;
    private int font1 = 16;
    private Font text = new Font("Verdana", Font.BOLD, font);
    private Font text1 = new Font("arial", Font.BOLD, font1);
    private String selectedData = "";

    //Public Variables
    public static DefaultTableModel model1;
    public Object row[][] = {};

    //Constructor
    completed() {
        this.setLayout(null);
        this.setBounds(55, 150, 1260, 570);

        //Table
        model1 = new DefaultTableModel(row, column_name);
        table1 = new JTable(model1);
        JTableHeader tableHeader = table1.getTableHeader();
        tableHeader.setBackground(button);
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(text1);
        table1.setFont(text1);
        table1.setRowHeight(30);
        table1.setBackground(Color.white);
        table1.setForeground(back);
        ListSelectionModel select = table1.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Listener For Table
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectRow = table1.getSelectedRow();
                if (selectRow != -1) {
                    selectedData = (String) table1.getValueAt(selectRow, 0);
                    Consignment.consignment.setDeliveryConsignmentDetails(selectedData);
                    delivery.deliveryCard.show(delivery.ContentForDelivery, "PDeliveryConsignment");
                    table1.clearSelection();
                }
            }
        });

        //Scroll Pane
        sp = new JScrollPane(table1);
        sp.setBounds(30, 30, 1200, 500);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setBackground(button);
        sp.setForeground(Color.black);
        sp.setFont(new Font("arial", Font.BOLD, 20));
        sp.setVisible(true);

        add(sp);
        setVisible(true);
        this.setBackground(panel);
    }

}
