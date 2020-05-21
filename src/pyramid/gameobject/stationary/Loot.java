package pyramid.gameobject.stationary;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.GameObject;
import pyramid.gameobject.mobile.Explorer;

import java.awt.image.BufferedImage;

public class Loot extends GameObject implements Collidable {

  private static final int POINTS = 100;

  public Loot(int x, int y, BufferedImage lootImage) {
    super(x, y, lootImage);
  }

  public void updatePlayer(Explorer explorer) {
    explorer.addScore(POINTS);
    destroyed = true;
  }
}
