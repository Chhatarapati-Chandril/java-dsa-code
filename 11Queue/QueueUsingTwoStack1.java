import java.util.Stack;

// in this we are implementing - queue using 2 stacks - push: O(n) and pop: O(1)

public class QueueUsingTwoStack1
{
    static class Queue
    {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // isEmpty
        public boolean isEmpty()
        {
            return s1.isEmpty();
        }
        // add - O(n)
        public void add(int data)
        {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        // remove - O(1)
        public int remove()
        {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.pop();
        }
        // peek - O(1)
        public int peek()
        {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) 
    {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }    
}