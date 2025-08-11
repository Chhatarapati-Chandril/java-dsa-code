public class operators
{
    public static void main(String args[])
    {
        /*
        NOTE - 
        n - number in decimal
        then 
        the number of bits in bindary system = (log n to the base 2) + 1
        */

       
        // Bitwise AND: multiply
        int num1 = 5; // 0101 in binary
        int num2 = 3; // 0011 in binary
        int andResult = num1 & num2; // 0001 in binary = 1
        System.out.println(andResult); // Output: 1

        // Bitwise OR: add
        int val1 = 5; // 0101 in binary
        int val2 = 3; // 0011 in binary
        int orResult = val1 | val2; // 0111 in binary = 7
        System.out.println(orResult); // Output: 7

        // Bitwise XOR: 1 if bits are different, 0 if the same
        int x = 5; // 0101 in binary
        int y = 3; // 0011 in binary
        int xorResult = x ^ y; // 0110 in binary = 6
        System.out.println(xorResult); // Output: 6

        // Left Shift: Shifts bits to the left ....... FORMULA -> A*(2^b) ..... where b is number of shifts
        int shiftLeftInput = 5; // 0101 in binary
        int leftShiftResult = shiftLeftInput << 2; // 010100 in binary = 20
        System.out.println(leftShiftResult); // Output: 20

        // Right Shift: Shifts bits to the right ....... FORMULA -> A/(2^b) ..... where b is number of shifts
        int shiftRightInput = 5; // 0101 in binary
        int rightShiftResult = shiftRightInput >> 2; // 0001 in binary = 1
        System.out.println(rightShiftResult); // Output: 1

        // Bitwise Complement: Inverts all bits (1 becomes 0, and 0 becomes 1).
        int complementInput = 5; // 0101 in binary
        int complementResult = ~complementInput; // 1010 in binary = -6
        System.out.println(complementResult); // Output: -6
        
        /*
        For a number n, the result of ~n is equivalent to -(n + 1).
        
        This is called one's complement
        Left bit -  Most significant bit (0 means +ve , 1 means -ve)
        Right bit- least significant bit

        To find out one's complement of a number.....follow the steps
        
        Let we have to find 1's complement of 5
        1. Write 5 in binary -> 00000101
        2. Add 1 in this -> 00000101+1=00000110
        3. This number is 6
        4. But when we do complement of 5, the LEFT MOST BIT is 1...so it will be a negative number
        5. So the 1's complement of 5 is -6
        */
    }
}