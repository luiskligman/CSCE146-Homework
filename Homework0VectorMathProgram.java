import java.util.Scanner;

public class VectorMathProgram {

	// System.out.println methods
	public static void p(String message) {
		System.out.println(message);
	}

	public static void p(int number) {
		System.out.println(number);
	}

	public static void p(double value) {
		System.out.println(value);
	}

	public static void main(String[] args) {
		p("Welcome to the Vector Operations Program!");
		int loop = 0;
		while (loop == 0) {
			// Initial Dialog
			p("Enter 1. To Add 2 Vectors");
			p("Enter 2. To Subtract 2 Vectors");
			p("Enter 3. To Find the Magnitude of a Vector");
			p("Enter 9. To Quit");

			Scanner UserInput = new Scanner(System.in);
			int userInput = UserInput.nextInt();

			// Adding 2 Vectors
			if (userInput == 1) {
				// Creating the Vectors and Establishing their sizes
				p("Enter the size of the Vectors");
				Scanner vectorSize = new Scanner(System.in);
				int vS = vectorSize.nextInt();
				if (vS <= 0) {
					p("Invalid Size");
				} 
				else {
					double[] vector1 = new double[vS];
					double[] vector2 = new double[vS];

					// Populating the Vectors
					p("Enter values for Vector1");
					for (int j = 0; j < vS; j++) {
						Scanner vectorValue = new Scanner(System.in);
						vector1[j] = vectorValue.nextDouble();
					}
					p("Enter values for Vector2");
					for (int j = 0; j < vS; j++) {
						Scanner vectorValue = new Scanner(System.in);
						vector2[j] = vectorValue.nextDouble();
					}

					// Printing out the Vectors
					p("Result:");
					for (int j = 0; j < vector1.length; j++) {
						p(vector1[j]);
					}

					p("+");

					for (int j = 0; j < vector2.length; j++) {
						p(vector2[j]);
					}

					p("=");

					// Adding the Vectors and returning Sum
					double[] sum = new double[vS];
					for (int j = 0; j < vS; j++) {
						sum[j] = vector1[j] + vector2[j];
						p(sum[j]);
					}
				}
			} 
			else if (userInput == 2) {
				p("Enter the size of the Vectors");
				Scanner vectorSize = new Scanner(System.in);
				int vS = vectorSize.nextInt();
				if (vS <= 0) {
					p("Invalid Size");
				} 
				else {
					double[] vector1 = new double[vS];
					double[] vector2 = new double[vS];

					// Populating the Vectors
					p("Enter values for Vector1");
					for (int j = 0; j < vS; j++) {
						Scanner vectorValue = new Scanner(System.in);
						vector1[j] = vectorValue.nextDouble();
					}
					p("Enter values for Vector2");
					for (int j = 0; j < vS; j++) {
						Scanner vectorValue = new Scanner(System.in);
						vector2[j] = vectorValue.nextDouble();
					}

					// Printing out the Vectors
					p("Result:");
					for (int j = 0; j < vector1.length; j++) {
						p(vector1[j]);
					}
					
					p("-");
					for (int j = 0; j < vector2.length; j++) {
						p(vector2[j]);
					}

					p("=");

					// Subtacting the vectors and printing the Difference
					double[] difference = new double[vS];
					for (int j = 0; j < vS; j++) {
						difference[j] = vector1[j] - vector2[j];
						p(difference[j]);
					}

				}
			} 
			else if (userInput == 3) {
				p("Enter the size of the Vectors");
				Scanner vectorSize = new Scanner(System.in);
				int vS = vectorSize.nextInt();
				if (vS <= 0) {
					p("Invalid Size");
				} 
				else {
					double[] magnitude = new double[vS];

					// Populating the Vector
					p("Enter values for the Vector");
					Scanner magnitude1 = new Scanner(System.in);
					for (int j = 0; j < vS; j++) {
						magnitude[j] = magnitude1.nextDouble();
					}
					// Squaring then adding the values
					double sum1 = 0;
					for (int j = 0; j < vS; j++) {
						sum1 += magnitude[j] * magnitude[j];
					}
					// Square rooting the total
					double total = Math.sqrt(sum1);

					p("The magnitude is: " + total);
				}
			} 
			else if (userInput == 9) {
				p("GoodBye!");
				loop++;
			} 
		}
	}
}
