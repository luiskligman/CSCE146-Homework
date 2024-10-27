import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class GameManager {
	private Prize[] prizes;
	
	public static final int NUM_OF_PRIZES = 52; //52 prizes
	public static final String lineDELIM = "\n";
	public static final String tabDELIM = "\t";
	public static final int PRIZE_FIELD_AMT = 2;
	
	//Creating array of Prizes 
	public GameManager() {
		prizes = new Prize[NUM_OF_PRIZES];
	}
 
	//Adding Prize (name / price) to Prize array
	public void addPrize(Prize aPrize) {
		
		if(prizes[prizes.length-1] != null) //Tells us if the last index has value, meaning the array is full
		{
			return;
		}
		
		for(int i = 0; i < prizes.length; i++) {
			if(prizes[i] == null) {
				prizes[i] = aPrize;
				break;
			}
		}
		//TODO sort Prizes // To send all null values to the end of the array // 50:00
		this.sortPrizes();
	}
	
	public void readPrizeFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			
			String fileLine = fileScanner.nextLine(); //Reading each line up until "\n"
			String[] splitLines = fileLine.split(tabDELIM); //Splits the line everytime "\t" appears
			
			while(fileScanner.hasNextLine()) { 
				 fileLine = fileScanner.nextLine(); //Read the line
				 splitLines = fileLine.split(tabDELIM); //Split the Line
				 if(splitLines.length == PRIZE_FIELD_AMT) {
					 String name = splitLines[0];
					 double price = Double.parseDouble(splitLines[1]);
					 Prize aPrize = new Prize(name,price);
					 this.addPrize(aPrize);
				 }
			}
			fileScanner.close(); //Stops the scanning
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
	private void sortPrizes() {
		//Using Bubble Sort
		boolean swapped = true;
		while(swapped == true) {
			swapped = false;
			for(int i = 0; i < prizes.length - 1; i++) {
				if(prizes[i+1] == null) {
					break;
				}
				if(prizes[i].getPrice() > prizes[i+1].getPrice()) {//Out of Order: Swap
					Prize temp = prizes[i];
					prizes[i] = prizes[i+1];
					prizes[i+1] = temp;
					swapped = true;
				}
			}
		}
	}
	public void printPrizes() {
		for(Prize prize : prizes) {
			if(prize == null)
				break;
			System.out.println(prize);
		}
	}
	
	int total = 0;
	public void runGame() {
		System.out.println("Your prizes are:");
		
		//Gives 5 random Prizes 
		int i = 0;
		int numbers[] = new int[5]; 

		while (i < 5) {
		    Random random = new Random();
		    int randomNumber = random.nextInt(51);
		    boolean isDuplicate = false;

		    // Check if the generated number is already in the array
		    for (int j = 0; j < i; j++) {
		        if (numbers[j] == randomNumber) {
		            isDuplicate = true;
		            break;
		        }
		    }
		    
		    if (!isDuplicate) { // If the number is not a duplicate, add it to the array
		        numbers[i] = randomNumber;
		        System.out.println(prizes[numbers[i]].getName());
		        total += prizes[numbers[i]].getPrice();
		        i++;
		    }
		}
			
				
		System.out.println(total);
		}
	
//		User Guessing the price
	
	//Win or lose conditions
	public void Guess(int guess) {
		
		if(guess < total-1300) {
			System.out.println("The actual cost was "+total);
			System.out.println("Your guess was close, but not close enough. You lose.");
		}
		else if(guess < total && guess >= total-1300 || guess == total) {
			System.out.println("The actual cost was "+total);
			System.out.println("You win!!!");
		}
		else {
			System.out.println("The actual cost was "+total);
			System.out.println("Your guess was over. You lose");
		}
			
		
	}
	
	//Testing method to print all prizes with null sorted to the end 
	public void printAll() {
		for(int i = 0; i < prizes.length; i++) {
			System.out.println(prizes[i]);
		}
	}
}


	
	
	









