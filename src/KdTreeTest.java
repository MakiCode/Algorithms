import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KdTreeTest {

	@Test
	public void testInsertAndSize() {
		KdTree kdTree = new KdTree();
		Point2D point = new Point2D(0, 0);
		kdTree.insert(point);
		boolean test = kdTree.contains(point);
		boolean test2 = kdTree.size() == 1;
		assertTrue("Expected was: true result was: " + test, test);
		assertTrue("Expected was: true result was: " + test2, test2);
	}

	@Test
	public void testInsertMultiple() {
		KdTree kdTree = new KdTree();
		Point2D point1 = new Point2D(10, 10);
		Point2D point2 = new Point2D(5, 5);
		Point2D point3 = new Point2D(15, 15);
		Point2D point4 = new Point2D(6, 6);
		Point2D point5 = new Point2D(4, 4);
		Point2D point6 = new Point2D(16, 16);
		Point2D point7 = new Point2D(14, 14);
		Point2D point8 = new Point2D(7, 7);
		kdTree.insert(point1);
		kdTree.insert(point2);
		kdTree.insert(point3);
		kdTree.insert(point4);
		kdTree.insert(point5);
		kdTree.insert(point6);
		kdTree.insert(point7);
		kdTree.insert(point8);
		assertTrue(kdTree.contains(point1));
		assertTrue(kdTree.contains(point2));
		assertTrue(kdTree.contains(point3));
		assertTrue(kdTree.contains(point4));
		assertTrue(kdTree.contains(point5));
		assertTrue(kdTree.contains(point6));
		assertTrue(kdTree.contains(point7));
		assertTrue(kdTree.contains(point8));
	}

	@Test
	public void testMultipleSameInsert() {
		KdTree kdTree = new KdTree();
		Point2D point1 = new Point2D(50, 50);
		Point2D point2 = new Point2D(50, 50);
		kdTree.insert(point2);
		kdTree.insert(point2);
		kdTree.insert(point1);
		kdTree.insert(point2);
		kdTree.insert(point1);
		kdTree.insert(point2);
		kdTree.insert(point2);
		kdTree.insert(point1);
		kdTree.printTree(); // Don't know how to test this with junit since I
							// need to know internals of tree
	}

	@Test
	public void testRange() {
		KdTree kdTree = new KdTree();
		RectHV rect = new RectHV(0, 0, 100, 100);
		Point2D point = new Point2D(50, 50);
		kdTree.insert(point);
		Iterable<Point2D> pointsInRange = kdTree.range(rect);
		assertTrue(pointsInRange.iterator().hasNext());
		Point2D point2d = pointsInRange.iterator().next();
		assertTrue(point2d.equals(point));
	}

	@Test
	public void testMultipleRange() {
		KdTree kdTree = new KdTree();
		RectHV rectHV = new RectHV(0, 0, 100, 100);
		Point2D point1 = new Point2D(50, 50);
		Point2D point2 = new Point2D(70, 70);
		Point2D point3 = new Point2D(30, 30);
		kdTree.insert(point1);
		kdTree.insert(point2);
		kdTree.insert(point3);
		Iterable<Point2D> pointsInRange = kdTree.range(rectHV);
		for (Point2D point : pointsInRange) {
			assertTrue(point.equals(point1) || point.equals(point2)
					|| point.equals(point3));
		}
	}

	@Test
	public void testMultipleInOutRange() {
		KdTree kdTree = new KdTree();
		RectHV rectHV = new RectHV(39, 39, 100, 100);
		Point2D point1 = new Point2D(50, 50);
		Point2D point2 = new Point2D(70, 70);
		Point2D point3 = new Point2D(40, 40);
		Point2D point4 = new Point2D(30, 30);
		Point2D point5 = new Point2D(20, 20);
		Point2D point6 = new Point2D(200, 200);
		kdTree.insert(point1);
		kdTree.insert(point2);
		kdTree.insert(point3);
		kdTree.insert(point4);
		kdTree.insert(point5);
		kdTree.insert(point6);
		Iterable<Point2D> pointsInRange = kdTree.range(rectHV);
		for (Point2D point : pointsInRange) {
			assertTrue(!point.equals(point4) && !point.equals(point5)
					&& !point.equals(point6));
			assertTrue(point.equals(point1) || point.equals(point2)
					|| point.equals(point3));
		}
	}

	@Test
	public void testOutOfRange() {
		KdTree kdTree = new KdTree();
		RectHV rect = new RectHV(0, 0, 1, 1);
		Point2D point1 = new Point2D(30, 30);
		Point2D point2 = new Point2D(40, 40);
		Point2D point3 = new Point2D(50, 50);
		kdTree.insert(point1);
		kdTree.insert(point2);
		kdTree.insert(point3);
		Iterable<Point2D> pointsInRange = kdTree.range(rect);
		assertTrue(!pointsInRange.iterator().hasNext());
	}
	
	@Test
	public void emptyContains() {
		KdTree kdTree = new KdTree();
		assertTrue(!kdTree.contains(new Point2D(0, 0)));
	}
	
	@Test
	public void testNearest() {
		KdTree kdTree = new KdTree();
		Point2D point = new Point2D(4, 7);
		kdTree.insert(point);
		Point2D queryPoint = new Point2D(6,  90);
		assertTrue(kdTree.nearest(queryPoint).equals(point));
	}

}
