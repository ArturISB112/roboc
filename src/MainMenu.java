import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by User on 10.11.2014.
 */
public class MainMenu extends JComponent {

    private Rectangle button = new Rectangle(50, 460, 120, 50);
    private Music musicmenu = new Music();
    public JFrame frame = new JFrame("Robocop");

    public MainMenu() {
        setPreferredSize(new Dimension(800, 600));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (button.contains(e.getX(), e.getY())) {
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
            }
        });
    }


    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        Image image = getToolkit().getImage(getClass().getResource("Robocop3.jpg"));
        g.drawImage(image, 0, 0, width, height, this);
        g.setColor(Color.red);
        g.fillRect(button.x, button.y, button.width, button.height);
        g.setColor(Color.white);
        g.drawString("Start", button.x + 45, button.y + 30);
    }

    public void start() {
      //  final Music musicmenu = new Music();
        musicmenu.PlayMenu();
     //   final JFrame frame = new JFrame("Robocop");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
     /*   JButton btn = new JButton("New game");
        frame.add(btn);
        frame.setComponentZOrder(scene, 0);
        frame.setComponentZOrder(btn, 1);
        scene.setBounds(0, 0, frame.getWidth(), frame.getHeight());
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
        }); */
    }
}

