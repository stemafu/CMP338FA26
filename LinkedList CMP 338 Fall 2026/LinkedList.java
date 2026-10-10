
public class LinkedList <I extends Comparable<? super I>> implements ListInterface<I>{

	/*
	 * A linkedlist consists of nodes. 
	 * 
	 * The first node in the linkedlist is called the head
	 * and the last node in the linkedlist is called the tail.
	 * 
	 * We also need to keep track of the size of the linkedlist
	 */
	
	private Node<I> head;
	private Node<I> tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	
	
	@Override
	public ListInterface<I> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public void add(I element) {
		
		/*
		 * We want to insert a new element into the linkedlist,
		 * the first thing we will do is to create a new node
		 */
		
		Node<I> node = new Node<I>(element);
		
		/*
		 * Now link the new node to the linkedlist.
		 */
		
		if(this.isEmpty()) {
			this.head = node;
			this.tail = node;
			this.size++;
		}else {
			this.tail.setNext(node);
			this.tail = node;
			this.size++;
		}
		
		
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSorted(I element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		
		/*
		 * Unlike arrays where we are able to access values at a random because
		 * values inside arrays are stored in a contiguous way; in LinkedList
		 * values are scattered across the memory.
		 * 
		 * Nodes where values are kept just contain address to the next nodes
		 * to form a chain structure.
		 * 
		 * So in linkedlist, if we want to access a value an an index, we 
		 * have to loop to that index
		 */
		
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("You provided an invalid index " + index);
		}
		
		I element = null; 
		
		if(index == 0) {
			element = this.head.getData();
			return element;
		}else if(index == this.size - 1) {
			element = this.tail.getData();
			return element;
		}else {
			
			int currentNodeCounter = 0;
			Node<I> currentNode = this.head;
			
			while(currentNodeCounter < index) {
				currentNode = currentNode.getNext();
				currentNodeCounter++;
			}
			
			element = currentNode.getData();
			return element;
		}
		

	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("You provided an invalid index " + index);
		}
		
		I replacedElement = null; 
		
		if(index == 0) {
			replacedElement = this.head.getData();
			this.head.setData(element);
			return replacedElement;
		}else if(index == this.size - 1) {
			replacedElement = this.tail.getData();
			this.tail.setData(element);
			return replacedElement;
		}else {
			
			int currentNodeCounter = 0;
			Node<I> currentNode = this.head;
			
			while(currentNodeCounter < index) {
				currentNode = currentNode.getNext();
				currentNodeCounter++;
			}
			
			replacedElement = currentNode.getData();
			currentNode.setData(element);
			return replacedElement ;
		}
		
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		
	}

}
