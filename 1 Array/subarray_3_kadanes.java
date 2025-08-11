public class subarray_3_kadanes                       //O(n)
{
    public static void kadanes(int array[])
    {
        int maxsum=array[0];
        int currsum=array[0];
        for (int i=1;i<array.length;i++)
        {
            currsum = Math.max(array[i], currsum + array[i]);
            maxsum = Math.max(maxsum,currsum);
        }
        System.out.println("max sub array sum is : "+maxsum);
    }
    public static void main(String args[])
    {
        int array[]={-2,-3,4,-1,-2,1,5,-3};
        // int array[]={-1,-2,-3,-4,-5}; // Example with all negative numbers
        kadanes(array);
    }
}