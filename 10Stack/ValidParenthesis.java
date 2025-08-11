
import java.util.Stack;

public class ValidParenthesis
{
    // O(n)
    public static boolean isValid(String str)
    {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
            // opening
            if(ch  == '(' || ch  == '{' || ch  == '[' ) 
            {
                s.push(ch);
            }
            // closing
            else
            {
                if (s.isEmpty()) 
                {
                    return false;
                }
                if ( 
                    (s.peek() == '(' && ch == ')') || 
                    (s.peek() == '{' && ch == '}') || 
                    (s.peek() == '[' && ch == ']')
                ) 
                {
                    s.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        else{
            return false;
        }
    }   

    // O(n)
    public static boolean isDulicate(String str)
    {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') 
            {
                int count = 0;
                while(s.peek() != '(')
                {
                    s.pop();
                    count++;
                } 
                // duplicate
                if (count < 1) {
                    return true;
                }
                // opening pair mil gya
                else{
                    s.pop();
                }
            }
            // opening, operand, operators
            else
            {
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) 
    {
        // String str = "({})]";
        // System.out.println(isValid(str));
        String str1 = "((a+b))";
        String str2 = "(a-b)";
        System.out.println(isDulicate(str1));
        System.out.println(isDulicate(str2));
    }
}