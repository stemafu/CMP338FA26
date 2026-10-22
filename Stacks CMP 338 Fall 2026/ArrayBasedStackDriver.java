
public class ArrayBasedStackDriver {

	public static void main(String[] args) {
		
		
		ArrayBasedStack<Integer> stack;
		
		stack = new ArrayBasedStack<Integer>();
		
		
		System.out.println("peek() from empty stack should null = " + stack.peek());
		System.out.println("pop() from empty stack should null = " + stack.pop());

		
		stack.push(90);
		
		System.out.println("peek() from non-empty stack should return a value = " + stack.peek());
	
		stack.push(40);
		
		stack.push(55);
		
		System.out.println("Size is " + stack.size());
		System.out.println("isEmpty() is " + stack.isEmpty());
		System.out.println("pop() from non-empty stack should return a value = " + stack.pop());
		System.out.println("pop() from non-empty stack should return a value = " + stack.pop());
		System.out.println("pop() from non-empty stack should return a value = " + stack.pop());
		System.out.println("pop() from non-empty stack should return a value = " + stack.pop());
		System.out.println("Size is " + stack.size());
		System.out.println("isEmpty() is " + stack.isEmpty());
	}

}
