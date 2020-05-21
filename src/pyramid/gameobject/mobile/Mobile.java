/*
extends GameObject class to include methods for objects that move
 */
package pyramid.gameobject.mobile;

import pyramid.gameobject.GameObject;
import pyramid.gui.PyramidPanicUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public abstract class Mobile extends GameObject {
  protected int vx;
  protected int vy;
  protected int angle;
  protected int imgWidth, imgHeight;
  protected double R = 4;
  protected double ROTATION_SPEED = 10;

  public Mobile(int x, int y, int vx, int vy, int angle, BufferedImage mobileImage) {
    super(x, y, mobileImage);
    this.vx = vx;
    this.vy = vy;
    this.angle = angle;
    this.imgWidth = mobileImage.getWidth();
    this.imgHeight = mobileImage.getHeight();
  }

  // safe guard in case check collision fails
  protected void checkBorder() {
    if (x < 20) {
      x = 20;
    }
    if (x >= PyramidPanicUI.WORLD_WIDTH - imgWidth) {
      x = PyramidPanicUI.WORLD_WIDTH - imgWidth;
    }
    if (y < 20) {
      y = 20;
    }
    if (y >= PyramidPanicUI.WORLD_HEIGHT - imgHeight) {
      y = PyramidPanicUI.WORLD_HEIGHT - imgHeight;
    }
  }

  public void moveBackwards() {
    vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
    vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
    x -= vx;
    y -= vy;
    checkBorder();
    this.hitBox.setLocation(x, y);
  }

  public void moveForwards() {
    vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
    vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
    x += vx;
    y += vy;
    checkBorder();
    this.hitBox.setLocation(x, y);
  }

  public void rotateLeft() {
    this.angle -= this.ROTATION_SPEED;
    if (angle < 0) {
      angle = 360 + angle;
    }
  }

  public void rotateRight() {
    this.angle += this.ROTATION_SPEED;
    if (angle > 359) {
      angle = angle - 360;
    }
  }

  public abstract void resolveCollision(GameObject gameObject);

  // update GameObject
  public void refresh() {}


  @Override
  public void drawImage(Graphics g) {
    if (!destroyed) {
      AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
      rotation.rotate(Math.toRadians(angle), this.gameObjectImage.getWidth() / 2.0, this.gameObjectImage.getHeight() / 2.0);
      Graphics2D g2d = (Graphics2D) g;
      g2d.drawImage(this.gameObjectImage, rotation, null);
    }
  }
}
