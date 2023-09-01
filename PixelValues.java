import java.awt.Color;
import java.awt.image.BufferedImage;

public class PixelValues {
 public int getWidth(BufferedImage inputImage) {
  return inputImage.getWidth();
 }

 public int getHeight(BufferedImage inputImage) {
  return inputImage.getHeight();
 }

 // Here sir implemented some other color instead of the awt package one.
 public int[] getRGB(BufferedImage inputImage, int x, int y) {
  Color color = new Color(inputImage.getRGB(x, y));
  int[] rgb = new int[3];
  rgb[0] = color.getRed();
  rgb[1] = color.getGreen();
  rgb[2] = color.getBlue();
  return rgb;
 }
}
