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
        int idx = -1;

        public Node buildTree(int nodes[]){
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // ------------------------------ BT-1 ------------------------------


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
    

        // ------------------------------ BT-2 ------------------------------


        // diameter - number of nodes in the longest path between 2 nodes
        
        //O(n^2) - brute force
        public static int diameter(Node root){  
            if (root == null) {
                return 0;
            }
            int lDiameter = diameter(root.left);
            int lHeight = height(root.left);
            int rDiameter = diameter(root.right);
            int rHeight = height(root.right);

            int selfDiameter = lHeight + rHeight + 1;

            return Math.max(selfDiameter, Math.max(lDiameter, rDiameter));
        }


        static class Info{
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }

        //O(n) - optimized
        public static Info diameter2(Node root){
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam ), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);
        }


        public static boolean isIdentical(Node node, Node subroot){
            if (node == null && subroot == null) {
                return true;
            } else if (node == null || subroot == null || node.data != subroot.data) {
                return false;
            }

            if (!isIdentical(node.left, subroot.left))  return false;
            if (!isIdentical(node.right, subroot.right))    return false;

            return true;
        }

        public static boolean isSubtree(Node root, Node subroot){
            if (root == null) {
                return false;
            }
            if (root.data == subroot.data) {
                if (isIdentical(root, subroot)) {
                    return true;
                }
            }
            // boolean leftAns = isSubtree(root.left, subroot);
            // boolean rightAns = isSubtree(root.right, subroot);

            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot); 
        }

    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int subnodes[] = {2, 4, -1, -1, 5, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // ----------- subtree -----------

        BinaryTree subtree = new BinaryTree();
        Node subroot = subtree.buildTree(subnodes);

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
        System.out.println("Diameter of BT : " + tree.diameter2(root).diam);
        System.out.println("Subree: " + tree.isSubtree(root, subroot));

    }
}