public class SheepSchedulerSimulator {

	public static final int NUM_OF_SHEEP = 60;

	public static void main(String[] args) {
		// Creates instance of SheepScheduler
		SheepScheduler s = new SheepScheduler();

		// Array of sheep, storing input directly from file
		Sheep[] sheepArray = new Sheep[NUM_OF_SHEEP];
		SheepScheduler.readSheepFile("sheepFile.txt", sheepArray);

		// Starting the simulation
		Sheep currentSheep = null;
		int currTime = 0;
		
		// Locate sheep with the first arrival time, already known to be 0
		for (int i = 0; i < sheepArray.length; i++) {
			if (sheepArray[i].getArrivalTime() == 0) {
				currentSheep = sheepArray[i];
				// Add first sheep
				s.addSheep(currentSheep);
				//Remove sheep from array
				sheepArray[i] = null;
			}
		}

		// If heap is not empty
		while (s.isDone() != true) {
			
			//Check to see if sheep should be arriving at this time, if so add sheep to minHeap
			if(currTime < sheepArray.length) {
				for(int i = 0; i < sheepArray.length; i++) {
					if(sheepArray[i] != null && sheepArray[i].getArrivalTime() == currTime) {
						//transfer sheep from sheepArray to minHeap
						s.addSheep(sheepArray[i]);
						sheepArray[i] = null;
					}
				}
			}
			//Start to sheer currentSheep
			s.advanceOneMinute();
			
			currTime++;
		}
		System.out.println();
	}
}
