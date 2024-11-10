import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TaskManager {

	private GenLL<Task>[] organizedTasks;
	private static final String DELIM = "\t";

	//Default Constructor
	public TaskManager() {
		//Constructs the array but not the linked lists
		organizedTasks = new GenLL[5];
		
		//Constructs the linkedlist in each index of the array
		for(int i = 0; i < organizedTasks.length; i++) {
			organizedTasks[i] = new GenLL<Task>();
		}
	}
	
	public void addTask(Task aTask) {
		if(aTask == null)
			return;
		
		int priority = aTask.getPriority();
		
		//Ensures that aTask have a valid priority value before adding
		if (priority < 0 || priority >= organizedTasks.length) {
            System.out.println("Invalid priority: " + priority + ". Task not added.");
            return;
        }
		GenLL<Task> taskList = organizedTasks[priority];
		taskList.add(aTask);
	}
	
	public void print() {
		for(int i = 0; i < organizedTasks.length; i++) {
			organizedTasks[i].print();
		}
	}
	
	public void removeTask(int aPriority, String aAction) {
		if(aAction == null) 
			return;
		if(aPriority > 4 || aPriority < 0)
			return;
		
		for(int i = 0; i < organizedTasks.length; i++) {
			organizedTasks[i].reset();
			while(organizedTasks[i].hasMore()) {//Current != null
				
				if(organizedTasks[i].getCurrent().getPriority() == aPriority &&
						organizedTasks[i].getCurrent().getAction().equalsIgnoreCase(aAction)) {
				organizedTasks[i].removeCurrent();
				break;
				}
				organizedTasks[i].gotoNext(); //Current = Current.link
			}	
		}
	}
	
	public void readTaskFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			//Read 
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();//read the line
				String[] splitLine = fileLine.split(DELIM);//Split the line
				if(splitLine.length == 2) {
					int priority = Integer.parseInt(splitLine[0]);
					String action = splitLine[1];
					
					//Creates new task and stores values obtained from file
					Task aTask = new Task(priority,action);
					
					//Adds task to array
					this.addTask(aTask);
				}
			}
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeTaskFile(String aName) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			//Write
			for(int i = 0; i < organizedTasks.length; i++) { //Iterates through each priority in the array of linked lists
				organizedTasks[i].reset();
				while(organizedTasks[i].hasMore()) {
					Task t = organizedTasks[i].getCurrent();
					fileWriter.println(t.getPriority()+DELIM+t.getAction());
					organizedTasks[i].gotoNext();//Current = Curren.link
				}
			}
			fileWriter.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
