import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 25.11.2014.
 */
public class Enemy {
    int x;
    int y;
    boolean right;
    public Enemy(int x,int y){
        this.x=x;
        this.y=y;
        this.right=right;
        timer.start();
    }
    Timer timer = new Timer(20, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            x-=6 + Engine.getDX();
        }
    });
    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }

}
