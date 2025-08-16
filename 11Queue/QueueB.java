import java.util.*;

public class QueueB 
{
    public static void main(String[] args) 
    {
        // Queue is an interface so we can't create its object

        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }    
}