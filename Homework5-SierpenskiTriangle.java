import java.awt.*;
import javax.swing.*;

public class SierpenskiTriangle extends Canvas{
	
	//Const, All triangles have a max & min number of points, being 3
	private static int NUM_OF_POINTS = 3;
	//Can be changed to make the frame bigger or smaller
	private static int FRAME_SIZE = 900;
	//Pixel Limit
	private static int PIXEL_LIMIT = 4;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sierpenski's Triangle");
		frame.setSize(FRAME_SIZE,FRAME_SIZE); //Creates size of Frame
		
		SierpenskiTriangle sierpenskiTriangle = new SierpenskiTriangle(); //Create new instance
		frame.add(sierpenskiTriangle);
		
		frame.setVisible(true); //Allows instance to be seen on frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Stops the program upon close of the window
	}
	
	public void paint(Graphics g) {
		//Sets intial cordinates to the top left starting position
		int x = 0;
		int y = 0;
		
		//Draws Initial Upward facing Black Triangle // Frame Size: 900x900
		int[] xCoordinates = {x, x+FRAME_SIZE/2, FRAME_SIZE}; // Array of x-coordinates of the vertices
		int[] yCoordinates = {FRAME_SIZE, y, FRAME_SIZE}; // Array of y-coordinates of the vertice
		g.fillPolygon(xCoordinates, yCoordinates, NUM_OF_POINTS);
		
		drawCarpet(x,y,FRAME_SIZE,g);
	}
	
	//Draws Downward facing White Triangle
	public void drawCarpet(int x, int y, int size, Graphics g) {
		int halfSize = size / 2; //Halfway point of current size, 450, 225, 112.5, 56.25, 28.125
		
		//Draws White Triangle Based on the inputs in the "drawCarpet" method
		int[] xCoordinates = {x+halfSize/2,x+halfSize,x+halfSize+halfSize/2};
		int[] yCoordinates = {y+halfSize, y+2*halfSize, y+halfSize};
			//Draw it
		g.setColor(Color.white);
		g.fillPolygon(xCoordinates, yCoordinates, NUM_OF_POINTS);
		
		//Recursive Calls
		if(halfSize >= PIXEL_LIMIT) { //Halting Condition
			//Top Triangle
			drawCarpet(x+halfSize/2,y,halfSize,g);
			//Left Triangle
			drawCarpet(x,y+halfSize,halfSize,g);
			//Right Triangle
			drawCarpet(x+halfSize,y+halfSize,halfSize,g);
		}
	}	
}