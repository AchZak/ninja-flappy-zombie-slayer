package weergave;

import gfx.Assets;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpelVenster {
    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 600;
    static final int BTN_WIDTH = 200;
    static final int BTN_HEIGHT = 50;
    static final int BTN_Y = 500;
    static final int BTN_XLINKS = 50;
    static final int BTN_XMIDDENLINKS = 350;
    static final int BTN_XMIDDEN = 500;
    static final int BTN_XMIDDENRECHTS = 650;
    static final int BTN_XRECHTS = 950;
    static final Font FONT_STD = new Font("Century Gothic", 1, 25);
    static InstellingenPaneel instellingenPaneel;
    static InstructiePaneel instructiePaneel;
    static MenuPaneel menuPaneel;
    static JFrame venster;

    public SpelVenster() {
        this.initPanelen();
        this.initVenster();
    }

    private void initPanelen() {
        instellingenPaneel = new InstellingenPaneel();
        instructiePaneel = new InstructiePaneel();
        menuPaneel = new MenuPaneel();
    }

    private void initVenster() {
        venster = new JFrame("Ninja Flappy Zombie Slayer !");
        venster.setIconImage(Assets.speler);
        venster.setLayout((LayoutManager)null);
        venster.setSize(1200, 600);
        venster.setResizable(false);
        venster.setLocationRelativeTo((Component)null);
        venster.setDefaultCloseOperation(3);
        venster.setContentPane(menuPaneel);
        venster.setVisible(true);
    }

    public static void switchPaneel(JPanel paneel) {
        venster.setContentPane(paneel);
        venster.setVisible(true);
    }

    public static void quit() {
        venster.dispose();
    }
}