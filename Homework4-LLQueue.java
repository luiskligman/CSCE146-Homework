public class LLQueue<T> implements QueueI<T> {
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head; //First element in the queue
	private ListNode tail; //Last element in the queue
	private int size;
	
	//Default Constructor
	public LLQueue() {
		head = tail = null;
		this.size = 0;
	}
	
	//Adding to the end of the queue
	public void enqueue(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {
			head = tail = newNode;
			this.size = 1;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
		this.size++;
	}
	
	//Removing the first part of the queue
	public T dequeue() {
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		this.size--;
		return ret;
	}
	
	public int size() {
		return this.size;
	}
	
	//print out first object in the queue
	public T peek() {
		if(head == null)
			return null;
		return head.data;
	}
	
	//Print out entire linklist queue
	public void print() {
		for(ListNode temp = head; temp != null; temp = temp.link) 
			System.out.println(temp.data);
	}
}






