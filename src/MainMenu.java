import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by User on 10.11.2014.
 */
public class MainMenu extends JComponent {
    private Rectangle button = new Rectangle(50, 460, 120, 50); // создаем кликабельную зону, где будет наша кнопка старта
    private Image img = getToolkit().getImage(getClass().getResource("startgame.png")); // загрузка фона
    public JFrame frame = new JFrame("Robocop v0.2"); // создание фрейма

    public MainMenu() {
        setPreferredSize(new Dimension(800, 600)); //задаем разрешение
        addMouseListener(new MouseAdapter() { //задаем слушателя
            @Override
            public void mouseClicked(MouseEvent e) {
                img = getToolkit().getImage(getClass().getResource("startgameonclick.png"));
                repaint();
                startGame(e);
            } //если мышь нажата, загрузить картинку нажатой кнопки, перерисовать форму и начать игру

            @Override
            public void mouseDragged(MouseEvent e) {
                img = getToolkit().getImage(getClass().getResource("startgameonclick.png"));
                repaint();
                startGame(e);
            } //если мышь нажата со сдвигом, загрузить картинку нажатой кнопки, перерисовать форму и начать игру

            private void startGame(MouseEvent e) {
                if (button.contains(e.getX(), e.getY())) {
                    Music.getMusic().StopMenu();
                    img = getToolkit().getImage(getClass().getResource("startgameonclick.png"));
                    repaint();
                    Music.getMusic().PlayGame();
                    frame.dispose();
                    try {
                        Engine.start();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            // если мышь нажата в нужных коордмнатах, то остановить музыку меню, изменить картинку кнопки, перерисовать, убрать текущий фрейм и начать игру.
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (button.contains(e.getX(), e.getY())) {
                    img = getToolkit().getImage(getClass().getResource("startgameonmove.png"));
                    repaint();
                } else {
                    img = getToolkit().getImage(getClass().getResource("startgame.png"));
                    repaint();
                }
                // перерисовка кнопки в зависимости от того, где курсор
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
        Music.getMusic().PlayMenu();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //установить де    ствие при закрытии по умолчанию
        frame.add(this);
        frame.pack();
        frame.setResizable(false); //нельзя изменять размер
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); // не задаем лейаутов
        frame.setVisible(true); //фрейм видимый
    }
}

