import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 10.11.2014.
 */
public class MainMenu extends JComponent {
    public MainMenu() {
        setPreferredSize(new Dimension(800, 600));
        }


    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
            Image image = getToolkit().getImage(getClass().getResource("Robocop3.jpg"));
            g.drawImage(image, 0, 0, width, height, this);
    }

    public static void paint() {
        JFrame frame = new JFrame("Robocop");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        MainMenu scene = new MainMenu();
        frame.add(scene);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
      frame.setLayout(null);
        frame.setVisible(true);
        JButton btn = new JButton("New game");
        frame.add(btn);
     btn.setBounds(50, 460, 120, 50);
        btn.setVisible(true);
    }
}

