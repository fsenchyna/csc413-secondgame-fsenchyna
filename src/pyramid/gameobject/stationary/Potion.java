package pyramid.gameobject.stationary;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.GameObject;
import pyramid.gameobject.mobile.Explorer;

import java.awt.image.BufferedImage;

public class Potion extends GameObject implements Collidable {

  public Potion(int x, int y, BufferedImage potionImage) {
    super(x, y, potionImage);
  }

  public void updatePlayer(Explorer explorer) {
    explorer.addLife();
    destroyed = true;
  }
}
