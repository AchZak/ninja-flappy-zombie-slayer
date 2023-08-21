package gfx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage speler;
    public static BufferedImage spelerAttack;
    public static BufferedImage spelerSpringt;
    public static BufferedImage spelerDaalt;
    public static BufferedImage spelerDood;
    public static BufferedImage spelerDood2;
    public static BufferedImage bckGroundMorning;
    public static BufferedImage bckGroundAfternoon;
    public static BufferedImage bckGroundNight;
    public static BufferedImage bckGroundCity;
    public static BufferedImage vijand;
    public static BufferedImage wapen;
    public static BufferedImage bovenToren;
    public static BufferedImage onderToren;
    public static Audio musicElectronical;
    public static Audio musicClassical;
    public static Audio musicRap;

    public Assets() {
    }

    public static void init() {
        initImages();
        initSounds();
    }

    private static void initImages() {
        speler = ImageLoader.loadImage("/images/speler.png");
        spelerSpringt = ImageLoader.loadImage("/images/spelerSpringt.png");
        spelerAttack = ImageLoader.loadImage("/images/spelerAttack.png");
        spelerDaalt = ImageLoader.loadImage("/images/spelerDaalt.png");
        spelerDood = ImageLoader.loadImage("/images/spelerDood.png");
        spelerDood2 = ImageLoader.loadImage("/images/spelerDood2.png");
        bckGroundMorning = ImageLoader.loadImage("/images/bckGroundMorning.png");
        bckGroundAfternoon = ImageLoader.loadImage("/images/bckGroundAfternoon.png");
        bckGroundNight = ImageLoader.loadImage("/images/bckGroundNight.png");
        bckGroundCity = ImageLoader.loadImage("/images/bckGroundCity.png");
        vijand = ImageLoader.loadImage("/images/vijand.png");
        wapen = ImageLoader.loadImage("/images/wapen.png");
        bovenToren = ImageLoader.loadImage("/images/bovenToren.png");
        onderToren = ImageLoader.loadImage("/images/onderToren.png");
    }

    private static void initSounds() {
        musicElectronical = new Audio("Electro-Light", "Symbolism", "/sounds/ElectronicalSoundTrack.wav");
        musicClassical = new Audio("Correlo", "Concerto Grosso", "/sounds/ClassicalSoundTrack.wav");
        musicRap = new Audio("Bazanji", "Fed Up", "/sounds/RapSoundTrack.wav");
    }
}
