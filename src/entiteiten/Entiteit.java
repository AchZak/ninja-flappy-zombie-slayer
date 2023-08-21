package entiteiten;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import weergave.SpelPaneel;

public abstract class Entiteit {
    protected static int randomYLoc;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Rectangle rect;
    protected BufferedImage image;
    protected SpelPaneel spelPaneel;

    public Entiteit(SpelPaneel spelPaneel, int x, int y, int width, int height, BufferedImage image) {
        this.spelPaneel = spelPaneel;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.rect = new Rectangle(x, y, width, height);
    }

    public abstract void updateEntiteit();

    public void updateRectEntiteit() {
        this.rect.setLocation(this.getX(), this.getY());
    }

    public void tekenEntiteit(Graphics g) {
        g.drawImage(this.image, this.x, this.y, this.width, this.height, (ImageObserver)null);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRect() {
        return this.rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}