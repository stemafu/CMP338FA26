
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
	
	public void setNext(Node<I> next) {
		this.next = next;
	}
	
	public I getData() {
		return this.data;
	}
	public Node<I> getNext() {
		return this.next;
	}

}
