
public class DummyNodeDriver {
	
	public static void main(String [] args) {
		
		DummyNodeLinkedBasedStack<Integer> list =null;
		
		list = new DummyNodeLinkedBasedStack<Integer>();
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.pop());
		System.out.println(list.peek());
		
		list.push(90);
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.pop());
		System.out.println(list.peek());
		list.push(91);
		System.out.println(list.peek());
		list.push(60);
		System.out.println(list.peek());
	}

}
