import java.util.*;                               // package
public class javabasics                          
/*
public keyword is an access modifier
main() is the method
*/
{
    public static void main(String args[])
    {
        //for printing 2 decimal precision (2 ways)
        double number = 123.456789;
        System.out.printf("Number with 2 decimals: %.2f \n", number);
        String formattedNumber = String.format("%.2f", number);
        System.out.println("Number with 2 decimals: " + formattedNumber);


        try (Scanner sc =new Scanner(System.in))     
        {  
            System.out.print("Enter a : ");           //System is a class predefined by java
            int a=sc.nextInt();                        //print() is build-in method
            System.out.print("Enter b : ");           
            int b=sc.nextInt();                        //varibale name - IDENTIFIER, varibale value - LITERAL
            System.out.print("Enter operator : ");
            char operator=sc.next().charAt(0);       // for char input as it automatically consider it as string

            switch(operator)
            {
                case '+' -> System.out.println(a+b);
                case '-' -> System.out.println(a-b);
                case '*' -> System.out.println(a*b);
                case '/' -> System.out.println(a/b);
                case '%' -> System.out.println(a%b);
                default -> System.out.println("Not valid");
            }
        }
    }
}
// boiler plate code
// String is not is primitive type, String defines an object
// String is treated as objects (not char arrays)
// The range of a char is 0 to 65,535 --- ASCII ranges from 0 to 127.

/*
51 standard reserved keywords
17 contextually reserved keywords

1 byte = 8 bits
+---------+-----------+-----------------------------------------------+
|  Type   |  Size     |  Range                                        |
+---------+-----------+-----------------------------------------------+
|  byte   |  8 bits   |  -128 to 127                                  |
|  short  |  2 byte   |  -32,768 to 32,767                            |
|  int    |  4 byte   |  -2^31 to 2^31-1                              |
|  long   |  8 byte   |  -2^63 to 2^63-1                              |
|  float  |  4 byte   | (6-7 significant decimal digits)              |
|  double |  8 byte   |  (15 significant decimal digits)              |
|  char   |  2 byte   |  0 to 65,535 (unsigned)                       |
|  boolean|  ~1 bit   |  true or false                                |
+---------+-----------+-----------------------------------------------+


In Java, variable names:

Can include letters (a-z, A-Z), digits (0-9), underscores (_), and dollar signs ($).
Must start with a letter, _, or $ (cannot start with a digit).
Cannot use special characters like @, #, %, etc., except _ and $.
Examples:
Valid: name, age1, _count, $value
Invalid: 1name, @var, my-var
*/
