import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class RobotQueueManager {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	//Creating board
	public static final int BOARD_SIZE = 10;
	public static String board[] = new String[BOARD_SIZE];
	//2D "board" of chars
	public static char board1[][] = new char[10][10];
	
	//used to replace the char at the robots position once the robot moves
	public static char swap;
	
	//booleans to tell the state of game
	public static boolean crash = false;
	public static boolean playAgain = true;
	
	//initializing the robots position
	public static int y = 0;
	public static int x = 0;
	
	public static void main(String[] args) {
		
		//Created linked list of robotCommands
		QueueI<String> robotCommands = new LLQueue<String>();
		
		System.out.println("Welcome to the Robot Simulator");

		while(playAgain == true) 
			prompt(robotCommands);
	}
	
	public static void runningRobotCommands(QueueI<String> robotCommands) {
		String command = null;
			command = robotCommands.dequeue();
			RobotFileToCommand(command, robotCommands);
	}
	
	public static void prompt(QueueI<String> robotCommands) {
		while(robotCommands.size() > 0) {
			robotCommands.dequeue();
		}
		//reseting robot position
		resetRobotPosition(); // x = y = 0
		crash = false; 
		
		//asking for board file
		System.out.println("Enter file for the Board");
		String boardFile = keyboard.nextLine();
		readBoardFile(boardFile);
		convert(); //Must have
		
		//Asking for robot Commands
		System.out.println("Enter file for the Robot Commands");
		String robotCommandFile = keyboard.nextLine();
		readRobotCommandFile(robotCommandFile, robotCommands);
		//System.out.println(robotCommands.size());
		printBoard();
		
		//begin simulation
		int command = 0;
		System.out.println("Simulation begin");
		while(robotCommands.size() > 0 && crash != true) {
			System.out.println("Command "+command);
			runningRobotCommands(robotCommands);
			command++;
			//printBoard();
		}
		
		System.out.println("Simulation end");
		
		//run again or quit
		System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
		if(keyboard.nextLine().equalsIgnoreCase("true")) {
			playAgain = false;
		}
	}
	
	public static void resetRobotPosition() {
		x = y = 0;
	}
	
	//Print Board
	public static void printBoard() {
		for(int i = 0; i < BOARD_SIZE; i++) {
	        for(int j = 0; j < BOARD_SIZE; j++) {
	            System.out.print(board1[i][j]); // Print each character of the string
	        }
	        System.out.println(); // Move to the next line after printing each row
	    }
		System.out.println();
	}
	
	//Convert board to 2D array of chars
	public static void convert() {
		for(int i = 0; i < BOARD_SIZE; i++) {
	        for(int j = 0; j < BOARD_SIZE; j++) {
	            board1[i][j] = board[i].charAt(j);
	        } 
	    }
		
		swap = board1[0][0]; //Set swap to the first position held by the robot
		board1[0][0] = 'R'; //Set robots position to the start
 	}

	public static void readBoardFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			//Read
			int i = 0;
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.next();//Using .next to read char by char, may be incorrect
				board[i] = fileLine;
				i++;	
			}
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void readRobotCommandFile(String aName, QueueI<String> robotCommands) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			//Read
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();//Read the line
				robotCommands.enqueue(fileLine);
			}
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void RobotFileToCommand(String command, QueueI<String> robotCommands) {
		if(command != null) {
			if(command.equalsIgnoreCase("Move Up")) {
				board1[y][x] = swap; //Replaces robot position with board char
				y--; //Goes up 
				swap = board1[y][x];
				board1[y][x] = 'R';
				if(swap == 'X') {
					System.out.println("CRASH!");
					crash = true;
				}
				else 
					printBoard();
			}
			if(command.equalsIgnoreCase("Move Down")) {
				board1[y][x] = swap; //Replaces robot position with board char
				y++; //Goes up 
				swap = board1[y][x];
				board1[y][x] = 'R';
				if(swap == 'X') {
					System.out.println("CRASH!");
					crash = true;
				}
				else 
					printBoard();
			}
			if(command.equalsIgnoreCase("Move Left")) {
				board1[y][x] = swap; //Replaces robot position with board char
				x--; //Goes left
				swap = board1[y][x];
				board1[y][x] = 'R';
				
				if(swap == 'X') {
					System.out.println("CRASH!");
					crash = true;
				}
				else 
					printBoard();
			}
			if(command.equalsIgnoreCase("Move Right")) {
				board1[y][x] = swap; //Replaces robot position with board char
				x++; //Goes right 
				swap = board1[y][x];
				board1[y][x] = 'R';
				if(swap == 'X') {
					System.out.println("CRASH!");
					crash = true;
				}
				else 
					printBoard();				
			}
		}
	}
}
