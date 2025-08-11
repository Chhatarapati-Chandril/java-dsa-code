public class fastExpo
{
    public static int fastexpo(int a,int n)
    {
        //base - a 
        //exponent - n
        int ans=1;
        while (n>0)
        {
            if ((n&1) != 0)     //checking the right most term of binary
            {
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String args[])
    {
        System.out.println(fastexpo(3, 5));
    }
}
/*
EXPLANATION

let we have to caclculate (a^5)

1. Write exponent in its binary form - (a^101)
2. now the 1(a^4) , 0(a^2) , 1(a^1)
3. three terms are created and we have to multipply these terms in "ans"
4. But in case of zero the "ans" will become zero, so in that case we will multiply with 1 or we can say we will ignore the 0 case

In this method, 
the loop will run [(log n to base 2) + 1] times
So, its time complexity is very less
*/