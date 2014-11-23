import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by User on 10.11.2014.
 */
public class Music {
    private Clip clip = null;
    private FloatControl volumeC = null;
    private boolean playing = false;

    public void PlayMenu() {
        try {
            File soundFile = new File("Robocop.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
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
    public void Stop(){
        clip.stop();
        clip.setFramePosition(0);
    }
    public void PlayGame() {
        try {
            File soundFile = new File("Robocopgame.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
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
    public void PlayFalling() {
        try {
            File soundFile = new File("Fall.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(0);
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
    public void PlayHeroShoot() {
        try {
            File soundFile = new File("shoothero.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(0);
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
