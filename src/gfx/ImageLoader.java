package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import javax.imageio.ImageIO;

public class ImageLoader {
    public ImageLoader() {
    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read((URL) Objects.requireNonNull(ImageLoader.class.getResource(path)));
        } catch (IOException var2) {
            return null;
        }
    }
}
