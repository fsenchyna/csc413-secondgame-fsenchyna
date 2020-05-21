/*
Start Menu for game, Allows for player to chose to start or quit game
 */
package pyramid.gui;

import javax.swing.*;
import java.awt.*;

import pyramid.Resources;

public class StartMenuUI extends GameUI {

  private JButton start, quit;

  public StartMenuUI(PyramidPanicUI panelAnchor) {
    super(panelAnchor);
    background  = Resources.getResource("background1");
    start = new JButton(new ImageIcon((Resources.getResource("start"))));
    start.setBounds(500, 350, 115, 40);
    add(start);
    start.addActionListener(e -> getStart());
    quit = new JButton(new ImageIcon((Resources.getResource("quit"))));
    quit.setBounds(500, 450, 115, 40);
    add(quit);
    quit.addActionListener(e -> getQuit());
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    g2.drawImage(background, 0, 0, null);
  }
}
