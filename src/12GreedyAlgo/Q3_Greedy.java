// Lexiographically smallest string of length N and sum K

// we have 2 int N and K
// the task is to print the lexiographically the smallest string of length N (in lower-case)
// such that the sum of characters of the string equals to K where a=1, b=2, ... z=26

public class Q3_Greedy {
    public static void main(String[] args) {
        int n = 5;
        int k = 42;

        // step 1: start with all a
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = 'a';
        }

        // Step 2: adjust from right
        int remaining = k - n;
        int lastIndex = n - 1;

        while (remaining > 0 && lastIndex >= 0) {
            int add = Math.min(25, remaining); // max we can add to current position
            result[lastIndex] = (char)(result[lastIndex] + add);
            remaining -= add;
            lastIndex--;
        }

        // Step 3: print result
        System.out.println(new String(result)); // aaamz
    }
}