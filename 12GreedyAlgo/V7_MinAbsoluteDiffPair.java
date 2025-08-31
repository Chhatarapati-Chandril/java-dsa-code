// Given 2 arrays A and B of equal length 'n'.
// Pair each element of arr A with elements of arr B , 
// such that sum 'S' of absolute differences of all the pairs is Minimum

import java.util.*;

// O(n logn)
public class V7_MinAbsoluteDiffPair {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 1, 4};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Min absolute difference: " + minDiff);
    }
}