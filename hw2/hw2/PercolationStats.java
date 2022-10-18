package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
public class PercolationStats {
    int T;
    double[] opensitefraction;
    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N<0||T<0){
            throw new IllegalArgumentException();
        }
        this.T=T;
        opensitefraction=new double[T];
        for(int i=0;i<T;i++){
            Percolation percalation=pf.make(N);
            while (!percalation.percolates()) {
                int x, y;
                do {
                    x = StdRandom.uniform(N);
                    y = StdRandom.uniform(N);
                } while (percalation.isOpen(x, y));
                percalation.open(x, y);
            }
            opensitefraction[i] = (double) percalation.numopen / (N * N);
        }
    }
    public double mean() {
        return StdStats.mean(opensitefraction);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(opensitefraction);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
