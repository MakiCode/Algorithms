import java.util.Comparator;

public class Point implements Comparable<Point> {
  public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {

    @Override
    public int compare(Point o1, Point o2) {
      double slope1 = slopeTo(o1); //TODO still have to deal with degenrate cases
      double slope2 = slopeTo(o2);
      if(slope1 < slope2) {
        return -1;
      } else if(slope1 > slope2) {
        return 1;
      } else {
        return 0;
      }
    }
  };        // compare points by slope to this point
  private int x;
  private int y;

   public Point(int x, int y){
     this.x = x;
     this.y = y;
   }// construct the point (x, y)

   public   void draw(){
     StdDraw.point(x, y);
   }
   public   void drawTo(Point that){
     StdDraw.line(x, y, that.x, that.y);
   }// draw the line segment from this point to that point

   public String toString() {
     return "(" + x + ", " + y + ")";
   }
  

  public int compareTo(Point that) {
    if(that == null) {
      throw new NullPointerException();
    }
    if(y < that.y) {
      return -1;
    } else if(y == that.y) {
      if(x < that.x) {
        return -1; 
      } else if(x > that.x) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return 1;
    }
  }// is this point lexicographically smaller than that point?
  public double slopeTo(Point that) {
    double yDiff = that.y - y;
    double xDiff = that.x - x;
    if(xDiff == 0 && yDiff == 0) {
      return Double.NEGATIVE_INFINITY;
    }
    if(yDiff == 0) {
     return +0;
    } else if(xDiff == 0) {
      return Double.POSITIVE_INFINITY;
    } else {
      return yDiff/xDiff;
    }
  } // the slope between this point and that point
}