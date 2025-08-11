public class SortedRotatedArray
{
    public static int search(int arr[], int tar, int startIndex, int EndIndex)
    {
        if(startIndex>EndIndex){
            return -1;
        }
        // kaam

        int mid = startIndex + (EndIndex-startIndex)/2;

        // cases 1 
        if(arr[mid]==tar){
            return mid;
        }

        // case 2 - mid on L1
        if(arr[startIndex] <= arr[mid]){
            // case a : left
            if (tar >= arr[startIndex] && tar<=arr[mid]) {
                return search(arr, tar, startIndex, mid-1);
            }
            // case b : right
            else{
                return search(arr, tar, mid+1, EndIndex);
            }
        }

        // case 3 - mid on L2
        else{
            // case c : right
            if (tar>=arr[mid] && tar <= arr[EndIndex]) {
                return search(arr, tar, mid+1, EndIndex);
            }
            // case d : left
            else{
                return search(arr, tar, startIndex, mid-1);
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 1;
        int targetIndex = search(arr, target, 0, arr.length-1);
        System.out.println(targetIndex);
    }
}