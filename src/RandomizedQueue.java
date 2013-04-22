import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private Item[] a; // array of items
  private int N; // number of elements on stack

  // create an empty stack
  @SuppressWarnings("unchecked")
  public RandomizedQueue() {
    a = (Item[]) new Object[2];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  // resize the underlying array holding the elements
  private void resize(int capacity) {
    assert capacity >= N;
    @SuppressWarnings("unchecked")
    Item[] temp = (Item[]) new Object[capacity];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  // push a new item onto the stack
  public void enqueue(Item item) {
    if (N == a.length) {
      resize(2 * a.length); // double size of array if necessary
    }
    a[N++] = item; // add item
  }

  // TODO delete and return a random item then switch its point with the head of
  // the list
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    int random = StdRandom.uniform(N);
    Item item = a[random];
    // switch head and random
    a[random] = a[N - 1];
    a[N - 1] = null; // to avoid loitering
    N--;
    // shrink size of array if necessary
    if (N > 0 && N == a.length / 4) {
      resize(a.length / 2);
    }
    return item;
  }

  // return a random item
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    return a[StdRandom.uniform(N)];
  }

  public Iterator<Item> iterator() {
    // the iterator returns things in a random order
    return new Iterator<Item>() {
      private Item[] array = a;
      private int N = a.length;

      @Override
      public boolean hasNext() {
        return N != 0;
      }

      @Override
      public Item next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(N);
        Item item = array[random];
        array[random] = array[N];
        array[N] = null;
        N--;
        return item;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
