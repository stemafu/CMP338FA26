import java.util.Iterator;

public class DummyNodeLinkedBasedStack<E> implements StackInterface<E> {

	
	private Node<E> bottom;
	
	private Node<E> top;
	
	private int size;
	
	
	public DummyNodeLinkedBasedStack() {
		Node<E> dummyNode = new Node<E>(null);
		
		/*
		 * The dummy will be the first node in the
		 * linkedlist
		 */
		this.bottom = dummyNode;
		this.top = dummyNode;
		
		this.size = 0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public StackInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		
		
		if(e == null) {
			throw new NullPointerException("The element you provided is NULL");
		}
		// Create the node for the given element first
		Node<E> node = new Node<E>(e);
		this.top.setNext(node);
		node.setPrevious(this.top);
		this.top = node;
		this.size++;
		
	}

	@Override
	public E peek() {
		
		/*if(this.isEmpty()) {
			return null;
		}*/
		
		return this.top.getData();
	}

	@Override
	public E pop() {
		if(this.isEmpty()) {
			return null;
		}
		
		E removedElement = this.top.getData();
		
		this.top = this.top.getPrevious();
		this.top.setNext(null);
		
		this.size--;
		
		return removedElement;
	}

	@Override
	public void clear() {
		this.bottom = null;
		this.top = null;
		this.size = 0;
		
	}

}
