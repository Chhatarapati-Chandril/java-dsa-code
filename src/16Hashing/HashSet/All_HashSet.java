import java.util.*;

// Hash Set - Null included
// Linked Hash Set - Null included
// Tree Set - Null not included

public class All_HashSet {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("India");
        hs.add("China");
        hs.add("USA");
        hs.add("Russia");

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("India");
        lhs.add("China");
        lhs.add("USA");
        lhs.add("Russia");

        TreeSet<String> ts = new TreeSet<>();
        ts.add("India");
        ts.add("China");
        ts.add("USA");
        ts.add("Russia");

        System.out.print("Hash Set:          ");
        System.out.println(hs);
        System.out.print("Linked Hash Set:   ");
        System.out.println(lhs);
        System.out.print("Tree Set:          ");
        System.out.println(ts);
    }

}