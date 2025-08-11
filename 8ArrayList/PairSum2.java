// SORTED ROTATED array list -- we will use MODULAR ARITHMETIC
// we have to check whether the target sum is possible from any 2 elements from the array list

import java.util.ArrayList;

public class PairSum2 {
    public static boolean pairsum(ArrayList<Integer> list, int target){
        // find the pivot / breaking point
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i+1)) {
                // breaking point
                bp=i;
                break;
            }
        }

        int lp = bp+1;
        int rp = bp;

        while(lp != rp){
            // case 1
            if (list.get(rp) + list.get(lp) == target) {
                return true;
            }
            // case 2
            if (list.get(rp) + list.get(lp) < target) {
                lp = (lp+1) % n;
            }
            else{
                rp = (n+rp-1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // sroted and roated list
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairsum(list, target));
    }
}