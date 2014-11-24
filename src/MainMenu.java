import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by User on 10.11.2014.
 */
public class MainMenu extends JComponent {

    private Rectangle button = new Rectangle(50, 460, 120, 50);
    private Image img = getToolkit().getImage(getClass().getResource("startgameonmove.png"));
    public JFrame frame = new JFrame("Robocop v0.2");

    public MainMenu() {
        setPreferredSize(new Dimension(800, 600));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                startGame(e);
            }

            private void startGame(MouseEvent e) {
                if (button.contains(e.getX(), e.getY())) {
                    Music.getMusic().StopMenu();
                    Music.getMusic().PlayGame();
                    frame.dispose();
                    try {
                        Engine.start();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (button.contains(e.getX(), e.getY())) {
                    img = getToolkit().getImage(getClass().getResource("startgameonclick.png"));
                    repaint();
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
       // Image img = getToolkit().getImage(getClass().getResource("startgame.png"));
        g.drawImage(img, 50, 440, 150,60, this);
    }

    public void start() {
      //  final Music musicmenu = new Music();
        Music.getMusic().PlayMenu();
     //   final JFrame frame = new JFrame("Robocop");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

