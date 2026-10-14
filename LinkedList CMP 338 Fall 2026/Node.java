
public class Node  <I extends Comparable<? super I>> {
	/*
	 * A linkedlist list node consists of
	 * 1. data
	 * 2. a link to the next node
	 */
	
	// variable for storing data
	private I data;
	
	// variable for keeping an address to the next node
	private Node<I> next;
	
	
	public Node(I data) {
		this.data = data;
		this.next = null;
	}
	
	public void setData(I data) {
		this.data = data;
	}
	
	/*
	 * Set the next node that comes after this node.
	 */
	public void setNext(Node<I> next) {
		this.next = next;
	}
	
	public I getData() {
		return this.data;
	}
	
	/*
	 * Get the address of the next node.
	 * This is the node that comes after this node.
	 */
	public Node<I> getNext() {
		return this.next;
	}

}
