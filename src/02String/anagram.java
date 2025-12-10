import java.util.*;

public class anagram 
{
    public static void main(String[] args) 
    {
        String str1 = "earth";
        String str2 = "heart";

        // Convert strings to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Check if lengths are the same
        if (str1.length() == str2.length())
        {
            // Convert to char arrays
            char[] str1CharArray = str1.toCharArray();
            char[] str2CharArray = str2.toCharArray();

            // Sort the char arrays
            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            // Compare sorted arrays
            if (Arrays.equals(str1CharArray, str2CharArray)) 
            {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            } 
            else 
            {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }
        } 
        else 
        {   // Case when lengths are not equal
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
        }
    }
}


// optimized solution - TC: O(n), SC: O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        s = s.toLowerCase();
        t = t.toLowerCase();

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            freq[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}