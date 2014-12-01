import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 25.11.2014.
 */
public class Enemy {
    int x;
    int y;
    int dy=-13;
    boolean right;
    int hp=100;
    boolean iskilled = false;
    public Enemy(int x,int y){
        this.x=x;
        this.y=y;
        this.right=right;
        timer.start();
    }
    Timer timer = new Timer(20, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (!iskilled){
              x-=5; //+ Engine.getDX();
          } else {
              x+=31;
              y+=dy;
              dy+=1;
          }
        }
    });
    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }
    public void decHP(){
        hp -=50;

    }
    public int GetHP(){
        return hp;
    }
    public void kill(){
            iskilled = true;
    }
}
