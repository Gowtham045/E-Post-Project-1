package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import warehouse.*;
import Database.DatabaseOperations;

public class Stocks extends JPanel implements ActionListener {

    //Private
    private JButton revenueStamp, postageStamp, postageStamp1, collectorStamp, inlandLetter, postCard, envelope;
    private JButton confirm;
    private JLabel revenueStampName, postageStampName, postageStamp1Name, collectorStampName, inlandLetterName, postCardName, envelopeName;
    private JLabel revenueStampPrice, postageStampPrice, postageStamp1Price, collectorStampPrice, inlandLetterPrice, postCardPrice, envelopePrice;
    private JLabel revenueStampQuantity, postageStampQuantity, postageStamp1Quantity, collectorStampQuantity, inlandLetterQuantity, postCardQuantity, envelopeQuantity;
    private ImageIcon revenueStampImage, postageStampImage, postageStamp1Image, collectorStampImage, inlandLetterImage, postCardImage, envelopeImage;
    private Image image, newimg;

    //Public Variables
    public static JTextField revenueStampQuantity_Info, postageStampQuantity_Info, postageStamp1Quantity_Info, collectorStampQuantity_Info, inlandLetterQuantity_Info, postCardQuantity_Info, envelopeQuantity_Info;

    //Contructer
    public Stocks() {
        Color fg = new Color(254, 254, 254);
        Color but = new Color(71, 63, 145);
        //Border
        Border border = new LineBorder(new Color(71, 63, 145), 5, true);
        Border borde = new LineBorder(new Color(71, 63, 145), 3, true);
        //Font
        Font fon = new Font("Segoe UI", Font.PLAIN, 16);

        JPanel prod = new JPanel(null);
        prod.setBackground(fg);
        prod.setPreferredSize(new Dimension(1260, 780));

        revenueStampImage = new ImageIcon(getClass().getResource("/Images/REVENUE STAMP.jpg"));
        image = revenueStampImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        revenueStampImage = new ImageIcon(newimg);

        //RevenueStamp Button
        revenueStamp = new JButton(revenueStampImage);
        revenueStamp.setBorder(border);
        revenueStamp.setBounds(50, 50, 180, 180);
        revenueStamp.addActionListener(this);

        //RevenueStamp Label
        revenueStampName = new JLabel("Item Name  : Revenue Stamp");
        revenueStampName.setBounds(50, 250, 240, 40);
        revenueStampPrice = new JLabel("Item Price : Rs.1");
        revenueStampPrice.setBounds(50, 290, 240, 40);
        revenueStampQuantity = new JLabel("Item Quantity :");
        revenueStampQuantity.setBounds(50, 330, 240, 40);
        revenueStampQuantity_Info = new JTextField();
        revenueStampQuantity_Info.setBounds(150, 330, 50, 40);
        revenueStampQuantity_Info.setFont(fon);
        revenueStampQuantity_Info.setBackground(fg);
        revenueStampQuantity_Info.setBorder(borde);

        prod.add(revenueStamp);
        prod.add(revenueStampName);
        prod.add(revenueStampPrice);
        prod.add(revenueStampQuantity);
        prod.add(revenueStampQuantity_Info);

        postageStampImage = new ImageIcon(getClass().getResource("/Images/M.S. SUBULAKSHMI STAMP.jpg"));
        image = postageStampImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        postageStampImage = new ImageIcon(newimg);

        //PostageStamp Button
        postageStamp = new JButton(postageStampImage);
        postageStamp.setBorder(border);
        postageStamp.setBounds(350, 50, 180, 180);
        postageStamp.addActionListener(this);

        //Postage Label
        postageStampName = new JLabel("Item Name  : Postage Stamp");
        postageStampName.setBounds(350, 250, 240, 40);
        postageStampPrice = new JLabel("Item Price : Rs.1");
        postageStampPrice.setBounds(350, 290, 240, 40);
        postageStampQuantity = new JLabel("Item Quantity :");
        postageStampQuantity.setBounds(350, 330, 240, 40);
        postageStampQuantity_Info = new JTextField();
        postageStampQuantity_Info.setBounds(450, 330, 50, 40);
        postageStampQuantity_Info.setFont(fon);
        postageStampQuantity_Info.setBackground(fg);
        postageStampQuantity_Info.setBorder(borde);

        prod.add(postageStampQuantity_Info);
        prod.add(postageStamp);
        prod.add(postageStampName);
        prod.add(postageStampPrice);
        prod.add(postageStampQuantity);

        postageStamp1Image = new ImageIcon(getClass().getResource("/Images/BAL GANGADHAR TILAK STAMP.jpg"));
        image = postageStamp1Image.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        postageStamp1Image = new ImageIcon(newimg);

        //Postage Button
        postageStamp1 = new JButton(postageStamp1Image);
        postageStamp1.setBorder(border);
        postageStamp1.setBounds(650, 50, 180, 180);
        postageStamp1.addActionListener(this);

        //Postage Label
        postageStamp1Name = new JLabel("Item Name  : Postage Stamp");
        postageStamp1Name.setBounds(650, 250, 240, 40);
        postageStamp1Price = new JLabel("Item Price : Rs.3");
        postageStamp1Price.setBounds(650, 290, 240, 40);
        postageStamp1Quantity = new JLabel("Item Quantity :");
        postageStamp1Quantity.setBounds(650, 330, 240, 40);
        postageStamp1Quantity_Info = new JTextField();
        postageStamp1Quantity_Info.setBounds(750, 330, 50, 40);
        postageStamp1Quantity_Info.setFont(fon);
        postageStamp1Quantity_Info.setBackground(fg);
        postageStamp1Quantity_Info.setBorder(borde);

        prod.add(postageStamp1Quantity_Info);
        prod.add(postageStamp1);
        prod.add(postageStamp1Name);
        prod.add(postageStamp1Price);
        prod.add(postageStamp1Quantity);

        collectorStampImage = new ImageIcon(getClass().getResource("/Images/GURU NANAK DEV STAMP.jpg"));
        image = collectorStampImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        collectorStampImage = new ImageIcon(newimg);

        //Collector Button
        collectorStamp = new JButton(collectorStampImage);
        collectorStamp.setBorder(border);
        collectorStamp.setBounds(950, 50, 180, 180);
        collectorStamp.addActionListener(this);

        //collector Label
        collectorStampName = new JLabel("Item Name  : Collector Stamp");
        collectorStampName.setBounds(950, 250, 240, 40);
        collectorStampPrice = new JLabel("Item Price : Rs.10");
        collectorStampPrice.setBounds(950, 290, 240, 40);
        collectorStampQuantity = new JLabel("Item Quantity :");
        collectorStampQuantity.setBounds(950, 330, 240, 40);
        collectorStampQuantity_Info = new JTextField();
        collectorStampQuantity_Info.setBounds(1050, 330, 50, 40);
        collectorStampQuantity_Info.setFont(fon);
        collectorStampQuantity_Info.setBackground(fg);
        collectorStampQuantity_Info.setBorder(borde);

        prod.add(collectorStampQuantity_Info);
        prod.add(collectorStamp);
        prod.add(collectorStampName);
        prod.add(collectorStampPrice);
        prod.add(collectorStampQuantity);

        inlandLetterImage = new ImageIcon(getClass().getResource("/Images/INLAND LETTER CARD.jpg"));
        image = inlandLetterImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        inlandLetterImage = new ImageIcon(newimg);

        //InlandLetter Button
        inlandLetter = new JButton(inlandLetterImage);
        inlandLetter.setBorder(border);
        inlandLetter.setBounds(50, 400, 180, 180);
        inlandLetter.addActionListener(this);

        //InlandLetter Label
        inlandLetterName = new JLabel("Item Name  : Inland Letter");
        inlandLetterName.setBounds(50, 600, 240, 40);
        inlandLetterPrice = new JLabel("Item Price : Rs.7");
        inlandLetterPrice.setBounds(50, 640, 240, 40);
        inlandLetterQuantity = new JLabel("Item Quantity :");
        inlandLetterQuantity.setBounds(50, 680, 240, 40);
        inlandLetterQuantity_Info = new JTextField();
        inlandLetterQuantity_Info.setBounds(150, 680, 50, 40);
        inlandLetterQuantity_Info.setFont(fon);
        inlandLetterQuantity_Info.setBackground(fg);
        inlandLetterQuantity_Info.setBorder(borde);

        prod.add(inlandLetterQuantity_Info);
        prod.add(inlandLetter);
        prod.add(inlandLetterName);
        prod.add(inlandLetterPrice);
        prod.add(inlandLetterQuantity);

        envelopeImage = new ImageIcon(getClass().getResource("/Images/ENVELOPE.jpg"));
        image = envelopeImage.getImage();
        newimg = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        envelopeImage = new ImageIcon(newimg);

        //Envelope Button
        envelope = new JButton(envelopeImage);
        envelope.setBorder(border);
        envelope.setBounds(350, 400, 180, 180);
        envelope.addActionListener(this);
        envelope.setBackground(fg);

        //Envelope Label
        envelopeName = new JLabel("Item Name  : Envelope");
        envelopeName.setBounds(350, 600, 240, 40);
        envelopePrice = new JLabel("Item Price : Rs.5");
        envelopePrice.setBounds(350, 640, 240, 40);
        envelopeQuantity = new JLabel("Item Quantity :");
        envelopeQuantity.setBounds(350, 680, 240, 40);
        envelopeQuantity_Info = new JTextField();
        envelopeQuantity_Info.setBounds(450, 680, 50, 40);
        envelopeQuantity_Info.setFont(fon);
        envelopeQuantity_Info.setBackground(fg);
        envelopeQuantity_Info.setBorder(borde);

        prod.add(envelopeQuantity_Info);
        prod.add(envelope);
        prod.add(envelopeName);
        prod.add(envelopePrice);
        prod.add(envelopeQuantity);

        postCardImage = new ImageIcon(getClass().getResource("/Images/POST CARD.jpg"));
        image = postCardImage.getImage();
        newimg = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        postCardImage = new ImageIcon(newimg);

        //Postcard Button
        postCard = new JButton(postCardImage);
        postCard.setBorder(border);
        postCard.setBounds(650, 400, 180, 180);
        postCard.addActionListener(this);
        postCard.setBackground(fg);

        //postCard Label
        postCardName = new JLabel("Item Name  : Postal Card");
        postCardName.setBounds(650, 600, 240, 40);
        postCardPrice = new JLabel("Item Price : Rs.3");
        postCardPrice.setBounds(650, 640, 240, 40);
        postCardQuantity = new JLabel("Item Quantity :");
        postCardQuantity.setBounds(650, 680, 240, 40);
        postCardQuantity_Info = new JTextField();
        postCardQuantity_Info.setBounds(750, 680, 50, 40);
        postCardQuantity_Info.setFont(fon);
        postCardQuantity_Info.setBackground(fg);
        postCardQuantity_Info.setBorder(borde);

        prod.add(postCardQuantity_Info);
        prod.add(postCard);
        prod.add(postCardName);
        prod.add(postCardPrice);
        prod.add(postCardQuantity);

        //Confirm Button
        confirm = new JButton("Confirm");
        confirm.setBorder(null);
        confirm.setBounds(950, 680, 180, 40);
        confirm.addActionListener(this);
        confirm.setBackground(but);
        confirm.setForeground(fg);
        confirm.setUI(new StyledButtonUi());
        prod.add(confirm);

        //scroll Bar
        JScrollPane scroll = new JScrollPane(prod);
        scroll.setPreferredSize(new Dimension(1260, 570));
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);

        this.add(scroll);
        this.setBackground(fg);
    }

    //Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        Object oe = e.getSource();
        if (oe == confirm) {
            ArrayList<Warehouse> stock = new ArrayList<Warehouse>();
            stock.add(new Warehouse("WH0004", envelopeQuantity_Info.getText()));
            stock.add(new Warehouse("WH0005", postCardQuantity_Info.getText()));
            stock.add(new Warehouse("WH0006", inlandLetterQuantity_Info.getText()));
            stock.add(new Warehouse("WH0007", postageStampQuantity_Info.getText()));
            stock.add(new Warehouse("WH0008", postageStamp1Quantity_Info.getText()));
            stock.add(new Warehouse("WH0009", collectorStampQuantity_Info.getText()));
            stock.add(new Warehouse("WH0010", revenueStampQuantity_Info.getText()));
            DatabaseOperations.updateStocks(stock);
            Warehouse.setStocks();
        }
    }

}
