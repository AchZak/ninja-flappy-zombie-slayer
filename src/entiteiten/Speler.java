package entiteiten;

import gfx.Assets;
import weergave.GameOverPaneel;
import weergave.SpelPaneel;
import weergave.SpelVenster;

public class Speler extends Entiteit implements CollisionDetection {
    public static final int SPELER_WIDTH = 50;
    public static final int SPELER_HEIGHT = 50;
    public static final int SPELER_X = 200;
    public static final int SPELER_YBEGIN = 275;
    private final int MOVE = 20;

    public Speler(SpelPaneel spelPaneel) {
        super(spelPaneel, 200, 275, 50, 50, Assets.speler);
    }

    public void moveUp() {
        if (this.y > 0) {
            this.y -= 20;
            this.setImage(Assets.spelerSpringt);
        }

    }

    public void moveDown() {
        if (this.y < 525) {
            this.y += 20;
            this.setImage(Assets.spelerDaalt);
        }

    }

    public void updateEntiteit() {
    }

    public void collidesWith(Vijand vijand) {
        if (this.rect.intersects(vijand.rect)) {
            this.spelPaneel.getSpelTimer().stop();
            SpelVenster.switchPaneel(new GameOverPaneel(this.spelPaneel.getScore()));
        }

    }

    public void collidesWith(Wapen wapen) {
        if (this.rect.intersects(wapen.rect)) {
            randomYLoc = 100 + 10 * this.spelPaneel.getRandom().nextInt(41);
            wapen.setX(wapen.getX() + 1450 + wapen.getWidth());
            wapen.setY(randomYLoc);
            if (this.spelPaneel.getListWapen().size() == 0) {
                this.spelPaneel.getListWapen().add(this.spelPaneel.getInventarisWapen0());
            } else if (this.spelPaneel.getListWapen().size() == 1) {
                this.spelPaneel.getListWapen().add(this.spelPaneel.getInventarisWapen1());
            } else if (this.spelPaneel.getListWapen().size() == 2) {
                this.spelPaneel.getListWapen().add(this.spelPaneel.getInventarisWapen2());
            }
        }

    }

    public void collidesWith(Toren toren) {
        if (this.rect.intersects(toren.rect)) {
            this.spelPaneel.getSpelTimer().stop();
            SpelVenster.switchPaneel(new GameOverPaneel(this.spelPaneel.getScore()));
        }

    }
}