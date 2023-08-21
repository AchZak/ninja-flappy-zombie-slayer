package weergave;

import java.awt.image.BufferedImage;
import javax.swing.JRadioButton;

public class RadioButtonImage extends JRadioButton {
    private BufferedImage image;

    public RadioButtonImage(String text, BufferedImage image) {
        super(text);
        this.image = image;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}