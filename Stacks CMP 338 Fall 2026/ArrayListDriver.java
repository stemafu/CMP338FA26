import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDriver {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(90);
		list.add(40);
		list.add(30);
		list.add(34);
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		

	}

}
