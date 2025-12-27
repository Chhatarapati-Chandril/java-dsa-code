public class o9static
{
    public static void main(String[] args) 
    {
        Students s1 = new Students();
        s1.schoolname = "DAV";

        Students s2 = new Students();
        System.out.println(s2.schoolname);
    }
}
class Students 
{
    String name;
    static String schoolname;
}

/*
static keyword in java is used to share the same variable or a method of a given class
- properties
- functions
- blocks
- nested classes
*/