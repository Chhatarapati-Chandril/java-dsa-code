// to find power x^n

public class CalcPower
{
    public static int power1(int x, int n)
    {
        if(n==0) {
            return 1;
        }
        return x * power1(x, n-1);
    }

    public static int power2(int x, int n)
    {
        if (n==0) {
            return 1;
        }
        return 1;
    }

    public static void main(String[] args) 
    {
        System.out.println(power1(2, 10));
    }
}
