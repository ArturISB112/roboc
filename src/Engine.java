import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Engine extends JComponent {
    /**
     * Текущая координата
     */
    private int x = 0;
    /**
     * Скорость движения (положительная - вправо, отрицательная - влево)
     */
    private int HeroX, HeroY = 0;
    private static int dx = 0;
    private int sitmodelcount = 0;
    private int y = 0;
    private double dy = 0;
    private boolean jumping = false;
    private boolean sitdown = false;
    private boolean situp = false;
    private static boolean isright = true;
    private boolean canfire = true;
    private int reload = -1;
    private BufferedImage background;
    private Image modelStop, modelWalk, modelJump;
    private Image modelSittingDown1, modelSittingDown2, modelSittingDown3;
    private Image image;
    private Image PatronHero;
    private ArrayList<Bullet> Bullets = new ArrayList<Bullet>();
    private ArrayList<EnvObj> objcts = new ArrayList<EnvObj>();
    public Engine() throws IOException {
// Загружаем изображение из файла:
        background = ImageIO.read(getClass().getResource("game.png"));
        //   model = getToolkit().getImage(getClass().getResource("model3.gif"));
        modelStop = getToolkit().getImage(getClass().getResource("herostop.png"));
        modelWalk = getToolkit().getImage(getClass().getResource("model3.gif"));
        modelJump = getToolkit().getImage(getClass().getResource("herojump.png"));
        modelSittingDown1 = getToolkit().getImage(getClass().getResource("sittingdown1.png"));
        modelSittingDown2 = getToolkit().getImage(getClass().getResource("sittingdown2.png"));
        modelSittingDown3 = getToolkit().getImage(getClass().getResource("sittingdown3.png"));
        modelSittingDown1.getWidth(this);
        modelSittingDown2.getWidth(this);
        modelSittingDown3.getWidth(this);
        PatronHero = getToolkit().getImage(getClass().getResource("bullet.png"));
        image = modelStop;
        EnvObj pregrada = new EnvObj(2450,30,20,30);
        objcts.add(pregrada);
// Устанавливаем начальный размер компонента (высота - по высоте изображения)
        setPreferredSize(new Dimension(1100, background.getHeight()));
// Для того, чтобы обрабатывать нажатия клавиш, компонент должен иметь фокус ввода:
        setFocusable(true);
// Нажатия кнопок влево/вправо меняют скорость движения
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    dx = -5;
                    isright = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    dx = 5;
                    isright = true;
                } else if (e.getKeyCode() == KeyEvent.VK_UP && !jumping) {
                    dy = 18.0;
                    jumping = true;
                } else if (e.getKeyCode() == KeyEvent.VK_CONTROL && canfire) {
                    canfire = false;
                    Music.getMusic().PlayHeroShoot();
                    if (isright) {
                        Bullet a = new Bullet(HeroX + 145, HeroY + 63, isright);
                        Bullets.add(a);
                    } else {
                        Bullet a = new Bullet(HeroX - 152, HeroY + 63, isright);
                        Bullets.add(a);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && !sitdown && !jumping) {
                    sitdown = true;
                    situp = false;
                    sitmodelcount = 0;
                }
            }

            public void keyReleased(KeyEvent e) {
                //modelStop = getToolkit().getImage(getClass().getResource("herostop.png"));
                if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    dx = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && sitdown) {
                    sitdown = false;
                    situp = true;
                    sitmodelcount = 4;
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL && !canfire) {
                    reload = 0;
                }
            }
        });
// Таймер будет срабатывать каждые 20 миллисекунд (50 раз в секунду)
        Timer timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
// Изменяем текущие координаты
                if (reload >= 4) {
                    canfire = true;
                    reload = -1;
                }
                if (reload >= 0 && reload <= 5) {
                    reload++;
                }
                if (dx < 0 && x < 5 || sitdown == true) {
                    dx = 0;
                } else {
                    int x1 = x + dx;
                    for (EnvObj d : objcts){
                        if (x1>d.x){
                            x1 = d.x;
                        }
                    }
                    x = x1;
                }
                if (sitdown) {
                    sitmodelcount++;
                    if (sitmodelcount > 3) {
                        sitmodelcount = 4;
                    }
                }
                if (situp) {
                    sitmodelcount--;
                    if (sitmodelcount < 0) {
                        sitmodelcount = -1;
                    }
                }
                if (jumping) {
                    y += dy;
                    dy -= 0.5;
                    if (y <= 0) {
                        y = 0;
                        Music.getMusic().PlayFalling();
                        jumping = false;
                    }
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
     *
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
        if (sitdown && !jumping) {
            switch (sitmodelcount) {
                case 1:
                    image = modelSittingDown1;
                    break;
                case 2:
                    image = modelSittingDown2;
                    break;
                case 3:
                    image = modelSittingDown3;
                    break;
            }
        } else if (situp) {
            switch (sitmodelcount) {
                case 0:
                    image = modelStop;
                    break;
                case 1:
                    image = modelSittingDown1;
                    break;
                case 2:
                    image = modelSittingDown2;
                    break;
                case 3:
                    image = modelSittingDown3;
                    situp = false;
                    break;
            }

        } else if (jumping) {
            image = modelJump;
        } else {
            image = dx != 0 ? modelWalk : modelStop;
        }
        HeroX = isright ? 50 : 190;
        HeroY = getHeight() - 265 - y;
        g.drawImage(image, HeroX, HeroY, isright ? 150 : -150, 225, this);
        g.setColor(Color.white);
        for (Iterator<Bullet> i = Bullets.iterator(); i.hasNext(); ) {
            Bullet s = i.next();
            if (s.GetX() > screenWidth + 15) {
                //Bullets.remove(s);
                i.remove();
            }
        }
        for (Bullet s : Bullets) {
            g.drawImage(PatronHero, s.GetX(), s.GetY(), 22, 21, this);

        }
        g.draw3DRect(screenWidth - 300, 20, 230, 45, true);
        g.setColor(Color.red);
        g.fillRect(screenWidth - 300, 20, 230, 45);
        g.setColor(Color.yellow);
        g.drawString("100%", screenWidth - 200, 45);
        g.drawString("X="+String.valueOf(x), 50, 50);
        g.drawString("Y="+String.valueOf(y),50,75);
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
        Engine scene = new Engine();
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

    public static int getDX() {
        return dx;
    }
    public static boolean getIsRight(){
        return isright;
    }

}


