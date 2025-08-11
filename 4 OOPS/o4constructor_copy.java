public class o4constructor_copy
{
    public static void main(String args[])
    {
        Student s1 = new Student();
        s1.name="Chandril";
        s1.roll=123;
        s1.password="abcd";
        s1.marks[0]=10;
        s1.marks[1]=9;
        s1.marks[2]=8;

        Student s2 = new Student(s1);  //values of s1 are copied to s2 
        s2.password="xyz";  
        s1.marks[2]=100; 
    /* 
    Values of s1 are copied to s2
    Then we think if we make any changes in s1 after copying, it will not affect s2
    But those changes will be reflected in s2 also. 
    Becuase when the array was created, s1 refers to that array and after copying, s2 also refers to that array.
    So any changes in the array will be seen in the objects refering it
    */
        for (int i=0;i<3;i++)   // to print marks of Student s2
        {
            System.out.println(s2.marks[i]);
        }
    }
}

@SuppressWarnings("unused")

class Student
{
    String name;
    int roll;
    String password;
    int marks[];

    //shallow copy constructor
    
    // Student(Student s1)
    // {
    //     marks = new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // }

    //deep copy constructor
    @SuppressWarnings("ManualArrayToCollectionCopy")
    
    Student(Student s1)
    {
        marks = new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<marks.length;i++)
        {
            this.marks[i]=s1.marks[i];
        }
    }
    
    Student()
    {
        marks = new int[3];
        System.out.println("Constructor is called...");
    }
}
