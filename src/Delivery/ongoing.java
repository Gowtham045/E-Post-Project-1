package Delivery;

import Database.DatabaseOperations;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class ongoing extends JPanel implements ItemListener 
{
    private String column_name[] = {"Con-ID", "From", "To", "Item", "Delivery Id", "Payment ", "Date", "Status"};
    Object row[][] = {};    
   
    //Private Variables
    private JScrollPane sp;    
    private Color panel = new Color(240, 238, 240);
    private Color back = new Color(34, 34, 44);
    private Color button = new Color(71, 63, 144);
    private int font = 16;
    private int font1 = 16;
    private Font text = new Font("Verdana", Font.BOLD, font);
    private Font text1 = new Font("arial", Font.BOLD, font1);
    private JComboBox comboBox;
    private String value = "";
    private String selectedData = "";
    private int Selected_row = 0;
    
    //Public Variables
    public static JTable table;
    public static DefaultTableModel model;

    public ongoing() 
    {
        this.setLayout(null);
        this.setBounds(55, 150, 1260, 570);

        //MODEL
        model = new DefaultTableModel(row, column_name);
        table = new JTable(model);

        //TABLE
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(button);
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(text1);
        TableColumn Statusdelivery = table.getColumnModel().getColumn(7);

        table.setFont(text1);
        table.setRowHeight(30);
        table.setBackground(Color.white);
        table.setForeground(back);

        //COMBOBOX
        String[] Status = {"Order Placed", "In-Transit", "Completed"};
        comboBox = new JComboBox<String>(Status);
        comboBox.addItemListener(this);
        comboBox.setFont(text1);
        Statusdelivery.setCellEditor(new DefaultCellEditor(comboBox));
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent e) 
            {
                Selected_row = table.getSelectedRow();
            }
        });

        //SCROLL PANE
        sp = new JScrollPane(table);
        sp.setBounds(30, 30, 1200, 500);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setBackground(button);
        sp.setForeground(Color.black);
        sp.setFont(new Font("arial", Font.BOLD, 20));
        sp.setVisible(true);
        
        //ADDING TO PANEL
        add(sp);
        setVisible(true);
        this.setBackground(panel);
    }
    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if (e.getStateChange() == 2) 
        {
            if (Selected_row != -1) 
            {
                int column = 0;
                String newStatus = comboBox.getSelectedItem().toString();
                value = table.getModel().getValueAt(Selected_row, column).toString();
                DatabaseOperations.UpdateDeliveryDeatils(value, newStatus);
            }

        }

    }

}
