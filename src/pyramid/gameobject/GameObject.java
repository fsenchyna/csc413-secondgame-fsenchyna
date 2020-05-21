//abstract class extended by all game objects in this game

package pyramid.gameobject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
  protected Rectangle hitBox;
  protected int x;
  protected int y;
  protected BufferedImage gameObjectImage;
  protected boolean destroyed = false;

  public GameObject(int x, int y, BufferedImage gameObjectImage) {
    this.x = x;
    this.y = y;
    this.gameObjectImage = gameObjectImage;
    this.hitBox = new Rectangle(x, y, this.gameObjectImage.getWidth(), this.gameObjectImage.getHeight());
  }

  public void setDestroyed(boolean destroyed) { this.destroyed = destroyed; }

  public boolean isDestroyed() { return this.destroyed; }

  // have a rectangle around the object so that it is known when it collides with something
  public Rectangle getHitBox() { return this.hitBox.getBounds(); }

  // draw object to screen
  public void drawImage(Graphics g) {
    if (!destroyed) {
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(this.gameObjectImage, x, y, null);
    }
  }
}