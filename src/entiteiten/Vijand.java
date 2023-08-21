package entiteiten;

import gfx.Assets;
import weergave.SpelPaneel;

public class Vijand extends Entiteit {
    public static final int VIJAND_WIDTH = 50;
    public static final int VIJAND_HEIGHT = 50;
    public static final int VIJAND_XBEGIN = 1150;
    public static final int VIJAND_YBEGIN = 275;

    public Vijand(SpelPaneel spelPaneel) {
        super(spelPaneel, 1150, 275, 50, 50, Assets.vijand);
    }

    public void updateEntiteit() {
        this.setX(this.getX() - 1);
        if (this.getX() == -this.getWidth()) {
            randomYLoc = 100 + 10 * this.spelPaneel.getRandom().nextInt(41);
            this.setX(1450);
            this.setY(randomYLoc);
        }

    }
}