import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        int totalGamesPlayed = 0;
        int totalUserWins = 0;
        int totalComputerWins = 0;
        
        System.out.println(PURPLE + "\nWelcome to the Rock-Paper-Scissors Game!" + RESET);
        System.out.println(CYAN + "Let's see if you can beat the computer." + RESET);
        
        boolean playAgain = true;
        
        while (playAgain) {
            int userScore = 0, computerScore = 0;

            System.out.print(YELLOW + "\nHow many rounds would you like to play? (1-10): " + RESET);
            int rounds;
            while (true) {
                if (scanner.hasNextInt()) {
                    rounds = scanner.nextInt();
                    if (rounds >= 1 && rounds <= 10) break;
                }
                System.out.print(RED + "Please enter a number between 1 and 10: " + RESET);
                scanner.nextLine();
            }


            System.out.println(YELLOW + "\nYou will play " + rounds + " rounds. Get ready!" + RESET);

            for (int i = 1; i <= rounds; i++) {
                System.out.println(BLUE + "\nRound " + i + " - Make your choice:" + RESET);
                System.out.println(CYAN + "1. Rock  |  2. Paper  |  3. Scissors" + RESET);
                System.out.println("Current Score - You: " + userScore + " Computer: " + computerScore);
                System.out.print(GREEN + "Your Choice (1-3): " + RESET);

                int userChoice;

                while (true) {
                    if (scanner.hasNextInt()) {
                        userChoice = scanner.nextInt();
                        if (userChoice >= 1 && userChoice <= 3) break;
                    }
                    System.out.print(RED + "Invalid choice! Enter 1, 2, or 3: " + RESET);

                    scanner.nextLine();
                }


                int computerChoice = random.nextInt(3);
                System.out.println(PURPLE + "Computer chose: " + choices[computerChoice] + RESET);
                System.out.println("Your choice: " + choices[userChoice-1]);


                // Determine the winner with more detailed messages
                if (userChoice - 1 == computerChoice) {





                    System.out.println(YELLOW + "It's a tie! Both chose " + choices[computerChoice] + RESET);
                } else if ((userChoice == 1 && computerChoice == 2) ||
                           (userChoice == 2 && computerChoice == 0) ||
                           (userChoice == 3 && computerChoice == 1)) {
                    System.out.println(GREEN + "You win this round! " + choices[userChoice-1] + " beats " + choices[computerChoice] + RESET);
                    userScore++;
                } else {

                    System.out.println(RED + "Computer wins this round! " + choices[computerChoice] + " beats " + choices[userChoice-1] + RESET);
                    computerScore++;
                }
            }



            totalGamesPlayed++;
            if (userScore > computerScore) totalUserWins++;
            if (computerScore > userScore) totalComputerWins++;

            // Final result with statistics
            System.out.println(BLUE + "\n=== Final Score ===");
            System.out.println("You: " + userScore + " - Computer: " + computerScore + RESET);
            System.out.println("Games played today: " + totalGamesPlayed);
            System.out.println("Your total wins: " + totalUserWins);
            System.out.println("Computer total wins: " + totalComputerWins);
            
            if (userScore > computerScore) {
                System.out.println(GREEN + "YOU ARE THE CHAMPION!" + RESET);
            } else if (userScore < computerScore) {
                System.out.println(RED + "Computer Wins! Better luck next time." + RESET);
            } else {
                System.out.println(YELLOW + "It's a tie! Well played." + RESET);
            }


            System.out.print(CYAN + "\nDo you want to play again? (yes/no): " + RESET);
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }


        // Final statistics when player quits
        System.out.println(PURPLE + "\n=== Game Statistics ===");
        System.out.println("Total games played: " + totalGamesPlayed);
        System.out.println("Your total victories: " + totalUserWins);
        System.out.println("Computer total victories: " + totalComputerWins);
        System.out.println("Thanks for playing! See you next time." + RESET);
        scanner.close();
    }
}