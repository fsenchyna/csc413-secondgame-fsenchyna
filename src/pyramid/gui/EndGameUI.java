/*
JPanel that displays when the game is over. Shows the players score
 */
package pyramid.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

import pyramid.Resources;

import javax.swing.*;

public class EndGameUI extends GameUI {

  private Graphics2D buffer;
  private BufferedImage world;
  private JButton quit;

  public EndGameUI(PyramidPanicUI panelAnchor) {
    super(panelAnchor);
    background = Resources.getResource("end_panel");
    background = resizeBackground(background, PyramidPanicUI.SCREEN_HEIGHT, PyramidPanicUI.SCREEN_WIDTH);
    this.world = new BufferedImage(PyramidPanicUI.WORLD_WIDTH, PyramidPanicUI.WORLD_HEIGHT, BufferedImage.TYPE_INT_RGB);
    quit = new JButton(new ImageIcon((Resources.getResource("quit"))));
    quit.setBounds(500, 450, 115, 40);
    add(quit);
    quit.addActionListener(e -> getQuit());
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    buffer = world.createGraphics();
    buffer.setColor(Color.BLACK);
    buffer.fillRect(0, 0, PyramidPanicUI.WORLD_WIDTH, PyramidPanicUI.WORLD_HEIGHT);
    buffer.drawImage(background, 0,0, null);
    g2.drawImage(background, 0, 0, null);
    g2.setFont(new Font("Plain", Font.BOLD, 60));
    g2.setColor(Color.ORANGE);
    g2.drawString(Integer.toString(panelAnchor.getScore()), 600, 225);
  }
}
