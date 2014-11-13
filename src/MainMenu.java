import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

    public static void start() {
        final Music musicmenu = new Music();
        musicmenu.PlayMenu();
       final JFrame frame = new JFrame("Robocop");
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

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicmenu.Stop();
                final Music musicgame = new Music();
                musicgame.PlayGame();
                frame.dispose();
                try {
                    Playing.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }
}

