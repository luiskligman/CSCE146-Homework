public class GenLL <T> {
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head; //First element of the list
	private ListNode current;//Movable iterator / current node of interest
	private ListNode previous;//One node behind current / previous.link == current
	public GenLL() {
		head = current = previous = null;
	}
	
	public void add(T aData) { //Adds to the end of the list
		//Create a new node with the data
		ListNode newNode = new ListNode(aData,null);
		
		//Add the node to the list
		if(head == null) //Empty list
		{
			head = current = newNode;
			return;
		}
		
		//Linking newNode to the list
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
		
	}
	
	//Printout the data
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	//Create an accessor
	public T getCurrent()
	{
		if(current == null)
			return null;
		return current.data;
	}
	
	//Mutator
	public void setCurrent(T aData)
	{
		if(current == null)
			return;
		current.data = aData;
	}
	
	//Moving Current forward
	public void gotoNext()
	{
		if(current == null)
			return;
		previous = current;
		current = current.link;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	
	public boolean hasMore()
	{
		return current != null;
	}
	
	//Removing node
	public void removeCurrent()
	{
		if(head == current)
		{
			head = head.link;
			current = head;
		}
		else
		{
			//Skipping over "current"
			previous.link = current.link;
			current = current.link;
		}
	}
}




