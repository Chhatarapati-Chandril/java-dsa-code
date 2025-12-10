public class o7abstractClasses
{
    public static void main(String[] args) 
    {
        Mustang myHorse = new Mustang();
        // Animal -> Horse -> Mustang
    }
}

abstract class Animal       // can't create object of abstract class
{
    String color;
    Animal()
    {
        System.out.println("Animal constructor called...");
        color="brown";  // horse will be of "brown" color by default until we change its color
    }
    abstract void walk(); // no implementation of walk()
    // as we created a abstarct method - walk(),
    // if we create a sub class, its compulsory to add walk () in its sub-classes
}
class Horse extends Animal
{
    Horse()
    {
        System.out.println("Horse constructor called...");
    }
    void changeColor()
    {
        color="drak brown"; 
    }
    @Override
    void walk()
    {
        System.out.println("walk on 4 legs");
    }
}
class Mustang extends Horse
{
    Mustang()
    {
        System.out.println("Mustang constructor called...");
    }
}