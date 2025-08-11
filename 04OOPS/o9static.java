public class o9static
{
    public static void main(String[] args) 
    {
        Student s1 = new Student();
        s1.school = "DAV";

        Student s2 = new Student();
        System.out.println(s2.school);
    }
}
class Student 
{
    String name;
    static String school;
}

/*
static keyword in java is used to share the same variable or a method of a given class
- properties
- functions
- blocks
- nested classes
*/