package pyramid.gameobject.mobile;

import pyramid.gameobject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Mummy extends Enemy {

  private static final int DISABLE_POINTS = 100;

  private static int LEFT_ODDS = 0;
  private static int RIGHT_ODDS = 1;
  private Random random;
  private static boolean isDisabled = false;

  public Mummy(int x, int y, int vx, int vy, int angle, BufferedImage mummyImage) {
    super(x, y, vx, vy, angle, mummyImage);
    random = new Random();
  }

  protected void setDamage() { damage = -2;}

  protected void initOutHitBox() {
    outHitBox = new Rectangle(x, y, gameObjectImage.getWidth()+RADAR,
        gameObjectImage.getHeight()+RADAR );
  }

  public void refresh() {
    if (isDisabled) { rotateLeft(); } // disabled mummies rotate in a circle
    else { // favor moving forward
      int num = random.nextInt( 10);
      if (num == LEFT_ODDS) { rotateLeft(); }
      if (num == RIGHT_ODDS) { rotateRight(); }
      else { moveForwards(); }
    }
  }

  @Override
  // If mummies are disabled they act as a treasure
  public void updatePlayer(Explorer explorer) {
    if (isDisabled) {
      explorer.addScore(DISABLE_POINTS);
      destroyed = true;
    }
    else { explorer.removeLife(); }
  }

  /*
  Aim: make mummy move faster and rotate mummy to follow explorer by trying
  to find the angle of the explorer from the mummy
   */
  protected void speedUp(GameObject gameObject) {
    int pointer = (int) Math.toDegrees(Math.atan2(hitBox.getX() - gameObject.getHitBox().getX(),
        (hitBox.getY() - gameObject.getHitBox().getY())));
    if (pointer < 0 ) {
      pointer += 360;
    }
    if (angle < pointer ) {
      rotateRight();
    }
    if (angle > pointer ) {
      rotateLeft();
    }
    vx =  (int) Math.round(R * 2 * Math.cos(Math.toRadians(angle)));
    vy =  (int) Math.round(R * 2 * Math.sin(Math.toRadians(angle)));
    x += vx;
    y += vy;
    checkBorder();
    this.hitBox.setLocation(x, y);
    validateOuterBox();
  }

  @Override
  public void setDestroyed(boolean destroyed) {
    if (isDisabled) {
      this.destroyed = destroyed;
    }
  }

  @Override
  public void moveForwards() {
    super.moveForwards();
    validateOuterBox();
  }

  @Override
  public void resolveCollision(GameObject gameObject) {
    if (gameObject instanceof Explorer && !isDisabled) {
      if (outHitBox.intersects(gameObject.getHitBox())) {
        speedUp(gameObject);
      }
    } else if (hitBox.intersects(gameObject.getHitBox())) {
      moveBackwards();
      rotateLeft();
    }
  }

  protected void validateOuterBox() {
    if (angle >= 0 && angle <= 180) {
      outHitBox.setLocation(x - RADAR/2, y );
    }
    else if (angle > 180) {
      outHitBox.setLocation(x - RADAR/2, y - RADAR);
    }
  }

  // sends all mummies into a spin when disabled
  public static void disable() {
    Runnable r = () -> setIsDisabled();
    new Thread(r).start();
  }

  /*
  Inspired by: https://stackoverflow.com/questions/2029118/run-code-for-x-seconds-in-java
   */
  private static void setIsDisabled() {
    long curtime = System.currentTimeMillis();
    long end = curtime+20000; // Disable mummies for 20 seconds
    while(System.currentTimeMillis() < end) {
      isDisabled = true;
    }
    isDisabled = false;
  }
}