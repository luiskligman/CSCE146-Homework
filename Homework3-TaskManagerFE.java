import java.util.Scanner;
public class TaskManagerFE {

	private static Scanner keyboard = new Scanner(System.in);
	private static TaskManager taskManager = new TaskManager();
	public static void main(String[] args) {
		System.out.println("Welcome to the Task Organizer!");
		
		boolean quit = false;
		while(quit == false) {
			System.out.println("");
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(choice) {
				case 1: 
					addTask();
					break;
				case 2:
					removeTask();
					break;
				case 3:	
					print();
					break;
				case 4:	
					readTaskFile();
					break;
				case 5:
					writeTaskFile();
					break;
				case 9:
					quit = true;
					System.out.println("Goodbye!");
					break;
			}
		}
	}
	
	public static void addTask() {
		System.out.println("Enter the task's priority");
		int priority = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Enter the task's action");
		String action = keyboard.nextLine();
		Task aTask = new Task(priority,action);
		taskManager.addTask(aTask);
	}
	
	public static void writeTaskFile() {
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		taskManager.writeTaskFile(fileName);
	}
	
	public static void removeTask() {
		System.out.println("Enter the task's priority");
		int priority = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Enter the task's action");
		String action = keyboard.nextLine();
		taskManager.removeTask(priority, action);
	}
	
	public static void print() {
		taskManager.print();
	}
	
	public static void readTaskFile() {
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		taskManager.readTaskFile(fileName);
	}
	
	public static void printChoices() {
		System.out.println("Enter 1. To Add a Task");
		System.out.println("Enter 2. To Remove a Task");
		System.out.println("Enter 3. To Print Tasks To Console");
		System.out.println("Enter 4. To Read from a Task File");
		System.out.println("Enter 5. To Write to a Task File");
		System.out.println("Enter 9. To Quit");
	}
}
