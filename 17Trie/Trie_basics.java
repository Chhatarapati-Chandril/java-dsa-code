public class Trie_basics {
    static class Node {
        Node[] childern = new Node[26];
        boolean eow = false;
        // eow -> end of word

        Node() {
            for (int i = 0; i < 26; i++) {
                childern[i] = null;
            }
        }
    }


    public static Node root = new Node();


    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            }
            curr = curr.childern[idx];
        }
        curr.eow = true;
    }

    
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.childern[idx] == null) {
                return false;
            }
            curr = curr.childern[idx];
        }
        return curr.eow;
    }


    public static boolean wordBreak(String key) {   // O(L)
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if( search( key.substring(0, i) ) && wordBreak( key.substring(i) ) ) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // word break problem
        String[] arr = {"i", "like", "sam", "samsung", "ice", "mobile"};
        for (String x : arr) {
            insert(x);
        }

        String key = "ilikesam";

        System.out.println("Word break of key -> " + key + " : " + wordBreak(key));

    }
}