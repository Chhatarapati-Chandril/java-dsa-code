public class o1OOPS
{
    public static void main(String args[])
    {
        Pen p1 = new Pen(); 
        // created a pen object called p1
        // Pen() is constructor
        p1.setColor("Blue");
        System.out.println(p1.color);

        p1.setTip(5);
        System.out.println(p1.tip);
        
        p1.color="Yellow";
        System.out.println(p1.color);


        BankAccount myAcc = new BankAccount(); // created a BankAccount object called myAcc

        myAcc.username = "Chhatarapati";
        myAcc.setPassword("qwerty123");
    }
}

class BankAccount
{
    public String username;
    private String password;

    public void setPassword(String pass)
    {
        password=pass;
    }
}

class Pen
{
    String color;
    int tip;

    void setColor (String newColor)
    {
        color=newColor;
    }

    void setTip(int newTip)
    {
        tip=newTip;
    }
}

/*
Access Modifier | within class | within package |outside package by subclass only|outside package
----------------|--------------|----------------|--------------------------------|---------------
Private         | Yes          | No             | No                             | No
Default         | Yes          | Yes            | No                             | No
Protected       | Yes          | Yes            | Yes                            | No
Public          | Yes          | Yes            | Yes                            | Yes


| Access Modifier | Class | Nested Class | Constructor | Method | Field |
|-----------------|-------|--------------|-------------|--------|-------|
| private         | No    | Yes          | Yes         | Yes    | Yes   |
| default         | Yes   | Yes          | Yes         | Yes    | Yes   |
| protected       | No    | Yes          | Yes         | Yes    | Yes   |
| public          | Yes   | Yes          | Yes         | Yes    | Yes   |

*/
