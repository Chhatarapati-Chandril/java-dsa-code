import java.util.*;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // ------------------------------ BST-1 ------------------------------


    public static Node insert(Node root, int val){
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            // left subtree
            root.left = insert(root.left, val);
        }
        else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null)    return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public static void preorder(Node root){
        if (root == null)   return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static boolean search(Node root, int key){
        if (root == null)   return false;
        if (root.data == key)   return true;
        if (root.data > key)    return search(root.left, key);
        else    return search(root.right, key);
    }

    public static Node delete(Node root, int val){
        if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else if (root.data > val) {
            root.left = delete(root.left, val);
        }
        // (root.data == val)
        else {
            // case 1 : node with 0 child - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 : node with 1 child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // case 3 : node with 2 child
            // find inorder successor - left most node in the right sub-tree
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }


    public static void printInRange(Node root, int k1, int k2){
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        }
        else {
            printInRange(root.left, k1, k2);
        }
    }


    public static void printpath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printpath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }


    public static boolean isValid(Node root, Node min, Node max){
        if (root == null) {
            return true;
        }
        if (min != null && min.data >= root.data) {
            return false;
        }
        if (max != null && max.data <= root.data) {
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }


    public static Node mirror(Node root){
        if (root == null) {
            return null;
        }
        // recursively mirror subtrees
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        // assign swapped children to root
        root.left = right;
        root.right = left;

        return root;
    }


    // ------------------------------ BST-2 ------------------------------


    public static Node createBST(int[] arr, int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }


    public static Node createBST(ArrayList<Integer> inorder, int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balanceBST(Node root){
        // 1. inorder seq - O(n)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
         
        // 2. make BST from sorted inorder - O(n)
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }


    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBSTinBT(Node root){
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftinfo = largestBSTinBT(root.left);
        Info rightinfo = largestBSTinBT(root.right);
        int size = leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, rightinfo.max));

        if (root.data <= leftinfo.max || root.data >= rightinfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftinfo.isBST && rightinfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }



    public static void main(String[] args) {
        // int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        int[] values = {5, 1, 3, 2, 4, 7};
        // int[] values = {3, 5, 6, 8, 10, 11, 12};
        // int[] values = {60, 45, 70, 65, 80};

        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }


        inorder(root);
        System.out.println();


        // root = delete(root, 5);
        // inorder(root);
        // System.out.println();


        // if (search(root, 6)) {
        //     System.out.println("Key found");
        // } else {
        //     System.out.println("Key not found ");
        // }


        // printInRange(root, 5, 12);


        // printRoot2Leaf(root, new ArrayList<>());


        // if (isValid(root, null, null)) {
        //     System.out.println("BST is valid");
        // } else {
        //     System.out.println("BST is not valid");
        // }


        // root = mirror(root);
        // preorder(root);


        // Node newroot = createBST(values, 0, values.length - 1);
        // preorder(newroot);


        // Node newroot = balanceBST(root);
        // preorder(newroot);


        // Info info = largestBSTinBT(root);
        // System.out.println("Largest BST size in BT is: " + maxBST);


    }
}