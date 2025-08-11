public class stringbuilder
{
    public static String compress(String str) {
    StringBuilder compressed = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
        int count = 1;
        // Count consecutive same characters
        while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
            count++;
            i++;
        }
        // Append current char
        compressed.append(str.charAt(i));
        // Append count if > 1
        if (count > 1) {
            compressed.append(count);
        }
    }

    return compressed.toString();
}


    public static String toUpperCase(String str)
    {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);                                  // to add element in string

        for (int i=1;i<str.length();i++)
        {
            if (str.charAt(i)==' ' && i<str.length()-1)
            {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i))); 
            }
            else
            {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String args[])
    {
        String str="aaabbcccddd";
        System.out.println(compress(str));
        System.out.println(toUpperCase("hello world. this is java programming"));
    }
}