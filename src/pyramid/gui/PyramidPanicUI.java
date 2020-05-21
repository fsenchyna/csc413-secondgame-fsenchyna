/*
Front-most class for this game. Switches between 3 panels; start menu, game, and end menu
 */
package pyramid.gui;

import pyramid.MapLoader;

import javax.swing.*;
import java.awt.*;

public class PyramidPanicUI extends JFrame {

  public static final int WORLD_WIDTH = 2010;
  public static final int WORLD_HEIGHT = 2010;
  public static final int SCREEN_WIDTH = 1090;
  public static final int SCREEN_HEIGHT = 660;
  public static final String START = "start";
  public static final String GAME = "game";
  public static final String END = "end";
  public static final String QUIT = "quit";

  private JFrame jFrame;
  private JPanel base;
  private CardLayout cLayout;
  private StartMenuUI startPanel;
  private EndGameUI endPanel;
  private GamePlayUI gamePanel;
  private MapLoader mapLoader;
  private int score;

  public static void main(String[] args) {
    PyramidPanicUI pyramidExample = new PyramidPanicUI();
    pyramidExample.init();
    pyramidExample.switchPanels(START);
  }

  private void init() {
    this.jFrame = new JFrame("Pyramid Panic");
    jFrame.setLayout(new BorderLayout());
    jFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    jFrame.setResizable(false);
    base = new JPanel();
    cLayout = new CardLayout();
    base.setLayout(cLayout);
    jFrame.add(base);
    this.mapLoader = new MapLoader(); // initialize map
    startPanel = new StartMenuUI(this);
    endPanel = new EndGameUI(this);
    gamePanel = new GamePlayUI(this, mapLoader.loadMap("maps/map1.txt"));
    base.add(startPanel, START);
    base.add(endPanel, END);
    base.add(gamePanel, GAME);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /*
CardLayout idea inspired from
https://stackoverflow.com/questions/46870004/how-to-switch-jpanels-in-a-jframe-from-within-the-panel
 */
  public void switchPanels(String newPanel) {
    switch (newPanel) {
      case START:
        cLayout.show(base, START);
        break;
      case GAME:
        cLayout.show(base, GAME);
        Thread thread = new Thread(() -> {
          gamePanel.run();
        });
        thread.start();
        break;
      case END:
        cLayout.show(base, END);
        break;
      case QUIT:
        System.out.println("game over");
        setVisible(false);
        jFrame.dispose();
        break;
      default:
        throw new NullPointerException();
    }
  }

  public void setScore(int score) { this.score = score; }

  public int getScore() { return score; }
  
}


