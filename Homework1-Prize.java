public class Prize {

	private String name;
	private double price;
	
	//Default constructor
	public Prize() {
		this.name = "none";
		this.price = 0.0;
	}
	
	//Param constructor
	public Prize(String aName, double aPrice) {
		this.setName(aName);
		this.setPrice(aPrice);
	}
	
	//Accessors
	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}
	
	//Mutators
	public void setName(String aName) {
		if(aName != null) {
			this.name = aName;
		}
		else {
			this.name = "none";
		}
	}

	public void setPrice(double aPrice) {
		if(aPrice >= 0.0) {
			this.price = aPrice;
		}
		else {
			this.price = 0.0;
		}
	}
	//To String
	public String toString() {
		return "Prize Name: "+this.name+" Prize  Price: $"+this.price;
	}
	
	//Equals
	public boolean equals(Prize aPrize) {
		return aPrize != null &&
				this.name.equals(aPrize.getName()) &&
				this.price == aPrize.getPrice();
	}
}