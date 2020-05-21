package pyramid.gameobject.stationary;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.GameObject;
import pyramid.gameobject.mobile.Explorer;
import pyramid.gameobject.mobile.Mummy;

import java.awt.image.BufferedImage;

public class Scarab extends GameObject implements Collidable {

  private static final int POINTS = 20;

  public Scarab(int x, int y, BufferedImage scarabImage) {
    super(x, y, scarabImage);
  }

  public void updatePlayer(Explorer explorer) {
    explorer.addScore(POINTS);
    Mummy.disable();
    destroyed = true;
  }
}
