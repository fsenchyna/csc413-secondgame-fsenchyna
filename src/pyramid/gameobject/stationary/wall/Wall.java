package pyramid.gameobject.stationary.wall;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.GameObject;
import pyramid.gameobject.mobile.Explorer;

import java.awt.image.BufferedImage;

public class Wall extends GameObject implements Collidable {

  public Wall(int x, int y, BufferedImage wallImage) {
    super(x, y, wallImage);
  }

  public void updatePlayer(Explorer explorer) { explorer.isBlocked(this.hitBox); }

}