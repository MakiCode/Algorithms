import java.util.Arrays;

public class Fast {
  public static void main(String[] args) {
<<<<<<< HEAD
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
=======
    In in = new In(args[0]);
    int N = in.readInt();
    Point[] a = new Point[N];
    StdDraw.setXscale(0,32768);
    StdDraw.setYscale(0,32768);

    for(int i = 0; i < N; i++) {
      int x = in.readInt();
      int y = in.readInt();
      Point point = new Point(x, y);
      point.draw();
      a[i] = point;
    }
    
    // we load the points from the file into an array
    for (int j = 0; j < a.length; j++) {
      Point point = a[j];
      Arrays.sort(a, j, a.length, point.SLOPE_ORDER);

      for (int k = j; k < a.length; k++) { // go from a[j] to end

        if (a.length - k <= 2){
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
          StdOut.println(point+" -> "+a[k]+" -> "+a[k+1]+" -> "+a[k+2]);
        }
      }
    }
   System.out.println("Finished!");
  }
}
>>>>>>> 58a4f6c18c201b90fb6e2f93d95ebadeac94b249
