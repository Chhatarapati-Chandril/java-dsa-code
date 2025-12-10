public class subarray_2_prefixsum                    //O(n^2)
{
    public static void subarray(int array[])
    {
        int currSum;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[array.length];

        prefix[0] = array[0];
        // calc prefix array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + array[i];
        }

        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = 0; j < array.length; j++) {
                int end = j;
                currSum = start==0 ? prefix[end] : prefix[end] - prefix[start-1] ;
                //  
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum subarray sum is: " + maxSum);
    }
    public static void main(String args[])
    {
        int array[]={1,2,3,4,5};
        subarray(array);
    }
}