public class Percolation {

  private boolean[][] data;
  private WeightedQuickUnionUF quickUnion1;
  private WeightedQuickUnionUF quickUnion2;
  private int N;

  public Percolation(final int N) {
    data = new boolean[N][N];
    quickUnion1 = new WeightedQuickUnionUF((N * N) + 2);
    quickUnion2 = new WeightedQuickUnionUF((N * N) + 2);
    this.N = N;
  } // create N-by-N grid, with all sites blocked

  private void connectSites(int x1, int y1, int x2, int y2) {
    if (valid(x1, y1) && valid(x2, y2)) {
      if (data[y1][x1] && data[y2][x2]) {
        quickUnion1.union(xyTo1D(x1, y1), xyTo1D(x2, y2));
        quickUnion2.union(xyTo1D(x1, y1), xyTo1D(x2, y2));
      }
    }
  }

  public void open(int i, int j) {
    int i2 = i - 1;
    int j2 = j - 1;

    if (i2 == 0) {
      quickUnion1.union(xyTo1D(j2, i2), 0);
      quickUnion2.union(xyTo1D(j2, i2), 0);
    }
    // must use original i and j because is full also auto corrects to
    // subtract 1
    // connect to bottom virtual node
    if (i2 == N - 1) {
      quickUnion1.union(xyTo1D(j2, i2), N * N + 1);
    }

    if (valid(j2, i2)) {
      data[i2][j2] = true;
    } else {
      throw new IndexOutOfBoundsException();
    }
    connectSites(j2, i2, j2 + 1, i2);
    connectSites(j2, i2, j2 - 1, i2);
    connectSites(j2, i2, j2, i2 + 1);
    connectSites(j2, i2, j2, i2 - 1);
  }

  private boolean valid(int x, int y) {
    if (y >= data.length || y < 0) {
      return false;
    }
    if (x >= data[y].length || x < 0) {
      return false;
    }
    return true;
  }

  public boolean isOpen(int i, int j) {
    if (valid(j - 1, i - 1)) {
      return data[i - 1][j - 1];
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public boolean isFull(int i, int j) {
    if (valid(j - 1, i - 1)) {
      return quickUnion2.connected(xyTo1D(j - 1, i - 1), 0);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public boolean percolates() {
    return quickUnion1.connected(0, N * N + 1);
  }

  private int xyTo1D(int x, int y) {
    if (valid(x, y)) {
      return (y * N) + x + 1;
    } else {
      return -1;
    }
  }
}
