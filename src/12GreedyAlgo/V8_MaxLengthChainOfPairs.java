// You are given n pairs of numbers. 
// In every pair, the first number is always smaller than the second number. 
// A pair (c, d) can come after pair (a, b) if b < c.
// Find the longest chain which can be formed from a given set of pairs.

// This Q is very much similar to ACTIVITY SELECTION

import java.util.*;

// O(n logn)
public class V8_MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};
        
        // sorting
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        // last selected pair
        int lastEnd = pairs[0][1];

        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                ++chainLength;
                lastEnd = pairs[i][1];
            }
        }
        System.out.println("Max length of chain is: " + chainLength);
    }
}