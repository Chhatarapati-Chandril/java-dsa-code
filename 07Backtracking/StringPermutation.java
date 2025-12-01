// Find and print all the permutations of a given array
// "abc"
// abc acb bac bca cab cba

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