public class upper_to_lower_case {

    public static void main(String[] args) {

        // Convert uppercase character to lowercase
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char)(ch | 32));
        }
        // prints abcdefghijklmnopqrstuvwxyz
    }
}

// Convert uppercase to lowercase using bitwise OR with space (' ')
// Uppercase letters (A-Z) have ASCII values 65-90; lowercase (a-z) have values 97-122
// The difference is 32, which is the ASCII value of space (' ')
// Bitwise OR with 32 flips the 6th bit, converting uppercase to lowercase
// Example: 'A' (65) | ' ' (32) → 'a' (97)