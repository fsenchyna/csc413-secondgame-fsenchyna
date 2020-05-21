/*
Class to notify GamePlayUI when there is a change in player life or score
 */
package pyramid;

import java.util.Observable;

public class PlayerUpdates extends Observable {

  private String type;
  private int value;
  public static final String LIVES = "life";
  public static final String SCORE = "score";


  public PlayerUpdates() {}

  public String getType() { return type; }

  public int getValue() { return value; }

  public void setType(String updateType) {
    if (updateType.equals(LIVES)) { type = LIVES; }
    if (updateType.equals(SCORE)) { type = SCORE; }
    setChanged();
    notifyObservers(this);
  }

  public void setValue(int updateValue ) {
    value = updateValue;
    setChanged();
    notifyObservers(this);
  }

}
