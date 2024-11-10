class Rectangle extends Shape {
	private double length;
	private double width;

	// Param Constructor
	public Rectangle(double aLength, double aWidth) {
		this.type = "Rectangle";
		this.length = aLength;
		this.width = aWidth;
		this.area = area();
	}

	// Accessors
	public String getType() {
		return this.type;
	}

	public double getLength() {
		return this.length;
	}

	public double getWidth() {
		return this.width;
	}

	public double getArea() {
		return this.area;
	}

	// Mutators
	public void setLength(double aLength) {
		if (aLength > 0)
			this.length = aLength;
	}

	public void setWidth(double aWidth) {
		if (aWidth > 0)
			this.width = aWidth;
	}

	public String toString() {
		return "Rectangle Length: " + this.length + " Width: " + this.width + " Area: " + this.area;
	}

	// Calculate Area
	private double area() {
		return length * width;
	}

}