package org.example;
import java.io.*;
import java.util.*;
public class MainSystem {
    static String name = null;
    static Library lib = new Library();
    static Scanner in = new Scanner (System.in);
    static boolean running = true;
    static int userChoice;
    public static void main(String[] args) {
        while (running){
            System.out.println("\nEnter 0 to load a library; \nEnter 1 to save and quest; " +
                    "\nEnter 2 to list all books in the library; \nEnter 3 to add a book");
            userChoice = in.nextInt();

            switch (userChoice){
                case 0:
                    System.out.println("Enter que file name to load:");
                    loadScript(in.next());
                    break;
                case 1:
                    saveAndQuit();
                    break;
                case 2:
                    System.out.println(lib.toString());
                    break;
                case 3:
                addBook();
                    break;

                default:
                    System.out.println("Error: unknown operation.");
            }
        }
        System.exit(0);
    }

    private static void addBook() {
        String title, author;
        int pages, option;
        boolean read = false;

        System.out.println("\n Enter title: ");
        title = in.next();

        System.out.println("\n Enter the author: ");
        author = in.next();

        System.out.println("\n Enter the pages: ");
        pages = in.nextInt();

        System.out.println("\n Read? [1 - Yes 2 - No]");
        option = in.nextInt();
        if(option == 1){
            read = true;
        } else if (option == 2){
            read = false;
        } else{
            System.out.println("Error: option unknown.");
        }

        Book b = new Book(title, author, pages, read);
        lib.addBooks(b);
    }

    private static void saveAndQuit() {
        System.out.println("Enter the file name: ");
        name = in.next() + ".ser";
        running = false;
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(name);
            out = new ObjectOutputStream(fos);
            out.writeObject(lib);
            out.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadScript(String name) {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        File file = new File(name + ".ser");
        if(file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                lib = (Library) in.readObject();
                fis.close();
                in.close();
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            System.out.println("\nThe file" + name + " does not exist.");
        }
    }
}