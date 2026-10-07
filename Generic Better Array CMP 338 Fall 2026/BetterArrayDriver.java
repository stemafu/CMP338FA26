
public class BetterArrayDriver {
	
	public static void main(String [] args) {
		
		BetterArray<Integer> list1;
		list1 = new BetterArray<Integer>();
		
		list1.add(90);
		list1.add(40);
		list1.add(31);
		list1.add(90);
		list1.add(5);
		System.out.println(list1.get(0));
		
		
		
		BetterArray<String> list2;
		list2 = new BetterArray<String>();
		
		list2.add("Drink Water");
		list2.add("Bronx");
		list2.add("Wonderwoman");
		list2.add("CCNY");
		list2.add("CUNY");
		System.out.println(list2.get(0));		
		
		
	}

}
