// Given an integer array nums, find the subarray with the largest sum, and return its sum.

public class subarray_1_bruteforce                    //O(n^3)
{
    public static void subarray(int array[])
    {
        int currSum;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = 0; j < array.length; j++) {
                int end = j;
                currSum = 0;
                for(int k = start; k <= end; k++) {
                    currSum += array[k];
                }
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum subarray sum is: " + maxSum);
    }
    public static void main(String args[])
    {
        int array[]={1, -2, 6, -1, 3};
        subarray(array);
    }
}