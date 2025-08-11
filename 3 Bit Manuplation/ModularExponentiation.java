public class ModularExponentiation 
{
    public static long fastPower(long a, long b, int n) 
    {
        long res = 1; // Initialize result
        a = a % n; // Reduce the base modulo n

        while (b > 0) 
        {
            // If base becomes 1, result won't change further
            if (a == 1) 
            {
                break;
            }
            // If exponent is odd, multiply result by base and reduce modulo n
            if ((b & 1) == 1) 
            {
                res = (res * a) % n;
            }
            // Square the base and reduce modulo n
            a = (a * a) % n;
            // Divide the exponent by 2 (using bitwise right shift)
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) 
    {
        long base = 23;
        long exponent = 77;
        int modulus = 30;

        // Compute (23^77) % 30
        long result = fastPower(base, exponent, modulus);
        System.out.println(base + "^" + exponent + " mod " + modulus + " = " + result);
    }
}
/*
Key Steps:
1. Initialize result (res) to 1.
2. Reduce the base (a) modulo n to ensure it's within the modulus range.
3. Use a while loop to process the exponent (b):
    - If the base (a) becomes 1, break the loop (since 1^b = 1 for any b).
    - If the exponent (b) is odd, multiply the result (res) by the base (a) and reduce modulo n.
    - Square the base (a) and reduce modulo n.
    - Divide the exponent (b) by 2 (using bitwise right shift).
4. Return the final result.
*/