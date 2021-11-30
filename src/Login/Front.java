package Login;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Front extends JPanel {

    //private Static variables
    private static Color bg = new Color(34, 34, 45);
    private static Color fg = new Color(254, 254, 254);
    private static Color pri = new Color(71, 63, 145);
    private static ImageIcon logo;
    private static Image image, newimg;
    private static JLabel lLogo;

    public Front() {
        logo = new ImageIcon(getClass().getResource("/Images/Group 33.png"));
        image = logo.getImage();
        newimg = image.getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(newimg);

        lLogo = new JLabel(logo);
        lLogo.setBounds(460, 245, 400, 300);
        this.add(lLogo);
        lLogo.setBorder(null);
        this.setLayout(null);
        this.setBackground(bg);

    }

    //Executes transitions
    public static void execute() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        int a = 400, b = 200;
        for (int i = 245; i > 0; i--) {
            try {
                Thread.sleep(1);
                lLogo.setBounds(460, i, 400, 300);
                if (a > 200 && b > 100 && i % 12 == 0) {
                    a -= 12;
                    b -= 6;
                    newimg = image.getScaledInstance(a, b, java.awt.Image.SCALE_FAST);
                    lLogo.setIcon(new ImageIcon(newimg));
                }
            } catch (Exception e) {
            }
        }
        main.main.switchPage("login");
    }
}
