public class Brute {
  public static void main(String[] args) {
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
              // and p->q->s->r etc. problem
            }
          }
        }
      }
    }
  }
}
