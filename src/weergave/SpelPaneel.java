package weergave;

import entiteiten.BovenToren;
import entiteiten.OnderToren;
import entiteiten.Speler;
import entiteiten.Toren;
import entiteiten.Vijand;
import entiteiten.Wapen;
import entiteiten.WapenProjectiel;
import gfx.Assets;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SpelPaneel extends JPanel implements ActionListener, KeyListener {
    public static int GameDelay = 5;
    private int xBckGround;
    private int score;
    private Speler speler;
    private Vijand vijand;
    private Wapen wapen;
    private ArrayList<Wapen> listInventarisWapen;
    private Wapen inventarisWapen0;
    private Wapen inventarisWapen1;
    private Wapen inventarisWapen2;
    private WapenProjectiel[] listWapenProjectiel;
    private BovenToren[] bovenToren;
    private OnderToren[] onderToren;
    private Random random;
    private Timer spelTimer;

    public SpelPaneel() {
        this.setLayout((LayoutManager)null);
        this.xBckGround = 0;
        this.score = 0;
        this.initEntiteiten();
        this.initRandomAndTimer();
        this.addKeyListener(this);
    }

    private void initEntiteiten() {
        this.speler = new Speler(this);
        this.vijand = new Vijand(this);
        this.wapen = new Wapen(this);
        this.listInventarisWapen = new ArrayList();
        this.inventarisWapen0 = new Wapen(this, 0, 525);
        this.inventarisWapen1 = new Wapen(this, 25, 525);
        this.inventarisWapen2 = new Wapen(this, 50, 525);
        this.listWapenProjectiel = new WapenProjectiel[3];
        this.listWapenProjectiel[0] = new WapenProjectiel(this);
        this.listWapenProjectiel[1] = new WapenProjectiel(this);
        this.listWapenProjectiel[2] = new WapenProjectiel(this);
        this.bovenToren = new BovenToren[3];
        this.onderToren = new OnderToren[3];
        this.bovenToren[0] = new BovenToren(this, 400, 65286);
        this.onderToren[0] = new OnderToren(this, 400, 250 + Toren.torenOpening);
        this.bovenToren[1] = new BovenToren(this, 900, 65236);
        this.onderToren[1] = new OnderToren(this, 900, 200 + Toren.torenOpening);
        this.bovenToren[2] = new BovenToren(this, 1400, 65186);
        this.onderToren[2] = new OnderToren(this, 1400, 150 + Toren.torenOpening);
    }

    private void initRandomAndTimer() {
        this.random = new Random();
        this.spelTimer = new Timer(GameDelay, this);
        this.spelTimer.start();
    }

    private void updateBckGround() {
        --this.xBckGround;
        if (this.xBckGround == -SpelVenster.instellingenPaneel.updateBckGround().getWidth()) {
            this.xBckGround = 0;
        }

    }

    private void updateEntiteiten() {
        this.vijand.updateEntiteit();
        this.wapen.updateEntiteit();

        int i;
        for(i = 0; i < this.bovenToren.length; ++i) {
            this.bovenToren[i].updateEntiteit();
            this.onderToren[i].updateEntiteit();
        }

        for(i = 0; i < this.listWapenProjectiel.length; ++i) {
            if (this.listWapenProjectiel[i].getIsShot()) {
                this.listWapenProjectiel[i].setX(this.listWapenProjectiel[i].getX() + 3);
            }
        }

    }

    private void updateRectEntiteiten() {
        this.speler.updateRectEntiteit();
        this.vijand.updateRectEntiteit();
        this.wapen.updateRectEntiteit();

        int i;
        for(i = 0; i < this.bovenToren.length; ++i) {
            this.bovenToren[i].updateRectEntiteit();
            this.onderToren[i].updateRectEntiteit();
        }

        for(i = 0; i < this.listWapenProjectiel.length; ++i) {
            this.listWapenProjectiel[i].updateRectEntiteit();
        }

    }

    public void collision() {
        this.updateRectEntiteiten();
        this.speler.collidesWith(this.vijand);
        this.speler.collidesWith(this.wapen);

        for(int i = 0; i < this.bovenToren.length; ++i) {
            this.speler.collidesWith(this.bovenToren[i]);
            this.speler.collidesWith(this.onderToren[i]);
            if (this.listWapenProjectiel[i].getIsShot()) {
                this.listWapenProjectiel[i].collidesWith(this.vijand);
                this.listWapenProjectiel[i].collidesWith(this.wapen);

                for(int j = 0; j < this.listWapenProjectiel.length; ++j) {
                    this.listWapenProjectiel[i].collidesWith(this.bovenToren[j]);
                    this.listWapenProjectiel[i].collidesWith(this.onderToren[j]);
                }
            }
        }

    }

    public void updateScore() {
        for(int i = 0; i < this.bovenToren.length; ++i) {
            if (this.bovenToren[i].getX() + this.bovenToren[i].getWidth() == this.speler.getX()) {
                ++this.score;
            }
        }

    }

    private void tekenBckGround(Graphics g) {
        g.drawImage(SpelVenster.instellingenPaneel.updateBckGround(), this.xBckGround, 0, 1200, 600, (ImageObserver)null);
        g.drawImage(SpelVenster.instellingenPaneel.updateBckGround(), this.xBckGround + 1200, 0, 1200, 600, (ImageObserver)null);
    }

    private void tekenEntiteiten(Graphics g) {
        this.speler.tekenEntiteit(g);
        this.vijand.tekenEntiteit(g);
        this.wapen.tekenEntiteit(g);

        int i;
        for(i = 0; i < 3; ++i) {
            this.bovenToren[i].tekenEntiteit(g);
            this.onderToren[i].tekenEntiteit(g);
        }

        if (this.listInventarisWapen.size() == 1) {
            this.inventarisWapen0.tekenEntiteit(g);
        } else if (this.listInventarisWapen.size() == 2) {
            this.inventarisWapen0.tekenEntiteit(g);
            this.inventarisWapen1.tekenEntiteit(g);
        } else if (this.listInventarisWapen.size() == 3) {
            this.inventarisWapen0.tekenEntiteit(g);
            this.inventarisWapen1.tekenEntiteit(g);
            this.inventarisWapen2.tekenEntiteit(g);
        }

        for(i = 0; i < this.listWapenProjectiel.length; ++i) {
            if (this.listWapenProjectiel[i].getIsShot()) {
                this.listWapenProjectiel[i].tekenEntiteit(g);
            }
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.tekenBckGround(g);
        this.tekenEntiteiten(g);
        g.setFont(SpelVenster.FONT_STD.deriveFont(30.0F));
        g.drawString(String.valueOf(this.score), 600, 60);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.spelTimer) {
            this.requestFocus();
            this.updateBckGround();
            this.updateEntiteiten();
            this.collision();
            this.updateScore();
            this.repaint();
        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38) {
            this.speler.moveUp();
        } else if (e.getKeyCode() == 40) {
            this.speler.moveDown();
        } else if (e.getKeyCode() == 32) {
            this.speler.setImage(Assets.spelerAttack);
            if (this.listInventarisWapen.size() == 1) {
                this.listInventarisWapen.remove(this.inventarisWapen0);
                this.listWapenProjectiel[0].setX(250);
                this.listWapenProjectiel[0].setY(this.speler.getY() + this.speler.getWidth() / 2);
                this.listWapenProjectiel[0].setIsShot(true);
            } else if (this.listInventarisWapen.size() == 2) {
                this.listInventarisWapen.remove(this.inventarisWapen1);
                this.listWapenProjectiel[1].setX(250);
                this.listWapenProjectiel[1].setY(this.speler.getY() + this.speler.getWidth() / 2);
                this.listWapenProjectiel[1].setIsShot(true);
            } else if (this.listInventarisWapen.size() == 3) {
                this.listInventarisWapen.remove(this.inventarisWapen2);
                this.listWapenProjectiel[2].setX(250);
                this.listWapenProjectiel[2].setY(this.speler.getY() + this.speler.getWidth() / 2);
                this.listWapenProjectiel[2].setIsShot(true);
            }
        }

    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Speler getSpeler() {
        return this.speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public ArrayList<Wapen> getListWapen() {
        return this.listInventarisWapen;
    }

    public void setListWapen(ArrayList<Wapen> listInventarisWapen) {
        this.listInventarisWapen = listInventarisWapen;
    }

    public Wapen getInventarisWapen0() {
        return this.inventarisWapen0;
    }

    public void setInventarisWapen0(Wapen inventarisWapen0) {
        this.inventarisWapen0 = inventarisWapen0;
    }

    public Wapen getInventarisWapen1() {
        return this.inventarisWapen1;
    }

    public void setInventarisWapen1(Wapen inventarisWapen1) {
        this.inventarisWapen1 = inventarisWapen1;
    }

    public Wapen getInventarisWapen2() {
        return this.inventarisWapen2;
    }

    public void setInventarisWapen2(Wapen inventarisWapen2) {
        this.inventarisWapen2 = inventarisWapen2;
    }

    public BovenToren[] getBovenToren() {
        return this.bovenToren;
    }

    public void setBovenToren(BovenToren[] bovenToren) {
        this.bovenToren = bovenToren;
    }

    public OnderToren[] getOnderToren() {
        return this.onderToren;
    }

    public void setOnderToren(OnderToren[] onderToren) {
        this.onderToren = onderToren;
    }

    public Random getRandom() {
        return this.random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Timer getSpelTimer() {
        return this.spelTimer;
    }

    public void setSpelTimer(Timer spelTimer) {
        this.spelTimer = spelTimer;
    }
}