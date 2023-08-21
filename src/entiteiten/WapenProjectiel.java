package entiteiten;

import weergave.SpelPaneel;

public class WapenProjectiel extends Wapen implements CollisionDetection {
    public static final int WAPENPROJECTIEL_XBEGIN = 250;
    private boolean isShot = false;

    public WapenProjectiel(SpelPaneel spelPaneel) {
        super(spelPaneel, 250, spelPaneel.getSpeler().getY() + 25);
    }

    public void collidesWith(Vijand vijand) {
        if (this.rect.intersects(vijand.rect)) {
            randomYLoc = 100 + 10 * this.spelPaneel.getRandom().nextInt(41);
            this.setX(1450);
            vijand.setX(vijand.getX() + 1450 + vijand.getWidth());
            vijand.setY(randomYLoc);
            this.spelPaneel.setScore(this.spelPaneel.getScore() + 1);
            this.isShot = false;
        }

    }

    public void collidesWith(Wapen wapen) {
        if (this.rect.intersects(wapen.rect)) {
            randomYLoc = 100 + 10 * this.spelPaneel.getRandom().nextInt(41);
            this.setX(1450);
            wapen.setX(wapen.getX() + 1450 + wapen.getWidth());
            wapen.setY(randomYLoc);
            this.spelPaneel.setScore(this.spelPaneel.getScore() + 1);
            this.isShot = false;
        }

    }

    public void collidesWith(Toren muur) {
        if (this.rect.intersects(muur.rect)) {
            this.setX(1450);
            this.isShot = false;
        }

    }

    public boolean getIsShot() {
        return this.isShot;
    }

    public void setIsShot(boolean isShot) {
        this.isShot = isShot;
    }
}