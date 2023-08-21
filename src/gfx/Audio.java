package gfx;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
    private String artist;
    private String titel;
    private Clip clip;

    public Audio(String artist, String titel, String path) {
        this.artist = artist;
        this.titel = titel;

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(Audio.class.getResource(path));
            this.clip = AudioSystem.getClip();
            this.clip.open(audio);
        } catch (Exception var5) {
        }

    }

    public void play() {
        this.clip.start();
    }

    public void stop() {
        this.clip.setMicrosecondPosition(0L);
        this.clip.stop();
    }

    public String writeSong() {
        return this.artist + " - " + this.titel;
    }
}
