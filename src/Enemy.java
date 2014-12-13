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
    int count=0;
    boolean right;
    boolean shoot=false;
    boolean canshoot=true;
    boolean stop=false;
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
          if (Engine.isGameover() || Engine.isWin()){
                timer.stop();
            } // есди выйграл или проиграл, остановить таймер
          if (!iskilled){
              if (!shoot && !stop) {
                  x -= 5; //+ Engine.getDX();
              } // если противник не убит, не стреляет и не стоит, то изменять координаты
              if (!canshoot){
                  count++;
                  if (count>120){
                      canshoot=true;
                      count=0;
                  }
              } // если не может стрелять, то ждать
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

    } // уменьшение хп при попадании
    public int GetHP(){
        return hp;
    }
    public void kill(){
            iskilled = true;
    }
    public void shoot(){
        shoot=true;
        canshoot=false;
        stop=true;
    }
    public void  run(){
        shoot=false;
        stop=false;
    }
    public boolean getCanshoot(){
        return canshoot;
    }
    public void setStop(){
        stop=true;
    }
}
