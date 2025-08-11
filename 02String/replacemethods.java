public class replacemethods
{
    public static void main(String args[])
    {
        //str.replace

        String str = "hello world";
        String result = str.replace('o', 'a');
        System.out.println(result); // Output: "hella warld"

        String str2 = "Java is fun, Java is powerful";
        String result2 = str2.replace("Java", "Python");
        System.out.println(result2); // Output: "Python is fun, Python is powerful"

        //str.replaceAll

        String str3 = "Programming is fun!";
        String result3 = str3.replaceAll("[aeiouAEIOU]", "*");    
        // [ ]: Denotes a character class, meaning it matches any character inside the brackets.
        System.out.println(result3); // Output: "Pr*gr*mm*ng *s f*n!"

        String str4 = "Remove all the spaces in this sentence.";
        String result4 = str4.replaceAll("\\s", "");
        System.out.println(result4); // Output: "Removeallthespacesinthissentence."

        String str5 = "Hello, World! 123.";
        String result5 = str5.replaceAll("[^a-zA-Z0-9]", "_");
        System.out.println(result5); // Output: "Hello__World__123_"
        /*
            a-zA-Z0-9: Specifies the valid characters:
	        a-z: Matches all lowercase letters (a to z)
	        A-Z: Matches all uppercase letters (A to Z)
	        0-9: Matches all numeric digits (0 to 9)
            ^  : Inside a character class ([ ]), ^ means “not.” 
            So [^a-zA-Z0-9] matches any character that is NOT a letter or digit.
        */

       //replaceFirst

        String str6 = "Programming is fun!";
        String result6 = str6.replaceFirst("[aeiouAEIOU]", "*");
        System.out.println(result6); // Output: "Pr*gramming is fun!"

        String str7 = "a1b2c3";
        String result7 = str7.replaceFirst("\\d", "#");
        System.out.println(result7); // Output: "a#b2c3"
    }
}