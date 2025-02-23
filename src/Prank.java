import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Prank {
    public Prank(String message) {
        int startX = 100;
        int startY = 100;
        int offsetX = 20;
        int offsetY = 20;

        Image errorIcon = (new ImageIcon(getClass().getResource("res/error_icon.png"))).getImage();

        for (int i = 0; i < 10; i++) {
            int x = startX + i * offsetX;
            int y = startY + i * offsetY;

            JOptionPane pane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION);
            JDialog dialog = pane.createDialog("Error");

            dialog.setIconImage(errorIcon);

            dialog.setLocation(x, y);
            dialog.setAlwaysOnTop(true);

            new Thread(() -> dialog.setVisible(true)).start();
        }
    }
}
