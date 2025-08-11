import java.util.*;

public class FakeOS 
{

    static Scanner sc = new Scanner(System.in);
    static LinkedList<String> commandHistory = new LinkedList<>();

    // Color Codes
    public static final String RESET   = "\u001B[0m";
    public static final String BLUE    = "\u001B[34m";
    public static final String GREEN   = "\u001B[32m";
    public static final String RED     = "\u001B[31m";
    public static final String MAGENTA = "\u001B[35m";

    public static void main(String[] args) {
        System.out.println(MAGENTA + "======================================" + RESET);
        System.out.println(MAGENTA + "        🌟 Welcome to Chandro-OS 🌟     " + RESET);
        System.out.println(MAGENTA + "   Your Personal Terminal Playground   " + RESET);
        System.out.println(MAGENTA + "======================================" + RESET);

        System.out.println(GREEN + "Type 'help' to view available commands." + RESET);
        System.out.println(BLUE + "Type a command below to begin:\n" + RESET);

        while (true) 
        { 
            System.out.print(BLUE + "Chandro-OS >> " + RESET);
            String input = sc.nextLine().trim();
            commandHistory.add(input);  //save input history

            // handle commands
            if (input.equalsIgnoreCase("help")) 
            {
                showHelp();
            } 
            else if (input.equalsIgnoreCase("history")) 
            {
                showCommandHistory();
            } 
            else if (input.equalsIgnoreCase("open chatbot")) 
            {
                ChatBot.runChatBot(sc);
            } 
            else if (input.startsWith("mkdir") || input.equals("ls") || input.startsWith("rm")) 
            {
                FileManager.runFileManager(input);
            }
            else if (input.equalsIgnoreCase("open game")) 
            {
                GameCenter.openGameCenter();
            }

            else if (input.equalsIgnoreCase("exit")) 
            {
                System.out.print(RED + "⚠️ Are you sure you want to exit? (y/n): " + RESET);
                String confirm = sc.nextLine().trim().toLowerCase();

                if (confirm.equals("y") || confirm.equals("yes")) 
                {
                    System.out.println(GREEN + "👋 Exiting Chandro-OS... Bye!" + RESET);
                    break;
                } 
                else 
                {
                    System.out.println(MAGENTA + "✨ Phew! Still hanging out in Chandro-OS!" + RESET);
                }
            } 
            else 
            {
                System.out.println(RED + "❌ Unknown command. Try 'help'." + RESET);
            }
        }
    }

    public static void showHelp() {
        System.out.println(GREEN + "\nAvailable Commands:" + RESET);
        System.out.println(BLUE + "- open chatbot     → launch ChandroBot" + RESET);
        System.out.println(BLUE + "- mkdir <name>     → create file/folder" + RESET);
        System.out.println(BLUE + "- ls               → list all files" + RESET);
        System.out.println(BLUE + "- rm <name>        → remove file/folder" + RESET);
        System.out.println(BLUE + "- open game        → play mini-games" + RESET);
        System.out.println(BLUE + "- history          → show command history" + RESET);
        System.out.println(BLUE + "- help             → show this message" + RESET);
        System.out.println(BLUE + "- exit             → exit Chandro-OS\n" + RESET);
    }

    public static void showCommandHistory() {
        // same here — keep it local
        System.out.println("\n📜 Command History:");
        int count = 1;
        for (String cmd : commandHistory) 
        {
            System.out.println(count + ". " + cmd);
            count++;
        }
    }
}
