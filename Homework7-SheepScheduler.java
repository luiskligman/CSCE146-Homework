import java.util.Scanner;
import java.io.File;

public class SheepScheduler {
	// Establishes MinHeap of type Sheep representing the Sheep waiting to be sheared
	MinHeap<Sheep> sheep = new MinHeap<Sheep>();
	
	public Sheep currentSheep;
	public int currentMinute = 0;
	public int totalSheep = 0;
	
	public void addSheep(Sheep aSheep) {
		if(currentSheep == null)
			currentSheep = aSheep;
		else
			sheep.add(aSheep);
		totalSheep++;
	}
	
	public boolean isDone() {
		return currentSheep == null;
	}
	
	public void advanceOneMinute() {
		currentMinute++;
		currentSheep.shearForOneMinute();
		
		//Current sheep is sheared
		if(currentSheep.getShearingTime() == 0) {
			//Set shearing time back to intial value in order to properly print to console
			currentSheep.setShearingTime(currentMinute);
			System.out.println(currentSheep.toString());
			//reset currentMinute value for next sheep to properly iterate
			currentMinute = 0;
			//Check if there are more sheep waiting in the heap
			if (sheep.size() > 0)
				currentSheep = sheep.remove(); // Remove and set the next Sheep as currentSheep
			else 
				currentSheep = null; //Empty Heap
		}
	}

	//Read File
	public static void readSheepFile(String aFileName, Sheep[] sheepArray) {
		try {
			Scanner fileScanner = new Scanner(new File(aFileName));
			//READ
			int iteration = 0;
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine(); //Read the line
				String[] splitLines = fileLine.split("\t"); //Split the line
				if(splitLines.length == 3) {
					String name = splitLines[0];
					int shearingTime = Integer.parseInt(splitLines[1]);
					int arrivalTime = Integer.parseInt(splitLines[2]);
					
					Sheep aSheep = new Sheep(name, shearingTime, arrivalTime);
					sheepArray[iteration] = aSheep;
					iteration++;
				}
			}
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
