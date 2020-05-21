/*
reads in all resources used in game
 */
package pyramid;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static javax.imageio.ImageIO.read;

public class Resources {

  private static Map<String, BufferedImage> resources;

  static {
    Resources.resources = new HashMap<>();
    try {
      Resources.resources.put("background1", read(Resources.class.getClassLoader().getResource("Background1.png")));
      Resources.resources.put("background2", read(Resources.class.getClassLoader().getResource("Background2.bmp")));
      Resources.resources.put("start", read(Resources.class.getClassLoader().getResource("start_button.png")));
      Resources.resources.put("quit", read(Resources.class.getClassLoader().getResource("quit_button.png")));
      Resources.resources.put("label_1", read(Resources.class.getClassLoader().getResource("Panel_1.gif")));
      Resources.resources.put("label_2", read(Resources.class.getClassLoader().getResource("Panel_2.gif")));
      Resources.resources.put("label_3", read(Resources.class.getClassLoader().getResource("Panel_3.gif")));
      Resources.resources.put("explorer_right", read(Resources.class.getClassLoader().getResource("Explorer_right.gif")));
      Resources.resources.put("block_hor", read(Resources.class.getClassLoader().getResource("Block_hor.gif")));
      Resources.resources.put("block_vert", read(Resources.class.getClassLoader().getResource("Block_vert.gif")));
      Resources.resources.put("wall1", read(Resources.class.getClassLoader().getResource("Wall1.gif")));
      Resources.resources.put("beetle", read(Resources.class.getClassLoader().getResource("Beetle_up.gif")));
      Resources.resources.put("scorpion", read(Resources.class.getClassLoader().getResource("Scorpion_right.gif")));
      Resources.resources.put("mummy", read(Resources.class.getClassLoader().getResource("Mummy_right.gif")));
      Resources.resources.put("treasure", read(Resources.class.getClassLoader().getResource("Treasure1.gif")));
      Resources.resources.put("scarab", read(Resources.class.getClassLoader().getResource("Scarab.gif")));
      Resources.resources.put("sword", read(Resources.class.getClassLoader().getResource("Sword.gif")));
      Resources.resources.put("potion", read(Resources.class.getClassLoader().getResource("Potion.gif")));
      Resources.resources.put("life", read(Resources.class.getClassLoader().getResource("Lives.gif")));
      Resources.resources.put("end_panel", read(Resources.class.getClassLoader().getResource("end.png")));
    }
    catch (IOException e) {
      e.printStackTrace();
      System.exit(-5);
    }
  }

  public static BufferedImage getResource(String key) {
    return Resources.resources.get(key);
  }
}
