/*
Loops through GameObjects until explorer gets the sword or dies
 */
package pyramid;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import pyramid.gameobject.GameObject;
import pyramid.gameobject.mobile.Explorer;
import pyramid.gameobject.mobile.Mobile;

public class PyramidDriver {

  private ArrayList<GameObject> stationaries;
  private ArrayList<Mobile> mobiles;
  private Explorer player;

  public PyramidDriver() {
    stationaries = new ArrayList<>();
    mobiles = new ArrayList<>();
  }

  // separate explorer
  public void add(GameObject gameObject) {
    if (gameObject instanceof Explorer && player == null) {
      player = (Explorer) gameObject;
    }
    // We will loop and update this ArrayList only
    if (gameObject instanceof Mobile) {
      mobiles.add((Mobile) gameObject);
    }
    else { stationaries.add(gameObject); }
  }

  public Explorer getPlayer() { return player; }

  // loop through list of Mobiles and update and check collisions
  public boolean execute() {
    Iterator<Mobile> mobileIter = mobiles.iterator();
    int index = 0; // ?? NOT SURE IF NEEDED
    while (mobileIter.hasNext()) {
      Mobile currentMobile = mobileIter.next();
      currentMobile.refresh();
      checkCollision(currentMobile, index);
      if (currentMobile.isDestroyed()) {
        mobileIter.remove();
      }
      index++;
    }
    return !player.isDestroyed();
  }

  private void checkCollision(Mobile mobile, int positionInArray) {
    // check if current mobile object collides with any other mobile object on the map
    for (int i = 0; i < mobiles.size(); i++) {
      if (i != positionInArray) { mobile.resolveCollision(mobiles.get(i)); }
    }
    // check if current mobile object collides with any stationary object
    Iterator<GameObject> stationaryIter = stationaries.iterator();
    while (stationaryIter.hasNext()) {
      GameObject currentStationary = stationaryIter.next();
      mobile.resolveCollision(currentStationary);
      if (currentStationary.isDestroyed()) {
        stationaryIter.remove();
      }
    }
  }

  public void draw(Graphics2D g) {
    stationaries.forEach (item -> item.drawImage(g));
    mobiles.forEach (item -> item.drawImage(g));
  }

  public int getScore() { return player.getScore(); }
}
