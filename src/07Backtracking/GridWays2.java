// using combinatorics (nCr),
// where only right and down moves are allowed — optimized with O(n + m) time complexity


public class GridWays2 {

    public static long factorial(int num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static long gridWays(int i, int j, int m, int n) {
        int rightMoves = m - j;
        int downMoves = n - i;
        int totalMoves = rightMoves + downMoves;

        return factorial(totalMoves) / (factorial(rightMoves) * factorial(downMoves));
    }

    public static void main(String[] args) {
        int m = 3, n = 3; 
        System.out.println(gridWays(1, 1, m, n)); 
    }
}
