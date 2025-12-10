// https://www.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1

// counting set bits from 1 to n

// Example -> n = 4
// now calc set bits in 1, 2, 3, 4

public class Q1_CountSetBits
 {

    public static int countSetBits(int n) {
        // Base case
        if (n == 0) return 0;

        // Find highest power of 2 (<= n)
        int highestPower = highestPowerOf2(n);

        // Count of set bits in numbers from 1 to (2^highestPower - 1)
        int bitsUpToPower = highestPower * (1 << (highestPower - 1));

        // Count of MSB (leftmost set bit) from 2^highestPower to n
        int leftBitCount = n - (1 << highestPower) + 1;

        // Remaining numbers below 2^highestPower
        int remainder = n - (1 << highestPower);

        // Recursive call for remainder
        return bitsUpToPower + leftBitCount + countSetBits(remainder);
    }

    // Helper function to find highest power of 2 <= n
    private static int highestPowerOf2(int n) {
        int power = 0;
        while ((1 << power) <= n) {
            power++;
        }
        return power - 1;
    }

    // Driver code to test
    public static void main(String[] args) {
        int n = 11;
        System.out.println("Count of set bits from 1 to " + n + " is: " + countSetBits(n));

        n = 17;
        System.out.println("Count of set bits from 1 to " + n + " is: " + countSetBits(n));
    }
}
