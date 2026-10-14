
public class LinkedListDriver {

	public static void main(String[] args) {
		
		
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(90);
		list.add(40);
		list.add(30);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("the value at index " + i + " is " + list.get(i));
		}
		
		
		System.out.println("adding 5 at index 0");
		list.add(5, 0);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("the value at index " + i + " is " + list.get(i));
		}
		System.out.println("adding 45 at index 3");
		list.add(45, 3);
		for(int i = 0; i < list.size(); i++) {
			System.out.println("the value at index " + i + " is " + list.get(i));
		}
		
		System.out.println("replace a value at index 3, which 45,  with 43");
		System.out.println("Replaced value is " + list.replace(43, 3));
		for(int i = 0; i < list.size(); i++) {
			System.out.println("the value at index " + i + " is " + list.get(i));
		}
		
		
		System.out.println("Remove value at index 0 " + list.remove(0));
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("the value at index " + i + " is " + list.get(i));
		}
		
		
		System.out.println("Remove value at index 1 " + list.remove(1));
		for(int i = 0; i < list.size(); i++) {
			System.out.println("the value at index " + i + " is " + list.get(i));
		}
	}

}
