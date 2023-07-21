
import java.util.Scanner;
        import java.util.Random;

public class codsofttask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 7;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nI've generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess the number.");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += attempts;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }

            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if ("no".equalsIgnoreCase(playAgain)) {
                System.out.println("Thanks for playing! Your final score is: " + score);
                break;
            }
        } while (true);

        scanner.close();
    }
}