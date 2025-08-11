public class QuickSort
{
    public static void printArr(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int startIndex, int EndIndex)
    {
        if (startIndex>=EndIndex) {
            return;
        }
        // pivot - first element
        int pivotIndex = partition(arr, startIndex, EndIndex);
        quickSort(arr, startIndex, pivotIndex-1);   //left
        quickSort(arr, pivotIndex+1, EndIndex);     //right
    } 
    public static int partition(int arr[], int startIndex, int EndIndex)
    {
        int pivot = arr[startIndex];
        int i = startIndex;  //to make space for elements smaller than pivot
        int j = EndIndex;

        while (i<j) { 
            // from left, find the element which is greator than the pivot
            while(arr[i]<=pivot && i<=EndIndex-1){
                i++;
            }
            // from right, find the element which is smaller than the pivot
            while(arr[j]>pivot && j>=startIndex+1){
                j--;
            }
            // 
            if(i<j){
                // swap
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }

        // swap the pivot (to position it to the correct place)
        arr[startIndex] = arr[j];
        arr[j] = pivot;

        return j;
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}