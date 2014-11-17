import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Playing extends JComponent {
/**
 * Текущая координата
 */
        private int x = 0;
/**
 * Скорость движения (положительная - вправо, отрицательная - влево)
 */
        private int dx = 0;
/**
 * Фоновое изображение
 */
        private BufferedImage background;
        private BufferedImage model;
        public Playing() throws IOException {
// Загружаем изображение из файла:
            background = ImageIO.read(getClass().getResource("game.png"));
            model = ImageIO.read(getClass().getResource("model3.gif"));
// Устанавливаем начальный размер компонента (высота - по высоте изображения)
            setPreferredSize(new Dimension(1100, background.getHeight()));
// Для того, чтобы обрабатывать нажатия клавиш, компонент должен иметь фокус ввода:
            setFocusable(true);
// Нажатия кнопок влево/вправо меняют скорость движения
            addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        dx = -5;
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        dx = 5;
                    }
                }
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        dx=0;
                    }
                }
            });
// Таймер будет срабатывать каждые 20 миллисекунд (50 раз в секунду)
            Timer timer = new Timer(20, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
// Изменяем текущие координаты
                    if (dx<0 && x<5) {
                        dx=0;
                    } else {
                        x += dx;
                    }
// Перерисовываем картинку
                    repaint();
                }
            });
// Запускаем таймер:
            timer.start();
        }

/**
 * Рисование фона
 * @param g графический контекст
 * @param x текущие координаты
 */
    private void drawBackground(Graphics g, int x) {
// Определяем ширину экрана:
        int screenWidth = getWidth();
// Определяем ширину изображения:
        int imageWidth = background.getWidth();
// x1 - координата, в которой нужно нарисовать самое левое изображение:
        int x1;
        if (x >= 0) {
            x1 = -x % imageWidth;
        } else {
            x1 = -x % imageWidth - imageWidth;
        }
// Продолжаем рисовать, пока не замостим весь экран:
        while (x1 < screenWidth) {
            g.drawImage(background, x1, 0, this);
           x1 += imageWidth;
       }
        g.drawImage(model, 50, getHeight()-275,170,240, this);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, x);
    }
    public static void start() throws IOException {
// Создаем главное окно приложения с заголовком
       JFrame frame = new JFrame("RoboCop 3");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
// Создаем компонент...
        Playing scene = new Playing();
// ...и добавляем его в окно
        frame.add(scene, BorderLayout.CENTER);
// Авто-определение размера окна
        frame.pack();
        frame.setResizable(false);
// Перемещение окна в центр экрана
        frame.setLocationRelativeTo(null);
// Показываем окно на экране
        frame.setVisible(true);
    }
}


