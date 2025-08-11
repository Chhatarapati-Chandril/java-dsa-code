import java.util.*;
public class NumberGuess
{
    @SuppressWarnings("resource")
    public static void main(String args[])
    {
        Random random=new Random();
        Scanner sc=new Scanner(System.in);
        boolean playagain=true;
        while (playagain)
        {
            System.out.println("Choose a difficulty level(1/2/3):");
            System.out.println("1. Easy (1-50, 15 attempts)");
            System.out.println("2. Medium (1-100, 10 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            
            int difficulty = sc.nextInt();

            int range;
            int maxAttempts;

            switch (difficulty) 
            {
                case 1 -> 
                {
                    range = 50;
                    maxAttempts = 15;
                }
                case 2 -> 
                {
                    range = 100;
                    maxAttempts = 10;
                }
                case 3 -> 
                {
                    range = 200;
                    maxAttempts = 5;
                }
                default -> 
                {
                    System.out.println("Invalid choice. Defaulting to Medium difficulty.");
                    range = 100;
                    maxAttempts = 10;
                }
            }
            int randomnum = random.nextInt(range) + 1;
            int guess = 0;
            int attempts=0;

            for (;guess!=randomnum;)
            {
                if (attempts<maxAttempts)
                {
                    System.out.print("Enter your guess : ");

                    while (!sc.hasNextInt())      // check input is integer or not
                    {
                        System.out.println("Invalid input! Please enter a number.");
                        sc.next();               // clear invalid input
                    }

                    guess=sc.nextInt();

                    if (guess < 1 || guess > range) 
                    {
                        System.out.println("Please enter a number between 1 and "+range+".");
                        continue;              // if the condition is false , then skip the loop
                    }

                    attempts++;

                    if (guess == randomnum) 
                    {
                        System.out.println("Congratulations!\nYou guessed the correct number in " + attempts + " attempts.\n");
                    } 
                    else if (guess >= randomnum - 5 && guess < randomnum) 
                    {
                        System.out.println("Very close, but increase a little bit.\n");
                    } 
                    else if (guess > randomnum && guess <= randomnum + 5) 
                    {
                        System.out.println("Very close, but decrease a little bit.\n");
                    } 
                    else if (guess >= randomnum - 15 && guess < randomnum) 
                    {
                        System.out.println("Close, but increase a bit.\n");
                    } 
                    else if (guess > randomnum && guess <= randomnum + 15) 
                    {
                        System.out.println("Close, but decrease a bit.\n");
                    } 
                    else if (guess >= randomnum - 30 && guess < randomnum) 
                    {
                        System.out.println("Far, but increase a bit.\n");
                    }
                    else if (guess > randomnum && guess <= randomnum + 30) 
                    {
                        System.out.println("Far, but decrease a bit.\n");
                    } 
                    else 
                    {
                        System.out.println("Very far! Try again.\n");
                    }
                }
                else
                {
                    System.out.println("You've used all " + maxAttempts + " attempts. Better luck next time!");
                    System.out.println("The correct number was " + randomnum + ".");
                    break;
                }
            }
            if (attempts<=maxAttempts)
            {
                int score = (maxAttempts - attempts + 1) * difficulty * 10;
                System.out.println("Your score: " + score);
            }
            else 
            {
                System.out.println("Your score: 0");
            }
            System.out.print("Do you want to play again? (yes/no): \n");
            String inputplayAgain = sc.next();
            playagain = inputplayAgain.equalsIgnoreCase("yes");   //ignore the inputs like yes,YES,Yes,yEs
        }
        System.out.println("Thanks for playing! Goodbye!");
    }
}