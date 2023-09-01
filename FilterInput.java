import java.util.Scanner;

public class FilterInput {
 public int filterInput() {
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter 1 for grayscale.");
  System.out.println("Enter 2 for rotate 90 degree clockwise.");
  System.out.println("Enter 3 for horizontally inverting the image.");
  System.out.println("Enter 4 for vertically inverting the image.");
  System.out.println("Enter 5 for change brightness.");
  System.out.println("Enter 6 for blur.");
  System.out.println("Enter 7 for contrast");
  // System.out.println("Enter 1 for grayscale.");

  int input = scan.nextInt();

  return input;
 }

 public int changeBrightness() {
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter the percentage of brightness you want to increase: ");
  int input = scan.nextInt();
  return input;
 }

 public double changeFactor() {
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter the factor of contrast you want to increase: ");
  double input = scan.nextDouble();
  return input;
 }
}
