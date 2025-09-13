import java.util.*;

// preorder - creating binary tree
public class BT_Basics {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int nodes[]){
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void printpreorder(Node root){    //O(n)
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            printpreorder(root.left);
            printpreorder(root.right);
        }

        public static void printinorder(Node root){    //O(n) 
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            printinorder(root.left);
            System.out.print(root.data + " ");
            printinorder(root.right);
        }

        public static void printpostorder(Node root){
            if (root == null) {
                return;
            }
            printpostorder(root.left);
            printpostorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void printlevelorder(Node root){
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty())    break; 
                    else    q.add(null);
                } else{
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null)  q.add(currNode.left);
                    if (currNode.right != null) q.add(currNode.right);
                }
            }
        }

        public static int height(Node root){
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(rightHeight, leftHeight) + 1;
        }

        public static int countNodes(Node root){
            if (root == null) {
                return 0;
            }
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount+rightCount+1;

        }
        
        public static int sumOfNodes(Node root){
            if (root == null) {
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }
    
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println("Pre order traversal");
        tree.printpreorder(root);
        System.out.println("\nIn order traversal");
        tree.printinorder(root);
        System.out.println("\nPost order traversal");
        tree.printpostorder(root);
        System.out.println("\nLevel order traversal");
        tree.printlevelorder(root);
        System.out.println("Height of Binary tree : " + tree.height(root));
        System.out.println("Count of nodes : " + tree.countNodes(root));
        System.out.println("Sum of nodes : " + tree.sumOfNodes(root));

    }
}