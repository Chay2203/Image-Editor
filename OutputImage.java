import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OutputImage {
 public void outputImage(BufferedImage outputImage) {
  try {
   File outputFile = new File("output.jpg");
   ImageIO.write(outputImage, "jpg", outputFile);
  } catch (IOException e) {
   System.out.println("Error: " + e);
  }
 }
}
