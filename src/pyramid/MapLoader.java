/*
1 = regular wall
2 = horizontal wall
3 = vertical wall
4 = explorer
5 = scorpion
6 = beetle
7 = mummy
8 = scarab -> disable mummies
9 = sword
A = potion -> lives for explorer
B = loot -> points for explorer
 */
package pyramid;

import pyramid.gameobject.mobile.*;
import pyramid.gameobject.stationary.wall.*;
import pyramid.gameobject.stationary.*;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapLoader {

  private final int IMG_SIZE = 30;
  private PyramidDriver machine;

  public MapLoader() { machine = new PyramidDriver(); }


  public PyramidDriver loadMap(String mapFile) {
    InputStreamReader isr = new InputStreamReader(MapLoader.class.getClassLoader().getResourceAsStream(mapFile));
    BufferedReader mapReader = new BufferedReader(isr);
    try {
      String row = mapReader.readLine();
      if (row == null) {
        throw new IOException("no data in file");
      }
      String[] mapInfo = row.split("\t");
      int numCols = Integer.parseInt(mapInfo[0]);
      int numRows = Integer.parseInt(mapInfo[1]);

      for (int curRow = 0; curRow < numRows; curRow++) {
        row = mapReader.readLine();
        mapInfo = row.split("\t");
        for (int curCol = 0; curCol < numCols; curCol++) {
          switch (mapInfo[curCol]) {
            case "1":
              machine.add(new Wall(curCol * IMG_SIZE, curRow * IMG_SIZE, (BufferedImage) Resources.getResource("wall1")));
              break;
            case "2":
              machine.add(new HorizontalWall(curCol * IMG_SIZE, curRow * IMG_SIZE,(BufferedImage)  Resources.getResource("block_hor")));
              break;
            case "3":
              machine.add(new VerticalWall(curCol * IMG_SIZE, curRow * IMG_SIZE, (BufferedImage) Resources.getResource("block_vert")));
              break;
            case "4":
              machine.add(new Explorer(curCol * IMG_SIZE, curRow * IMG_SIZE,0, 0, 0, (BufferedImage)  Resources.getResource("explorer_right")));
              break;
            case "5":
              machine.add(new Scorpion(curCol * IMG_SIZE, curRow * IMG_SIZE,0,0, 0,  (BufferedImage) Resources.getResource("scorpion")));
              break;
            case "6":
              machine.add(new Beetle(curCol * IMG_SIZE, curRow * IMG_SIZE,0, 0, 270, (BufferedImage) Resources.getResource("beetle")));
              break;
            case "7":
              machine.add(new Mummy(curCol * IMG_SIZE, curRow * IMG_SIZE,0, 0, 0, (BufferedImage) Resources.getResource("mummy")));
              break;
            case "8":
              machine.add(new Scarab(curCol * IMG_SIZE, curRow * IMG_SIZE,(BufferedImage) Resources.getResource("scarab")));
              break;
            case "9":
              machine.add(new Sword(curCol * IMG_SIZE, curRow * IMG_SIZE, (BufferedImage) Resources.getResource("sword")));
              break;
            case "A":
              machine.add(new Potion(curCol * IMG_SIZE, curRow * IMG_SIZE,(BufferedImage) Resources.getResource("potion")));
              break;
            case "B":
              machine.add(new Loot(curCol * IMG_SIZE, curRow * IMG_SIZE, (BufferedImage) Resources.getResource("treasure")));
              break;

          }
        }
      }
    } catch (IOException ex) {
      System.out.println(ex);
    }
    return machine;
  }
}
