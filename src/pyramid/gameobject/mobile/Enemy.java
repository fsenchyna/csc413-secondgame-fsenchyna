package pyramid.gameobject.mobile;

import pyramid.gameobject.Collidable;
import pyramid.gameobject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Mobile implements Collidable {

  // how far ahead enemy can see the explorer
  protected static final int RADAR = 150;

  protected Rectangle outHitBox;
  protected int damage;

  public Enemy(int x, int y, int vx, int vy, int angle, BufferedImage enemyImage) {
    super(x, y, vx, vy, angle, enemyImage);
    initOutHitBox();
    setDamage();
    R = 1;
    ROTATION_SPEED = 5;
  }

  // how far away enemy can spot explorer
  protected abstract void initOutHitBox();

  // update outer box as enemy moves
  protected abstract void validateOuterBox();

  // health damage enemy does to explorer
  protected abstract void setDamage();

  public int getDamage() { return damage; }

  public void updatePlayer(Explorer explorer) { explorer.removeLife(); }

  // when enemy is around the explorer
  protected void speedUp() {
    vx = (int) Math.round(R * 2 * Math.cos(Math.toRadians(angle)));
    vy = (int) Math.round(R * 2 * Math.sin(Math.toRadians(angle)));
    x += vx;
    y += vy;
    checkBorder();
    this.hitBox.setLocation(x, y);
    validateOuterBox();
  }

  @Override
  public void moveForwards() {
    super.moveForwards();
    validateOuterBox();
  }

  @Override
  // also check if enemy can see explorer
  public void resolveCollision(GameObject gameObject) {
    if (gameObject instanceof Explorer) {
      if (outHitBox.intersects(gameObject.getHitBox())) {
        speedUp();
      }
    }
    else if (hitBox.intersects(gameObject.getHitBox())) {
      moveBackwards();
      rotateLeft();
    }
  }
}
