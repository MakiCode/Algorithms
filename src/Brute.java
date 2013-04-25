public class Brute {
  public static void main(String[] args) {
    // we load the list points....
    Point[] array = new Point[2];
    for (Point p : array) {
      for (Point q : array) {
        for (Point r : array) {
          for (Point s : array) {
            if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
              StdOut.println(p + " -> " + q + " -> " + r + " -> " + s);
              // basic brute force implementation need to solve the p->q->r->s
              // and p->q->s->r etc. problem
            }
          }
        }
      }
    }
  }
}
