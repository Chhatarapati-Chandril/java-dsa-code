import java.util.LinkedList;
import java.util.Queue;

// in this we are implementing - stack using 2 queues - push: O(1) and pop: O(n)

// STEPS:

// push(data)
// - Add element directly to q1 [O(1)]

// pop()
// 1. Move elements from q1 → q2 until only 1 element is left in q1
// 2. The last element in q1 is the "top" → remove and return it
// 3. Swap q1 and q2 (so q1 again becomes the main queue)

// peek()
// 1. Move elements from q1 → q2 until only 1 element is left in q1
// 2. The last element in q1 is the "top" → save it
// 3. Move this last element to q2 as well (so it isn’t lost)
// 4. Swap q1 and q2
// 5. Return the saved element


public class StackUsingTwoQueue2 
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
            // q2 is not empty
            if (!q2.isEmpty()) {
                q2.add(data);
            }
            // q2 is empty
            else{
                q1.add(data);
            }
        }
        // pop
        public int pop(){
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            }
            // case 2
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }
        // peek
        public int peek(){
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }
            // case 2
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
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