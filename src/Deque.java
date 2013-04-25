import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int N;

  public Deque() {
    first = null;
    last = null;
    N = 0;
  } // construct an empty deque

  public boolean isEmpty() {
    return first == null;
  } // is the deque empty?

  public int size() {
    return N;
  } // return the number of items on the deque

  public void addFirst(Item item) {
    if (item == null) {
      throw new NullPointerException();
    }
    // Need to deal with corner cases such as adding the first item to the front
    // or back
    Node oldFirst = first;
    if (first != null && last != null) {
      first = new Node();
      first.item = item;
      first.next = oldFirst;
      oldFirst.prev = first;
      first.prev = null;
    } else { //exceptional case should only happen once
      first = new Node();
      first.item = item;
      first.next = null;
      first.prev = null;
      last = first;
    }
    N++;
  } // insert the item at the front push

  public void addLast(Item item) {
    if (item == null) {
      throw new NullPointerException();
    }
    Node oldLast = last;
    if (last == null && first == null) {
      last = new Node();
      last.item = item;
      last.prev = null;
      last.next = null;
      first = last;
    } else {
      last = new Node();
      last.item = item;
      oldLast.next = last;
      last.prev = oldLast;
      last.next = null;
      if (isEmpty()) {
        first = last;
      } else {
        oldLast.next = last;
      }
    }
    N++;
  } // insert the item at the end enque

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    Item item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = null; // to avoid loitering
    } else {
      first.prev = null;
    }
    N--;
    return item;

  } // delete and return the item at the front pop

  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    Item item = last.item;
    last = last.prev;
    if (last == null) {
      first = null; //to avoid loitering
    } else {
      last.next = null;
    }
    N--;
    return item;
  } // delete and return the item at the end deque

  public Iterator<Item> iterator() {
    return new DequeIterator();
  } // return an iterator over items in order from front to end
  
  private class DequeIterator implements Iterator<Item> {
    private Node currentNode = first;

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = currentNode.item;
      currentNode = currentNode.next;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  private class Node {
    private Node prev; 
    private Item item;
    private Node next;
  }
}