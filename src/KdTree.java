import java.util.ArrayList;
import java.util.List;

public class KdTree {
  private Node root;
  private int size;

  public KdTree() {
  } // construct an empty set of points

  private class Node {
    private Node left;
    private Node right;
    private Point2D value;

    public Node(Point2D val) {
      this.value = val;
      this.left = null;
      this.right = null;
    }

    @Override
    public String toString() {
      return "{" + left + "} " + value + " {" + right + "}";

    }
  }

  public void printTree() {
    System.out.println(root);
  }

  public boolean isEmpty() {
    return root == null;
  } // is the set empty?

  public int size() {
    return size;
  } // number of points in the set

  public void insert(Point2D p) {
    root = insert(root, p, 0);
  } // add the point p to the set (if it is not already in the set)

  private Node insert(Node node, Point2D p, int height) {
    if (node == null) {
      size++;
      Node node2 = new Node(p);
      return node2;
    }
    if (node.value.equals(p)) {
      return node;
    }
    if (height % 2 == 0) {
      if (p.x() < node.value.x()) {
        node.left = insert(node.left, p, height + 1);
        return node;
      } else {
        node.right = insert(node.right, p, height + 1);
        return node;
      }
    } else {
      if (p.y() < node.value.y()) {
        node.left = insert(node.left, p, height + 1);
        return node;
      } else {
        node.right = insert(node.right, p, height + 1);
        return node;
      }
    }
  }

  public boolean contains(Point2D p) {
    return contains(root, p, 0);
  } // does the set contain the point p?

  private boolean contains(Node node, Point2D p, int height) {
    if (node == null) {
      return false;
    }
    if (node.value.equals(p)) {
      return true;
    }
    if (height % 2 == 0) {
      if (p.x() < node.value.x()) {
        return contains(node.left, p, height + 1);
      } else {
        return contains(node.right, p, height + 1);
      }
    } else {
      if (p.y() < node.value.y()) {

        return contains(node.left, p, height + 1);
      } else {
        return contains(node.right, p, height + 1);
      }
    }
  }

  public void draw() {
    draw(root, root.value.x(), root.value.y(), 0);
  } // draw all of the points to standard draw

  private void draw(Node node, double xEdge, double yEdge, int height) {
    if (node == null) {
      return;
    }
    StdDraw.setPenRadius(.01);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.point(node.value.x(), node.value.y());
    draw(node.left, 0, 0, height+1);
    draw(node.right, 0, 0, height+1);
    if (height % 2 == 0) {
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.setPenRadius();
      StdDraw.line(xEdge, node.value.y(), 1, node.value.y());
      draw(node.left, node.value.x(), node.value.y(), height + 1);
      draw(node.right, node.value.x(), node.value.y(), height + 1);
    } else {
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.setPenRadius();
      StdDraw.line(node.value.x(), yEdge, node.value.x(), 1);
      draw(node.left, node.value.x(), node.value.y(), height + 1);
      draw(node.right, node.value.x(), node.value.y(), height + 1);
    }
  }

  public Iterable<Point2D> range(RectHV rect) {
    List<Point2D> points = new ArrayList<Point2D>();
    range(root, rect, 0, points);
    return points;
  } // all points in the set that are inside the rectangle

  private void range(Node node, RectHV r, int height, List<Point2D> points) {
    if (node == null) {
      return;
    }
    if (r.contains(node.value)) {
      points.add(node.value);
      range(node.left, r, height + 1, points);
      range(node.right, r, height + 1, points);
    } else {
      if (height % 2 == 0) {
        if (r.ymin() < node.value.y() && r.ymax() > node.value.y()) {
          range(node.left, r, height + 1, points);
          range(node.right, r, height + 1, points);
        } else {
          if (r.ymin() > node.value.y()) {
            range(node.right, r, height + 1, points);
          }
          if (r.ymax() < root.value.y()) {
            range(node.left, r, height + 1, points);
          }
        }
      } else {
        if (r.xmin() < node.value.x() && r.xmax() > node.value.x()) {
          range(node.left, r, height + 1, points);
          range(node.right, r, height + 1, points);
        } else {
          if (r.xmin() > node.value.x()) {
            range(node.right, r, height + 1, points);
          }
          if (r.xmax() < node.value.x()) {
            range(node.left, r, height + 1, points);
          }
        }
      }
    }
    // TODO Auto-generated method stub

  }

  public Point2D nearest(Point2D p) {
    return null;
  } // a nearest neighbor in the set to p; null if set is empty

}
