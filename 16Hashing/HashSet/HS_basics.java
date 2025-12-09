import java.util.*;

public class HS_basics {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        Iterator it = cities.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        for (String city : cities) {
            System.out.println(city);
        }

    }
}