
public class Subset {
  public static void main(String[] args) {
    int k = StdIn.readInt();
    RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
    while (!StdIn.isEmpty()) {
      randomQueue.enqueue(StdIn.readString());
    }
    for (int i = 0; i < k; i++) {
      StdOut.println(randomQueue.dequeue());
    }
  }
}
