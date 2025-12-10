// Current position - i,j
// Final position - m,n

// O( 2 ^ (m+n) )

public class GridWays
{
    public static int gridWays(int i, int j, int m, int n)
    {
        // base case
        if (i==n && j==m) {
            return 1;
        }
        if (i>n || j>n) {
            return 0; 
        }
        int way1 = gridWays(i+1, j, m, n);
        int way2 = gridWays(i, j+1, m, n);
        return way1+way2;
    }
    public static void main(String[] args) {
        int m=2;
        int n=2;
        System.out.println(gridWays(1, 1, m, n));
    }
}