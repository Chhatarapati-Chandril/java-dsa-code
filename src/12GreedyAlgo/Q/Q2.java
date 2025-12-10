// Kth largest odd number in a given range

// we have 2 numbers L and R, indicating the range of integers from L to R (both inlcusive)
// and a number K, the task is to find Kth largest odd number.
// if k > (num of odd num in that range L to R), then return 0

public class Q2 {

    public static int kthodd(int[] range, int k){
        int l = range[0];
        int r = range[1];
        // k is not natural num
        if(k <= 0) return 0;

        // count number of odds in the range
        int count;
        // both ends are odd 
        if ((l & 1) == 1 && (r & 1) == 1) {
            count = (r - l) / 2 + 1;
        } 
        // both ends are not odd
        else {
            count = (r - l + 1) / 2;
        }

        if (k > count) return 0;

        // find kth largest odd
        int largestOdd = (r % 2 == 1) ? r : r - 1;
        return largestOdd - 2 * (k - 1);
    }

    public static void main(String[] args) {
        int[] range = {-10, 10};
        System.out.println(kthodd(range, 1)); // 9
        System.out.println(kthodd(range, 2)); // 7
        System.out.println(kthodd(range, 10)); // -9
        System.out.println(kthodd(range, 11)); // 0 (not enough odds)
    }
}