import java.util.*;
import java.util.Map.Entry;

public class HM_basics {
    public static void main(String[] args) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();

        // insert - O(1)
        hm.put("India", 100);
        hm.put("China", 120);
        hm.put("Russia", 80);
        hm.put("USA", 50);

        System.out.println(hm);

        // Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k + ", value = " + hm.get(k)); 
        }

        Set<Entry<String, Integer>> keyvalue = hm.entrySet();
        System.out.println(keyvalue);


        // // get - O(1)
        // int populationOfIndia = hm.get("India");
        // System.out.println(populationOfIndia);

        // // containsKey - O(1)
        // System.out.println(hm.containsKey("India"));

        // // Remove
        // hm.remove("China");
        // System.out.println(hm);

        // // size
        // System.out.println(hm.size());

        // // isEmpty
        // System.out.println(hm.isEmpty());
        // hm.clear();
        // System.out.println(hm.isEmpty());



    }
}