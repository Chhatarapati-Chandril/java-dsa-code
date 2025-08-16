public class QueueUsingLinkedList {
    static class Node
    {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue
    {
        static Node head = null;
        static Node tail = null;

        // isEmpty
        public static boolean isEmpty()
        {
            return (head == null & tail == null);
        }

        // add - O(1)
        public static void add(int data)
        {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove - O(1)
        public static int remove()
        {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            int front = head.data;
            // single element
            if (tail == head) {
                tail = head = null;
            }
            else{
                head = head.next;
            }
            return front;
        }

        // peek - O(1)
        public static int peek()
        {
            if(isEmpty()){
                System.out.println("Empty queuue");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) 
    {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty())
        {
            System.out.println(q.peek());
            q.remove();
        }
        // it should print 1 2 3
        // but if it was stack - 3 2 1
    }
}