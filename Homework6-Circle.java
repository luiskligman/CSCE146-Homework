class Circle extends Shape {

	private double radius;

	public Circle(double aRadius) {
		this.type = "Circle";
		this.radius = aRadius;
		this.area = area();
	}

	// Accessors
	public String getType() {
		return this.type;
	}

	public double getRadius() {
		return this.radius;
	}

	public double getArea() {
		return this.area;
	}

	// Mutators
	public void setRadius(double aRadius) {
		if (aRadius > 0)
			this.radius = aRadius;
	}

	public String toString() {
		return "Circle Radius: " + this.radius + " Area: " + this.area;
	}

	// Calculate Area
	private double area() {
		return radius * radius * Math.PI;
	}
}