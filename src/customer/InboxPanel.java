package customer;

import Database.DatabaseOperations;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import customer.DatasForCustomer.*;

public class InboxPanel extends JPanel implements MouseListener {

    // private
    private JLabel icon, Sender_Name, Subject, Date, Time;
    private Integer index;
    private Border border = BorderFactory.createRaisedBevelBorder();
    private Icon image = new ImageIcon(getClass().getResource("/Images/profile.png"));
    private final int fontSize = 18;
    private Font font = new Font("Bold", Font.BOLD, fontSize);
    private Integer i = 0, y = 0;
    private JPanel MyPanel;
    private JScrollPane scroll;
    private CardLayout card = new CardLayout();
    private JLabel back;

    public InboxPanel() {
        setLayout(card);
        MyPanel = new JPanel();
        MyPanel.setLayout(null);
        MyPanel.setPreferredSize(new Dimension(1260, 3000));
        // Fetching All IncommingMessages From Database
        try {
            DatabaseOperations.getInboxDetails();
        } catch (Exception h) {

        }

        int count = 0;

        i = InboxData.ListForInbox.size() - 1;
        while (i >= 0) {

            JPanel temp = this.getPanel(i, y);
            temp.addMouseListener(this);
            MyPanel.add(temp);
            y = y + 130;

            i--;
            count++;
        }
        MyPanel.setPreferredSize(new Dimension(1260, count * 147));
        scroll = new JScrollPane(MyPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, "MessagePanel");
        card.show(this, "MessagePanel");

    }

    //Setting sort Message in Panel and adding to the MyPanel
    public JPanel getPanel(Integer i, Integer y) {
        JPanel panel1 = new JPanel(null);
        icon = new JLabel(image);
        icon.setBounds(10, 10, 50, 50);
        Sender_Name = new JLabel(InboxData.ListForInbox.get(i).getSender_name());
        Sender_Name.setBounds(70, -20, 100, 100);
        Sender_Name.setFont(font);
        Subject = new JLabel(InboxData.ListForInbox.get(i).getSubject());
        Subject.setBounds(90, 5, 300, 100);
        Subject.setFont(font);
        Date = new JLabel(InboxData.ListForInbox.get(i).getSent_Date().substring(0, 10));
        Date.setBounds(860, 13, 100, 30);
        Date.setFont(font);
        Time = new JLabel(InboxData.ListForInbox.get(i).getTime().substring(10));
        Time.setBounds(860, 42, 150, 30);
        Time.setFont(font);
        panel1.add(Time);
        panel1.add(icon);
        panel1.add(Sender_Name);
        panel1.add(Subject);
        panel1.add(Date);
        panel1.setBounds(120, 90 + y, 1000, 85);
        panel1.setBackground(Color.white);
        panel1.setBorder(border);
        panel1.setName(i.toString());
        return panel1;
    }

    //MouseListener For Panel Switching
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() instanceof JPanel) {
            JPanel p = (JPanel) e.getSource();
            index = Integer.valueOf(p.getName());
            add(getViewInbox(index), "viewMessage");
            card.show(this, "viewMessage");
        }
        if (e.getSource() == back) {
            card.show(this, "MessagePanel");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //Setting Particular selected Messages in New Panel And Showing It
    public JPanel getViewInbox(int i) {
        JPanel viewMessage = new JPanel(null);
        viewMessage.setPreferredSize(new Dimension(1260, 750));

        Icon icon = new ImageIcon(getClass().getResource("/Images/back.png"));
        back = new JLabel(icon);
        back.setBounds(10, 10, 30, 30);
        back.setBorder(null);
        back.setBackground(Color.WHITE);
        back.addMouseListener(this);

        JLabel ProfileIcon = new JLabel(image);
        ProfileIcon.setBounds(50, 65, 50, 50);

        Sender_Name = new JLabel(InboxData.ListForInbox.get(i).getSender_name());
        Sender_Name.setBounds(120, 68, 200, 28);
        Sender_Name.setFont(font);
        Subject = new JLabel(InboxData.ListForInbox.get(i).getSubject());
        Subject.setBounds(120, 60, 500, 100);
        Subject.setFont(font);

        Date = new JLabel(InboxData.ListForInbox.get(i).getSent_Date().substring(0, 10));
        Date.setBounds(1100, 66, 100, 30);
        Date.setFont(font);

        Time = new JLabel(InboxData.ListForInbox.get(i).getTime().substring(10));
        Time.setBounds(1100, 86, 150, 30);
        Time.setFont(font);

        JTextArea message = new JTextArea();
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setEditable(false);
        message.setBackground(null);
        String m = InboxData.ListForInbox.get(i).getMessage();
        message.setText(m);
        message.setFont(font);
        message.setBounds(120, 190, 990, 370);

        viewMessage.add(ProfileIcon);
        viewMessage.setFont(font);
        viewMessage.add(Time);
        viewMessage.add(Sender_Name);
        viewMessage.add(Subject);
        viewMessage.add(Date);
        viewMessage.add(back);
        viewMessage.add(message);
        viewMessage.setForeground(Color.WHITE);
        return viewMessage;

    }

}
