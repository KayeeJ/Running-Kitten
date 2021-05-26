package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class MusicPlay {
    private static Clip bgm;//背景乐
    private static AudioInputStream ais;

    public MusicPlay() {
    }

    public static void play(String filename) {
        try {
            bgm = AudioSystem.getClip();
            InputStream is = MusicPlay.class.getClassLoader().getResourceAsStream(filename);
            //getclassLoader得到当前类的加载器.getResourceAsStream加载资源，只能加载wav的音乐格式
            if (is != null) {
                ais = AudioSystem.getAudioInputStream(is);//获取输入流
            }
            bgm.open(ais);
            //is.close();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        bgm.start();//开始播放
    }

    public static void loop() {
        bgm.loop(Clip.LOOP_CONTINUOUSLY);//循环播放
    }

    public void stop() {
        if (ais != null)
            bgm.close();

        try {
            ais.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}