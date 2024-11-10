public class MinHeap <T extends Comparable<T>> {
	private T[] heap;
	public static final int DEF_SIZE = 128;
	private int lastIndex; //First null Element
	
	//Default Constructor
	public MinHeap() {
		init(DEF_SIZE);
	}
	//Param Constructor
	public MinHeap(int size) {
		init(size);
	}
	
	private void init(int size) {
		if(size > 0) {
			heap = (T[])(new Comparable[size]);
			lastIndex = 0;
		}
		else
			init(DEF_SIZE);
	}
	
	public int size() {
		return lastIndex;
	}
	
	public void add(T aData) {
		if(lastIndex >= heap.length)
			return;
		heap[lastIndex] = aData;
		//bubbleup
		bubbleUp();
		lastIndex++;
	}
	private void bubbleUp() {
		int index = lastIndex;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index]) > 0) {
			//Swap
			T temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	
	public T remove() {
		if(lastIndex == 0) //Empty Tree
			return null;
		T ret = heap[0];
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		//bubble down
		bubbleDown();
		return ret;
	}
	private void bubbleDown() {
		int index = 0;
		while(index*2+1 < lastIndex) {
			int smallIndex = index*2+1; //Left Child
			if(index*2+2 < lastIndex && heap[index*2+1].compareTo(heap[index*2+2]) > 0)
				smallIndex = index*2+2;
			if(heap[index].compareTo(heap[smallIndex]) > 0) {
				//Swap
				T temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			else 
				break;
			index = smallIndex;
		}
	}
	
	public void print() {
		for(T h : heap) {
			if(h == null)
				break;
			System.out.println(h);
		}
	}
	
	public void heapSort(T[] array) {
		if(array == null)
			return;
		MinHeap<T> mHeap = new MinHeap<T>(array.length);
		for(int i = 0; i < array.length; i++) 
			mHeap.add(array[i]);
		for(int i = 0; i < array.length; i++)
			array[i] = mHeap.remove();
	}
	
	public boolean isEmpty() {
		if(lastIndex == 0)
			return true;
		return false;
	}
	
	// Observes first element without removing
	public T peek() {
		return heap[0];
	}
		
	//Observes last element without removing
	public T observe() {
		return heap[lastIndex-1];
	}
}
