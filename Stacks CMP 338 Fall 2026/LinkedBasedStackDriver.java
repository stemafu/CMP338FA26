import java.util.Iterator;

public class LinkedBasedStackDriver {

	public static void main(String[] args) {
		LinkedBasedStack<Integer> stack;
		stack = new LinkedBasedStack<Integer>();
		
		
		System.out.println("This should print true: " + stack.isEmpty());
		System.out.println("This should print 0: " + stack.size());
		System.out.println("This should print null: " + stack.peek());
		stack.push(90);
		System.out.println("This should print false: " + stack.isEmpty());
		System.out.println("This should print 1: " + stack.size());
		System.out.println("This should print 90: " + stack.peek());
		stack.push(40);
		System.out.println("This should print 40: " + stack.peek());
		System.out.println("This should print 2: " + stack.size());
		stack.push(75);
		System.out.println("This should print 75: " + stack.peek());
		System.out.println("This should print 3: " + stack.size());
		
		
		System.out.println("This should print 75: " + stack.pop());
		System.out.println("This should print 2: " + stack.size());
		
		System.out.println("This should print 40: " + stack.pop());
		System.out.println("This should print 1: " + stack.size());
		
		System.out.println("This should print 90: " + stack.pop());
		System.out.println("This should print 0: " + stack.size());		
	
		stack.push(90);
		stack.push(40);
		stack.push(50);
		Iterator<Integer> it = stack.iterator();
		
		System.out.println("Using iterator");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
	}

}
