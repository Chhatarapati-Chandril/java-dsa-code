import java.util.*;

public class FileManager 
{

    static ArrayList<String> fileSystem = new ArrayList<>();

    public static void runFileManager(String input)
    {
        String[] parts = input.split(" ");
        String command = parts[0];

        switch (command) 
        {
            case "mkdir" -> 
            {
                if(parts.length < 2)
                {
                    System.out.println("❗ Usage: mkdir <folder_name>");
                }
                else
                {
                    makeFile(parts[1]);
                }
            }
            case "rm" -> 
            {
                if (parts.length < 2) 
                {
                    System.out.println("❗ Usage: rm <file_name>");
                }
                else 
                {
                    removeFile(parts[1]);
                }
            }
            case "ls" -> listFiles();
            default -> System.out.println("❌ Unknown file command");
        }
    }

    public static void makeFile(String name)
    {
        if (fileSystem.contains(name)) 
        {
            System.out.println("⚠️ File/folder already exists: " + name);
        }
        else
        {
            fileSystem.add(name);
            System.out.println("✅ Created: " + name);
        }
    }

    public static void removeFile(String name)
    {
        if (fileSystem.contains(name)) 
        {
            fileSystem.remove(name);
            System.out.println("🗑️ Removed: " + name);
        }
        else
        {
            System.out.println("❌ Not found: " + name);
        }
    }

    public static void listFiles()
    {
        if (fileSystem.isEmpty()) 
        {
            System.out.println("📂 No files/folders created yet.");
        }
        else
        {
            System.out.println("📁 Files/Folders:");
            for (String file : fileSystem) 
            {
                System.out.println("- " + file);
            }
        }
    }
}