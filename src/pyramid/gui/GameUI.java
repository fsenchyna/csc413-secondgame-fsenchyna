package pyramid.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameUI extends JPanel {

  protected BufferedImage background;
  protected PyramidPanicUI panelAnchor;

  public GameUI(PyramidPanicUI panelAnchor) {
    this.panelAnchor = panelAnchor;
    setLayout(null);
    setVisible(true);
  }

  // close opening JPanel so game can start
  protected void getStart() {
    panelAnchor.switchPanels(PyramidPanicUI.GAME);
  }

  // exit game
  protected void getQuit() {
    panelAnchor.switchPanels(PyramidPanicUI.QUIT);
  }

  /*
  taken from : https://memorynotfound.com/java-resize-image-fixed-width-height-example/
   */
  protected static BufferedImage resizeBackground(BufferedImage img, int height, int width) {
    Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = resized.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();
    return resized;
  }
}
