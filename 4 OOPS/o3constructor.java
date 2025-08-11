@SuppressWarnings("unused")
public class o3constructor
{
    public static void main(String args[])
    {
        Student s1 = new Student();
        Student s2 = new Student("Chandril");
        Student s3 = new Student(123);
    }
}

class Student
{
    String name;
    int roll;
    
    Student()
    {
        System.out.println("Constructor is called...");
    }
    Student(String name)
    {
        this.name=name;
    }
    Student(int roll) 
    {
        this.roll = roll;
    }
}


/*
Constructors (3 types)
Constructor is a special method which is invoked automatically at the time of object creation.
- Constructors have the same name as class or structure
- Constructors don't have a return type. (Not even void)
- Constructors are only called once, at object creation.
- Memory allocation happens when constructor is called

Types - 
1. Non-parameterized
2. Parameterized
3. Copy constructor

CONSTRUCTOR OVERLOADING - 
is when a class has multiple constructors with the same name but different parameter lists. 
It allows creating objects in various ways by passing different numbers or types of arguments. 
The compiler determines which constructor to call based on the arguments.
*/