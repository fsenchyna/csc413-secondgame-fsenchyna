package pyramid.gameobject.mobile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Beetle extends Enemy {

  public Beetle(int x, int y, int vx, int vy, int angle, BufferedImage beetleImage) {
    super(x, y, vx, vy, angle, beetleImage);
  }

  protected void initOutHitBox() {
    outHitBox = new Rectangle(x, y, gameObjectImage.getWidth(),
        gameObjectImage.getHeight()+RADAR);
    }

  protected void setDamage() { damage = -1; }

  public void refresh() {
    if (angle == 270 || angle == 90) { moveForwards(); }
    else { rotateLeft(); }
  }

  protected void validateOuterBox() {
    if (angle == 90) {
      outHitBox.setLocation(x, y);
    }
    else if (angle == 270) {
      outHitBox.setLocation(x, y - RADAR);
    }
  }
}
