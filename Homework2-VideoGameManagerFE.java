import java.util.Scanner;
public class VideoGameManagerFE {

	private static Scanner keyboard = new Scanner(System.in);
	private static VideoGameManager videoGameManager = new VideoGameManager();
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Video Game Database!");
		boolean quit = false;
		while(quit == false) {
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice) {
			case 1: 
				readVideoGameFile();
				//Shows that the video game file was read by printing it out
					//videoGameManager.printVideoGames();
				break;
			case 2:
				search();
				break;
			case 3:
				videoGameManager.printSearchList();
				break;
			case 4:
				printToFile();
				break;
			case 0:
				System.out.println("GoodBye!");
				quit = true;
			}
		}
	}
	
	public static void printToFile() {
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		System.out.println("Would you like to append? True or false?");
		String append = keyboard.nextLine();
		
		videoGameManager.writeVideoGameFile(fileName, append);
	}
	
	public static void search() {
		System.out.println("Enter the name of the game or '*' for all");
		String gameName = keyboard.nextLine();
		System.out.println("Enter the name of the console or '*' for all");
		String consoleName = keyboard.nextLine();
		
		videoGameManager.searchByGame(gameName, consoleName);
		
		//System.out.println(gameName);
	}
	
	public static void printChoices() {
		System.out.println("");
		System.out.println("Enter 1 to load the video game database");
		System.out.println("Enter 2 to search the database");
		System.out.println("Enter 3 to print current results to the console");
		System.out.println("Enter 4 to print current results to file");
		System.out.println("Enter 0 to quit");
	}
	
	public static void readVideoGameFile() {
		System.out.println("Enter the file name");
		
		String fileName = keyboard.nextLine();
		videoGameManager.readVideoGameFile(fileName);
	}
}
