package pyramid.gameobject.mobile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Scorpion extends Enemy {

  public Scorpion(int x, int y, int vx, int vy, int angle, BufferedImage scorpionImage) {
    super(x, y, vx, vy, angle, scorpionImage);
  }

  protected void initOutHitBox() {
    outHitBox = new Rectangle(x, y, gameObjectImage.getWidth()+RADAR,
        gameObjectImage.getHeight());
  }

  protected void setDamage() { damage = -1; }

  public void refresh() {
    if (angle == 0 || angle == 180) { moveForwards(); }
    else { rotateLeft(); }
  }

  protected void validateOuterBox() {
    if (angle == 0) {
      outHitBox.setLocation(x, y);
    }
    else if (angle == 180) {
      outHitBox.setLocation(x - RADAR, y);
    }
  }
}
