package weergave;

import entiteiten.Toren;
import gfx.Assets;
import gfx.Audio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InstellingenPaneel extends JPanel implements ActionListener, ChangeListener {
    private final int RDBTN_WIDTH1 = 300;
    private final int RDBTN_WIDTH2 = 250;
    private final int RDBTN_HEIGHT = 50;
    private final int RDBTN_XPOS = 550;
    private final int SLIDER_WIDTH = 300;
    private final int SLIDER_HEIGHT = 100;
    private final int SLIDER_XPOS = 50;
    private final int LABEL_WIDTH = 300;
    private final int LABEL_HEIGHT = 50;
    private final int LABEL_XPOS = 50;
    private RadioButtonImage rdBtnBckgroundMorning;
    private RadioButtonImage rdBtnBckgroundAfternoon;
    private RadioButtonImage rdBtnBckgroundNight;
    private RadioButtonImage rdBtnBckgroundCity;
    private RadioButtonAudio btnElectronical;
    private RadioButtonAudio btnClassical;
    private RadioButtonAudio btnRap;
    private RadioButtonAudio btnNoMusic;
    private RadioButtonImage[] listRdbtnBckground;
    private RadioButtonAudio[] listRdbtnMusic;
    private ButtonGroup btnGroupBckground;
    private ButtonGroup btnGroupMusic;
    private JButton btnQuit;
    private JButton btnMenu;
    private JSlider sliderTorenOpening;
    private JSlider sliderGameDelay;
    private JLabel lblTorenOpening;
    private JLabel lblGameDelay;
    private JLabel lblMusic;
    private Audio huidigeMuziek;
    private BufferedImage BckGround;

    public InstellingenPaneel() {
        this.setLayout((LayoutManager)null);
        this.setBackground(Color.GRAY);
        this.huidigeMuziek = null;
        this.BckGround = null;
        this.initRadioButtonsBckGround();
        this.initRadioButtonsMusic();
        this.initButtons();
        this.initSliders();
        this.initLabels();
    }

    private void initRadioButtonsBckGround() {
        this.rdBtnBckgroundMorning = new RadioButtonImage("MorningBackground", Assets.bckGroundMorning);
        this.rdBtnBckgroundMorning.setFont(SpelVenster.FONT_STD);
        this.rdBtnBckgroundMorning.setBackground(Color.GRAY);
        this.rdBtnBckgroundMorning.setBounds(550, 50, 300, 50);
        this.rdBtnBckgroundMorning.setSelected(true);
        this.rdBtnBckgroundMorning.addActionListener(this);
        this.rdBtnBckgroundAfternoon = new RadioButtonImage("AfternoonBackground", Assets.bckGroundAfternoon);
        this.rdBtnBckgroundAfternoon.setFont(SpelVenster.FONT_STD);
        this.rdBtnBckgroundAfternoon.setBackground(Color.GRAY);
        this.rdBtnBckgroundAfternoon.setBounds(550, 100, 300, 50);
        this.rdBtnBckgroundAfternoon.addActionListener(this);
        this.rdBtnBckgroundNight = new RadioButtonImage("NightBackground", Assets.bckGroundNight);
        this.rdBtnBckgroundNight.setFont(SpelVenster.FONT_STD);
        this.rdBtnBckgroundNight.setBackground(Color.GRAY);
        this.rdBtnBckgroundNight.setBounds(550, 150, 300, 50);
        this.rdBtnBckgroundNight.addActionListener(this);
        this.rdBtnBckgroundCity = new RadioButtonImage("CityBackground", Assets.bckGroundCity);
        this.rdBtnBckgroundCity.setFont(SpelVenster.FONT_STD);
        this.rdBtnBckgroundCity.setBackground(Color.GRAY);
        this.rdBtnBckgroundCity.setBounds(550, 200, 300, 50);
        this.rdBtnBckgroundCity.addActionListener(this);
        this.listRdbtnBckground = new RadioButtonImage[4];
        this.listRdbtnBckground[0] = this.rdBtnBckgroundMorning;
        this.listRdbtnBckground[1] = this.rdBtnBckgroundAfternoon;
        this.listRdbtnBckground[2] = this.rdBtnBckgroundNight;
        this.listRdbtnBckground[3] = this.rdBtnBckgroundCity;
        this.btnGroupBckground = new ButtonGroup();

        for(int i = 0; i < this.listRdbtnBckground.length; ++i) {
            this.btnGroupBckground.add(this.listRdbtnBckground[i]);
            this.add(this.listRdbtnBckground[i]);
        }

    }

    private void initRadioButtonsMusic() {
        this.btnElectronical = new RadioButtonAudio("Electronical Music", Assets.musicElectronical);
        this.btnElectronical.setFont(SpelVenster.FONT_STD);
        this.btnElectronical.setBackground(Color.GRAY);
        this.btnElectronical.setBounds(550, 300, 250, 50);
        this.btnElectronical.addActionListener(this);
        this.btnClassical = new RadioButtonAudio("Classical Music", Assets.musicClassical);
        this.btnClassical.setFont(SpelVenster.FONT_STD);
        this.btnClassical.setBackground(Color.GRAY);
        this.btnClassical.setBounds(550, 350, 250, 50);
        this.btnClassical.addActionListener(this);
        this.btnRap = new RadioButtonAudio("Rap Music", Assets.musicRap);
        this.btnRap.setFont(SpelVenster.FONT_STD);
        this.btnRap.setBackground(Color.GRAY);
        this.btnRap.setBounds(550, 400, 250, 50);
        this.btnRap.addActionListener(this);
        this.btnNoMusic = new RadioButtonAudio("No Music", (Audio)null);
        this.btnNoMusic.setFont(SpelVenster.FONT_STD);
        this.btnNoMusic.setBackground(Color.GRAY);
        this.btnNoMusic.setBounds(550, 450, 250, 50);
        this.btnNoMusic.addActionListener(this);
        this.listRdbtnMusic = new RadioButtonAudio[4];
        this.listRdbtnMusic[0] = this.btnElectronical;
        this.listRdbtnMusic[1] = this.btnClassical;
        this.listRdbtnMusic[2] = this.btnRap;
        this.listRdbtnMusic[3] = this.btnNoMusic;
        this.btnGroupMusic = new ButtonGroup();

        for(int i = 0; i < this.listRdbtnMusic.length; ++i) {
            this.btnGroupMusic.add(this.listRdbtnMusic[i]);
            this.add(this.listRdbtnMusic[i]);
        }

    }

    private void initButtons() {
        this.btnQuit = new JButton("Quit");
        this.btnQuit.setFont(SpelVenster.FONT_STD);
        this.btnQuit.setBounds(50, 500, 200, 50);
        this.btnQuit.addActionListener(this);
        this.btnMenu = new JButton("Menu");
        this.btnMenu.setFont(SpelVenster.FONT_STD);
        this.btnMenu.setBounds(950, 500, 200, 50);
        this.btnMenu.addActionListener(this);
        this.add(this.btnQuit);
        this.add(this.btnMenu);
    }

    private void initSliders() {
        this.sliderTorenOpening = new JSlider(100, 250, 150);
        this.sliderTorenOpening.setPaintTicks(true);
        this.sliderTorenOpening.setPaintLabels(true);
        this.sliderTorenOpening.setFont(SpelVenster.FONT_STD);
        this.sliderTorenOpening.setBackground(Color.GRAY);
        this.sliderTorenOpening.setMajorTickSpacing(50);
        this.sliderTorenOpening.setMinorTickSpacing(10);
        this.sliderTorenOpening.setBounds(50, 150, 300, 100);
        this.sliderTorenOpening.addChangeListener(this);
        this.sliderGameDelay = new JSlider(1, 11, 5);
        this.sliderGameDelay.setPaintTicks(true);
        this.sliderGameDelay.setPaintLabels(true);
        this.sliderGameDelay.setFont(SpelVenster.FONT_STD);
        this.sliderGameDelay.setBackground(Color.GRAY);
        this.sliderGameDelay.setMajorTickSpacing(5);
        this.sliderGameDelay.setMinorTickSpacing(1);
        this.sliderGameDelay.setBounds(50, 350, 300, 100);
        this.sliderGameDelay.addChangeListener(this);
        this.add(this.sliderTorenOpening);
        this.add(this.sliderGameDelay);
    }

    private void initLabels() {
        this.lblTorenOpening = new JLabel("TorenOpening (pxl)", 0);
        this.lblTorenOpening.setFont(SpelVenster.FONT_STD);
        this.lblTorenOpening.setBounds(50, 100, 300, 50);
        this.lblGameDelay = new JLabel("GameDelay (ms)", 0);
        this.lblGameDelay.setFont(SpelVenster.FONT_STD);
        this.lblGameDelay.setBounds(50, 300, 300, 50);
        this.lblMusic = new JLabel("Kies een muziek !", 0);
        this.lblMusic.setFont(SpelVenster.FONT_STD);
        this.lblMusic.setBounds(800, 375, 400, 50);
        this.add(this.lblTorenOpening);
        this.add(this.lblGameDelay);
        this.add(this.lblMusic);
    }

    private void updateMusic(Audio audio) {
        if (this.huidigeMuziek != null) {
            this.huidigeMuziek.stop();
        }

        if (audio != null) {
            audio.play();
            this.huidigeMuziek = audio;
        }

    }

    private void updateLabelMusic(Audio audio) {
        if (audio != null) {
            this.lblMusic.setText(audio.writeSong());
        } else {
            this.lblMusic.setText("Geen muziek gekozen !");
        }

    }

    public BufferedImage updateBckGround() {
        for(int i = 0; i < this.listRdbtnBckground.length; ++i) {
            if (this.listRdbtnBckground[i].isSelected()) {
                this.BckGround = this.listRdbtnBckground[i].getImage();
                break;
            }
        }

        return this.BckGround;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < this.listRdbtnBckground.length; ++i) {
            if (this.listRdbtnBckground[i].isSelected()) {
                g.drawImage(this.listRdbtnBckground[i].getImage(), 875, 75, 300, 150, (ImageObserver)null);
                break;
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        int i;
        for(i = 0; i < this.listRdbtnBckground.length; ++i) {
            if (e.getSource() == this.listRdbtnBckground[i]) {
                this.repaint();
                break;
            }
        }

        for(i = 0; i < this.listRdbtnMusic.length; ++i) {
            if (e.getSource() == this.listRdbtnMusic[i]) {
                this.updateLabelMusic(this.listRdbtnMusic[i].getAudio());
                this.updateMusic(this.listRdbtnMusic[i].getAudio());
                break;
            }
        }

        if (e.getSource() == this.btnMenu) {
            SpelVenster.switchPaneel(SpelVenster.menuPaneel);
        } else if (e.getSource() == this.btnQuit) {
            SpelVenster.quit();
        }

    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == this.sliderTorenOpening) {
            Toren.torenOpening = this.sliderTorenOpening.getValue();
        } else if (e.getSource() == this.sliderGameDelay) {
            SpelPaneel.GameDelay = this.sliderGameDelay.getValue();
        }

    }
}
