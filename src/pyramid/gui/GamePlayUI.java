/*
Purpose of GamePlauUI.java : Display everything that is happening in the game to the screen,
and display a panel at the bottom showing the player's lives and score. Uses the Observer class
to update this panel

 */

package pyramid.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import pyramid.FollowScreen;
import pyramid.Resources;
import pyramid.PlayerUpdates;
import pyramid.PyramidDriver;
import pyramid.gameobject.mobile.Explorer;
import pyramid.gameobject.mobile.ExplorerControls;

import javax.swing.*;

public class GamePlayUI extends GameUI implements Observer {
  private JLabel playerLivesLabel;
  private ImageIcon playerLives[];
  private BufferedImage world;
  private Graphics2D buffer;
  private PyramidDriver pyramidDriver;
  private boolean isRunning = true;
  private FollowScreen followScreen;
  private int lives;
  private int score;

  public GamePlayUI(PyramidPanicUI panelAnchor, PyramidDriver pyramidDriver) {
    super(panelAnchor);
    background = Resources.getResource("background2");
    background = resizeBackground(background, PyramidPanicUI.WORLD_HEIGHT, PyramidPanicUI.WORLD_WIDTH);
    this.world = new BufferedImage(PyramidPanicUI.WORLD_WIDTH, PyramidPanicUI.WORLD_HEIGHT, BufferedImage.TYPE_INT_RGB);
    this.pyramidDriver = pyramidDriver;
    playerLivesLabel = new JLabel();
    playerLivesLabel.setBounds(0, 595, PyramidPanicUI.SCREEN_WIDTH, PyramidPanicUI.SCREEN_HEIGHT/15);
    playerLivesLabel.setHorizontalTextPosition(JLabel.CENTER);
    playerLivesLabel.setVerticalTextPosition(JLabel.CENTER);
    playerLivesLabel.setForeground(Color.orange);
    playerLivesLabel.setFont(new Font("score", Font.BOLD, 40));
    this.add(playerLivesLabel);
    playerLives = new ImageIcon[3];
    playerLives[0] = new ImageIcon( Resources.getResource("label_1"));
    playerLives[1] = new ImageIcon( Resources.getResource("label_2"));
    playerLives[2] = new ImageIcon( Resources.getResource("label_3"));
  }

  private void initializePlayer(Explorer player) {
    new ExplorerControls(this, player, KeyEvent.VK_UP, KeyEvent.VK_DOWN,
        KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
    followScreen = new FollowScreen(player);
    lives = player.getLives();
    score = player.getScore();
    player.getUpdates(this);
    updatePlayerPanel();
  }

  private void updatePlayerPanel() {
    if (lives == 1 ) {
      playerLivesLabel.setIcon(playerLives[0]);
    }
    if (lives == 2) {
      playerLivesLabel.setIcon(playerLives[1]);
    }
    if (lives == 3) {
      playerLivesLabel.setIcon(playerLives[2]);
    }
    playerLivesLabel.setText(Integer.toString(score));
  }


  public void run() {
    initializePlayer(pyramidDriver.getPlayer());
    try {
      while (isRunning) {
        isRunning = pyramidDriver.execute();
        repaint();
        Thread.sleep(1000 / 50);
      }
    } catch (InterruptedException ignored) {
      System.out.println(ignored);
    }
    gameOver(pyramidDriver.getScore());
  }


  private void gameOver(int score) {
    panelAnchor.setScore(score);
    panelAnchor.switchPanels(PyramidPanicUI.END);
  }

  // update player panel
  public void update(Observable obs, Object arg) {
    PlayerUpdates update = (PlayerUpdates) arg;
    if (update.getType().equals(PlayerUpdates.LIVES)) {
     lives = update.getValue();
    }
    if(update.getType().equals(PlayerUpdates.SCORE)) {
      score = update.getValue();
    }
    updatePlayerPanel();
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    buffer = world.createGraphics();
    buffer.setColor(Color.BLACK);
    buffer.fillRect(0, 0, PyramidPanicUI.WORLD_WIDTH, PyramidPanicUI.WORLD_HEIGHT);
    buffer.drawImage(background, 0,0, this);
    pyramidDriver.draw(buffer);
    BufferedImage screen = world.getSubimage(followScreen.getX(), followScreen.getY(),
        PyramidPanicUI.SCREEN_WIDTH, PyramidPanicUI.SCREEN_HEIGHT);
    g2.drawImage(screen, 0, 0, null);
  }
}