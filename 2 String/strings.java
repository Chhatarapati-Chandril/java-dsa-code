import java.util.*;
public class strings               // STRINGS ARE -> IMMUTABLE ....CAN'T CHANGE
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        String name;

        System.out.println("Enter your name:");
        name = sc.nextLine();   // this will save the full name with space 

        System.out.println(name);
        String fruits[]={"apple","banana","mango"};
        String largest=fruits[0];
        for (int i = 1; i < fruits.length; i++) 
        {
            if (largest.compareTo(fruits[i]) < 0)               // compareTo func to compare strings
            {
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }
}


// interning
