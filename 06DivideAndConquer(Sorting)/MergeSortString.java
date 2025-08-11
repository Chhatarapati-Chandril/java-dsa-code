public class MergeSortString
{
    public static void printArr(String arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(String arr[], int startIndex, int endIndex)
    {
        // base case
        if (startIndex>=endIndex) {
            return;
        }
        // kaam
        int mid = startIndex+ (endIndex-startIndex)/2;
        // left part
        mergeSort(arr, startIndex, mid);
        // right part
        mergeSort(arr, mid+1, endIndex);
        // merge
        merge(arr, startIndex, mid, endIndex);
    }
    public static void merge(String arr[], int startIndex, int mid, int endIndex)
    {
        String temp[] = new String[endIndex-startIndex+1];
        int i = startIndex; // iterator for left part 
        int j = mid +1;     // iterator for right part
        int k = 0;          // iterator for temp arr 

        while(i<=mid && j<=endIndex)
        {
            if (arr[i].compareTo(arr[j])<0) {
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // if all left part elements are not used
        while(i<=mid)
        {
            temp[k] = arr[i];
            k++;
            i++;
        }
        // if all right part elements are not used
        while(j<=endIndex)
        {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // copy temp arr to orginal
        for (k=0, i=startIndex; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        String arr[] = {"sun", "earth", "mars", "mercury"};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}