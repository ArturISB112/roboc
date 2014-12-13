import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 08.12.2014.
 */
public class EnemyBullet {
    int x;
    int y;
    int count = 0;
    boolean right;
    Timer timer = new Timer(20, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (Engine.isGameover() || Engine.isWin()) {
                timer.stop();
            } // если выйграл или проиграл, то стоп
            if (Engine.getIsRight()) {
                x -= 20 + Engine.getDX();
            } else x -= 20 - Engine.getDX();
        }
    });

    public EnemyBullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.right = right;
        timer.start();
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

}

