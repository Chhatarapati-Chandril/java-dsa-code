/*
Given n non-negative integers representing an elevation map 
where the width of each bar is 1, compute how much water it 
can trap after raining.
*/


public class trappedrain
{
    public static int rain(int height[])
    { 
        //calculate left max boundary
        int n = height.length;

        int leftmax[]=new int[n];
        leftmax[0]=height[0];
        for (int i=1;i<n;i--)
        {
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }

        //calculate right max boundary

        int rightmax[]=new int[n];
        rightmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rightmax[i]=Math.max(height[i],rightmax[i+1]);  
        }

        int trapwater=0;
        for (int i=1;i<n;i++)
        {
            int waterlevel=Math.min(leftmax[i],rightmax[i]);
            trapwater+=waterlevel-height[i];
        }

        return trapwater;
    }
    public static void main(String args[])
    {
        int height[]={4,2,0,6,3,2,5};
        rain(height);
        System.out.println("rain(height[])");
    }
}