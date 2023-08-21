package weergave;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameOverPaneel extends JPanel implements ActionListener {
    private final String TXT_INSTRUCTIES = "              Game Over ! \n\nJe kan opnieuw starten door op restart te drukken.\n\nWil je de instellingen aanpassen, druk dan op menu.\n\n             Veel succes !";
    private final String TXT_SCORE = "EPIC score: ";
    private JButton btnRestart;
    private JButton btnMenu;
    private JButton btnQuit;
    private JTextArea TXTGameOver;
    private JLabel lblScore;

    public GameOverPaneel(int score) {
        this.setLayout((LayoutManager)null);
        this.setBackground(Color.GRAY);
        this.initButtons();
        this.initTextArea();
        this.initLabels(score);
    }

    private void initButtons() {
        this.btnRestart = new JButton("Restart");
        this.btnRestart.setFont(SpelVenster.FONT_STD);
        this.btnRestart.setBounds(950, 500, 200, 50);
        this.btnRestart.addActionListener(this);
        this.btnMenu = new JButton("Menu");
        this.btnMenu.setFont(SpelVenster.FONT_STD);
        this.btnMenu.setBounds(500, 500, 200, 50);
        this.btnMenu.addActionListener(this);
        this.btnQuit = new JButton("Quit");
        this.btnQuit.setFont(SpelVenster.FONT_STD);
        this.btnQuit.setBounds(50, 500, 200, 50);
        this.btnQuit.addActionListener(this);
        this.add(this.btnRestart);
        this.add(this.btnMenu);
        this.add(this.btnQuit);
    }

    private void initTextArea() {
        this.TXTGameOver = new JTextArea("              Game Over ! \n\nJe kan opnieuw starten door op restart te drukken.\n\nWil je de instellingen aanpassen, druk dan op menu.\n\n             Veel succes !");
        this.TXTGameOver.setFont(SpelVenster.FONT_STD);
        this.TXTGameOver.setWrapStyleWord(true);
        this.TXTGameOver.setLineWrap(true);
        this.TXTGameOver.setBackground(Color.GRAY);
        this.TXTGameOver.setBounds(400, 150, 400, 400);
        this.TXTGameOver.setEditable(false);
        this.TXTGameOver.setBackground(Color.GRAY);
        this.add(this.TXTGameOver);
    }

    private void initLabels(int score) {
        this.lblScore = new JLabel("EPIC score: " + score);
        this.lblScore.setFont(SpelVenster.FONT_STD);
        this.lblScore.setBounds(500, 50, 200, 50);
        this.add(this.lblScore);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.spelerDood2, 0, 25, 400, 350, (ImageObserver)null);
        g.drawImage(Assets.spelerDood, 800, 25, 400, 350, (ImageObserver)null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnRestart) {
            SpelVenster.switchPaneel(new SpelPaneel());
        } else if (e.getSource() == this.btnMenu) {
            SpelVenster.switchPaneel(SpelVenster.menuPaneel);
        } else if (e.getSource() == this.btnQuit) {
            SpelVenster.quit();
        }

    }
}