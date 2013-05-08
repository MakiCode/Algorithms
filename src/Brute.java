import java.util.Arrays;

public class Brute {
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

    for (int i = 0; i < a.length; i++) {
      Point p = a[i];
      for (int j = i + 1; j < a.length; j++) {
        Point q = a[j];
        for (int k = j + 1; k < a.length; k++) {
          Point r = a[k];
          for (int x = k + 1; x < a.length; x++) {
            if (a.length - x < 3) {
              break;
            }
            Point s = a[x];
            if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
              Point[] arrayTest = new Point[4];
              arrayTest[0] = p;
              arrayTest[1] = q;
              arrayTest[2] = r;
              arrayTest[3] = s;
              Arrays.sort(arrayTest);
              arrayTest[0].drawTo(arrayTest[3]);
              StdOut.println(p + " -> " + q + " -> " + r + " -> " + s);
            }
          }
        }
      }
    }
  }
}
