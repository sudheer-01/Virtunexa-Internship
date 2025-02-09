import java.util.Scanner;
import java.util.Random;

public class AdventureGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to the Mysterious Forest Adventure!");
        System.out.println("You wake up in a dark forest with no memory of how you got here.");
        System.out.println("Your goal is to find a way out safely.");
        startGame();
    }

    public static void startGame() {
        System.out.println("\nYou see two paths ahead:");
        System.out.println("1. Take the left path through a dark cave.");
        System.out.println("2. Take the right path leading into the thick woods.");

        int choice = getUserChoice(2);
        if (choice == 1) {
            cavePath();
        } else {
            forestPath();
        }
    }

    public static void cavePath() {
        System.out.println("\nYou enter the cave. It's dark and eerie...");
        System.out.println("Suddenly, you hear growling. A wild beast appears!");
        System.out.println("What do you do?");
        System.out.println("1. Fight the beast.");
        System.out.println("2. Run away.");

        int choice = getUserChoice(2);
        if (choice == 1) {
            fightBeast();
        } else {
            System.out.println("\nYou run as fast as you can and escape the cave!");
            startGame();
        }
    }

    public static void fightBeast() {
        System.out.println("\nYou decide to fight the beast...");
        int outcome = random.nextInt(2); // Random success or failure

        if (outcome == 0) {
            System.out.println("You bravely fight but the beast overpowers you.");
            gameOver();
        } else {
            System.out.println("You defeat the beast and find a treasure chest!");
            System.out.println("Inside the chest, there's a magical map leading out of the forest.");
            System.out.println("Congratulations! You have escaped the forest successfully!");
            playAgain();
        }
    }

    public static void forestPath() {
        System.out.println("\nYou enter the thick woods. It's quiet... too quiet.");
        System.out.println("After walking for a while, you see an abandoned cabin.");
        System.out.println("Do you want to enter?");
        System.out.println("1. Enter the cabin.");
        System.out.println("2. Keep walking past it.");

        int choice = getUserChoice(2);
        if (choice == 1) {
            cabinEvent();
        } else {
            System.out.println("\nYou keep walking and eventually find a road leading out of the forest!");
            System.out.println("You are safe now. Congratulations!");
            playAgain();
        }
    }

    public static void cabinEvent() {
        System.out.println("\nYou step inside the cabin. It looks abandoned, but there’s a strange book on the table.");
        System.out.println("Do you want to read it?");
        System.out.println("1. Read the book.");
        System.out.println("2. Leave immediately.");

        int choice = getUserChoice(2);
        if (choice == 1) {
            System.out.println("\nAs you open the book, the room starts shaking!");
            System.out.println("The book is cursed, and you are trapped forever inside the cabin.");
            gameOver();
        } else {
            System.out.println("\nYou leave the cabin and find a hidden path leading to safety.");
            System.out.println("Congratulations! You have escaped the forest!");
            playAgain();
        }
    }

    public static void gameOver() {
        System.out.println("\nGame Over! Better luck next time.");
        playAgain();
    }

    public static void playAgain() {
        System.out.println("\nDo you want to play again? (yes/no)");
        String choice = scanner.next().toLowerCase();
        if (choice.equals("yes")) {
            startGame();
        } else {
            System.out.println("Thanks for playing! Goodbye.");
            System.exit(0);
        }
    }

    public static int getUserChoice(int options) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= options) {
                    return choice;
                }
            }
            System.out.println("Invalid choice. Please enter a valid option.");
            scanner.nextLine(); // Clear invalid input
        }
    }
}
