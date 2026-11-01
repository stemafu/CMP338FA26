import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBasedQueue <E> implements QueueInterface<E> {
	
	private final int ARRAY_CAPACITY = 10;
	private Object [] array;
	private int size;
	
	private int front;
	private int rear;


	/*
	 * This constructor is used to create an empty queue
	 */
	public ArrayBasedQueue() {
		this.array = new Object[ARRAY_CAPACITY];
		this.size = 0;
		this.front = -1;
		this.rear = -1;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return (this.size == 0);
	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public QueueInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
	
		if(this.size == this.array.length) {
			throw new IllegalStateException("We cannot add the given element because the queue is full");
		}
		
		if(element == null) {
			throw new NullPointerException("Cannot add a null element");
		}
		
		
		this.rear = (this.rear + 1) % this.array.length;
		this.array[this.rear] = element;
		this.size++;
		
		
		/*if(this.isEmpty()) {
			this.rear = 0;
			//this.front = 0;
			
		
			this.array[this.rear] = element;
			this.size++;
		}else {

			
		}*/
		
	}

	@Override
	public E peek() {
		
		if(this.isEmpty())
			return null;
		else
			return (E)this.array[this.front];
	}

	@Override
	public E dequeue() {

		if(this.isEmpty())
			return null;
		
		else {
			
			this.front = (this.front + 1) % this.array.length;
			
			E removedElement = (E)this.array[this.front];
			
			this.size--;
			/*
			 * When we dequeue from a queue we have multiple options for
			 * managing the elements that are inside the queue
			 * 
			 * Option 1 involves shifting the remaining values forward
			 * so that front would always be at index 0. 
			 * The main problem of this solution is that in runs in O(n).
			 * 
			 * Option 2 involves incrementing the front to the next index.
			 * This would be O(1). The major problem of this solution is that
			 * you waste space at previous fronts at they cannot be reused once
			 * you have removed elements.
			 * 
			 * Option 3 we can improve option 2 so that that we implement our
			 * queue as a circular array. We create the index for both front and
			 * back to wrap around the end of the array.
			 * 
			 * In this example, we use option 3.
			 */
			
			
			
			return removedElement;
			
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

}
