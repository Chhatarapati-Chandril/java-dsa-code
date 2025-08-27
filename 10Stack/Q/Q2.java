import java.util.Stack;

// Simplify Path
// We hava an absolute path for a file (Unix-style), simplify it. Note that absolute path always begin
// with '/' ( root directory ), a dot in path represent current directory and double dot represents
// parent directory.
// Sample Input 1 : /apnacollege/
// Sample Output 1 : /apnacollege
// Sample Input 1 : /a/..
// Sample Output 1 : /


// Time Complexity : o(n)
// Space Complexity: o(1)

public class Q2 
{
    public static String simplifyPath(String path)
    {
        Stack<String> s = new Stack<>();
        // divide the string on basis of '/'
        String[] parts = path.split("/");

        // go to each part of the splitted path
        for (int i = 0; i < parts.length; i++) 
        {
            String part = parts[i];

            // If it's empty ("") or ".", skip it
            if (part.equals("") || part.equals(".")) 
            {
                continue;
            }
            // If it's "..", go up one directory
            if (part.equals("..")) {
                if (!s.isEmpty()) {
                    // remove the last directory from stack
                    s.pop();
                }
            }
            // Else, it's a valid directory name → push it
            else{
                s.push(part);
            }
        }
        // append the strings from the stack
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.size(); i++) {
            result.append("/").append(s.get(i));
        }
        // if stack is empty -> return "/"
        return result.length() > 0 ? result.toString() : "/";
    }
    public static void main(String[] args) 
    {
        System.out.println(simplifyPath("/apnacollege/"));   // /apnacollege
        System.out.println(simplifyPath("/a/.."));           // /
        System.out.println(simplifyPath("/a/./b/../../c/")); // /c
        System.out.println(simplifyPath("/../"));            // /
        System.out.println(simplifyPath("/home//foo/"));     // /home/foo
    }    
}