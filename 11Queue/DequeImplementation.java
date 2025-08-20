import java.util.*;

public class DequeImplementation 
{
    static class Queue
    {
        Deque<Integer> deque = new LinkedList<>();
        public boolean isEmpty()
        {
            return deque.isEmpty();
        }
        public void add(int data)
        {
            deque.addLast(data);
        }
        public int remove()
        {
            return deque.removeFirst();
        }
        public int peek()
        {
            return deque.getFirst();
        }
    }

    static class Stack
    {
        Deque<Integer> deque = new LinkedList<>();
        public boolean isEmpty()
        {
            return deque.isEmpty();
        }
        public void push(int data)
        {
            deque.addLast(data);
        }
        public int pop()
        {
            return deque.removeLast();
        }
        public int peek()
        {
            return deque.getLast();
        }
    }

    public static void main(String[] args) 
    {
        // this stack is not of JCF, this stack is of the class Stack we made above
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Implementing stack using deque");
        while(!s.isEmpty())
        {
            System.out.print(s.pop()+ " ");
        }
        System.out.println();

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Implementing queue using deque");
        while(!q.isEmpty())
        {
            System.out.print(q.remove()+ " ");
        }
        System.out.println();
    }    
}