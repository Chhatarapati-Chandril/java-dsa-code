public class TowerOfHanoi
{
    public static void towerOfHanoi(int n, String source, String helper, String destination)
    {
        if (n==1) {
            System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
            return;
        }

        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n-1, helper, source, destination);
    }
    public static void main(String[] args) {
        int n=3;
        towerOfHanoi(n , "A", "B", "C");
    }
}