import java.util.Scanner;
import java.util.Random;

public class GuessTheShape {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] shapes = {
            "Circle", "Square", "Triangle",
            "Rectangle", "Diamond"
        };

        String[] symbols = {
            "O", "[]", "/_\\", "▭", "<>"
        };

        int score = 0;
        String playAgain;

        System.out.println("================================");
        System.out.println("       GUESS THE SHAPE GAME");
        System.out.println("================================");

        do {
            int number = random.nextInt(shapes.length);

            System.out.println("\nGuess this shape: " + symbols[number]);

            System.out.println("\nChoose your answer:");
            System.out.println("1. Circle");
            System.out.println("2. Square");
            System.out.println("3. Triangle");
            System.out.println("4. Rectangle");
            System.out.println("5. Diamond");

            int answer;

            // Validate answer
            while (true) {
                System.out.print("Enter your answer (1-5): ");

                if (input.hasNextInt()) {
                    answer = input.nextInt();

                    if (answer >= 1 && answer <= 5) {
                        break;
                    } else {
                        System.out.println("Invalid choice! Choose only 1-5.");
                    }

                } else {
                    System.out.println("Invalid input! Enter a number.");
                    input.next();
                }
            }

            if (shapes[answer - 1].equals(shapes[number])) {
                System.out.println("Correct! Great job!");
                score++;
            } else {
                System.out.println("Wrong answer!");
                System.out.println("Correct answer: " + shapes[number]);
            }

            System.out.println("Your score: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = input.next();

            while (!playAgain.equalsIgnoreCase("yes") &&
                   !playAgain.equalsIgnoreCase("no")) {

                System.out.print("Invalid input! Enter yes or no: ");
                playAgain = input.next();
            }

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n================================");
        System.out.println("           GAME OVER");
        System.out.println("Your final score: " + score);
        System.out.println("Thank you for playing!");
        System.out.println("================================");

        input.close();
    }
}
