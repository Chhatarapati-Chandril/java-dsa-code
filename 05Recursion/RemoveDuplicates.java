// remove the dulicate alphabets from a given string

public class RemoveDuplicates
{

    public static void removeDuplicates(String str, int idx, StringBuilder newstr, boolean map[])
    {
        if (idx == str.length()) {
            System.out.println(newstr);
            return;
        }

        // kaam
        char currentChar = str.charAt(idx);

        if (map[currentChar-'a'] == true) {
            // duplicate 
            removeDuplicates(str, idx+1, newstr, map);
        }
        else 
        {
            map[currentChar-'a'] = true;
            removeDuplicates(str, idx+1, newstr.append(currentChar), map);
        }
    }
    
    public static void main(String[] args) 
    {
        String str = "appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}