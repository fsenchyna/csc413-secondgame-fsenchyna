package pyramid.gameobject.stationary;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.GameObject;
import pyramid.gameobject.mobile.Explorer;

import java.awt.image.BufferedImage;

public class Sword extends GameObject implements Collidable {

  private static final int POINTS = 500;

  public Sword(int x, int y, BufferedImage swordImage) {
    super(x, y, swordImage);
  }

  public void updatePlayer(Explorer explorer) {
    explorer.addScore(POINTS);
    destroyed = true;
    explorer.setDestroyed(true);
  }
}
