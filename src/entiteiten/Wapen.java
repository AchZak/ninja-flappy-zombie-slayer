package entiteiten;

import gfx.Assets;
import weergave.SpelPaneel;

public class Wapen extends Entiteit {
    public static final int WAPEN_XBEGIN = 650;
    public static final int WAPEN_YBEGIN = 275;
    public static final int WAPEN_WIDTH = 50;
    public static final int WAPEN_HEIGHT = 50;
    public static final int WAPEN_INVENTARIS_YLOC = 525;
    public static final int WAPEN_INVENTARIS_WIDTH = 25;
    public static final int WAPEN_INVENTARIS_HEIGHT = 25;

    public Wapen(SpelPaneel spelPaneel) {
        super(spelPaneel, 650, 275, 50, 50, Assets.wapen);
    }

    public Wapen(SpelPaneel spelPaneel, int x, int y) {
        super(spelPaneel, x, y, 25, 25, Assets.wapen);
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