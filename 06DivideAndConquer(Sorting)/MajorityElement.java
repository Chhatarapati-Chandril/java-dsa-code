// Given an array nums[], return the element that appears more than ⌊n / 2⌋ times
// You may assume that a majority element always exists.


public class MajorityElement {

    public static int findMajorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        // First pass: find a candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num; // assign new candidate
            }

            if (num == candidate) {
                count++; // same as candidate, increment count
            } else {
                count--; // different, cancel out
            }
        }

        // No need to verify, because problem guarantees majority exists
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int result = findMajorityElement(nums);

        System.out.println("Majority Element: " + result);
    }
}
