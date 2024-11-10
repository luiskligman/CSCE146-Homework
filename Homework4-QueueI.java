public interface QueueI <T> {
	public void enqueue(T aData); //Add to end
	public T dequeue(); //Remove from beginning
	public T peek();
	public void print();
	public int size();
}
