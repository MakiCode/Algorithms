import static org.junit.Assert.*;

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
		//kdTree.printTree();
	}
	
	@Test
	public void testInsertMultiple() {
		KdTree kdTree = new KdTree();
		Point2D point1 = new Point2D(10,10);
		Point2D point2 = new Point2D(5,5);
		Point2D point3 = new Point2D(15,15);
		Point2D point4 = new Point2D(6,6);
		Point2D point5 = new Point2D(4,4);
		Point2D point6 = new Point2D(16,16);
		Point2D point7 = new Point2D(14,14);
		Point2D point8 = new Point2D(7,7);
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
		kdTree.printTree();
	}

}
