import java.util.Arrays;

public class Fast {
  public static void main(String[] args) {

    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    StdDraw.show(0);

    // read in the input
    String filename = args[0];
    In in = new In(filename);
    int N = in.readInt();
    Point[] a = new Point[N];

    for (int i = 0; i < N; i++) {
      int x = in.readInt();
      int y = in.readInt();
      Point p = new Point(x, y);
      p.draw();
      a[i] = p;
    }

    // display to screen all at once
    StdDraw.show(0);

    // we load the points from the file into an array
    for (int j = 0; j < a.length; j++) {
      Point point = a[j];
      Arrays.sort(a, j, a.length, point.SLOPE_ORDER);

      for (int k = j; k < a.length; k++) { // go from a[j] to end

        if (a.length - k <= 2) {
          break;
        }
        // we only move forward in the array. if the array is not long enough
        // for these to work then quit
        if (point.slopeTo(a[k]) == point.slopeTo(a[k + 1])
            && point.slopeTo(a[k]) == point.slopeTo(a[k + 2])) {
          // check on each side whether we have a match
          Point[] arrayTest = new Point[4];
          arrayTest[0] = a[k];
          arrayTest[1] = a[k + 1];
          arrayTest[2] = a[k + 2];
          arrayTest[3] = point;
          Arrays.sort(arrayTest);
          arrayTest[0].drawTo(arrayTest[3]);
  StdOut.println(point + " -> " + a[k] + " -> " + a[k + 1] + " -> " + a[k + 2]);
        }
      }
    }
    System.out.println("Finished!");
  }
}