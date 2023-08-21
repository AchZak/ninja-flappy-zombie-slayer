package weergave;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MenuPaneel extends JPanel implements ActionListener {
    private final String TXT_INTRO = "\nIngenieurswetenschappen ! \n Scientia Vincere Tenebras ! \n\nNinja Flappy Zombie Slayer ! \n";
    private JButton btnInstellingen;
    private JButton btnInstructies;
    private JButton btnQuit;
    private JButton btnStart;
    private JTextArea txtMenu;

    public MenuPaneel() {
        this.setLayout((LayoutManager)null);
        this.setBackground(Color.GRAY);
        this.initButtons();
        this.initTextArea();
    }

    private void initButtons() {
        this.btnInstellingen = new JButton("Instellingen");
        this.btnInstellingen.setFont(SpelVenster.FONT_STD);
        this.btnInstellingen.setBounds(350, 500, 200, 50);
        this.btnInstellingen.addActionListener(this);
        this.btnInstructies = new JButton("Instructies");
        this.btnInstructies.setFont(SpelVenster.FONT_STD);
        this.btnInstructies.setBounds(650, 500, 200, 50);
        this.btnInstructies.addActionListener(this);
        this.btnStart = new JButton("Start");
        this.btnStart.setFont(SpelVenster.FONT_STD);
        this.btnStart.setBounds(950, 500, 200, 50);
        this.btnStart.addActionListener(this);
        this.btnQuit = new JButton("Quit");
        this.btnQuit.setFont(SpelVenster.FONT_STD);
        this.btnQuit.setBounds(50, 500, 200, 50);
        this.btnQuit.addActionListener(this);
        this.add(this.btnInstellingen);
        this.add(this.btnInstructies);
        this.add(this.btnStart);
        this.add(this.btnQuit);
    }

    private void initTextArea() {
        this.txtMenu = new JTextArea(TXT_INTRO);
        this.txtMenu.setFont(SpelVenster.FONT_STD.deriveFont(60.0F));
        this.txtMenu.setBackground(Color.GRAY);
        this.txtMenu.setBounds(200, 30, 900, 400);
        this.txtMenu.setEditable(false);
        this.add(this.txtMenu);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnInstellingen) {
            SpelVenster.switchPaneel(SpelVenster.instellingenPaneel);
        } else if (e.getSource() == this.btnInstructies) {
            SpelVenster.switchPaneel(SpelVenster.instructiePaneel);
        } else if (e.getSource() == this.btnStart) {
            SpelVenster.switchPaneel(new SpelPaneel());
        } else if (e.getSource() == this.btnQuit) {
            SpelVenster.venster.dispose();
        }
    }
}