import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KdTree {
	private Node root;
	private int size;

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

	public KdTree() {
	} // construct an empty set of points

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
			node = new Node(p);
			return node;
		}
		if (node.value.equals(p)) {
			return node;
		}
		if (height % 2 == 0) {
			if (p.x() < node.value.x()) {
				node.left = insert(node.left, p, height++);
				return node;
			} else {
				node.right = insert(node.right, p, height++);
				return node;
			}
		} else {
			if (p.y() < node.value.y()) {
				node.left = insert(node.left, p, height++);
				return node;
			} else {
				node.right = insert(node.right, p, height++);
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
				return contains(node.left, p, height++);
			} else {
				return contains(node.right, p, height++);
			}
		} else {
			if (p.y() < node.value.y()) {

				return contains(node.left, p, height++);
			} else {
				return contains(node.right, p, height++);
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
		if (height % 2 == 0) {
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.setPenRadius();
			StdDraw.line(0, node.value.y(), 1, node.value.y());
			draw(node.left, 0, 0, height + 1);
			draw(node.right, 0, 0, height + 1);
		} else {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.setPenRadius();
			StdDraw.line(node.value.x(), 0, node.value.x(), 1);
			draw(node.left, 0, 0, height + 1);
			draw(node.right, 0, 0, height + 1);
		}
	}

	public Iterable<Point2D> range(RectHV rect) {
		List<Point2D> points = new ArrayList<Point2D>();
		range(root, rect, 0, points);
		return points;
	} // all points in the set that are inside the rectangle

	private void range(Node node, RectHV rect, int height, List<Point2D> points) {
		if (rect.contains(root.value)) {
			points.add(root);
			range(root.left, rect, 1);
			range(root.right, rect, 1);
		} else {
			if (rect.ymin() > root.value.y()) {
				range(root.right, rect, 1);
			} else if (rect.ymax() < root.value.y()) {
				range(root.right, rect,1 );
			}
		}
		// TODO Auto-generated method stub
		
	}

	public Point2D nearest(Point2D p) {
		return null;
	} // a nearest neighbor in the set to p; null if set is empty

}
