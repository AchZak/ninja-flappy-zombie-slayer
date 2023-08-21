package weergave;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InstructiePaneel extends JPanel implements ActionListener {
    private final String txt = "De speler wordt bestuurd door middel van de ARROWKEYS.\n\nVoor iedere toren die de speler passeert, krijg je een punt.\n\nJe kan ook wapens collecteren en ze op vijanden schieten via de SPACEKEY.\n\nVoor iedere vijand die je verslaagt, krijg je een extra punt.\n\nAls de speler een toren of een vijand raakt stort hij neer en is het spel ten einde.\n\n                 Veel succes !";
    private JButton btnQuit;
    private JButton btnMenu;
    private JTextArea txtInstructies;

    public InstructiePaneel() {
        this.setLayout((LayoutManager)null);
        this.setBackground(Color.GRAY);
        this.initButtons();
        this.initTextArea();
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

    private void initTextArea() {
        this.txtInstructies = new JTextArea("De speler wordt bestuurd door middel van de ARROWKEYS.\n\nVoor iedere toren die de speler passeert, krijg je een punt.\n\nJe kan ook wapens collecteren en ze op vijanden schieten via de SPACEKEY.\n\nVoor iedere vijand die je verslaagt, krijg je een extra punt.\n\nAls de speler een toren of een vijand raakt stort hij neer en is het spel ten einde.\n\n                 Veel succes !");
        this.txtInstructies.setFont(SpelVenster.FONT_STD.deriveFont(20.0F));
        this.txtInstructies.setWrapStyleWord(true);
        this.txtInstructies.setLineWrap(true);
        this.txtInstructies.setBackground(Color.GRAY);
        this.txtInstructies.setBounds(400, 50, 400, 500);
        this.txtInstructies.setEditable(false);
        this.add(this.txtInstructies);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.speler, 0, 25, (ImageObserver)null);
        g.drawImage(Assets.vijand, 950, 100, 250, 300, (ImageObserver)null);
        g.drawImage(Assets.wapen, 850, 140, 50, 250, (ImageObserver)null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnMenu) {
            SpelVenster.switchPaneel(SpelVenster.menuPaneel);
        } else if (e.getSource() == this.btnQuit) {
            SpelVenster.quit();
        }

    }
}