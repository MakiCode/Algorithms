public class PercolationStats {

  private int T;
  private double[] results;

  public PercolationStats(int N, int T) {
    if (N <= 0 || T <= 0) {
      throw new IllegalArgumentException();
    }
    this.T = T;
    results = new double[T];
    for (int k = 0; k < T; k++) {
      int numOfSitesOpen = 0;
      Percolation percolation = new Percolation(N);
      while (!percolation.percolates()) {
        int i;
        int j;
        do {
          i = StdRandom.uniform(1, N + 1);
          j = StdRandom.uniform(1, N + 1);
        } while (percolation.isOpen(i, j));
        percolation.open(i, j);
        numOfSitesOpen++;
        if (percolation.percolates()) {
          results[k] = ((double) numOfSitesOpen) / ((double) N * N);
        }
      }
    }
    // here we create the specified number of experiments and record the number
    // of N and the number of sites it took to percolate
  } // perform T independent computational experiments on an N-by-N grid

  public double mean() {
    return StdStats.mean(results);

  } // sample mean of percolation threshold

  public double stddev() {
    return StdStats.stddev(results);
  } // sample standard deviation of percolation threshold

  public double confidenceLo() {
    return mean() - (1.96 * Math.sqrt(stddev())) / (Math.sqrt(T));
  } // returns lower bound of the 95% confidence interval

  public double confidenceHi() {
    return mean() + (1.96 * Math.sqrt(stddev())) / (Math.sqrt(T));
  } // returns upper bound of the 95% confidence interval

  public static void main(String[] args) {
    PercolationStats p = new PercolationStats(StdIn.readInt(), StdIn.readInt());
    StdOut.println("mean:                      " + p.mean());
    StdOut.println("stddev:                    " + p.stddev());
    StdOut.println("95% confidence interval:   " + p.confidenceLo() + ", "
        + p.confidenceHi());
  }
}
