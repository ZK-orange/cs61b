package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    int N;
    boolean[][] flagopen;
    int topsite;
    int bottomsite;
    int numopen=0;
    WeightedQuickUnionUF site;
    WeightedQuickUnionUF site2;
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.N=N;
        topsite=N*N;
        bottomsite=N*N+1;
        site=new WeightedQuickUnionUF(N*N+2);
        for(int i=0;i<N;i++){
            site.union(topsite,xytop(0,i));
        }
        for(int i=0;i<N;i++){
            site.union(bottomsite,xytop(N-1,i));
        }
        site2=new WeightedQuickUnionUF(N*N+1);
        for(int i=0;i<N;i++){
            site2.union(topsite,xytop(0,i));
        }
        boolean[][] flagopen=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                flagopen[i][j]=false;
            }
        }
    }// create N-by-N grid, with all sites initially blocked
    public int xytop(int row,int col){
        return row*N+col;
    }
    public void open(int row, int col){
        validrange(row,col);
        if(flagopen[row][col]){
            return;
        }
        site.union(topsite,row*N+col);
        site2.union(topsite,row*N+col);
        flagopen[row][col]=true;
        numopen+=1;
    }       // open the site (row, col) if it is not open already
    private void validrange(int row,int col){
        if(row<0||row>=N||col<0||col>=N){
            throw new IndexOutOfBoundsException();
        }
    }
    public boolean isOpen(int row, int col){
        validrange(row, col);
        return flagopen[row][col];
    }  // is the site (row, col) open?
    public boolean isFull(int row, int col){
        validrange(row, col);

        if (!isOpen(row, col)) {
            return false;
        }
        return site2.connected(xytop(row, col), topsite);
    }  // is the site (row, col) full?
    public int numberOfOpenSites() {
        return numopen;
    }          // number of open sites
    public boolean percolates(){
        return site.connected(topsite,bottomsite);
    }              // does the system percolate?
    public static void main(String[] args){

    }   // use for unit testing (not required)
    private void unionOpenNeighbor(int row, int col, int newRow, int newCol) {
        if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N) {
            return;
        }
        if (flagopen[newRow][newCol]) {
            site.union(xytop(row, col), xytop(newRow, newCol));
            site2.union(xytop(row, col), xytop(newRow, newCol));
        }
    }
}
