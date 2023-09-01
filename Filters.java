import java.awt.Color;
import java.awt.image.BufferedImage;
public class Filters {
 PixelValues pixelValues = new PixelValues();
 int width;
 int height;

 public BufferedImage toGrayScale(BufferedImage inputImage) {

  width = pixelValues.getWidth(inputImage);
  height = pixelValues.getHeight(inputImage);

  BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
  for (int i = 0; i < width; i++) {
   for (int j = 0; j < height; j++) {
    outputImage.setRGB(i, j, inputImage.getRGB(i, j));
   }
  }

  return outputImage;
 }

 public BufferedImage changeBrightness(BufferedImage inputImage, int increase) {
  width = pixelValues.getWidth(inputImage);
  height = pixelValues.getHeight(inputImage);
  BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
  for (int i = 0; i < width; i++) {
   for (int j = 0; j < height; j++) {
    int red = pixelValues.getRGB(inputImage, i, j)[0];
    int green = pixelValues.getRGB(inputImage, i, j)[1];
    int blue = pixelValues.getRGB(inputImage, i, j)[2];
    red = red + (increase * red / 100);
    green = green + (increase * green / 100);
    blue = blue + (increase * blue / 100);
    if (red > 255)
     red = 255;
    if (green > 255)
     green = 255;
    if (blue > 255)
     blue = 255;
    if (red < 0)
     red = 0;
    if (green < 0)
     green = 0;
    if (blue < 0)
     blue = 0;
    Color color = new Color(red, green, blue);
    outputImage.setRGB(i, j, color.getRGB());
   }
  }
  return outputImage;
 }

 public BufferedImage rotateNintyImage(BufferedImage inputImage) {
  width = pixelValues.getWidth(inputImage);
  height = pixelValues.getHeight(inputImage);
  BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
  for (int i = 0; i < width; i++) {
   for (int j = 0; j < height; j++) {
    outputImage.setRGB(j, i, inputImage.getRGB(i, j));
   }
  }
  return outputImage;
 }

 public BufferedImage horizontalFlip(BufferedImage inputImage) {
  width = pixelValues.getWidth(inputImage);
  height = pixelValues.getHeight(inputImage);
  BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
  for (int i = 0; i < width; i++) {
   for (int j = 0; j < height; j++) {
    outputImage.setRGB(i, j, inputImage.getRGB(width - i - 1, j));
   }
  }
  return outputImage;
 }

 public BufferedImage verticalFlip(BufferedImage inputImage) {
  width = pixelValues.getWidth(inputImage);
  height = pixelValues.getHeight(inputImage);
  BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
  for (int i = 0; i < width; i++) {
   for (int j = 0; j < height; j++) {
    outputImage.setRGB(i, j, inputImage.getRGB(i, height - j - 1));
   }
  }
  return outputImage;
 }

 public BufferedImage blurImage(BufferedImage inputImage) {
  width = pixelValues.getWidth(inputImage);
  height = pixelValues.getHeight(inputImage);
  BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

  Color[] color = null;

  int i = 0;
  int max = 400, rad = 10;
  int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
  color = new Color[max];

  // Now this core section of code is responsible for
  // blurring of an image

  int x = 1, y = 1, x1, y1, d = 0;

  // Running nested for loops for each pixel
  // and blurring it
  for (x = rad; x < inputImage.getHeight() - rad; x++) {
   for (y = rad; y < inputImage.getWidth() - rad; y++) {
    for (x1 = x - rad; x1 < x + rad; x1++) {
     for (y1 = y - rad; y1 < y + rad; y1++) {
      color[i++] = new Color(
        inputImage.getRGB(y1, x1));
     }
    }

    // Smoothing colors of image
    i = 0;
    for (d = 0; d < max; d++) {
     a1 = a1 + color[d].getAlpha();
    }

    a1 = a1 / (max);
    for (d = 0; d < max; d++) {
     r1 = r1 + color[d].getRed();
    }

    r1 = r1 / (max);
    for (d = 0; d < max; d++) {
     g1 = g1 + color[d].getGreen();
    }

    g1 = g1 / (max);
    for (d = 0; d < max; d++) {
     b1 = b1 + color[d].getBlue();
    }

    b1 = b1 / (max);
    int sum1 = (a1 << 24) + (r1 << 16)
      + (g1 << 8) + b1;
    outputImage.setRGB(y, x, (int) (sum1));
   }
  }

  return outputImage;
 }

 public BufferedImage contrastImage(BufferedImage inputImage, double factor) {
  width = pixelValues.getWidth(inputImage);
  height = pixelValues.getHeight(inputImage);
  BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

  for (int y = 0; y < height; y++) {
   for (int x = 0; x < width; x++) {
    int pixel = inputImage.getRGB(x, y);

    int alpha = (pixel >> 24) & 0xFF;
    int red = (pixel >> 16) & 0xFF;
    int green = (pixel >> 8) & 0xFF;
    int blue = pixel & 0xFF;

    red = (int) Math.min(255, Math.max(0, (red - 128) * factor + 128));
    green = (int) Math.min(255, Math.max(0, (green - 128) * factor + 128));
    blue = (int) Math.min(255, Math.max(0, (blue - 128) * factor + 128));

    int adjustedPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
    outputImage.setRGB(x, y, adjustedPixel);
   }
  }

  return outputImage;
 }

 public BufferedImage applyFilters(BufferedImage inputImage, int filterInput) {
  switch (filterInput) {
   case 1:
    return toGrayScale(inputImage);
   case 2:
    return rotateNintyImage(inputImage);
   case 3:
    return horizontalFlip(inputImage);
   case 4:
    return verticalFlip(inputImage);
   case 5:
    int increase = new FilterInput().changeBrightness();
    return changeBrightness(inputImage, increase);
   case 6:
    return blurImage(inputImage);
   case 7:
    double factor = new FilterInput().changeFactor();
    return contrastImage(inputImage, factor);
  }

  return inputImage;
 }

}
