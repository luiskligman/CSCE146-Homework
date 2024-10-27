import java.util.Scanner;

public class GameMangerFE {

	public static void p(String aS) {
		System.out.println(aS);
	}

	private static Scanner keyboard = new Scanner(System.in);
	private static GameManager gameManager = new GameManager();

	public static void main(String[] args) {

		p("Welcome to the showcase show down!");

		// reads the txt file and stores the values
		gameManager.readPrizeFile("./prizeList.txt");

//		gameManager.printAll(); //Prints all prizes with prices : sorted

		boolean run = true;
		while (run) { // while loop to keep game running until yes is inputed
			gameManager.runGame();

			System.out.println(
					"You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
			System.out.println("Enter your guess");
			int guess = keyboard.nextInt();
			keyboard.nextLine();
			gameManager.Guess(guess);

			System.out.println("you like to quit? Enter \"yes\" to quit");
			String playAgain = keyboard.nextLine();
			if (playAgain.equalsIgnoreCase("yes")) {
				run = false;
				System.out.println("GoodBye!");
			} else
				run = true;
		}
	}
}
