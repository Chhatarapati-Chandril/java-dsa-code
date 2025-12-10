public class PrefixProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 0;

        }
    }

    public static Node root = new Node();


    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr.children[idx].freq++;  // always increment because this node is part of one more word
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


    public static String findPrefix(String word) {
        Node curr = root;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            sb.append(word.charAt(i));

            if (curr.children[idx].freq == 1) {
                return sb.toString();   // this prefix is unique
            }

            curr = curr.children[idx];
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};

        for (String w : arr) insert(w);

        for (String w : arr) {
            System.out.println(findPrefix(w));
        }
    }
}