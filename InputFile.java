import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

public class InputFile {
 public BufferedImage inputImage() {
  Scanner scanner = new Scanner(System.in);

  System.out.print("Enter the image file name: ");
  String fileName = scanner.nextLine();

  File imageFile = new File("assets//" + fileName);

  if (!imageFile.exists()) {
   System.out.println("File not found: " + fileName);
   scanner.close();
   return null;
  }
  System.out.println("Image file found: " + fileName);

  BufferedImage inputImage = null;
  try {
   inputImage = ImageIO.read(imageFile);
  } catch (IOException e) {
   System.out.println("Error reading image file: " + fileName);
   return null;
  }

  System.out.println("Image file read: " + fileName);
  return inputImage;

 }
}
