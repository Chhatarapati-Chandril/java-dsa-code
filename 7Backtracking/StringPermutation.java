// Find and print all the subsets of a given array
// "abc"
// a, b, c, ab, bc, ac, abc

public class StringPermutation 
{
    public static void permutation(String str, String ans)
    {
        // basecase
        if (str.length()==0) {
            System.out.print(ans+" ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" -> "ab" + "de"
            String newStr = str.substring(0,i) + str.substring(i+1);
            permutation(newStr, ans+curr);
        }
       
    }
    public static void main(String[] args) {
        String str = "abc";
        permutation(str, "");
        
    }
}