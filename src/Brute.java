public class Brute {
  public static void main(String[] args) {
<<<<<<< HEAD
    // we load the list points....
    Point[] array = new Point[2];
    for (Point p : array) {
      for (Point q : array) {
        for (Point r : array) {
          for (Point s : array) {
            if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
              StdOut.println(p + " -> " + q + " -> " + r + " -> " + s);
              // basic brute force implementation need to solve the p->q->r->s
=======
    In in = new In(args[0]);
    int N = in.readInt();
    Point[] a = new Point[N];
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (int i = 0; i < N; i++) {
      int x = in.readInt();
      int y = in.readInt();
      Point point = new Point(x, y);
      point.draw();
      a[i] = point;
    }

    for (Point p : a) {
      for (Point q : a) {
        for (Point r : a) {
          for (Point s : a) {
            if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
              StdOut.println(p + " -> " + q + " -> " + r + " -> " + s);
              // basic brute force implementation still need to solve the p->q->r->s
>>>>>>> 58a4f6c18c201b90fb6e2f93d95ebadeac94b249
              // and p->q->s->r etc. problem
            }
          }
        }
      }
    }
  }
}
