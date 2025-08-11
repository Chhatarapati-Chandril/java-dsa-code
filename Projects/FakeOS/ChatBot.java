import java.util.*;

public class ChatBot 
{
    
    static ArrayList<String> chatHistory = new ArrayList<>();
    
    public static void runChatBot(Scanner sc) 
    {

        System.out.println("\n🤖 Welcome to CC-Term!");
        System.out.println("Type 'bye' to exit.\n");

        while (true) 
        { 
            System.out.print(FakeOS.GREEN + "You: " + FakeOS.RESET);   
            String userInput = sc.nextLine().trim();
            chatHistory.add(FakeOS.GREEN + "You: " + FakeOS.RESET + userInput);

            if (userInput.equalsIgnoreCase("bye")) 
            {
                System.out.println("CC-Term: Goodbye, Commander 🫡");
                break;
            }

            String response = getCCResponse(userInput);
            System.out.println(FakeOS.MAGENTA + "CC-Term: " + FakeOS.RESET + response);
            chatHistory.add(FakeOS.MAGENTA + "CC-Term: " + FakeOS.RESET + response);
        }
    }

    public static String getCCResponse(String input) 
    {
        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) 
        {
            return "Hey hey! ✨ What’s cookin’, Commander?";
        } 
        else if (input.contains("how are you")) 
        {
            return "I’m running on caffeine and Java classes ☕💻";
        } 
        else if (input.contains("your name")) 
        {
            return "I go by CC-Term. Your loyal digital sidekick. 🤖";
        } 
        else if (input.contains("who made you")) 
        {
            return "A mastermind named Chandril 😌";
        } 
        else if (input.contains("joke")) 
        {
            return "Why do Java devs wear glasses? Because they can't C# 😎";
        } 
        else if (input.contains("love you")) 
        {
            return "Awww 🤖💙 Love you too... but as a statically typed friend!";
        }

        return "Hmm I didn't get that... but I'm learning, promise 😅";
    }
    
    public static void showChatHistory() 
    {
        System.out.println("\n📜 Chat History with CC-Term:");
        for (String msg : chatHistory) 
        {
            System.out.println(msg);
        }
    }
}