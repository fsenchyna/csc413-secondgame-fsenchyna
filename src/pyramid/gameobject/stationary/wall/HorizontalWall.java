/*
Did not finish
 */
package pyramid.gameobject.stationary.wall;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.mobile.Explorer;

import java.awt.image.BufferedImage;

public class HorizontalWall extends Wall implements Collidable {

  private static final int MOVE = 96;
  int moveX;

  public HorizontalWall(int x, int y, BufferedImage wallImage) {
    super(x, y, wallImage);
  }

  public void updatePlayer(Explorer explorer) {
    super.updatePlayer(explorer);
    if (moveX == 0 && explorer.getHitBox().getX() < this.x) {
      while (moveX < MOVE) {
        this.x++;
        moveX++;
        hitBox.setLocation(x, y);
      }
    }
    if (moveX == MOVE && explorer.getHitBox().getX() > this.x) {
      while (moveX > 0) {
        this.x--;
        moveX--;
        hitBox.setLocation(x, y);
      }
    }
  }
}