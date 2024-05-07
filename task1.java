import java.util.*;

public class task1 {
    public static void userGuess(int randomnumber) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (true) {
            System.out.println("Guess the number between 1 and 100 (or enter -1 to exit): ");
            int guessnumber = scanner.nextInt();
            attempts++;

            if (guessnumber == randomnumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guessnumber == -1) {
                System.out.println("Exiting the game. The correct number was: " + randomnumber);
                break;
            } else if (guessnumber < randomnumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int randomnumber = random.nextInt(max - min + 1) + min;
            userGuess(randomnumber);
            score++; 

            System.out.println("Do you want to play again? (yes/no): ");
            String playagain = scanner.next().toLowerCase();
            if (!playagain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing. Your final score is: " + score);
        scanner.close();
    }
}
