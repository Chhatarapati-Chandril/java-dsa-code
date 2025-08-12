import java.util.Stack;

// Decode a string
// We have an encoded string s and the task is to decode it. The pattern in which the strings are
// encoded is as follows.
// Sample Input 1 : 2[cv]
// Sample Output 1 : cvcv
// Sample Input 2 : 3[b2[v]]
// Sample Output 2 : bvvbvvbvv

public class Q3 
{
    public static String decodeString(String s)
    {
        Stack<Integer> NumberStack = new Stack<>();
        Stack<String> StringStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int index = 0;
        int n = s.length();

        while(index < n)
        {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                int number = 0;
                while (index < n && Character.isDigit(s.charAt(index))) { 
                    number = number * 10 + (ch - '0');
                    index++;
                }
                NumberStack.push(number);
            }
            else if (ch == '[') {
                StringStack.push(result.toString());
                result = new StringBuilder();
                index++;
            }
            else if (ch == ']') {
                StringBuilder temp = new StringBuilder(StringStack.pop());
                int number = NumberStack.pop();
                for (int i = 0; i < number; i++) {
                    temp.append(result);
                }
                result = temp;
                index++;
            }
            else{
                result.append(ch);
                index++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) 
    {
        System.out.println(decodeString("2[cv]"));
        System.out.println(decodeString("3[b2[v]]"));
        System.out.println(decodeString("3[a]2[b]c"));
    }    
}