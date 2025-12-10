// Find and print all the subsets of a given array
// "abc"
// a, b, c, ab, bc, ac, abc

public class StringSubsets 
{
    public static void subsets(String str, String ans, int i)
    {
        // basecase
        if (i==str.length()) {
            if (ans.length()==0) {
                System.out.println("null");
            }
            else {
                System.out.print(ans+" ");
            }
            return;
        }
        // yes choice
        subsets(str, ans+str.charAt(i), i+1);

        // no choice
        subsets(str, ans, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        
        subsets(str, "", 0);
    }
}