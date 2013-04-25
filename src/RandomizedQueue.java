import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private Item[] a;
  private int N;

  public RandomizedQueue() {
    a = (Item[]) new Object[2];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void resize(int capacity) {
    assert capacity >= N;
    Item[] temp = (Item[]) new Object[capacity];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void enqueue(Item item) {
    if (item == null) {
      throw new NullPointerException();
    }
    if (N == a.length) {
      resize(2 * a.length);
    }
    a[N++] = item; // add item
  }
  
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
    return new RandomIterator();
  }

  private class RandomIterator implements Iterator<Item> {
    private Item[] array;
    private int numOfElements = N;

    public RandomIterator() {
      array = (Item[]) new Object[a.length];
      for (int i = 0; i < a.length; i++) {
        array[i] = a[i];
      }
    }

    @Override
    public boolean hasNext() {
      return numOfElements != 0;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      int random = StdRandom.uniform(numOfElements);
      Item item = array[random];
      array[random] = array[numOfElements - 1]; //for 0 based
      array[numOfElements - 1] = null; //for 0 based
      numOfElements--;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
