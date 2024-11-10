public class Task {

	private int priority;
	private String action;
	
	//Default Constructor
	public Task() {
		this.priority = 4;
		this.action = "none";
	}
	
	//Param Constructor
	public Task(int aPriority, String aAction) {
		this.setPriority(aPriority);
		this.setAction(aAction);
	}
	
	//Getters
	public int getPriority() {
		return this.priority;
	}
	public String getAction() {
		return this.action;
	}
	
	//Mutators
	public void setPriority(int aPriority) {
		this.priority = aPriority;
	}
	public void setAction(String aAction) {
		this.action = aAction;
	}
	
	public String toString() {
		return "[Task] Priority: "+this.priority+" Task: "+this.action;
	}
	
	public boolean equals(Task aTask) {
		return aTask != null &&
				this.priority == aTask.getPriority() &&
				this.action.equals(aTask.getAction());
	}
}
