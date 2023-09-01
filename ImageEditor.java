import java.awt.image.BufferedImage;

public class ImageEditor {
    public void run() {
        BufferedImage inputImage = new InputFile().inputImage();

        if (inputImage != null) {
            int filterInput = new FilterInput().filterInput();
            BufferedImage outputImage = new Filters().applyFilters(inputImage, filterInput);
            new OutputImage().outputImage(outputImage);
        }

    }
}
