import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class DequeTest {

  @Test
  public void testIsEmpty() {
    Deque deque = new Deque<String>();
    assert deque.isEmpty();
    deque.addFirst("One");
    deque.addLast("Two");
    deque.addFirst("Three");
    deque.removeFirst(); //three
    deque.removeLast(); //two
    deque.removeFirst(); //one
    assert deque.isEmpty();
  }

  @Test
  public void testSize() {
    Deque deque = new Deque<Integer>();
    int numOfItems = new Random().nextInt(101);
    for (int i = 0; i < numOfItems; i++) {
      deque.addFirst(i);
    }
    assert deque.size() == numOfItems;
  }

  @Test
  public void testAddFirst() {
    fail("Not yet implemented");
  }

  @Test
  public void testAddLast() {
    fail("Not yet implemented");
  }

  @Test
  public void testRemoveFirst() {
    fail("Not yet implemented");
  }

  @Test
  public void testRemoveLast() {
    Deque<String> deque = new Deque<String>();
    deque.addFirst("One");
    deque.addFirst("Two");
    assert deque.removeLast().equals("One");
  }

  @Test
  public void testIterator() {
    fail("Not yet implemented");
  }

}
