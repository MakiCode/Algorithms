import java.util.Comparator;

public class Point implements Comparable<Point> {
  private int x;
  private int y;
  public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {

    @Override
    public int compare(final Point o1, final Point o2) {
      if (o1 == null || o2 == null) {
        throw new NullPointerException();
      }
      double slope1 = slopeTo(o1);
      double slope2 = slopeTo(o2);
      if (slope1 < slope2) {
        return -1;
      } else if (slope1 > slope2) {
        return 1;
      } else {
        return 0;
      }
    }
  };        // compare points by slope to this point

   public Point(int x1, int y1){
     x = x1;
     y = y1;
   }

   public   void draw(){
     StdDraw.point(x, y);
   }
   public   void drawTo(Point that){
     StdDraw.line(x, y, that.x, that.y);
   }

   public String toString() {
     return "(" + x + ", " + y + ")";
   }

  public int compareTo(Point that) {
    if (that == null) {
      throw new NullPointerException();
    }
    if (y < that.y) {
      return -1;
    } else if (y == that.y) {
      if (x < that.x) {
        return -1;
      } else if (x > that.x) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return 1;
    }
  }
  public double slopeTo(Point that) {
    double yDiff = that.y - y;
    double xDiff = that.x - x;
    if (xDiff == 0 && yDiff == 0) {
      return Double.NEGATIVE_INFINITY;
    }
    if (yDiff == 0) {
     return +0;
    } else if (xDiff == 0) {
      return Double.POSITIVE_INFINITY;
    } else {
      return yDiff / xDiff;
    }
  } // the slope between this point and that point
}