import java.util.Comparator;

public class Point implements Comparable<Point> {
<<<<<<< HEAD
  public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {

    @Override
    public int compare(Point o1, Point o2) {
      double slope1 = slopeTo(o1); //TODO still have to deal with degenrate cases
      double slope2 = slopeTo(o2);
      if(slope1 < slope2) {
        return -1;
      } else if(slope1 > slope2) {
=======
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
>>>>>>> 58a4f6c18c201b90fb6e2f93d95ebadeac94b249
        return 1;
      } else {
        return 0;
      }
    }
  };        // compare points by slope to this point
<<<<<<< HEAD
  private int x;
  private int y;

   public Point(int x, int y){
     this.x = x;
     this.y = y;
   }// construct the point (x, y)
=======

   public Point(int x1, int y1){
     x = x1;
     y = y1;
   }
>>>>>>> 58a4f6c18c201b90fb6e2f93d95ebadeac94b249

   public   void draw(){
     StdDraw.point(x, y);
   }
   public   void drawTo(Point that){
     StdDraw.line(x, y, that.x, that.y);
<<<<<<< HEAD
   }// draw the line segment from this point to that point
=======
   }
>>>>>>> 58a4f6c18c201b90fb6e2f93d95ebadeac94b249

   public String toString() {
     return "(" + x + ", " + y + ")";
   }
<<<<<<< HEAD
  

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
=======

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
>>>>>>> 58a4f6c18c201b90fb6e2f93d95ebadeac94b249
        return 1;
      } else {
        return 0;
      }
    } else {
      return 1;
    }
<<<<<<< HEAD
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
=======
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
>>>>>>> 58a4f6c18c201b90fb6e2f93d95ebadeac94b249
    }
  } // the slope between this point and that point
}