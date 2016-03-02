import java.lang.Integer;
import java.awt.*;
import java.util.*;

public class ClosestColor {
  public static void main(String[] args) {
    // store color code as an integer
    Integer color = Integer.parseInt(args[0], 16);
    
    // build output
    //StringBuilder newColor = new StringBuilder();
    int[] oldColorRGB = new int[3];
    int[] newColorRGB = new int[3];
    for (int i = 0; i < 3; i++) {
      // single out a pair of hex digits
      int section = (color >> (i * 8)) % 0x100;
      oldColorRGB[i] = section;
      // downscale color
      section = (section + 8) / 17;
      newColorRGB[i] = section * 16 + section;
      
      // 
      //newColor.append(Integer.toHexString(section));
      
    }
    //System.out.println(newColor);
    
    
    Color oldColor = new Color(oldColorRGB[0], oldColorRGB[1], oldColorRGB[2]);
    Color newColor = new Color(newColorRGB[0], newColorRGB[1], newColorRGB[2]);
    drawComparison(oldColor, newColor);
  }

  
  public static void drawComparison(Color c1, Color c2) {
    DrawingPanel p = new DrawingPanel(540, 300);
    p.setBackground(Color.DARK_GRAY);
    Graphics g = p.getGraphics();
    
    // draw first rectangle
    g.setColor(c1);
    g.fillRect(40, 40, 200, 200);
    g.setColor(Color.WHITE);
    g.drawRect(40, 40, 200, 200);
    String c1Hex = Integer.toHexString(c1.getRGB() & 0xFFFFFF);
    g.drawString("Original color: 0x" + c1Hex.toUpperCase(), 60, 262);
    
    // draw second rectangle
    g.setColor(c2);
    g.fillRect(300, 40, 200, 200);
    g.setColor(Color.WHITE);
    g.drawRect(300, 40, 200, 200);
    String c2Hex = Integer.toHexString(c2.getRGB() & 0xFFFFFF);
    g.drawString("Closest color: 0x" + c2Hex.toUpperCase(), 320, 262);
    
  }
  
}

            
/*
0: 00 - 08    0 - 8     9
1: 09 - 19    9 - 25    17
2: 1A - 2A    26 - 42   17
3: 2B - 3B    43 - 59   17
4: 3C - 4C            17
5: 4D - 5D            17
6: 5E - 6E      17
7: 6F - 7F      17
8: 80 - 90      17
9: 91 - A1      17
A: A2 - B2      17
B: B3 - C3      17
C: C4 - D4      17
D: D5 - E5      17
E: E6 - F6      17
F: F7 - FF      9

16^2 -> 16


00 -> 11    : 9
11 -> 22    : 19


*/
