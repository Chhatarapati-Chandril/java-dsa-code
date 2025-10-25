public class o6polymorphism
{
    public static void main(String[] args) 
    {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(2,3));
        System.out.println(calc.sum((float)2.5,(float)2.5));
        System.out.println(calc.sum(2,1,2));

        Animal a = new Animal();
        a.eat();

        Deer d = new Deer();
        d.eat();

        Animal s = new Deer();
    }
}
/*
METHOD OVERLOADING
multiple function with same name but different parameter
*/
class Calculator
{
    int sum(int a,int b)
    {
        return a+b;
    }
    int sum(int a,int b,int c)
    {
        return a+b+c;
    }
    float sum(float a,float b)
    {
        return a+b;
    }
}
/* 
METHOD OVERRIDING
parent and child class both contain same function with different defination
*/
class Animal
{
    void eat()
    {
        System.out.println("eats anything");
    }
}
class Deer extends Animal
{
    @SuppressWarnings("override")
    void eat()
    {
        System.out.println("eats grass");
    }
}