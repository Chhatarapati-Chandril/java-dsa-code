import java.util.*;

// Hash Map - Linked List
// Linked Hash Map - Doubly Linked List
// Tree Map - Red Black Tree

public class All_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Russia", 70);

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("USA", 50);
        lhm.put("Russia", 70);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("USA", 50);
        tm.put("Russia", 70);

        System.out.print("Hash Map:          ");
        System.out.println(hm);
        System.out.print("Linked Hash Map:   ");
        System.out.println(lhm);
        System.out.print("Tree Map:          ");
        System.out.println(tm);
    }

}