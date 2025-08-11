// Friends pairing problem
// Given n friends, each one can remain single or can be paired up with some other friend. 
// Each friend can be paired only once. 
// Find out the total number of ways in which friends can remain single or can be paired up.


public class Friends
{

    public static int friendsPairing(int n)
    {
        if (n==1 || n==2) {
            return n;
        }
        // single
        int fnm1 = friendsPairing(n-1);
        int fnm2 = friendsPairing(n-2);
        int pairways = (n-1)*fnm2;

        // total ways
        int totalWays = fnm1 + pairways;

        return totalWays;
    }

    public static void main(String[] args) 
    {
        System.out.println(friendsPairing(3));
    }
}
