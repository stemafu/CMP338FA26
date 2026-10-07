
public class GenericBoxDriver {

	public static void main(String[] args) {
		
		GenericBox<Integer> box1 = new GenericBox<Integer>(90);
		
		GenericBox<String> b2 = new GenericBox<String>("Lehman College");
		
		System.out.println(box1.getData());
		System.out.println(b2.getData());

	}

}
