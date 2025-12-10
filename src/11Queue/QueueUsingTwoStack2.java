
import java.util.Stack;

// in this we are implementing - queue using 2 stacks - push: O(1) and pop: O(n)

public class QueueUsingTwoStack2 
{
    static class Queue
    {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // isEmpty
        public boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }
        // add - O(1)
        public void add(int data){
            s1.push(data);
        }
        // remove - O(n)
        public int remove(){
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            while(s1.size() > 1){
                s2.push(s1.pop());
            }
            int front = s1.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return front;
        }
        // peek - O(n)
        public int peek(){
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            while(s1.size() > 1){
                s2.push(s1.pop());
            }
            int front = s1.peek();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return front;
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