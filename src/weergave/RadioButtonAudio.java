package weergave;

import gfx.Audio;
import javax.swing.JRadioButton;

public class RadioButtonAudio extends JRadioButton {
    private Audio audio;

    public RadioButtonAudio(String text, Audio audio) {
        super(text);
        this.audio = audio;
    }

    public Audio getAudio() {
        return this.audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }
}