import java.util.Iterator;

public class ArrayBasedStack<E> implements StackInterface<E> {

	private final int ARRAY_CAPACITY = 10;
	private Object [] stackArray = null;
	private int size;
	/*
	 * The following constructor will be used to create
	 * an empty stack.
	 */
	public ArrayBasedStack() {
		this.stackArray = new Object[ARRAY_CAPACITY];
		this.size = 0;
	}
	
	public ArrayBasedStack(int capacity) {
		this.stackArray = new Object[capacity];
		this.size = 0;
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
	public StackInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		
		if(this.size == stackArray.length) {
			// This is only for fixed size array based stacks
			throw new IllegalStateException("The stack is full");
		}
		
		if(e == null) {
			throw new NullPointerException("The element you provided is NULL");
		}
		
		this.stackArray[this.size] = e;
		this.size++;
		
	}

	@Override
	public E peek() {
		
		if(this.isEmpty()) {
			return null;
		}
		
		
		return (E)this.stackArray[this.size - 1];
	}

	@Override
	public E pop() {
		if(this.isEmpty()) {
			return null;
		}else {
			// Get item from the top of the stack
			E removedElement = (E)this.stackArray[this.size - 1];
			this.size--;
			return removedElement;
		}
	}

	@Override
	public void clear() {
		this.stackArray = new Object[ARRAY_CAPACITY];
		this.size = 0;
	}

}
