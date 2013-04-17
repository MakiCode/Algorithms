import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  // use the linked list implementation

  private Node first;
  private Node last;
  private int numOfItems;

  public Deque() {
  } // construct an empty deque

  public boolean isEmpty() {
    return first == null && last == null;
  } // is the deque empty?

  public int size() {
    return numOfItems;
  } // return the number of items on the deque

  public void addFirst(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.last = oldfirst;
    first.next = null;
    numOfItems++;
  }// insert the item at the front

  // code can't be identical
  public void addLast(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = oldLast;
    last.last = null;
    numOfItems++;
  } // insert the item at the end

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    Item item = first.item; // save item to return
    first = first.last; // delete first node
    numOfItems--;
    return item;
  } // delete and return the item at the front

  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    Item item = last.item; // save item to return
    last = last.next; // delete first node
    numOfItems--;
    return item;
  } // delete and return the item at the end

  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      private Node currentNode = first;

      @Override
      public boolean hasNext() {
        return first.next != null;
      }

      @Override
      public Item next() {
        currentNode = currentNode.next;
        return currentNode.item;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  } // return an iterator over items in order from front to end

  private class Node {
    private Node next; // the item ahead in the queue
    private Node last; // the item behind in the queue
    private Item item; // the item refrenced by this node
  }

}