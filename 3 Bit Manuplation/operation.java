public class operation
{
    public static void oddeven(int n)
    {
        int bitmask=1; // it is the variable which will operate with n
        if ((n & bitmask) == 0) // even
        {
            System.out.println("Even number"); 
        }
        else
        {
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n, int i)
    {
        int bitmask=1<<i;
        if ((n & bitmask) == 0)     return 0;
        else    return 1;
    }

    public static int setIthBit(int n, int i)
    {
        int bitmask=1<<i;
        return n|bitmask;
    }

    public static int clearIthBit(int n, int i)
    {
        int bitmask= ~(1<<i);
        return n & bitmask;
    }

    public static int updateithBit(int n,int i,int newbit)
    {
        n=clearIthBit(n, i);
        int bitmask=newbit<<i;
        return n|bitmask;
    }

    public static int clearIBits(int n,int i)
    {
        int bitmask=(~0)<<i;
        return n& bitmask;
    }

    public static int clearBitsInRange(int n,int i,int j)
    {
        int a=(~0)<<j+1;
        int b=(1<<i)-1;
        int bitmask=a|b;
        return (n & bitmask);
    }

    public static boolean isPowerOfTwo(int n)
    {
        return (n&(n-1))==0;
    }

    public static int countSetBit(int n)
    {
        int count=0;
        while(n>0)
        {
            if ((n&1)!=0)   count++;
            n=n>>1;
        }
        return count;
    }


    public static void main(String args[])
    {
        System.out.println(countSetBit(15));
    }
}