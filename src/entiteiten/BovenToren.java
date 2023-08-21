package entiteiten;

import gfx.Assets;
import weergave.SpelPaneel;

public class BovenToren extends Toren {
    public BovenToren(SpelPaneel spelPaneel, int x, int y) {
        super(spelPaneel, x, y, Assets.bovenToren);
    }

    public void updateEntiteit() {
        this.setX(this.getX() - 1);
        if (this.getX() == -this.getWidth()) {
            randomYLoc = -75 - (-100 + torenOpening) - 10 * this.spelPaneel.getRandom().nextInt(50 - torenOpening / 10);
            this.setX(1450);
            this.setY(randomYLoc);
        }

    }
}