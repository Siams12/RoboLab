import java.util.ArrayList;

public class QueueImplementation<T> implements Queue<T> {
	private ArrayList<T> Queue = new ArrayList<T>(); 

	public void add(T item){
		Queue.add(item);
			
	
		}
	
	
	public T remove() {
		int Size = Queue.size();
		if (Size != 0) {
		T front_item = Queue.remove(0);
		return front_item;
		}
		else {
			return null;

		}
	}
	
	public boolean isEmpty() {
		if (Queue.size() == 0)  {
			return true;
		}
		return false;
		
	}
	public T Peek() {
		if (isEmpty() == false){
		return Queue.get(0);
		}
		else {
		return null;
		}
	}
	public ArrayList<T> peekAll() {
		if (isEmpty() == false) {
				return Queue;
			
		}
		return null;
	}
	

}

