public class LinkedList
{

    public static class Node 
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
   
    public static Node head;
    public static Node tail;
    public static int size;

    public void print()
    {
        if (head == null) 
        {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while (temp != null) 
        { 
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }


    public void addFirst(int data)
    {
        // step 1: create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) 
        {
            head = tail = newNode;
            return;
        }
        // step 2: newNode next -> head
        newNode.next = head;
        // step 3: 
        head = newNode;
    }

    public void addLast(int data)
    {
        // step 1
        Node newNode = new Node(data);
        size++;
        if (head == null) 
        {
            head = tail = newNode;
            return;
        }
        // step 2
        tail.next = newNode;
        // step 3
        tail = newNode;
    }

    public void add(int idx, int data)
    {
        if (idx==0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx-1)
        {
            temp = temp.next;
            i++;
        }
        // i = idx-1
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst()
    {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast()
    {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //  prev : index = size - 2
        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int iterativeSearch(int key) //O(n)
    {
        Node temp = head;
        int index = 0;
        while(temp != null)
        {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
    
    public int helperRecursiveSearch(Node head, int key) //O(n)
    {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = helperRecursiveSearch(head.next, key);
        if (index == -1) {
            return -1;
        }
        return index+1;
    }

    public int recursiveSearch(int key)
    {
        return helperRecursiveSearch(head, key);
    }

    public void reverse() //O(n)
    {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; 
    }

    public void delteNthFromEnd(int n)
    {
        // calc size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++; 
        }
        // remove head from end
        if (n == sz) {
            head = head.next;
        }
        // sz-n
        int idx = 1;
        int idxToFind = sz - n;
        Node prev = head;
        while(idx < idxToFind){
            prev = prev.next;
            idx++;
        }
        prev.next = prev.next.next;
    }

    // Slow-fast approach
    public Node findMid(Node head)
    {
        Node slow =head;
        Node fast =head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;    // slow is middle node
    }

    public boolean checkPalindrome()
    {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1: find mid
        Node midNode = findMid(head);

        // step 2: reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        

        // step 3: compare 1st half and 2nd half 
        while(right != null){
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // ------------------------------ Floyd's cycle finding algorithm ------------------------------
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                return true;    //cycle exist
            }
        }
        return false;   //cycle does not exist
    }

    public static void removeCycle()
    {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle - last.next -> null
        prev.next = null;
    }

    //  --------------------------------- Merge sort ---------------------------------
    // O(n*logn)

    public Node getMid(Node head)
    {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        // mid node
    }

    public Node merge(Node head1, Node head2)
    {
        // dummy node
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null)
        {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        // return the LL after dummy node(-1)
        return mergedLL.next;
    }

    public Node mergeSort(Node head)
    {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // left and right part ke liye call kro merge sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    // ------------------------------------------- zig zag -------------------------------------------

    public void zigZag()
    {
        // find mid
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        Node lefthead = head;
        Node righthead = prev;
        Node nextL, nextR;

        // alt merge - zig zag merge
        while(lefthead != null & righthead != null)
        {
            // zig zag 
            nextL = lefthead.next;
            lefthead.next = righthead;
            nextR = righthead.next;
            righthead.next = nextL;
            // update
            lefthead = nextL;
            righthead = nextR;
        }
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();

        // ll.zigZag(); 
        
        // ll.head = ll.mergeSort(ll.head);
        
        // ll.print();
        

// -------------------- check wheter LL is cyclic or not , If cyclic then remove cycle --------------------

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // 1->2->3->2

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());


// --------------------------------------------- basic ---------------------------------------------
        // LinkedList ll = new LinkedList();

        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.add(2, 3);

        // ll.print();
        // System.out.println("Size: "+LinkedList.size);
        
        // ll.removeFirst();
        // ll.print();
        // System.out.println("Size: "+LinkedList.size);

        // ll.removeLast();
        // ll.print();
        // System.out.println("Size: "+LinkedList.size);

        // System.out.println(ll.iterativeSearch(3));
        // System.out.println(ll.iterativeSearch(50));
        // System.out.println(ll.recursiveSearch(3));
        // System.out.println(ll.recursiveSearch(50));

        // ll.reverse();
        // ll.print();

        // ll.delteNthFromEnd(3);
        // ll.print();

        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.print();
        // System.out.println(ll.checkPalindrome());
        

    }
}