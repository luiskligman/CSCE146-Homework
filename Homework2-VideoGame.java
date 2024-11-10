public class VideoGame {

	private String name;
	private String console;
	
	//Default Constructor
	public VideoGame() {
		this.name = this.console = "none";	
	}
	
	//Param Constructor
	public VideoGame(String aName, String aConsole) {
		this.setName(aName);
		this.setConsole(aConsole);
	}
	
	//Accessors
	public String getName() {
		return this.name;
	}
	public String getConsole() {
		return this.console;
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
	public void setConsole(String aConsole) {
		if(aConsole != null) {
			this.console = aConsole;
		}
		else {
			this.console = "none";
		}
	}
	
	public String toString() {
		return this.name+" "+this.console;
	}
	
	
	public boolean equals(VideoGame aVideoGame) {
		return aVideoGame != null &&
				this.name.equals(aVideoGame.getName()) &&
				this.console.equals(aVideoGame.getConsole());
	}
}
