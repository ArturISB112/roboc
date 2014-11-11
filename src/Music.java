import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by User on 10.11.2014.
 */
public class Music {
    public static void Play() {
        try {
            File soundFile = new File("Robocopmenu.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(clip.LOOP_CONTINUOUSLY);
            clip.setFramePosition(0); //устанавливаем указатель на старт
            clip.start(); //Поехали!!!
            //   Thread.sleep(clip.getMicrosecondLength()/1000);
            //    clip.stop(); //Останавливаем
            //     clip.close(); //Закрываем
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
