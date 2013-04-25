import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeTest2 {
  // /////////////////////////////////////////////////////////////////////////
  // Fields
  // /////////////////////////////////////////////////////////////////////////

  // Statics
  private final static int MAX_PROBLEM_SIZE = 10000;

  // /////////////////////////////////////////////////////////////////////////
  // Test
  // /////////////////////////////////////////////////////////////////////////

  @Test
  public void testDeque() {
    Deque<String> mDequeue = new Deque<String>();

    assertNotNull(mDequeue);
  }

  @Test
  public void testIsEmpty() {
    Deque<String> mDequeue = new Deque<String>();

    assertTrue("Initialized queue should be empty", mDequeue.isEmpty());
  }

  @Test
  public void testIsEmptyAfterAddRemoveFirst() {
    Deque<String> mDequeue = new Deque<String>();

    mDequeue.addFirst("Something");
    boolean empty = mDequeue.isEmpty();
    assertFalse(empty);
    mDequeue.removeFirst();

    empty = mDequeue.isEmpty();
    assertTrue("Should be empty after adding then removing", empty);

  }

  @Test
  public void testIsEmptyAfterAddRemoveLast() {

    Deque<String> mDequeue = new Deque<String>();

    mDequeue.addLast("Something");
    assertFalse(mDequeue.isEmpty());
    mDequeue.removeLast();
    assertTrue("Should be empty after adding then removing", mDequeue.isEmpty());

  }

  @Test
  public void testIsEmptyAfterAddFirstRemoveLast() {
    Deque<String> mDequeue = new Deque<String>();

    mDequeue.addFirst("Something");
    assertFalse(mDequeue.isEmpty());
    mDequeue.removeLast();
    assertTrue("Should be empty after adding then removing", mDequeue.isEmpty());
  }

  @Test
  public void testIsEmptyAfterAddLastRemoveFirst() {
    Deque<String> mDequeue = new Deque<String>();

    mDequeue.addLast("Something");
    assertFalse(mDequeue.isEmpty());
    mDequeue.removeFirst();
    assertTrue("Should be empty after adding then removing", mDequeue.isEmpty());
  }

  @Test
  public void testIsEmptyAfterMultipleAddRemove() {
    Deque<String> mDequeue = new Deque<String>();

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addFirst("Something");
      assertFalse("Should not be empty after " + i + " item added", mDequeue.isEmpty());
    }

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      assertFalse("Should not be empty after " + i + " item removed", mDequeue.isEmpty());
      mDequeue.removeLast();
    }

    assertTrue("Should be empty after adding and removing " + MAX_PROBLEM_SIZE + " elements.",
        mDequeue.isEmpty());
  }

  @Test
  public void testMultipleFillAndEmpty() {
    Deque<String> mDequeue = new Deque<String>();

    for (int tries = 0; tries < 50; tries++) {
      for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
        mDequeue.addFirst(String.valueOf(i));
      }

      assertFalse(mDequeue.isEmpty());
      int i = 0;
      while (!mDequeue.isEmpty()) {
        assertEquals(String.valueOf(i), mDequeue.removeLast());
        i++;
      }

      assertTrue(mDequeue.isEmpty());

      for (int j = 0; j < MAX_PROBLEM_SIZE; j++) {
        mDequeue.addLast(String.valueOf(j));
      }

      assertFalse(mDequeue.isEmpty());

      i = 0;
      while (!mDequeue.isEmpty()) {
        assertEquals(String.valueOf(i), mDequeue.removeFirst());
        i++;
      }

      assertTrue(mDequeue.isEmpty());
    }
  }

  @Test
  public void testSize() {
    Deque<String> mDequeue = new Deque<String>();

    assertEquals(0, mDequeue.size());
    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addFirst("Something");
      assertEquals(i + 1, mDequeue.size());
    }

    for (int i = MAX_PROBLEM_SIZE; i > 0; i--) {
      assertEquals(i, mDequeue.size());
      mDequeue.removeLast();
    }

    assertEquals(0, mDequeue.size());
  }

  @Test
  public void testAddFirst() {
    Deque<String> mDequeue = new Deque<String>();

    String[] aBunchOfString = { "One", "Two", "Three", "Four" };

    for (String aString : aBunchOfString) {
      mDequeue.addFirst(aString);
    }

    for (int i = aBunchOfString.length - 1; i >= 0; i--) {
      assertEquals(aBunchOfString[i], mDequeue.removeFirst());
    }
  }

  @Test
  public void testAddLast() {
    Deque<String> mDequeue = new Deque<String>();

    String[] aBunchOfString = { "One", "Two", "Three", "Four" };

    for (String aString : aBunchOfString) {
      mDequeue.addLast(aString);
    }

    for (int i = aBunchOfString.length - 1; i >= 0; i--) {
      assertEquals(aBunchOfString[i], mDequeue.removeLast());
    }
  }

  @Test
  public void testAddNull() {
    Deque<String> mDequeue = new Deque<String>();

    try {
      mDequeue.addFirst(null);
      fail("Should have thrown a NullPointerException");
    } catch (NullPointerException npe) {
      assertTrue("Null pointer exception was thrown!", true);
    } catch (Exception e) {
      fail("Wrong exception catched." + e);
    }

    try {
      mDequeue.addLast(null);
      fail("Should have thrown a NullPointerException");
    } catch (NullPointerException npe) {
      // Continue
    } catch (Exception e) {
      fail("Wrong exception catched." + e);
    }
  }

  @Test
  public void testRemoveFirst() {
    Deque<String> mDequeue = new Deque<String>();

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addFirst(String.valueOf(i));
      assertEquals(String.valueOf(i), mDequeue.removeFirst());
    }

    mDequeue = new Deque<String>();

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addLast(String.valueOf(i));
      assertEquals(String.valueOf(i), mDequeue.removeFirst());
    }

    mDequeue = new Deque<String>();

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addLast(String.valueOf(i));
    }

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      assertEquals(String.valueOf(i), mDequeue.removeFirst());
    }

  }

  @Test
  public void testRemoveLast() {
    Deque<String> mDequeue = new Deque<String>();

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addFirst(String.valueOf(i));
      assertEquals(String.valueOf(i), mDequeue.removeLast());
    }

    mDequeue = new Deque<String>();

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addLast(String.valueOf(i));
      assertEquals(String.valueOf(i), mDequeue.removeLast());
    }

    mDequeue = new Deque<String>();

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addFirst(String.valueOf(i));
    }

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      assertEquals(String.valueOf(i), mDequeue.removeLast());
    }
  }

  @Test
  public void testRemoveEmpty() {
    Deque<String> mDequeue = new Deque<String>();

    try {
      assertTrue(mDequeue.isEmpty());
      mDequeue.removeFirst();
      fail("Expected a NoSuchElementException");
    } catch (NoSuchElementException nsee) {
      // Continue
    } catch (Exception e) {
      fail("Unexpected exception : " + e);
    }

    try {
      assertTrue(mDequeue.isEmpty());
      mDequeue.removeLast();
      fail("Expected a NoSuchElementException");
    } catch (NoSuchElementException nsee) {
      // Continue
    } catch (Exception e) {
      fail("Unexpected exception : " + e);
    }

    try {
      assertTrue(mDequeue.isEmpty());

      for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
        mDequeue.addLast(String.valueOf(i));
      }
      for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
        mDequeue.removeLast();
      }
      mDequeue.removeLast();
      fail("Expected a NoSuchElementException");
    } catch (NoSuchElementException nsee) {
      // Continue
    } catch (Exception e) {
      fail("Unexpected exception : " + e);
    }
  }

  @Test
  public void testIterator() {
    Deque<String> mDequeue = new Deque<String>();

    Iterator<String> anIterator = mDequeue.iterator();
    assertFalse(anIterator.hasNext());

    for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
      mDequeue.addFirst(String.valueOf(i));
    }

    anIterator = mDequeue.iterator();

    assertTrue(anIterator.hasNext());

    int i = MAX_PROBLEM_SIZE - 1;
    for (String aString : mDequeue) {
      assertEquals(String.valueOf(i), aString);
      i--;
    }

    anIterator = mDequeue.iterator();

    assertTrue(anIterator.hasNext());

    int j = MAX_PROBLEM_SIZE - 1;
    while (anIterator.hasNext()) {
      assertEquals(String.valueOf(j), anIterator.next());
      j--;
    }
  }

  @Test
  public void testIteratorNoMoreItem() {
    Deque<String> mDequeue = new Deque<String>();

    Iterator<String> anIterator = mDequeue.iterator();
    while (anIterator.hasNext()) {
      anIterator.next();
    }
    try {
      anIterator.next();
      fail("Should have thrown a NoSuchElementException.");
    } catch (NoSuchElementException nsee) {
      // Continue
    } catch (Exception e) {
      fail("Should have thrown a NoSuchElementException, but received" + " : " + e);
    }
  }

  @Test
  public void testIteratorRemoveNotSupported() {
    Deque<String> mDequeue = new Deque<String>();

    Iterator<String> anIterator = mDequeue.iterator();
    try {
      anIterator.remove();
      fail("Should have thrown an UnsupportedOperationException");
    } catch (UnsupportedOperationException uoe) {
      // Continue
    } catch (Exception e) {
      fail("Unexpected exception : " + e);
    }
  }

  @Test
  public void testMultipleIterator() {

    for (int i = 0; i < MAX_PROBLEM_SIZE / 1000; i++) {

      Deque<String> mDequeue = new Deque<String>();
      for (int j = 0; j < i; j++) {
        mDequeue.addLast(String.valueOf(j));
      }

      @SuppressWarnings("rawtypes")
      Iterator[] someIterators = { mDequeue.iterator(), mDequeue.iterator(), mDequeue.iterator(),
          mDequeue.iterator(), mDequeue.iterator(), mDequeue.iterator() };

      @SuppressWarnings("unchecked")
      Iterator<String>[] manyStringIterators = (Iterator[]) someIterators;

      for (int iterID = 0; iterID < manyStringIterators.length; iterID++) {
        int index = 0;
        while (manyStringIterators[iterID].hasNext()) {
          assertEquals("Iterator #" + iterID + " failed:\n", String.valueOf(index),
              manyStringIterators[iterID].next());
          index++;
        }
      }

    }
  }

  @Test
  public void testQueueBehavior() {
    Deque<String> mDequeue = new Deque<String>();

    String[] aBunchOfString = { "One", "Two", "Three", "Four" };

    for (String aString : aBunchOfString) {
      mDequeue.addFirst(aString);
    }

    for (String aString : aBunchOfString) {
      assertEquals(aString, mDequeue.removeLast());
    }
  }

  @Test
  public void testStackBehavior() {
    Deque<String> mDequeue = new Deque<String>();

    String[] aBunchOfString = { "One", "Two", "Three", "Four" };

    for (String aString : aBunchOfString) {
      mDequeue.addFirst(aString);
    }

    for (int i = aBunchOfString.length - 1; i >= 0; i--) {
      assertEquals(aBunchOfString[i], mDequeue.removeFirst());
    }
  }
}