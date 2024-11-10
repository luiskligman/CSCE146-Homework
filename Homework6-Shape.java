class Shape implements Comparable<Shape> {
	public String type;
	public double area;
	
	public double length;
	public double width;
	
	public double base;
	public double height;
	
	public double radius;
	
	public void removeGreaterThan(int aMax) {
		
	}
	
	public double getArea() {
		return this.area;
	}
	
	public int compareTo(Shape aShape) {
		if(this.area > aShape.area) { //This shape has a greater area than the given shape 
			//System.out.println("1");
			return 1;
		}
		else if(this.area < aShape.area) {//This shape has a lesser area than the given shape
			//System.out.println("2");
			return -1;
		}
		
		//Shapes have equal area, Comparing type
		else if(this.type.compareTo(aShape.type) < 0) {
			System.out.println("3");
			return -1;
		}
			
		else if(this.type.compareTo(aShape.type) > 0) {
			System.out.println("4");
			return 1;
		}
		//else This is the shape
		else {
			return 0;
		}
	}

	public String getType() {
		return this.type;
	}
}
	
