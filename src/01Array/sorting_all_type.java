public class sorting_all_type
{
    // Compares adjacent elements and swaps if they are in the wrong order.
    // Largest element "bubbles up" to the end in each pass.
    // Repeats for n-1 passes.

    public static void bubblesort(int arr[])   
    {
        for (int turn=0;turn<=arr.length-2;turn++)
        {
            for (int j=0;j<=arr.length-2-turn;j++)
            {
                if (arr[j]>arr[j+1])
                {
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    // Selects the minimum element from the unsorted part and places it at the beginning.
    //select min from n elements and swap - 1st,n-1 and swap - 2nd

    public static void selectionsort(int arr[]) 
    {
        for (int i=0;i<=arr.length-2;i++)
        {
            int min=i;
            for (int j=i+1;j<=arr.length-1;j++)
            {
                if (arr[j]<arr[min])    min=j;
            }
            //swap
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }

    // let 1st element is sorted and other are inserted in sorted part
    // Builds the sorted array one item at a time.
    // Picks next element and inserts it into its correct position in the sorted part.
    // example - card game

    public static void insertionsort(int arr[]) 
    {
        for (int i=1;i<arr.length;i++)
        {
            int curr=arr[i];
            int j=i;
            //finding out corect postion to insert
            while(j>=1 && curr<arr[j-1])
            {
                arr[j]=arr[j-1];
                j--;                // to check with more previous element
            }
            //insertion
            arr[j]=curr;
        }
    }

    // Counting Sort works by counting the number of occurrences of each element.
    // It's fast for small ranges of integers but doesn't work for negative numbers directly.
    // It's a non-comparison-based and stable sorting algorithm.

    public static void countingsort(int arr[])
    {
        int largest=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
        {
            largest=Math.max(largest,arr[i]);
        }
        int count[]=new int[largest+1];
        for (int i=0;i<arr.length;i++)
        {
            count[arr[i]]++;
        }
        //sort
        int j=0;
        for (int i=0;i<count.length;i++)
        {
            while(count[i]>0)
            {
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }




    public static void printarr(int arr[])
    {
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[])
    {
        int arr[]={5,4,1,3,2};
        insertionsort(arr);
        printarr(arr);
    }
}