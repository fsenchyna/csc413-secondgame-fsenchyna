/*
class to make screen follow explorer as he moves.
 */
package pyramid;


import pyramid.gameobject.GameObject;
import pyramid.gui.PyramidPanicUI;

public class FollowScreen {
  private GameObject screenSubject;
  private int x;
  private int y;

  public FollowScreen(GameObject screenSubject) {
    this.screenSubject = screenSubject;
  }

  public int getX() {
    checkX();
    return x;
  }
  public int getY() {
    checkY();
    return y;
  }
  private void checkX() {
    if (screenSubject.getHitBox().getX() <= PyramidPanicUI.SCREEN_WIDTH / 2) {
      x = 0;
    }
    else if (screenSubject.getHitBox().getX() >= PyramidPanicUI.WORLD_WIDTH - PyramidPanicUI.SCREEN_WIDTH / 2) {
      x = PyramidPanicUI.WORLD_WIDTH - PyramidPanicUI.SCREEN_WIDTH;
    } else {
      x = (int) screenSubject.getHitBox().getX() - PyramidPanicUI.SCREEN_WIDTH / 2;
    }
  }

  private void checkY() {
    if (screenSubject.getHitBox().getY() <= PyramidPanicUI.SCREEN_HEIGHT / 2) {
      y = 0;
    }
    else if (screenSubject.getHitBox().getY() >= PyramidPanicUI.WORLD_HEIGHT - PyramidPanicUI.SCREEN_HEIGHT/2) {
      y = PyramidPanicUI.WORLD_HEIGHT- PyramidPanicUI.SCREEN_HEIGHT;
    }
    else {
      y = (int) screenSubject.getHitBox().getY() - PyramidPanicUI.SCREEN_HEIGHT / 2;
    }
  }
}

