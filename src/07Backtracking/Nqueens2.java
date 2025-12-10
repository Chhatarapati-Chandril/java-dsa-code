public class Nqueens2
{
    public static boolean isSafe(char board[][], int row, int col)
    {
        // vertical up
        for (int i = row-1; i >= 0 ; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left up
        for (int i = row-1, j=col-1; i >= 0 && j>=0 ; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonal right up
        for (int i = row-1, j=col+1; i >= 0 && j<board.length ; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static boolean nQueens(char board[][], int row)
    {
        // base case
        if (row==board.length) {
            count++;
            return true;
        }
        // column loop
        for (int col = 0; col < board.length; col++) 
        {
            if (isSafe(board, row, col)) 
            {
                board[row][col]='Q';
                if(nQueens(board, row+1)){
                    return true;
                } 
                board[row][col]='x';  // backtracking step 
            }
        }
        return false;
    }

    public static void printBoard(char board[][])
    {
        System.out.println("------------ chess board ------------ "); 
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }

    static int count =0; 
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        // initialize
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = 'x';
            }
        }
        if (nQueens(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        }
        else{
            System.out.println("Solution is not possible");
        }
    }
}