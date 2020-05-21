/*
Class to connect key pressings to control player movemeent.
Inspiration for code related to Key Binding from: https://www.youtube.com/watch?v=LNizNHaRV84
*/
package pyramid.gameobject.mobile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExplorerControls {
  private JPanel jPanel;
  private Explorer explorer;
  private int up, down, left, right;
  private InputMap iMap;
  private ActionMap aMap;

  public ExplorerControls(JPanel jPanel, Explorer explorer, int up, int down, int left, int right) {
    this.jPanel = jPanel;
    this.explorer = explorer;
    this.up = up;
    this.down = down;
    this.left = left;
    this.right = right;
    iMap = this.jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    aMap = this.jPanel.getActionMap();
    initializeExplorer();
  }

  private void initializeExplorer() {
    addKeyBinding(up, "move forward", (evt) -> {
      this.explorer.moveForwards();
    });
    addKeyBinding(down, "move backward", (evt) -> {
      this.explorer.moveBackwards();
    });
    addKeyBinding(left, "rotate left", (evt) -> {
      this.explorer.rotateLeft();
    });
    addKeyBinding(right, "rotate right", (evt) -> {
      this.explorer.rotateRight();
    });
  }

  private void addKeyBinding(int keyCode, String id, ActionListener actionListener) {
    iMap.put(KeyStroke.getKeyStroke(keyCode, 0, false), id);
    aMap.put(id, new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionListener.actionPerformed(e);
      }
    });
  }
}
