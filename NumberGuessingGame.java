import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int score = 0;
        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange);
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    score += maxAttempts - attempts + 1;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
            }
            
            System.out.println("Current Score: " + score);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainStr = scanner.next();
            playAgain = playAgainStr.equalsIgnoreCase("yes");
            
            rounds++;
        }
        
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
