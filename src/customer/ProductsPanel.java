package customer;

import static Database.DatabaseOperations.*;
import customer.DatasForCustomer.WalletDataG;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import warehouse.Warehouse;

public class ProductsPanel extends JPanel implements MouseListener {

    //private 
    private JLabel revenueStamp, postageStamp, postageStamp1, collectorStamp, inlandLetter, envelope, postCard;
    private JLabel revenueStampName, postageStampName, postageStamp1Name, collectorStampName, inlandLetterName, postCardName, envelopeName;
    private JLabel revenueStampPrice, postageStampPrice, postageStamp1Price, collectorStampPrice, inlandLetterPrice, postCardPrice, envelopePrice;
    private JLabel revenueStampQuantity, postageStampQuantity, postageStamp1Quantity, collectorStampQuantity, inlandLetterQuantity, postCardQuantity, envelopeQuantity;
    //Stamp Images
    private ImageIcon revenueStampImage, postageStampImage, postageStamp1Image, collectorStampImage, inlandLetterImage, postCardImage, envelopeImage;
    private Image image, newimg;

    public ProductsPanel() {
        Color bg = new Color(34, 34, 45);
        Color fg = new Color(254, 254, 254);
        Border border = new LineBorder(new Color(71, 63, 145), 5, true);

        //Objects
        JPanel prod = new JPanel(null);

        prod.setPreferredSize(new Dimension(1260, 780));

        revenueStampImage = new ImageIcon(getClass().getResource("/Images/REVENUE STAMP.jpg"));
        image = revenueStampImage.getImage(); // transform it 
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        revenueStampImage = new ImageIcon(newimg);

        revenueStamp = new JLabel(revenueStampImage);
        revenueStamp.setBorder(border);
        revenueStamp.setBounds(50, 50, 180, 180);
        revenueStamp.addMouseListener(this);

        revenueStampName = new JLabel("Item Name  : Revenue Stamp");
        revenueStampName.setBounds(50, 250, 240, 40);
        revenueStampPrice = new JLabel("Item Price : Rs.5");
        revenueStampPrice.setBounds(50, 290, 240, 40);
        revenueStampQuantity = new JLabel("Item Quantity : 10");
        revenueStampQuantity.setBounds(50, 330, 240, 40);

        prod.add(revenueStamp);
        prod.add(revenueStampName);
        prod.add(revenueStampPrice);
        prod.add(revenueStampQuantity);

        postageStampImage = new ImageIcon(getClass().getResource("/Images/M.S. SUBULAKSHMI STAMP.jpg"));
        image = postageStampImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        postageStampImage = new ImageIcon(newimg);

        postageStamp = new JLabel(postageStampImage);
        postageStamp.setBorder(border);
        postageStamp.setBounds(350, 50, 180, 180);
        postageStamp.addMouseListener(this);

        postageStampName = new JLabel("Item Name  : Postage Stamp");
        postageStampName.setBounds(350, 250, 240, 40);
        postageStampPrice = new JLabel("Item Price : Rs.5");
        postageStampPrice.setBounds(350, 290, 240, 40);
        postageStampQuantity = new JLabel("Item Quantity : 10");
        postageStampQuantity.setBounds(350, 330, 240, 40);

        prod.add(postageStamp);
        prod.add(postageStampName);
        prod.add(postageStampPrice);
        prod.add(postageStampQuantity);

        postageStamp1Image = new ImageIcon(getClass().getResource("/Images/BAL GANGADHAR TILAK STAMP.jpg"));
        image = postageStamp1Image.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        postageStamp1Image = new ImageIcon(newimg);

        postageStamp1 = new JLabel(postageStamp1Image);
        postageStamp1.setBorder(border);
        postageStamp1.setBounds(650, 50, 180, 180);
        postageStamp1.addMouseListener(this);

        postageStamp1Name = new JLabel("Item Name  : Postage Stamp");
        postageStamp1Name.setBounds(650, 250, 240, 40);
        postageStamp1Price = new JLabel("Item Price : Rs.5");
        postageStamp1Price.setBounds(650, 290, 240, 40);
        postageStamp1Quantity = new JLabel("Item Quantity : 10");
        postageStamp1Quantity.setBounds(650, 330, 240, 40);

        prod.add(postageStamp1);
        prod.add(postageStamp1Name);
        prod.add(postageStamp1Price);
        prod.add(postageStamp1Quantity);

        collectorStampImage = new ImageIcon(getClass().getResource("/Images/GURU NANAK DEV STAMP.jpg"));
        image = collectorStampImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        collectorStampImage = new ImageIcon(newimg);

        collectorStamp = new JLabel(collectorStampImage);
        collectorStamp.setBorder(border);
        collectorStamp.setBounds(950, 50, 180, 180);
        collectorStamp.addMouseListener(this);

        collectorStampName = new JLabel("Item Name  : Collector Stamp");
        collectorStampName.setBounds(950, 250, 240, 40);
        collectorStampPrice = new JLabel("Item Price : Rs.5");
        collectorStampPrice.setBounds(950, 290, 240, 40);
        collectorStampQuantity = new JLabel("Item Quantity : 10");
        collectorStampQuantity.setBounds(950, 330, 240, 40);

        prod.add(collectorStamp);
        prod.add(collectorStampName);
        prod.add(collectorStampPrice);
        prod.add(collectorStampQuantity);

        inlandLetterImage = new ImageIcon(getClass().getResource("/Images/INLAND LETTER CARD.jpg"));
        image = inlandLetterImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        inlandLetterImage = new ImageIcon(newimg);

        inlandLetter = new JLabel(inlandLetterImage);
        inlandLetter.setBorder(border);
        inlandLetter.setBounds(50, 400, 180, 180);
        inlandLetter.addMouseListener(this);

        inlandLetterName = new JLabel("Item Name  : Inland Letter");
        inlandLetterName.setBounds(50, 600, 240, 40);
        inlandLetterPrice = new JLabel("Item Price : Rs.5");
        inlandLetterPrice.setBounds(50, 640, 240, 40);
        inlandLetterQuantity = new JLabel("Item Quantity : 10");
        inlandLetterQuantity.setBounds(50, 680, 240, 40);

        prod.add(inlandLetter);
        prod.add(inlandLetterName);
        prod.add(inlandLetterPrice);
        prod.add(inlandLetterQuantity);

        envelopeImage = new ImageIcon(getClass().getResource("/Images/ENVELOPE.jpg"));
        image = envelopeImage.getImage();
        newimg = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        envelopeImage = new ImageIcon(newimg);

        envelope = new JLabel(envelopeImage);
        envelope.setBorder(border);
        envelope.setBounds(350, 400, 180, 180);
        envelope.addMouseListener(this);
        envelope.setBackground(fg);

        envelopeName = new JLabel("Item Name  : Envelope");
        envelopeName.setBounds(350, 600, 240, 40);
        envelopePrice = new JLabel("Item Price : Rs.5");
        envelopePrice.setBounds(350, 640, 240, 40);
        envelopeQuantity = new JLabel("Item Quantity : 10");
        envelopeQuantity.setBounds(350, 680, 240, 40);

        prod.add(envelope);
        prod.add(envelopeName);
        prod.add(envelopePrice);
        prod.add(envelopeQuantity);

        postCardImage = new ImageIcon(getClass().getResource("/Images/POST CARD.jpg"));
        image = postCardImage.getImage();
        newimg = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        postCardImage = new ImageIcon(newimg);

        postCard = new JLabel(postCardImage);
        postCard.setBorder(border);
        postCard.setBounds(650, 400, 180, 180);
        postCard.addMouseListener(this);
        postCard.setBackground(fg);

        postCardName = new JLabel("Item Name  : Postal Card");
        postCardName.setBounds(650, 600, 240, 40);
        postCardPrice = new JLabel("Item Price : Rs.5");
        postCardPrice.setBounds(650, 640, 240, 40);
        postCardQuantity = new JLabel("Item Quantity : 10");
        postCardQuantity.setBounds(650, 680, 240, 40);

        prod.add(postCard);
        prod.add(postCardName);
        prod.add(postCardPrice);
        prod.add(postCardQuantity);

        JScrollPane scroll = new JScrollPane(prod);
        scroll.setPreferredSize(new Dimension(1260, 570));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scroll);
        this.setBackground(fg);
    }

    //MouseClick Listener to Listen Which Stamp is selected by end User
    @Override
    public void mouseClicked(MouseEvent me) {
        ArrayList<Warehouse> stock = getStocks();

        if (me.getSource() == revenueStamp) {
            WalletDataG.setItemCode(stock.get(9).getitemCode());
            new PaymentProducts(9);
        }
        if (me.getSource() == postageStamp) {
            WalletDataG.setItemCode(stock.get(6).getitemCode());
            new PaymentProducts(6);
        }
        if (me.getSource() == postageStamp1) {
            WalletDataG.setItemCode(stock.get(7).getitemCode());
            new PaymentProducts(7);
        }
        if (me.getSource() == collectorStamp) {
            WalletDataG.setItemCode(stock.get(8).getitemCode());
            new PaymentProducts(8);
        }
        if (me.getSource() == inlandLetter) {
            WalletDataG.setItemCode(stock.get(5).getitemCode());
            new PaymentProducts(5);
        }
        if (me.getSource() == envelope) {
            WalletDataG.setItemCode(stock.get(3).getitemCode());
            new PaymentProducts(3);
        }
        if (me.getSource() == postCard) {
            WalletDataG.setItemCode(stock.get(4).getitemCode());
            new PaymentProducts(4);
        }

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}
