class RightTriangle extends Shape {
	private double base;
	private double height;

	public RightTriangle(double aBase, double aHeight) {
		this.type = "Right Triangle";
		this.base = aBase;
		this.height = aHeight;
		this.area = area();
	}

	// Accessors
	public String getType() {
		return this.type;
	}

	public double getBase() {
		return this.base;
	}

	public double getHeight() {
		return this.height;
	}

	public double getArea() {
		return this.area;
	}

	// Mutators
	public void setBase(double aBase) {
		if (aBase > 0)
			this.base = aBase;
	}

	public void setHeight(double aHeight) {
		if (aHeight > 0)
			this.height = aHeight;
	}

	public String toString() {
		return "Right Triangle Base: " + this.base + " Height " + this.height + " Area: " + this.area;
	}

	// Calculate Area
	private double area() {
		return base * height / 2;
	}

}