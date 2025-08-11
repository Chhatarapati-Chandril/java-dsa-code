// Input:  arr = [2, 4, 1, 3, 5]
// Output: 3

// Explanation:
// Inversions are:
// (2, 1), (4, 1), (4, 3)


public class InversionCount {

    static int inversionCount = 0; // Global variable to track inversions

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5, 2};

        System.out.println("Original array:");
        printArr(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        printArr(arr);

        System.out.println("\nTotal Inversions: " + inversionCount);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        // Sort left half
        mergeSort(arr, start, mid);
        // Sort right half
        mergeSort(arr, mid + 1, end);

        // Merge both and count inversions
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;     // Left part pointer
        int j = mid + 1;   // Right part pointer
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i] > arr[j] means (mid - i + 1) inversions
                temp[k++] = arr[j++];
                inversionCount += (mid - i + 1);
            }
        }

        // Copy remaining elements from left
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // copy temp arr to orginal
        for (k=0, i=start; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
