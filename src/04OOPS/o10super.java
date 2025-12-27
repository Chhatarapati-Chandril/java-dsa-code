public class o10super
{
    public static void main(String[] args) 
    {
        Horse h=new Horse();
        System.out.println(h.color);
    }
}
class Animal__
{
    String color;
    Animal__()
    {
        System.out.println("Animal constructor is called...");
    }
}
class Horse extends Animal__
{
    Horse()
    {
        super.color="brown";
        // super();         java by default call this constructor
        System.out.println("Horse constructor is called...");
    }
}

/*
"super" keyword is used to refer  immediate parent class
- to access parents properties
- to access parents functions
- to access parents constructor
*/