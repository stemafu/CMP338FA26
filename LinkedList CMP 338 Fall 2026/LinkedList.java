
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
			/*
			 * Link the new node to the existing
			 * linked list.
			 */
			this.tail.setNext(node);
			
			/* Once we have linked the new node to the existing
			 * linked list, we update the tail.
			 */
			this.tail = node;
			this.size++;
		}
		
		
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		
		
		/*
		 * As  we already know linkedlist have no specific
		 * indexes as arrays do. So Linkedlist do not have
		 * random access. In order for us to insert (add)\
		 * an element at a given index, we have to first 
		 * loop (iterate) to the node where we want to insert
		 * and once we find the node we can be able to insert
		 * 
		 */
		
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		}
		
		
		if(index == this.size) {
			// This means we want to add at the tail
			this.add(element);
		}else {
			//The head
			Node<I> node = new Node<I>(element);
			if (index == 0) {
				/*
				 * We are linking the new node to the 
				 * existing linkedlist by pointing to the
				 * current head
				 */
				node.setNext(this.head);
				//Update head
				// The new node becomes the new head of the linkedlist
				this.head = node;
				this.size++;
				
			}else {
				/* we want to use this to insert at a node
				 * that is not the head or the tail.
				 * 
				 * Since nodes are not contiguous, they 
				 * scattered through the memory, we have to
				 * iterate to the node where we have to insert
				 * so that we can be able to link the new node.
				 */
				
				Node <I> previousNode = null;
				
				Node <I> currentNode = this.head;
				int currentNodeIndex = 0;
				
				
				while(currentNodeIndex < (index - 1)) {
					//previousNode = currentNode; 
					currentNode = currentNode.getNext();
					currentNodeIndex++;
				}
				
				
				//Node<I> nextOfNewNode = currentNode.getNext();
				node.setNext(currentNode.getNext());
				currentNode.setNext(node);
				
				//previousNode.setNext(node);
				//node.setNext(currentNode);
				
				
				this.size++;
			}
			
		}
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
		
		
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("You provided an invalid index " + index);
		}
		
		I removedElement = null;
		
		
		
		/*
		 * 		if(this.size == 1 && index == 0) {
			removedElement = this.head.getData();
			removeAll();
		}else if (index == 0) {
			removedElement = this.head.getData();
			this.head = this.head.getNext();
			this.size--;
		
		 */
		if(index == 0) {
			if(this.size == 1) {
				removedElement = this.head.getData();
				removeAll();
			}else {
				removedElement = this.head.getData();
				this.head = this.head.getNext();
				this.size--;
			}
		}else {
			
			
			int currentNodeCounter = 0;
			Node<I> currentNode = this.head;
			Node<I> previousNode = null;
			
			while(currentNodeCounter < index) {
				//Make the currentNode to be the previous of the future next node
				previousNode = currentNode;
				currentNode = currentNode.getNext();
				currentNodeCounter++;
			}
			
			removedElement = currentNode.getData();
			if(index == this.size - 1) {
				// remove the tail
				this.tail = previousNode;
				previousNode.setNext(null);
				this.size--;
			}else {
				previousNode.setNext(currentNode.getNext());
				currentNode.setNext(null);
				this.size--;
			}
			
		}
		
		
		return removedElement;
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		
	}

}
