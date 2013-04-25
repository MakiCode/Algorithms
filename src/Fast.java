import java.util.Arrays;

public class Fast {
  public static void main(String[] args) {
    // we load the points from the file into an array
    Point[] array = new Point[2];
    for (Point point : array) {
      Arrays.sort(array, point.SLOPE_ORDER);
      // this is a bit harder... check if any 3 or more adjacent points have the
      // same slope when compared to the original point (the var point)
    }
    Arrays.sort(array); // last step to psuedo shuffle the array and make quick
                        // sort go fast
  }
}
