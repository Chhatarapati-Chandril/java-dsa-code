public class o5inheritance
{
    public static void main(String[] args) 
    {
        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs=4;
        System.out.println(dobby.legs);
    }
}
//base class
class Animal
{   
    String color;
    void eat()
    {
        System.out.println("eats");
    }
}
//Derived class
class Mammal extends Animal
{
    int legs;
}
class Dog extends Mammal
{

}

/*
Single Inheritance
    ┌───────────┐
    │ BaseClass │
    └────▼──────┘
    │ Derived   │
    └───────────┘


Multilevel Inheritance
    ┌───────────┐
    │ BaseClass │
    └────▼──────┘
    │ Derived1  │
    └────▼──────┘
    │ Derived2  │
    └───────────┘


Hierarchical Inheritance
       ┌───────────┐
       │ BaseClass │
  ┌────▼────┬────▼────┐
  │ Derived1│ Derived2│
  └─────────┴─────────┘


Hybrid Inheritance
       ┌───────────┐
       │ BaseClass │
  ┌────▼────┬────▼────┐
  │ Derived1│ Derived2│
  └────▼────┴────▲────┘
  │Derived3 │
  └────▼────┘
           

Multiple Inheritance **

   ┌────────────┐   ┌────────────┐
   │ BaseClass1 │   │ BaseClass2 │
   └────────────┘   └────────────┘
          │               │
          └───────▼───────┘
            ┌────────────┐
            │  Derived   │
            └────────────┘

Can be implemented by class in Cpp
But in java, we use interfaces
*/


/*
class Vehicle{}
class Car extends Vehicle{}

Vehicle v = new Car(); is valid because:
- A Car is a Vehicle (inheritance).
- The Car object has all the properties of Vehicle (x) plus its own properties (y).
- The Vehicle reference (v) can access only the x properties, which the Car object has.

Car c = new Vehicle(); is invalid because:
- A Vehicle is not a Car.
- The Vehicle object does not have the y properties that Car expects.
- The Car reference (c) cannot access y properties in a Vehicle object.


and this thing is called Upcasting and Downcasting
*/