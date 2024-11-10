import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShapeTreeFE {
	
	public static final String DELIM = "\t";
	
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Creates instance of LinkedBSTree of Fruit
		LinkedBST<Shape> iBST = new LinkedBST<Shape>();
		
		boolean quit = false;
		while(quit != true ) {
			welcomeMessage();
			int userChoice = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(userChoice) {
			case 1:
				readShapeFile(iBST);
				break;
			case 2: 
				printShapeTree(iBST);
				break;
			case 3:
				addShape(iBST);
				break;
			case 4: 
				removeShape(iBST);
				break;
			case 5: 
				searchTree(iBST);
				break;
			case 6:
				findMaxArea(iBST);
				break;
			case 7:
				removeShapesGreaterThan(iBST);
				break;
			case 8:
				writeShapeFile(iBST);
				break;
			case 0:
				//Quit
				quit = true;
				p("GoodBye!");
				break;
			}
		System.out.println();
		}
	}
	public static void writeShapeFile(LinkedBST<Shape> iBST) {
		p("Enter the file's name");
		String fileName = keyboard.nextLine();
		writeShapeFile(fileName, iBST);
	}
	
	public static void removeShapesGreaterThan(LinkedBST<Shape> iBST) {
		p("Enter the maximum area");
		int area = keyboard.nextInt();
		keyboard.nextLine();
		iBST.removeGreatherThan(area);
	}
	
	public static void findMaxArea(LinkedBST<Shape> iBST) {
		iBST.findMax();
	}

	public static void searchTree(LinkedBST<Shape> iBST) {
		p("Enter the type of shape to Search");
		String type = keyboard.nextLine();
		if(type.equalsIgnoreCase("rectangle")) {
			p("Enter the length followed by the width");
			double length = keyboard.nextDouble();
			keyboard.nextLine();
			double width = keyboard.nextDouble();
			keyboard.nextLine();
			
			Rectangle rectangle = new Rectangle(length, width);
			p("Was the shape in the tree? "+iBST.search(rectangle));
		}
		else if(type.equalsIgnoreCase("circle")) {
			p("Enter the radius");
			double radius = keyboard.nextDouble();
			keyboard.nextLine();
			
			Circle circle = new Circle(radius);
			p("Was the shape in the tree? "+iBST.search(circle));
			
		}
		else if(type.equalsIgnoreCase("right triangle")) {
			p("Enter the base followed by the height");
			double base = keyboard.nextDouble();
			keyboard.nextLine();
			double height = keyboard.nextDouble();
			keyboard.nextLine();
			
			RightTriangle rightTriangle = new RightTriangle(base, height);
			p("Was the shape in the tree? "+iBST.search(rightTriangle));
		}
	}
	
	public static void removeShape(LinkedBST<Shape> iBST) {
		p("Enter the type of shape to remove");
		String type = keyboard.nextLine();
		if(type.equalsIgnoreCase("rectangle")) {
			//Getting Parameters
			p("Enter the length followed by the height");
			double length = keyboard.nextDouble();
			keyboard.nextLine();
			double width = keyboard.nextDouble();
			keyboard.nextLine();
			
			//Adding Object
			Rectangle rectangle = new Rectangle(length, width);
			iBST.remove(rectangle);
		}
		else if(type.equalsIgnoreCase("circle")) {
			//Getting parameters
			p("Enter the radius");
			double radius = keyboard.nextDouble();
			keyboard.nextLine();
			
			//Adding Object
			Circle circle = new Circle(radius);
			iBST.remove(circle);
		}
		else if(type.equalsIgnoreCase("right triangle")) {
			//Getting parameters
			p("Enter the base followed by the height");
			double base = keyboard.nextDouble();
			keyboard.nextLine();
			double height = keyboard.nextDouble();
			keyboard.nextLine();
			
			//Adding Object
			RightTriangle triangle = new RightTriangle(base, height);
			iBST.remove(triangle);
		}
		else
			p("Invalid Input");
	}
	
	public static void addShape(LinkedBST<Shape> iBST) {
		p("Enter the type of shape to add");
		String addType = keyboard.nextLine();
		
		//Rectangle
		if(addType.equalsIgnoreCase("rectangle")) {
			//Getting Parameters
			p("Enter the length followed by the height");
			double length = keyboard.nextDouble();
			keyboard.nextLine();
			double width = keyboard.nextDouble();
			keyboard.nextLine(); 
			
			//Adding Object
			Rectangle rectangle = new Rectangle(length, width);
			iBST.add(rectangle);
		}
		else if(addType.equalsIgnoreCase("circle")) {
			//Getting parameters
			p("Enter the radius");
			double radius = keyboard.nextDouble();
			keyboard.nextLine();
			
			//Adding Object
			Circle circle = new Circle(radius);
			iBST.add(circle);
		}
		else if(addType.equalsIgnoreCase("right triangle")) {
			//Getting parameters
			p("Enter the base followed by the height");
			double base = keyboard.nextDouble();
			keyboard.nextLine();
			double height = keyboard.nextDouble();
			keyboard.nextLine();
			
			//Adding Object
			RightTriangle triangle = new RightTriangle(base, height);
			iBST.add(triangle);
		}
		
	}
	
	public static void printShapeTree(LinkedBST<Shape> iBST) {
		p("Which traversal?");
		p("Enter 1. For Pre-order");
		p("Enter 2. For In-order");
		p("Enter 3. For Post-order");
		
		int userChoice = keyboard.nextInt();
		switch(userChoice) {
		case 1:
			iBST.printPreorder();
			break;
		case 2:
			iBST.printInorder();
			break;
		case 3:
			iBST.printPostorder();
			break;
		}
	}
	
	public static void readShapeFile(LinkedBST<Shape> iBST) {
		//Reading File
		p("Enter the file's name");
		//String fileName = keyboard.nextLine();
		String fileName = keyboard.nextLine();
		readShapeFile(fileName, iBST);
		
		//Printing after Reading In-Order
		p("Printing after Reading In-Order");
		iBST.printInorder();
	}
	
	//Write File
	public static void writeShapeFile(String fileName, LinkedBST<Shape> iBST) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writeShapeNode(writer, iBST.root); //Starts at root
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

	private static void writeShapeNode(FileWriter writer, LinkedBST<Shape>.Node node) throws IOException {
		 if (node != null) {
	            Shape shape = node.data;
	            if (shape != null) {
	                writer.write(formatShapeInfo(shape));
	                writer.write("\n");
	            }
	            writeShapeNode(writer, node.leftChild);
	            writeShapeNode(writer, node.rightChild);
	        }
	}
	
	//Takes shape and formats its data depending on what shape it is
	private static String formatShapeInfo(Shape shape) {
        String type = shape.getType();
        switch (type.toLowerCase()) {
            case "rectangle":
                Rectangle rectangle = (Rectangle) shape;
                return "Rectangle" + DELIM + rectangle.getLength() + DELIM + rectangle.getWidth();
            case "circle":
                Circle circle = (Circle) shape;
                return "Circle" + DELIM + circle.getRadius();
            case "right triangle":
                RightTriangle triangle = (RightTriangle) shape;
                return "Right Triangle" + DELIM + triangle.getBase() + DELIM + triangle.getHeight();
        }
		return "Error in formatShapeInfo method";
    }
	
	//Read File
	public static void readShapeFile(String aFileName, LinkedBST<Shape> iBST) {
		try {
			Scanner fileScanner = new Scanner(new File(aFileName));
			//READ
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine(); //Read the Line
				String[] splitLines = fileLine.split(DELIM); //Split the line based on DELIM value
				if(splitLines.length > 0) {
					String shapeType = splitLines[0];
					switch(shapeType) {
					
					case "Rectangle":
						if(splitLines.length == 3) {
							double length = Double.parseDouble(splitLines[1]);
							double width = Double.parseDouble(splitLines[2]);
							Rectangle rectangle = new Rectangle(length, width);
							iBST.add(rectangle);
						}
						break;
					case "Circle":
						if(splitLines.length == 2) {
						double radius = Double.parseDouble(splitLines[1]);
						Circle circle = new Circle(radius);
						iBST.add(circle);
						}
						break;
					case "Right Triangle":
						if(splitLines.length == 3) {
							double base = Double.parseDouble(splitLines[1]);
							double height = Double.parseDouble(splitLines[2]);
							RightTriangle rightTriangle = new RightTriangle(base, height);
							iBST.add(rightTriangle);
						}
						break;
					}
				}
			}
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void welcomeMessage() {
		p("Welcome to the Shape Tree!");
		p("Enter 1. To Read a Shape Tree from a File.");
		p("Enter 2. To Print a Tree Traversal to the Console");
		p("Enter 3. To Add a Shape.");
		p("Enter 4. To Remove a Shape.");
		p("Enter 5. To Search for a Shape.");
		p("Enter 6. To Find the Shape with the Max Area.");
		p("Enter 7. To Remove All Shapes Greater than an Area.");
		p("Enter 8. To Print Shape Tree to File.");
		p("Enter 0. To Quit.");
	}
	
	public static void p(String aString) {
		System.out.println(aString);
	}
	public static void p(Boolean aBoolean) {
		System.out.println(aBoolean);
	}

}
