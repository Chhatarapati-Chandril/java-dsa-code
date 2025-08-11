public class MergeSort
{
    public static void printArr(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int arr[], int startIndex, int EndIndex)
    {
        // base case
        if (startIndex>=EndIndex) {
            return;
        }
        // kaam
        int mid = startIndex+ (EndIndex-startIndex)/2;
        // left part
        mergeSort(arr, startIndex, mid);
        // right part
        mergeSort(arr, mid+1, EndIndex);
        // merge
        merge(arr, startIndex, mid, EndIndex);
    }
    public static void merge(int arr[], int startIndex, int mid, int EndIndex)
    {
        int temp[] = new int[EndIndex-startIndex+1];
        int i = startIndex; // iterator for left part 
        int j = mid +1;     // iterator for right part
        int k = 0;          // iterator for temp arr 

        while(i<=mid && j<=EndIndex)
        {
            if (arr[i]<arr[j]) {
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
        while(j<=EndIndex)
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
        int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}