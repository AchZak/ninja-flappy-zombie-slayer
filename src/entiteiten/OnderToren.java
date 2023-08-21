package entiteiten;

import gfx.Assets;
import weergave.SpelPaneel;

public class OnderToren extends Toren {
    public OnderToren(SpelPaneel spelPaneel, int x, int y) {
        super(spelPaneel, x, y, Assets.onderToren);
    }

    public void updateEntiteit() {
        this.setX(this.getX() - 1);
        if (this.getX() == -this.getWidth()) {
            randomYLoc = randomYLoc + torenOpening + 500;
            this.setX(1450);
            this.setY(randomYLoc);
        }

    }
}