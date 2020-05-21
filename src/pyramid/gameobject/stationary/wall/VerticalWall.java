package pyramid.gameobject.stationary.wall;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.mobile.Explorer;

import java.awt.image.BufferedImage;

public class VerticalWall extends Wall implements Collidable {
  private static final int MOVE = 96;
  int moveY;

  public VerticalWall(int x, int y, BufferedImage wallImage) {
    super(x, y, wallImage);
  }

  public void updatePlayer(Explorer explorer) {
    super.updatePlayer(explorer);
    if (moveY == 0 && explorer.getHitBox().getY() < this.y) {
      while (moveY < MOVE) {
        this.y++;
        moveY++;
        hitBox.setLocation(x, y);
      }
    }
    if (moveY == MOVE && explorer.getHitBox().getY() > this.y) {
      while (moveY > 0) {
        this.y--;
        moveY--;
        hitBox.setLocation(x, y);
      }
    }
  }
}
