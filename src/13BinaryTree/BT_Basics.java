import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
            Queue<Node> q = new LinkedList<>();
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


        static class Info_top{
            Node node;
            int horizonatalDist;

            public Info_top(Node node, int horizonatalDist){
                this.node = node;
                this.horizonatalDist = horizonatalDist;   
            }
        }

        public static void topview(Node root){
            // level order
            Queue<Info_top> q = new LinkedList<>();
            // store horizontal distance
            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0, max = 0;

            q.add(new Info_top(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                Info_top curr = q.remove();

                if(curr == null){
                    if(q.isEmpty()) break;
                    else q.add(null);
                }
                else {
                    if(!map.containsKey(curr.horizonatalDist)) {
                        map.put(curr.horizonatalDist, curr.node);
                    }

                    if(curr.node.left != null){
                        q.add(new Info_top(curr.node.left, curr.horizonatalDist - 1));
                        min = Math.min(min, curr.horizonatalDist - 1);
                    }

                    if(curr.node.right != null){
                        q.add(new Info_top(curr.node.right, curr.horizonatalDist + 1));
                        max = Math.max(max, curr.horizonatalDist + 1);
                    }
                }

            }
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }


        public static void leftView(Node root) {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    Node curr = q.remove();

                    if (i == 0) System.out.print(curr.data + " ");  // leftmost

                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
            }
        }


        // ------------------------------ BT-3 ------------------------------


        // using to level order approach
        public static void kth_level(Node root, int k) {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            int level = 1; // root is level 1

            while (!q.isEmpty()) {
                Node curr = q.remove();

                if (curr == null) {
                    level++;
                    if (q.isEmpty()) break;
                    q.add(null);
                }
                else {
                    if (level == k)     System.out.print(curr.data + " ");

                    if (curr.left != null)      q.add(curr.left);
                    if (curr.right != null)     q.add(curr.right);
                }
            }
        }


        public static void kth_level2(Node root, int level, int k){
            if(root == null) {
                return;
            }
            if(level == k) {
                System.out.print(root.data + " ");
                return;
            }
            kth_level2(root.left, level+1, k);
            kth_level2(root.right, level+1, k);

        }


        public static boolean getpath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
            path.add(root);
            if (root.data == n) {
                return true;
            }
            boolean foundleft = getpath(root.left, n, path);
            boolean foundright = getpath(root.right, n, path);
            if(foundleft || foundright){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }

        // lowest common ancestor
        // 1. find the path between root and nodes
        // 2. find lowest common ancestor
        public static Node lca(Node root, int n1, int n2){

            // 1st step
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getpath(root, n1, path1);
            getpath(root, n2, path2);

            // 2nd step
            int i = 0;
            for (; i < Math.min(path1.size(), path2.size()); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }
            // last equal node -> (i-1)th node
            Node lca = path1.get(i-1);
            return lca;
        }


        public static Node lca2(Node root, int n1, int n2){

            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            if (leftLca == null) {
                return rightLca;
            }
            if (rightLca == null) {
                return leftLca;
            }
            return root;
        }


        public static int lcaDist(Node root, int n) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if (leftDist  == -1 && rightDist == -1) {
                return -1;
            } 
            else if(leftDist == -1){
                return rightDist + 1;
            }
            else {
                return leftDist + 1;
            }
        }

        public static int minDist(Node root, int n1, int n2) {
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca, n1);
            int dist2 = lcaDist(lca, n2);

            return dist1 + dist2;
        }


        // k - distance of node
        public static int kth_ancestor_of_a_node(Node root, int n, int k){
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDist = kth_ancestor_of_a_node(root.left, n, k);
            int rightDist = kth_ancestor_of_a_node(root.right, n, k);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            }

            int max = Math.max(leftDist, rightDist);
            if (max + 1 == k) {
                System.out.println(root.data);
            }
            return max + 1;

        }



        public static int sumTree(Node root){
            if (root == null) return 0;

            // Step 1: get subtree sums
            int leftSum = sumTree(root.left);
            int rightSum = sumTree(root.right);

            // Step 2: store original value
            int oldVal = root.data;

            // Step 3: update node value to sum of subtree
            root.data = leftSum + rightSum;

            // Step 4: return original value + subtree sum (total sum)
            return oldVal + root.data;
        }


    }

    public static void main(String[] args) {

/*
            1
         /     \
        2       3
      /   \       \
     4     5       6
*/


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

        System.out.print("Top view: ");
        tree.topview(root);
        System.out.println();

        System.out.print("Kth level elements: ");
        tree.kth_level(root, 3);
        System.out.println();

        System.out.print("Kth level elements: ");
        tree.kth_level2(root, 1, 3);
        System.out.println();

        int n1 = 4, n2 = 5;
        System.out.println("Lowest common ancestor1: " + tree.lca(root, n1, n2).data);
        System.out.println("Lowest common ancestor2: " + tree.lca2(root, n1, n2).data);

        int n = 4, k = 2;
        System.out.print("kth ancestor of a node: ");
        tree.kth_ancestor_of_a_node(root, n, k);

        // tree.sumTree(root);
        tree.printlevelorder(root);
        
    }
}