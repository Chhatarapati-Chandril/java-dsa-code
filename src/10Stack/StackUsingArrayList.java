import java.util.ArrayList;

public class StackUsingArrayList 
{
    static class Stack
    {
        static ArrayList<Integer> list = new ArrayList<>();
        
        // isEmpty
        public static boolean  isEmpty()
        {
            return list.isEmpty();
        }
        // push
        public static void push(int data)
        {
            list.add(data);
        }
        // pop
        public static int pop()
        {
            if (isEmpty()) {
                return -1;
            }
            int top = list.getLast();
            list.removeLast();
            return top;
        }
        // peek
        public static int peek()
        {
            if (isEmpty()) {
                return -1;
            }
            return list.getLast();
        }
    }
    public static void main(String[] args) 
    {
        Stack s = new Stack();

        Stack.push(1);
        Stack.push(2);
        Stack.push(3);

        while(!Stack.isEmpty()){
            System.out.println(Stack.peek());
            Stack.pop();
        }

    }    
}