public class Sheep implements Comparable<Sheep> {
	private String name;
	private int shearingTime;
	private int arrivalTime;
	
	public Sheep(String aName, int aShearingTime, int aArrivalTime) {
		this.setName(aName);
		this.setShearingTime(aShearingTime);
		this.setArrivalTime(aArrivalTime);
	}
	
	//Accessors
	public String getName() {
		return this.name;
	}
	public int getShearingTime() {
		return this.shearingTime;
	}
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	//Mutators
	public void setName(String aName) {
		if(aName != null)
			this.name = aName;
	}
	public void setShearingTime(int aShearingTime) {
		this.shearingTime = aShearingTime;
	}
	public void setArrivalTime(int aArrivalTime) {
		this.arrivalTime = aArrivalTime;
	}
	
	public String toString() {
		return "Name: "+this.name+" ShearingTime: "+this.shearingTime+" ArrivalTime:"+
				this.arrivalTime;
	}

	public int compareTo(Sheep aSheep) {
		//Compare shearing time first, then by name
		if(this.shearingTime > aSheep.shearingTime) //This sheep has a greater shearing tine than aSheep
			return 1;
		else if(this.shearingTime < aSheep.shearingTime) //This sheep has a lesser shearing tine than aSheep
			return -1;
		else if(this.shearingTime == aSheep.shearingTime) { //Sheering times are the same, compare by name
			if(this.name.compareTo(aSheep.name) > 0)
				return 1;
			else if(this.name.compareTo(aSheep.name) < 0) 
				return -1;
		}
		return 0;
	}
	
	public void shearForOneMinute() {
		this.shearingTime--;
	}
}
