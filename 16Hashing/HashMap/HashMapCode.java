import java.util.*;

public class HashMapCode {

    static class HashMap<K,V> {      // generic

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int n;   // n
        private int N;
        private LinkedList<Node>[] buckets;  // N

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // bi - bucket index
        // di - data index
        // hc - hashed code

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            // to make our Data structure(hash map) more optimized
            LinkedList<Node>[] oldBuck = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // add nodes in new bucket
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {   // O(lamda) -> O(1)

            int bi = hashFunction(key); // 0 to 3
            int di = searchInLL(key, bi);   // valid -1

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lamda = (double)n / N;
            if (lamda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) { // valid
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {   // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) { // valid
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {    // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) { // valid
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));

    }
}