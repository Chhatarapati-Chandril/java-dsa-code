// Tilling problem
// give a "2*n" board and tiles of size "2*1",
// count the number of ways to tile the board using the "2*1" tiles.
// (A tile can be place either horizontally or vertically)



public class tile
{
    public static int tile(int n)
    {
        if (n==0 || n==1)
        {
            return 1;
        }
        // vertical
        int fnm1 = tile(n-1);

        // horizontal
        int fnm2 = tile(n-2);

        int total = fnm1+fnm2;

        return total;
    }

    public static void main(String[] args) 
    {
        System.out.println(tile(10));
    }
}