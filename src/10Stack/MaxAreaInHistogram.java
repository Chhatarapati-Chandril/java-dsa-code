
import java.util.Stack;

// Given an array of heights representing the histogram's bar height 
// where the width of each bar is 1
// return the area of the largest rectangle in the histogram

public class MaxAreaInHistogram 
{
    public static void maxArea(int arr[])
    {
        int maxArea = 0;
        int nextSmallerRight[] = new int[arr.length];
        int nextSmallerLeft[] = new int[arr.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0 ; i--) 
        {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }  
            if (s.isEmpty()) {
                nextSmallerRight[i] = arr.length;
            }
            else{
                nextSmallerRight[i] = s.peek();
            }
            s.push(i); 
        }
        // next smaller left
        s = new Stack<>();
        for (int i = 0; i < arr.length ; i++) 
        {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }  
            if (s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            }
            else{
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i); 
        }
        // current area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int currArea = height*width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("max area in histogram is " + maxArea);
    }
    public static void main(String[] args) 
    {
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
    }
}