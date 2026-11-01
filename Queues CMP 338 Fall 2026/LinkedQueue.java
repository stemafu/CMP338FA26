import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements QueueInterface<E>{
	/*
	 * This queue is based on LinkedList
	 */
	
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	/*
	 * This constructor is used to create an empty linkedqueue.
	 */
	public LinkedQueue() {
		this.front = null;
		this.rear = null;
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
	public QueueInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		
		if(element == null) {
			throw new NullPointerException("Unable to add the new item because you provided a null element");
		}
		
		/*
		 * 1. Create a node to hold the value we want to add at the rear of the queue.
		 */
		
		Node<E> node = new Node<E>(element);
		
		/* Now that we have the node holding the value, next we need to add
		 * it to the rear of the queue
		 */
		
		if(this.isEmpty()) {
			this.front = node;
			this.rear = node;
			this.size++;
		}else {
			/* 
			 * point the current node to the new node
			 * 
			 */
			this.rear.setNext(node);
			
			// point the previous node the new node to the current rear
			node.setPrevious(this.rear);
			
			//Update the rear
			this.rear = node;
			this.size++;
		}
		
	}

	@Override
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}
		
		return this.front.getData();
	}

	@Override
	public E dequeue() {
		if(this.isEmpty()) {
			return null;
		}else {
			E removedElement = this.front.getData();
			
			if(this.size == 1) {
				this.removeAll();
				
			}else {
				this.front = this.front.getNext();
				this.front.setPrevious(null);
				this.size--;
			}
			
			
			return removedElement;
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		
		if (index < 0 || index >= this.size || index > (this.size - 1)) {
			throw new NoSuchElementException("Invalid index");
		}
		
		E removedElement = null;
		if(index == 0) {
			return this.dequeue();
		}else if(index == (this.size - 1)) {
			removedElement = this.rear.getData();
			
			this.rear =  this.rear.getPrevious();
			this.rear.setNext(null);
			this.size--;
			return removedElement;
		}else {
			
			Node<E> currentNode = this.front;
			int countCurrentNodeIndex = 0;
			
			while(countCurrentNodeIndex < index) {
				currentNode = currentNode.getNext();
				countCurrentNodeIndex++;
			}
			
			removedElement = currentNode.getData();
			
			Node<E> prevNode = currentNode.getPrevious();
			Node<E> nextNode = currentNode.getNext();
			
			prevNode.setNext(nextNode);
			nextNode.setPrevious(prevNode);
			
			currentNode.setNext(null);
			currentNode.setPrevious(null);
			this.size--;
			return removedElement;
			
		}
	}

	@Override
	public void removeAll() {
		
		this.front = null;
		this.rear = null;
		this.size = 0;
		
	}


}
