package pyramid.gameobject.mobile;

import pyramid.PlayerUpdates;
import pyramid.gameobject.GameObject;
import pyramid.gameobject.Collidable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observer;

public class Explorer extends Mobile {

  private static final int MAX_HEALTH = 20;
  private static final int MAX_LIVES = 3;

  private int score;
  private int lives;
  private int health;
  private PlayerUpdates playerUpdates;

  public Explorer(int x, int y, int vx, int vy, int angle, BufferedImage explorerImage) {
    super(x, y, vx, vy, angle, explorerImage);
    this.R = 10;
    this.score = 0;
    this.lives = MAX_LIVES;
    this.health = MAX_HEALTH;
    playerUpdates = new PlayerUpdates();
  }

  /*
  Not entirely functional! - Could not get to work properly
   */
  public void isBlocked(Rectangle rec) {
    if (angle < 90 && rec.getX() < hitBox.getX()) { moveForwards(); }
    else if (angle < 90 && rec.getX() > hitBox.getX()) { moveBackwards(); }
    else if (angle >= 90 && angle < 180 && rec.getY() < hitBox.getY()) { moveForwards(); }
    else if (angle >= 90 && angle < 180 && rec.getY() > hitBox.getY()) { moveBackwards(); }
    else if (angle >= 180 && angle < 270 && rec.getX() < hitBox.getX()) { moveBackwards(); }
    else if (angle >= 180 && angle < 270 && rec.getX() > hitBox.getX()) { moveForwards(); }
    else if (angle >= 270 && rec.getY() < hitBox.getY()) { moveBackwards(); }
    else if (angle >= 270 && rec.getY() > hitBox.getY()) { moveForwards(); }
  }

  public void resolveCollision(GameObject gameObject) {
    if (hitBox.intersects(gameObject.getHitBox())) {
      if (gameObject instanceof Collidable) {
        ((Collidable) gameObject).updatePlayer(this);
      }
    }
  }

  private void setHealth(int healthChange) {
    int change = health + healthChange;
    if (change > MAX_HEALTH && lives == 3) {
      health = MAX_HEALTH;
    }
    if (change > MAX_HEALTH) {
      this.setLife(1); // add life if health change is above max health
    }
    else if (change <= 0) {  // remove life
      setLife(-1);
      health = MAX_HEALTH;
    }
    else {
      health = change;
    }
  }

  private void setLife(int lifeChange) {
    int change = lives + lifeChange;
    if (change > 0 && change <= 3) {
      lives = change;
      playerUpdates.setType(PlayerUpdates.LIVES);
      playerUpdates.setValue(lives);
    }
    else if (change <= 0 ){
      destroyed = true;
    }
  }

  public int getScore() { return score; }

  public void addScore(int addPoints) {
    score += addPoints;
    playerUpdates.setType(PlayerUpdates.SCORE);
    playerUpdates.setValue(score);
  }

  public void addLife() { setLife(1); }

  public void removeLife() { setHealth( -1); }

  public int getLives() { return lives; }

  public void getUpdates(Observer obs) { playerUpdates.addObserver(obs); }

}
