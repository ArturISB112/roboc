import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by User on 10.11.2014.
 */
public class Music {
    private Clip menu = null;
    private Clip music = null;
    private Clip falling = null;
    private Clip heroShoot = null;
    private Clip enemyshoot = null;
    private Clip enemypopal = null;

    private static final Music instance = new Music();

    private Music() {
    }

    public static Music getMusic() {
        return instance;
    }

    public void PlayMenu() {
        try {
            File soundFile = new File("Robocop.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            menu = AudioSystem.getClip();
            menu.open(ais);
            menu.loop(Clip.LOOP_CONTINUOUSLY); // бесокнечное зацикливание
            menu.setFramePosition(0); //устанавливаем указатель на старт
            menu.start(); //начинаем воспроизведение музыки
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StopMenu() {
        menu.stop();
        menu.setFramePosition(0);
    }

    public void PlayGame() {
        try {
            File soundFile = new File("Robocopgame.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            music = AudioSystem.getClip();
            music.open(ais);
            music.loop(Clip.LOOP_CONTINUOUSLY);
            music.setFramePosition(0); //устанавливаем указатель на старт
            music.start(); //Поехали!!!
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StopGame() {
        music.stop();
        music.setFramePosition(0);
    }

    public void EnemyPopal() {
        try {
            if (enemypopal == null) {
                File soundFile = new File("enemypopal.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                enemypopal = AudioSystem.getClip();
                enemypopal.open(ais);
                enemypopal.loop(0); // потвтор 1 раз
            }
            enemypopal.setFramePosition(0); //устанавливаем указатель на старт
            enemypopal.start(); //Поехали!!!
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void EnemyShoot() {
        try {
            if (enemyshoot == null) {
                File soundFile = new File("enemyshoot.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                enemyshoot = AudioSystem.getClip();
                enemyshoot.open(ais);
                enemyshoot.loop(0);
            }
            enemyshoot.setFramePosition(0); //устанавливаем указатель на старт
            enemyshoot.start(); //Поехали!!!
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void PlayWin() {
        try {
            File soundFile = new File("win.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            music = AudioSystem.getClip();
            music.open(ais);
            music.loop(Clip.LOOP_CONTINUOUSLY);
            music.setFramePosition(0); //устанавливаем указатель на старт
            music.start(); //Поехали!!!
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
            if (falling == null) {
                File soundFile = new File("Fall.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                falling = AudioSystem.getClip();
                falling.open(ais);
                falling.loop(0);
            }
            falling.setFramePosition(0); //устанавливаем указатель на старт
            falling.start(); //Поехали!!!
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
            if (heroShoot == null) {
                File soundFile = new File("shoothero.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                heroShoot = AudioSystem.getClip();
                heroShoot.open(ais);
                heroShoot.loop(0);
            }
            heroShoot.setFramePosition(0); //устанавливаем указатель на старт
            heroShoot.start(); //Поехали!!!
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PlayGameOver() {
        try {
            File soundFile = new File("gameover.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            music = AudioSystem.getClip();
            music.open(ais);
            music.loop(Clip.LOOP_CONTINUOUSLY);
            music.setFramePosition(0); //устанавливаем указатель на старт
            music.start(); //Поехали!!!
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
