import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  public boolean isEmpty() {
    return first == null && last == null;
  } // is the deque empty?

  public int size() {
    return numOfItems;
  } // return the number of items on the deque

  public void addFirst(Item item) {
    if(item == null) {
      throw new NullPointerException();
    }
    //last is only null in the corner case where add first is only called
    if(last == null) {
      last = new Node();
      last.item = item;
    }
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    first.last = null;
    numOfItems++;
  }// insert the item at the front

  // code can't be identical
  public void addLast(Item item) {
    if(item == null) {
      throw new NullPointerException();
    }
    //first is only null in the corner case where add last is only called
    if(first == null) {
      first = new Node();
      first.item = item;
    }
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    last.last = oldLast;
    numOfItems++;
  } // insert the item at the end

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    
    //corner case where first and last are the same. if so then we have to remove them
    if(last.equals(first)) {
      first = first.next;
    }
    Item item = first.item; // save item to return
    first = first.next; // delete first node
    numOfItems--;
    return item;
  } // delete and return the item at the front

  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    //corner case where first and last are the same. if so then we have to null them
    if(last.equals(first)) {
      first = first.next;
    }
    Item item = last.item; // save item to return
    last = last.last; // delete first node
    numOfItems--;
    return item;
  } // delete and return the item at the end

  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      private Node currentNode = first;

      @Override
      public boolean hasNext() {
        if(currentNode != null) {
          return currentNode.next != null;          
        } else {
          return false;
        }
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
    private Node next; // the item ahead in the queue first does not have any last but it does have a next
    private Node last; // the item behind in the queue last does not have any next ut does have a last
    private Item item; // the item refrenced by this node

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if(!(obj instanceof Deque.Node))
          return false;
      Node other = (Node) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (item == null) {
        if (other.item != null)
          return false;
      } else if (!item.equals(other.item))
        return false;
      if (last == null) {
        if (other.last != null)
          return false;
      } else if (!last.equals(other.last))
        return false;
      if (next == null) {
        if (other.next != null)
          return false;
      } else if (!next.equals(other.next))
        return false;
      return true;
    }
    private Deque getOuterType() {
      return Deque.this;
    }
    
   
  }

}