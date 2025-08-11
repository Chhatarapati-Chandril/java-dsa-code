public class internMethod
{
    public static void main(String args[])
    {
    /*
    The intern() method in Java is used to ensure that 
    all identical String objects share the same memory location in the string pool.

    If a string already exists in the POOL, the intern() method returns the reference to the existing string.
	If the string is not in the POOL, the intern() method adds it to the pool and returns the reference to it.
    */

        String str1 = new String("Hello"); // Creates a new string object in the HEAP/POOL
        String str2 = "Hello";            // Refers to another literal in the string POOL

        System.out.println(str1 == str2); // Output: false (different references)

        String str3 = str1.intern();      // Adds "Hello" to the POOL or retrieves the existing one

        System.out.println(str2 == str3); // Output: true (both now refer to the same string in the pool/stack)

        /*
        Before intern():
        str1 == str2 → false
        str1 == str1 → true
        str2 == str2 → true

        After intern():
        str1 == str2 → false
        str2 == str3 → true
        str1 == str3 → false
        */   
    }
}