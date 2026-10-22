import java.util.Iterator;
import java.util.Vector;

public class LinkedBasedStack<E> implements StackInterface<E>{

	/* 
	 * The instance variable top will point to the top of the stack.
	 * Top points to the node that is at the top of the stack
	 * 
	 * The instance variable bottom points to the node that is at the
	 * bottom of the stack
	 * 
	 * size keeps track of the number of items(elements) that have been 
	 * pushed to the stack.
	 */
	
	private Node<E> bottom;
	
	private Node<E> top;
	
	private int size;
	
	
	/*
	 * This constructor is used to create an empty LinkedBasedStack
	 */
	public LinkedBasedStack() {
		this.bottom = null;
		this.top = null;
		this.size = 0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		
		/*
		 * take the values from the linkedBasedstack
		 * and store in a vector.
		 * 
		 * Create an elementiterator with this vector
		 * as a parameter
		 * 
		 * and return that
		 */
		
		Vector<E> vector = new Vector<E>();
		
		Node<E> head = this.top;
		
		while (head != null) {
			vector.add(head.getData());
			head = head.getPrevious();
		}
		
		
		Iterator<E> it = new ElementIterator<E>(vector);
		
		
		return it;
	}

	@Override
	public boolean isEmpty() {
		/*
		 *  We can use one of the following boolean expression to see if the
		 *  LinkedBasedStack is empty
		 */
		return (this.top == null || this.size == 0);
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

		if(e == null) {
			throw new NullPointerException("The element you provided is NULL");
		}

		// Create the node for the given element first
		Node<E> node = new Node<E>(e);
		if(this.isEmpty()) {
			this.bottom = node;
			this.top = node;
			this.size++;
		}else {
			this.top.setNext(node);
			node.setPrevious(this.top);

			this.top = node;
			this.size++;
		}
		
	}

	@Override
	public E peek() {
		
		if(this.isEmpty()) {
			return null;
		}else {
			return this.top.getData();
		}
		
		
	}

	@Override
	public E pop() {

		if(this.isEmpty()) {
			return null;
		}else {
			 E removedElement = this.peek();
			
			if(this.size == 1) {
				this.clear();
				return removedElement;
			}else {
				
				Node<E> removedNode = this.top;
				this.top = top.getPrevious();
				this.top.setNext(null);
				removedNode.setPrevious(null);
				this.size--;
				
				return removedElement;
				
				/* We have to loop to find the next top. This is 
				 * when you are using a singly- linked list.
				 * 
				 * When we use singly-linked list to implement a LinkedBasedStack,
				 * the top does not have a link to the previous node as such
				 * we need to loop to find the node that will become the new top.
				 * 
				 * When we use the singly-linked list for the LinkedBasedStack, the
				 * this method requires O(N) in the worst case.
				 * 
				 * We can improve this with the use of  Doubly-Linked List.
				 * See the improved implementation above that uses doubly linked list
				 * Now, pop takes O(1)
				 */
				
				/*
				 // This takes o(n)
				while(currentNode.getNext() != this.top) {
					currentNode = currentNode.getNext();
				}
				
				this.top = currentNode;
				this.top.setNext(null);
				this.size--;
				return removedElement;
				
				*/
				
			}
		}
	}

	@Override
	public void clear() {
		this.bottom = null;
		this.top = null;
		this.size = 0;
	}

}
