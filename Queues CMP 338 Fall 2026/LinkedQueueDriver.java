
public class LinkedQueueDriver {
	
	public static void main(String [] args) {
		
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		System.out.println("Should print null " + queue.peek());
		System.out.println("Should print null " + queue.dequeue());
		queue.enqueue(90);
		
		System.out.println("Should print 90 " + queue.peek());
		System.out.println("Should print 90 " + queue.dequeue());

		System.out.println("Should print null " + queue.peek());
		System.out.println("Should print null " + queue.dequeue());
		
		System.out.println("size is 0 " + queue.size());
		for(int i = 1; i <= 1000; i++) {
			queue.enqueue(i);
		}
		System.out.println("size should be 1000 ? " + queue.size());

		for(int i = 1; i <= 1000; i++) {
			System.out.println("Should print " + i + " "  + queue.dequeue());
		}
		System.out.println("size is 0 " + queue.size());
	}

}
