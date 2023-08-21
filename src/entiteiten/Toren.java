package entiteiten;

import java.awt.image.BufferedImage;
import weergave.SpelPaneel;

public abstract class Toren extends Entiteit {
    public static final int TOREN_WIDTH = 50;
    public static final int TOREN_HEIGHT = 500;
    public static final int AFSTAND_TSS_TOREN = 500;
    public static final int XTOREN_BEGIN = 400;
    public static final int ACHTER_SCHERM = 1450;
    public static int torenOpening = 150;

    public Toren(SpelPaneel spelPaneel, int x, int y, BufferedImage image) {
        super(spelPaneel, x, y, 50, 500, image);
    }
}