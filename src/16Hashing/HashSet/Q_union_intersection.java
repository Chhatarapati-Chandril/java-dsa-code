
import java.util.HashSet;

public class Q_union_intersection {
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        // union
        HashSet<Integer> set = new HashSet<>();

        for (int arr : arr1) {
            set.add(arr);
        }
        for (int arr : arr2) {
            set.add(arr);
        }
        System.out.println("union: " + set.size());

        // intersection
        set.clear();

        for (int arr : arr1) {
            set.add(arr);
        }
        int count = 0;
        for (int arr : arr2) {
            if (set.contains(arr)) {
                count++;
                set.remove(arr);
            }
        }
        System.out.println("intersection: " + set.size());
    }
}