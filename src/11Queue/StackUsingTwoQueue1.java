import java.util.LinkedList;
import java.util.Queue; 

// in this we are implementing - stack using 2 queues - push: O(n) and pop: O(1)

// STEPS:

// push(data)
// 1. Move all elements from q1 → q2
// 2. Add new element to q1
// 3. Move all elements back from q2 → q1
//
// pop()
// - Remove element from q1 (front)  [O(1)]
//
// peek()
// - Return element at q1 front  [O(1)]


public class StackUsingTwoQueue1
{
    static class Stack
    {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // isEmpty
        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        // push
        public void push(int data){
            // q1 is not empty 
            while(!q1.isEmpty())
            {
                q2.add(q1.peek());
                q1.remove();
            }
            q1.add(data);
            while(!q2.isEmpty())
            {
                q1.add(q2.peek());
                q2.remove();
            }
        }
        // pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1; 
            }
            return q1.remove();
        }
        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1; 
            }
            return q1.peek();
        }
    }
    public static void main(String[] args) 
    {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }    
}