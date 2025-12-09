
import java.util.HashSet;

public class Q_countDistinctElem {
    public static void main(String[] args) {
        int[] num = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> set = new HashSet<>();

        for (int n : num) {
            set.add(n);
        }

        System.out.println("Number of distinct elements: " + set.size());
    }
}